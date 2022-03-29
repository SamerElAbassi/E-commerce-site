import { Product } from "./Product";
import { Container } from "react-bootstrap";
export function ProductDeck({ products }) {
  return (
    <Container fluid className="mx-auto" style={{ display: "flex" }}>
      {products.map((product) => (
        <Product {...product}></Product>
      ))}
    </Container>
  );
}
