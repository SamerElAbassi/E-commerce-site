import { initCartItems } from "../../defaults/InitData";
import { CartItemList } from "../CartItemList";
import { useState, useEffect } from "react";
import { backendLink } from "../../defaults/InitData";
import axios from "axios";
import { Button, Typography, Container } from "@mui/material";
import { CartFooter } from "./../CartFooter";
export function CartPage({ onCartChange }) {
  const [cartItems, setCartItems] = useState([]);
  const [price, setPrice] = useState(0);
  const fetchItems = async () => {
    const result = await axios.get(backendLink + "cart/");
    console.log(result);
    setCartItems(result.data.cartItems);
    setPrice(result.data.price);
  };
  useEffect(() => {
    fetchItems();
  }, []);
  function updateItem(id, quantity) {
    const update = async () => {
      if (quantity >= 1) {
        await axios.put(backendLink + "cart/update", {
          productId: id,
          quantity: quantity,
        });
      } else {
        await axios.delete(backendLink + "cart/delete/" + id);
        onCartChange();
      }
    };
    update().then(() => fetchItems());
  }
  return (
    <>
      <Container
        fix
        maxWidth={false}
        sx={{
          width: "95%",
          m: 6,
          ml: 10,
          display: "flex",
          flexDirection: "column",
        }}
        className="min-vh-100"
      >
        <Container
          maxWidth={false}
          disableGutters
          sx={{ width: "100%", m: 0, p: "0!important" }}
        >
          <Typography
            align="left"
            variant="h4"
            gutterBottom
            sx={{ mb: 10, mt: 5, fontWeight: "300" }}
          >
            SHOPPING CART ({cartItems.length})
          </Typography>
          <CartItemList cartItems={cartItems} updateItem={updateItem} />
          {/* <Button onSubmit={()=>} */}
        </Container>
      </Container>
      <CartFooter price={price} align />
    </>
  );
}
