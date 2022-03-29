import { CartItem } from "./CartItem";
import { Typography, Container, Grid, Box } from "@mui/material";
export function CartItemList({ cartItems, updateItem }) {
  return (
    <Box
      display="flex"
      sx={{
        height: "60vh",
        border: "1",
        overflowX: "auto",
        overflowY: "hidden",
      }}
      direction="column"
      gap={2}
    >
      {cartItems.map((item) => (
        <CartItem
          key={item.product.id}
          product={item.product}
          quantity={item.quantity}
          updateItem={updateItem}
          size={item.size}
        />
      ))}
    </Box>
  );
}
