import Box from "@mui/material/Box";
import { Button } from "@mui/material";
import { useState } from "react";
export function SelectableButtonGroup({ children, onClick }) {
  const [selected, setSelected] = useState(
    Object.assign(
      {},
      children.map((e, index) => false)
    )
  );
  return (
    <Box
      display="flex"
      flexDirection="row"
      flexWrap="wrap"
      justifyContent="center"
    >
      {children.map((child, index) => (
        <Button
          variant={selected[index] === true ? "contained" : "outlined"}
          onClick={(e) => {
            setSelected({ ...selected, [index]: !selected[index] });
            onClick(!selected[index], child);
          }}
          key={index}
          sx={{ m: 1 }}
        >
          {child}
        </Button>
      ))}
    </Box>
  );
}
