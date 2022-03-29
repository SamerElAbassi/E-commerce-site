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
const sizes = { 0: "XS", 1: "S", 2: "M", 3: "L", 4: "XL" };
export function ListStack({ list, onClick }) {
  const [selected, setSelected] = useState(-1);
  return (
    <Stack
      spacing={1}
      my={2}
      borderTop="0.5px solid"
      borderBottom="0.5px solid"
    >
      {Object.values(sizes).map((item, index) => (
        <ListItemButton
          selected={index === selected}
          onClick={(e) => {
            index === selected ? setSelected(-1) : setSelected(index);
            onClick(e.target.innerText, index !== selected);
          }}
          disabled={!list.includes(item)}
        >
          <Typography
            variant="body1"
            fontWeight={index === selected ? "800" : "400"}
          >
            {item}
          </Typography>
        </ListItemButton>
      ))}
    </Stack>
  );
}
