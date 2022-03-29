import { Slider, Box } from "@mui/material";
import { useState } from "react";

export function RangeSlider({ children, onClick }) {
  const [value, setValue] = useState(children);
  return (
    <Box
      display="flex"
      flexDirection="row"
      flexWrap="wrap"
      justifyContent="center"
    >
      <Slider
        max={children[1]}
        min={children[0]}
        valueLabelDisplay="on"
        step={0.5}
        value={value}
        onChange={(e, val) => setValue(val)}
        sx={{ color: "black", padding: 0, width: "80%" }}
        onChangeCommitted={() => onClick(true, value)}
      ></Slider>
    </Box>
  );
}
