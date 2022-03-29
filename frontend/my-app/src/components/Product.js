import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import { Link } from "react-router-dom";

export function Product({ id, img, name, reviews, price }) {
  return (
    <Link style={{ textDecoration: "none" }} to={"/products/" + id}>
      <Card elevation={0} sx={{ border: 0 }}>
        <CardMedia
          component="img"
          image={img}
          alt="photo"
          style={{ height: "450px" }}
          href={"/products/" + id}
        />
        <CardContent>
          <Typography variant="h6" align="center" fontWeight="400">
            {name.toUpperCase()}
          </Typography>
          {/* <Rating name="read-only" value={reviews} precision={0.2} readOnly /> */}
          <Typography variant="h6" align="center" fontWeight="350">
            ${price}
          </Typography>
        </CardContent>
      </Card>
    </Link>
  );
}
