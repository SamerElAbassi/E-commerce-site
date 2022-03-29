import {
  ListItem,
  Stack,
  Item,
  Divider,
  ListItemButton,
  MenuItem,
  Typography,
} from "@mui/material";
import { useState } from "react";
export function CategoryListStack({ list, onClick }) {
  return (
    <Stack spacing={2} my={3} direction="column" justifyContent="center">
      {list.map((item, index) => (
        <ListItemButton
          key={index}
          onClick={(e) => {
            onClick(e.target.innerText);
          }}
        >
          <Typography variant="h6">{item} </Typography>
        </ListItemButton>
      ))}
    </Stack>
  );
}
