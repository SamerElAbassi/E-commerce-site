import { Typography, Grid, Box } from "@mui/material";
import { Card, Col, Row } from "react-bootstrap";
import { IncrementableTextBox } from "./IncrementableTextBox";

export function CartItem({ product, quantity, updateItem, size }) {
  function handleQuantity(op, quantity) {
    quantity > 0 && op == "plus" ? quantity++ : quantity--;
    updateItem(product.id, quantity);
  }
  return (
    <Box display="flex" flexDirection="column" height="100%">
      <Typography variant="body1" align="left" sx={{ fontWeight: "350" }}>
        {product.name.toUpperCase()} <br />{" "}
      </Typography>
      <Box display="flex" flexDirection="row">
        <Box component="img" src={product.img} sx={{ height: "58vh" }} />
        <Box display="flex" alignItems="center" flexDirection="column" mx={1}>
          <Typography
            variant="body1"
            sx={{ fontWeight: "350" }}
            align="left"
            alignSelf="center"
          >
            {size}
          </Typography>
          <Typography
            variant="body1"
            sx={{ fontWeight: "350" }}
            align="left"
            alignSelf="center"
          >
            {product.color}
          </Typography>

          <IncrementableTextBox
            quantity={quantity}
            handleQuantity={handleQuantity}
          ></IncrementableTextBox>
          <Typography
            variant="body1"
            align="center"
            sx={{ fontWeight: "350", m: "auto" }}
          >
            {product.price} LEI
          </Typography>
        </Box>
      </Box>
    </Box>
  );
}
