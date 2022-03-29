import { Container, Typography, Grid } from "@mui/material";
import { useState, useEffect } from "react";
import { backend } from "../../defaults/InitData";
import { Order } from "../Order";
import axios from "axios";
import { OrderItem } from "../OrderItem";
export function OrderPage() {
  const [orders, setOrders] = useState([]);
  useEffect(() => {
    axios
      .get(backend["getOrders"] + window.localStorage.getItem("username"))
      .then((res) => {
        setOrders(res.data);
      });
  }, []);

  return (
    <Container
      maxWidth="false"
      sx={{ maxWidth: "93%", minHeight: "100vh", m: 6, ml: 10 }}
    >
      <Grid container sx={{ minHeight: "100vh" }} direction="column">
        <Grid item>
          <Typography
            align="left"
            variant="h4"
            gutterBottom
            sx={{ mb: 10, mt: 5, fontWeight: "300" }}
          >
            Orders
          </Typography>
        </Grid>
        {orders.map((order, index) => (
          <Order {...order} key={index}></Order>
        ))}
      </Grid>
    </Container>
  );
}
