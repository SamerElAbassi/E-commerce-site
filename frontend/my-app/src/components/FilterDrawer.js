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
import { Filters } from "./Filters";
export function FilterDrawer({
  open,
  setOpen,
  items,
  categories,
  priceRange,
  onFilterChange,
}) {
  return (
    <Drawer
      anchor="right"
      variant="persistent"
      open={open}
      onClose={() => setOpen(false)}
      PaperProps={{
        sx: {
          width: "26%",
          maxHeight: "100%",
        },
      }}
      sx={{
        zIndex: 1400,
      }}
    >
      <Box sx={{ display: "flex", flexDirection: "column", overflow: "auto" }}>
        <Grid container item direction="row" px={3} py={1}>
          <Grid
            container
            item
            xs={12}
            alignContent="right"
            alignItems="right"
            justifyContent="flex-end"
          >
            <IconButton onClick={() => setOpen(false)}>
              <CloseSharpIcon fontSize="medium"></CloseSharpIcon>
            </IconButton>
          </Grid>
          <Grid item xs={12}></Grid>
        </Grid>
        {<Filters categories={categories} onFilterChange={onFilterChange} />}
      </Box>
    </Drawer>
  );
}
