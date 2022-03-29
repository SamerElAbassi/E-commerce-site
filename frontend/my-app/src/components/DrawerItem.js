import { Typography, Container, Grid } from "@mui/material";

export function DrawerItem({ product, quantity, size }) {
  return (
    <Grid container rowSpacing={1} px={3} py={3}>
      <Grid item xs={12}>
        <Typography variant="body1" fontWeight="350">
          {product.name.toUpperCase()}
        </Typography>
      </Grid>
      <Grid item xs={6}>
        <img
          src={product.img}
          alt="product img"
          style={{ maxWidth: "100%", height: "auto" }}
        ></img>
      </Grid>
      <Grid
        container
        justify-content="center"
        direction="column "
        flexWrap="wrap"
        item
        xs={6}
      >
        <Grid item xs={6}>
          <Typography variant="body1" fontWeight="350" align="left" mx={2}>
            {product.color}
          </Typography>
          <Typography variant="body1" fontWeight="350" align="left" mx={2}>
            {size}
          </Typography>
        </Grid>
        <Grid item xs={6}>
          <Typography
            variant="body1"
            fontWeight="350"
            align="left"
            paragraph
            mx={2}
          >
            {quantity} X ${product.price}
          </Typography>
        </Grid>
      </Grid>
    </Grid>
  );
}
