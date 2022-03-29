import { Product } from "./Product";
import { Col, Container, Row } from "react-bootstrap";
export function ProductList({ products }) {
  function ProductGrid({ product }) {
    return (
      <Col md={3} key={product.id} className="py-3">
        <Product {...product} />
      </Col>
    );
  }

  if (products.length >= 1) {
    return (
      <Row className="d-flex justify-content-center">
        {products.map((product) => (
          <ProductGrid key={product.id} product={product}></ProductGrid>
        ))}
      </Row>
    );
  } else return <Row></Row>;
}
