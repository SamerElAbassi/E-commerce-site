import { useState } from "react";
import { Col, Container, Row } from "react-bootstrap";
import { ProductList } from "./ProductList";
import { Filters } from "./Filters";
import { FilterDrawer } from "./FilterDrawer";
import { Typography, Button } from "@mui/material";
export function FilterableProducts({ onFilterChange, products, categories }) {
  // function getMinMaxPrice(products) {
  //   let minPrice, maxPrice;
  //   if (products.length) {
  //     minPrice = products.reduce((prev, curr) =>
  //       prev.price < curr.price ? prev : curr
  //     ).price;
  //     maxPrice = products.reduce((prev, curr) =>
  //       prev.price > curr.price ? prev : curr
  //     ).price;
  //   }
  //   return { min: minPrice || 0, max: maxPrice || 100 };
  // }
  const [open, setOpen] = useState(false);
  return (
    <>
      {/* <Col md={2}>
        <Filters
          onFilterChange={onFilterChange}
          categories={categories}
          priceRange={{ ...getMinMaxPrice(products), onFilterChange }}
        ></Filters>
      </Col> */}
      <Row>
        <Typography variant="h6" align="right">
          <Button
            disableRipple
            sx={{ color: "black" }}
            onClick={() => setOpen(true)}
          >
            Filter
          </Button>
        </Typography>
        <FilterDrawer
          open={open}
          setOpen={setOpen}
          onFilterChange={onFilterChange}
          categories={categories}
        ></FilterDrawer>
      </Row>
      <Col md={12}>
        <ProductList products={products}></ProductList>
      </Col>
    </>
  );
}
