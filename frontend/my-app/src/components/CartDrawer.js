import {
  Drawer,
  Container,
  Button,
  Box,
  Grid,
  Typography,
  IconButton,
  ButtonBase,
  Divider,
} from "@mui/material";
import CloseSharpIcon from "@mui/icons-material/CloseSharp";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

import { CartItem } from "./CartItem";
import { DrawerItem } from "./DrawerItem";
import axios from "axios";
import { backendLink } from "../defaults/InitData";
export function CartDrawer({ open, setIsOpen }) {
  const [items, setItems] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchItems = async () => {
      const result = await axios.get(backendLink + "cart/");
      setItems(result.data.cartItems);
    };
    fetchItems();
  }, []);
  return (
    <Drawer
      anchor="right"
      persistent
      open={open}
      onClose={() => setIsOpen(false)}
      PaperProps={{
        sx: {
          maxWidth: "25%",
          maxHeight: "100%",
        },
      }}
      sx={{ zIndex: "1400" }}
    >
      <Box sx={{ display: "flex", flexDirection: "column", overflow: "auto" }}>
        <Grid container item direction="row" px={3} py={1}>
          <Grid
            container
            item
            xs={12}
            alignContent="right"
            alignItems="right"
            justifyContent="flex-end"
          >
            <IconButton onClick={() => setIsOpen(false)}>
              <CloseSharpIcon fontSize="medium"></CloseSharpIcon>
            </IconButton>
          </Grid>
          <Grid item xs={12}>
            <Typography align="left" variant="h5" fontWeight="400">
              Cart
            </Typography>
          </Grid>
        </Grid>
        {Array.isArray(items) ? (
          items.map((item) => <DrawerItem {...item} />)
        ) : (
          <DrawerItem {...items} />
        )}
        <Divider></Divider>
      </Box>
      <Button
        onClick={() => navigate("/cart")}
        sx={{
          mt: "auto",
          backgroundColor: "black",
          borderRadius: "0",
          width: "100%",
          color: "white!important",
          alignSelf: "flex-end",
          "&:hover": {
            backgroundColor: "black",
            color: "white!important",
          },
        }}
      >
        <Typography variant="h6">Access cart</Typography>
      </Button>
    </Drawer>
  );
}
