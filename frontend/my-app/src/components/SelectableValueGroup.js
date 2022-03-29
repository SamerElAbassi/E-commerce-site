import { Link, Box, Button, Typography } from "@mui/material";
import { useState } from "react";
import SquareIcon from "@mui/icons-material/Square";
export function SelectableValueGroup({ children, onClick }) {
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
          variant={selected[index] === true ? "contained" : "text"}
          onClick={(e) => {
            setSelected({ ...selected, [index]: !selected[index] });
            onClick(!selected[index], child);
          }}
          key={index}
        >
          <SquareIcon
            sx={{
              color: child.toLowerCase(),
              border: "1px black solid",
              backgroundColor: child.toLowerCase(),
              m: 1,
            }}
          />
          <Typography variant="h6"> {child}</Typography>
        </Button>
      ))}
    </Box>
  );
}
