import axios from "axios";
import cloneDeep from "lodash/cloneDeep";
import isEqual from "lodash/isEqual";
import { useEffect, useState } from "react";
import { Container, Row } from "react-bootstrap";
import { performance } from "universal-perf-hooks";
import { categories } from "../../defaults/InitData";
import { convertChildrenQuery } from "../../utils";
import { FilterableProducts } from "../FilterableProducts";
import { backend } from "../../defaults/InitData";
import { useParams } from "react-router-dom";
const initFilters = {
  color: {
    children: [],
    type: "value",
  },
  price: {
    children: [],
    type: "range",
  },
  sizes: {
    children: [],
    type: "value",
  },
};

export function ProductsPage() {
  const [prods, setProds] = useState({});
  const { name } = useParams();
  const [categories, setCategories] = useState([]);
  const [filters, setFilters] = useState(initFilters);
  useEffect(() => {
    const fetchData = async () => {
      let link;
      name
        ? (link = backend["getProductsByCategory"] + name)
        : (link = backend["getProducts"]);
      const result = await axios.get(link);
      setProds(result.data);
      categoryCreator(result.data);
    };
    fetchData();
  }, [name]);
  useEffect(() => {
    const fetchFiltered = async () => {
      const url = queryCreator(filters);

      const result = await axios.get(url);
      setProds(result.data);
    };
    fetchFiltered();
  }, [filters]);
  function onFilterChange(checked, title, child, type) {
    let newFilters = cloneDeep(filters);
    title = title.toLowerCase();
    if (checked) {
      if (type === "value") newFilters[title]["children"].push(child);
      if (type === "range") newFilters[title]["children"] = child;
    } else {
      if (type === "value") {
        newFilters[title]["children"] = filters[title]["children"].filter(
          (chld) => !isEqual(chld, child)
        );
      } else newFilters[title]["children"] = [];
    }
    setFilters(newFilters);
  }
  function queryCreator(filters) {
    const url = new URL("http://localhost:8080/api/products/filter?");

    for (const key in filters) {
      if (filters[key]["children"].length >= 1) {
        url.searchParams.append(key, convertChildrenQuery(filters[key]));
      }
    }
    if (name) url.searchParams.append("category", name);
    return url.href;
  }
  function categoryCreator(products) {
    let categ = { color: new Set(), sizes: new Set(), price: new Set() };
    products.forEach((prod) => {
      Object.keys(categ).forEach((key) =>
        Array.isArray(prod[key])
          ? prod[key].forEach((value) => categ[key].add(value))
          : categ[key].add(prod[key])
      );
    });

    let category = [];
    categ["price"] = new Set([
      Math.min(...categ["price"]),
      Math.max(...categ["price"]),
    ]);
    Object.keys(categ).forEach((key) =>
      category.push({
        title: key,
        children: Array.from(categ[key]),
        type: initFilters[key]["type"],
      })
    );
    setCategories(category);
  }
  return (
    <>
      <Container fluid className="min-vh-100">
        <Row>
          <FilterableProducts
            onFilterChange={onFilterChange}
            products={prods}
            categories={categories}
          />
        </Row>
      </Container>
    </>
  );
}
