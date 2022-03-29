import { Button, Typography, Container, Box } from "@mui/material";
import { backend } from "./../defaults/InitData";
import axios from "axios";
export function CartFooter({ price }) {
  function placeOrder() {
    axios.post(backend["placeOrder"]);
    window.localStorage.setItem("cartCount", 0);
    window.location.reload();
  }
  return (
    // <Container sx={{ mt: "auto", alignSelf: "flex-end" }}>
    <Container
      sx={{
        display: "flex",
        height: "5vh",
        justifyContent: "flex-end",
        flexDirection: "row",
        m: 1,
        maxWidth: "100%!important",
        position: "fixed",
        bottom: "0",
      }}
    >
      <Typography
        variant="h6"
        fontWeight="400"
        align="center"
        alignSelf="center"
        p={1}
      >
        Total: {price.toFixed(2)}
      </Typography>

      <Button
        disableRipple
        variant="contained"
        sx={{ width: "20%", mx: 2, height: "100%", background: "black" }}
        onClick={() => placeOrder()}
      >
        Order
      </Button>
    </Container>
    //{" "}
    // </Container>
  );
}
