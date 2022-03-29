import { InputGroup, FormControl, Container } from "react-bootstrap";
import CheckboxCategory from "./CheckboxCategory";
import { PriceFilter } from "./PriceFilter";
import { Grid, Typography } from "@mui/material";
export function Filters({ categories, onFilterChange }) {
  return (
    <Grid container direction="column" gap={3}>
      <Grid item px={2}>
        <Typography variant="h5">Filters</Typography>
      </Grid>
      {categories.map((category) => {
        return (
          <Grid key={category.title + "form"} item>
            <CheckboxCategory onFilterChange={onFilterChange} {...category} />
          </Grid>
        );
      })}
    </Grid>
  );
}
