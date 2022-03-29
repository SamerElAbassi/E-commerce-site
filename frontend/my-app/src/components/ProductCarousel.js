import { Carousel, Container } from "react-bootstrap";
import { Product } from "./Product";
import { ProductDeck } from "./ProductDeck";
import _ from "lodash";
import { ProductList } from "./ProductList";
import { Typography } from "@mui/material";
export function ProductCarousel({ products }) {
  return (
    <>
      <Container fluid className="mt-3">
        <Typography variant="h2" align="center">
          Best sellers!
        </Typography>
      </Container>
      <Carousel
        fade
        className="mx-auto"
        controls={false}
        interval={8000}
        variant="dark"
      >
        {_.chunk(products.slice(0, 9), 3).map((chunk) => {
          return (
            <Carousel.Item>
              <ProductList products={chunk}></ProductList>
            </Carousel.Item>
          );
        })}
      </Carousel>
    </>
  );
}
