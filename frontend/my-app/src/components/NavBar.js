import LoginIcon from "@mui/icons-material/Login";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import PersonAddIcon from "@mui/icons-material/PersonAdd";
import {
  Badge,
  Grid,
  IconButton,
  Link,
  Typography,
  AppBar,
  Toolbar,
  Box,
  Container,
  Icon,
} from "@mui/material";
import styled from "styled-components";

import MenuIcon from "@mui/icons-material/Menu";
import MenuOutlinedIcon from "@mui/icons-material/MenuOutlined";
import { useState } from "react";
import CloseIcon from "@mui/icons-material/Close";
import { CategoryDrawer } from "./CategoryDrawer";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import AccountBoxIcon from "@mui/icons-material/AccountBox";
const NavLink = styled(Link)`
  color: inherit;
  text-decoration: none;
  &:hover {
    color: black;
  }
`;

export function NavBar({ cartCount, isLogged }) {
  const [open, setOpen] = useState(false);
  return (
    <>
      <AppBar
        color="transparent"
        elevation={0}
        position="sticky"
        sx={{ zIndex: 1400 }}
      >
        <Toolbar>
          <Box alignSelf="flex-start" my="auto" mr={3}>
            {open ? (
              <IconButton
                onClick={() => setOpen(false)}
                disableFocusRipple
                disableRipple
                sx={{
                  fill: "black!important",
                  color: "black!important",
                }}
              >
                <CloseIcon
                  sx={{
                    fill: "black!important",
                    fontSize: "3rem",
                  }}
                ></CloseIcon>
              </IconButton>
            ) : (
              <IconButton
                disableFocusRipple
                disableRipple
                onClick={() => setOpen(true)}
                mr={2}
              >
                <MenuIcon sx={{ fontSize: "3rem" }}></MenuIcon>
              </IconButton>
            )}
          </Box>
          <NavLink href="/">
            <Typography variant="h1" align="center">
              XARA
            </Typography>
          </NavLink>
          <Box display="flex" flexDirection="row" ml="auto">
            <NavLink href="/products" className="px-4">
              <Typography variant="h5">Products</Typography>
            </NavLink>

            <NavLink href="/cart" className="px-4">
              <Typography variant="h5">
                <Badge
                  sx={{ color: "black", fontSize: "1em" }}
                  badgeContent={cartCount}
                >
                  <ShoppingCartIcon sx={{ fontSize: "1em" }}></ShoppingCartIcon>
                </Badge>
              </Typography>
            </NavLink>
            {isLogged ? (
              <>
                <NavLink href="/orders" className="px-4">
                  <Typography variant="h5">
                    {window.localStorage.getItem("firstname")}{" "}
                    {window.localStorage.getItem("lastname")}
                  </Typography>
                </NavLink>
                <NavLink
                  href="/"
                  className="px-4"
                  onClick={() => window.localStorage.clear()}
                >
                  <Typography variant="h5">Sign out</Typography>
                </NavLink>
              </>
            ) : (
              <>
                <NavLink href="/login" className="px-4">
                  <Typography variant="h5">
                    <LoginIcon sx={{ fontSize: "1em" }}> </LoginIcon> Login
                  </Typography>
                </NavLink>
                <NavLink href="/signup" className="px-4">
                  <Typography variant="h5">
                    <PersonAddIcon sx={{ fontSize: "1em" }}> </PersonAddIcon>{" "}
                    Sign up
                  </Typography>
                </NavLink>
              </>
            )}
          </Box>
        </Toolbar>
      </AppBar>
      <CategoryDrawer
        open={open}
        setOpen={setOpen}
        onClick={() => setOpen(false)}
      />
    </>
  );
}
