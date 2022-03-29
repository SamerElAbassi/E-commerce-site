import { Grid, Card, CardMedia, CardContent, Typography } from "@mui/material";
import { Product } from "./Product";
export function OrderItem({ product, quantity, size }) {
  return (
    <Grid item>
      <Card elevation={0} sx={{ maxWidth: 400, borderRadius: 0 }}>
        <CardMedia
          component="img"
          alt="green iguana"
          height="400"
          image={product.img}
        />
        <CardContent>
          <Typography
            gutterBottom
            variant="body1"
            component="div"
            align="center"
          >
            {quantity} X ${product.price}
          </Typography>
          <Typography variant="body2" color="text.secondary" align="center">
            {size}
          </Typography>
        </CardContent>
      </Card>
    </Grid>
  );
}
