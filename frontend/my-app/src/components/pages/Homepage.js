import { Container } from "react-bootstrap";
import { initImgs, initProducts } from "../../defaults/InitData";
import ImgCarousel from "../ImgCarousel";
import { ProductCarousel } from "../ProductCarousel";
export function Homepage() {
  return (
    <Container fluid className="mx-0 px-0">
      <ImgCarousel imgs={initImgs}></ImgCarousel>
      {/* <ProductCarousel products={initProducts}></ProductCarousel> */}
    </Container>
  );
}
