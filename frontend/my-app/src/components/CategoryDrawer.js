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

import MenuIcon from "@mui/icons-material/Menu";
import { fetchItems } from "./axiosDefaults";
import { backend } from "../defaults/InitData";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

import { CategoryListStack } from "./CategoryListStack";
export function CategoryDrawer({ open, setOpen, onClick }) {
  const [categories, setCategories] = useState([]);
  const navigate = useNavigate();
  useEffect(() => {
    fetchItems(backend["getCategoryNames"]).then((res) => {
      setCategories(res.data);
    });
  }, [open]);
  function onCategorySelect(category) {
    navigate("/category/" + category);
    onClick();
  }
  return (
    <Box sx={{ width: "25%" }}>
      <Drawer
        anchor="left"
        open={open}
        onClose={() => setOpen(false)}
        variant="persistent"
        PaperProps={{
          sx: {
            width: "25%",
            height: "100%",
            justifyContent: "start",
            alignContent: "center",
            gap: "0",
            borderRight: "0",
          },
        }}
      >
        <Box mt={20}>
          {categories != null ? (
            <CategoryListStack list={categories} onClick={onCategorySelect} />
          ) : (
            <h1> No content </h1>
          )}
        </Box>
      </Drawer>
    </Box>
  );
}
