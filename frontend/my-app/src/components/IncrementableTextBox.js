import { ButtonGroup, Button } from "@mui/material";
import { useState } from "react";

export function IncrementableTextBox({ quantity, handleQuantity }) {
  const [quant, setQuant] = useState(quantity);
  return (
    <>
      {" "}
      <ButtonGroup>
        <Button
          disableRipple
          sx={{
            border: "0",
            "&.MuiButtonBase-root:hover": {
              bgcolor: "transparent",
              border: "0",
            },
            color: "black",
            backgroundColor: "transparent",
          }}
          onClick={() => {
            setQuant(quant + 1);
            handleQuantity("plus", quant);
          }}
        >
          +
        </Button>
        <Button
          sx={{
            border: "0!important",
            color: "black",
            "&.MuiButtonBase-root:hover": {
              bgcolor: "transparent",
              border: "0",
            },
            backgroundColor: "transparent",
          }}
        >
          {quant}
        </Button>
        <Button
          disableRipple
          sx={{
            border: "0",
            "&.MuiButtonBase-root:hover": {
              bgcolor: "transparent",
              border: "0",
            },
            color: "black",
          }}
          onClick={() => {
            setQuant(quant - 1);
            handleQuantity("minus", quant);
          }}
        >
          -
        </Button>
      </ButtonGroup>
    </>
  );
}
