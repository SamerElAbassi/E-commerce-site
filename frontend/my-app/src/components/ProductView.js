import { Card, Container, Button, Col, Row } from "react-bootstrap";
import { Typography, Rating } from "@mui/material";
import { useParams } from "react-router-dom";
import { backendLink, initProducts } from "../defaults/InitData";
import { useEffect, useState } from "react";
import axios from "axios";
import { ListStack } from "./ListStack";
import { CartDrawer } from "./CartDrawer";
import { DialogAlert } from "./DialogAlert";
import { mapValues, map } from "lodash";
export function ProductView({ onProductAdd }) {
  const { id } = useParams();
  const [product, setProduct] = useState({});
  const [size, setSize] = useState("");
  const [open, setOpen] = useState(false);
  const [showDialog, setShowDialog] = useState(false);
  useEffect(() => {
    const fetchProduct = async (id) => {
      let result = await axios.get(backendLink + "products/" + id);
      result = result.data;
      for (const key in result) {
        if (
          key !== "img" &&
          key !== "description" &&
          typeof result[key] === "string"
        ) {
          result[key] = result[key].toUpperCase();
        }
      }
      setProduct(result);
    };
    fetchProduct(id);
  }, []);
  const addToCart = async () => {
    await axios.post(backendLink + "cart/add", {
      productId: id,
      quantity: 1,
      size: size,
    });
    onProductAdd();
    setOpen(!open);
  };
  const onSizeChange = (selectedSize, isSelected) => {
    isSelected ? setSize(selectedSize) : setSize("");
  };
  return (
    <Container fluid>
      <Row className="justify-content-around align-items-center">
        <Col md={4}>
          <img src={product.img} alt="product" style={{ width: "100%" }}></img>
        </Col>
        <Col md={4} className="text-align-center">
          <Typography variant="h4" fontWeight="400" my={2}>
            {product.name}
          </Typography>
          <Typography variant="h6" fontWeight="400" my={2}>
            {product.color}
          </Typography>

          <Typography variant="body1" fontWeight="400" my={2}>
            {product.description}
          </Typography>
          <Typography variant="h6" fontWeight="400" my={2}>
            ${product.price}
          </Typography>

          <ListStack
            list={product.sizes ? product.sizes : []}
            onClick={onSizeChange}
          />

          <Button
            variant="dark"
            onClick={() => {
              if (size && window.localStorage.getItem("firstname")) {
                addToCart();
              } else setShowDialog(true);
            }}
            style={{ width: "100%", borderRadius: "0" }}
          >
            Add to cart
          </Button>
          {showDialog ? (
            <DialogAlert
              title={
                !window.localStorage.getItem("firstname")
                  ? "Need to login first!"
                  : "Need to select size before adding to cart!"
              }
              open={showDialog}
              onClose={() => setShowDialog(false)}
            />
          ) : (
            <></>
          )}
          {open ? (
            <CartDrawer open={open} setIsOpen={(open) => setOpen(open)} />
          ) : (
            <></>
          )}
        </Col>
      </Row>
    </Container>
  );
}
