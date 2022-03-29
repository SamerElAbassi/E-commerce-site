import CheckboxChildren from "./CheckboxChildren";
import { Form } from "react-bootstrap";
import { RangeFilter } from "./PriceFilter";
import {
  Typography,
  Accordion,
  AccordionDetails,
  AccordionSummary,
} from "@mui/material";
import { CheckboxRadioGroup } from "./CheckboxRadioGroup";
import { useState } from "react";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import ExpandLessIcon from "@mui/icons-material/ExpandLess";
export default function CheckboxCategory({
  onFilterChange,
  title,
  children,
  type,
}) {
  const [open, setOpen] = useState(false);
  function wrapTitleChild(checked, child) {
    return onFilterChange(checked, title, child, type);
  }
  return (
    <Accordion elevation={0}>
      <AccordionSummary expandIcon={<ExpandMoreIcon />}>
        <Typography variant="h6" fontWeight="350">
          {title.toUpperCase()}{" "}
        </Typography>
      </AccordionSummary>
      <AccordionDetails>
        <CheckboxChildren
          title={title}
          onFilterChange={wrapTitleChild}
          children={children}
          key={title + "-category"}
          type={type}
        />
      </AccordionDetails>
    </Accordion>
  );
}
