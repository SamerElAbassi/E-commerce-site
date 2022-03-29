import { Carousel } from "react-bootstrap";
import NavigateNextIcon from "@mui/icons-material/NavigateNext";
import NavigateBeforeIcon from "@mui/icons-material/NavigateBefore";

export default function ImgCarousel({ imgs }) {
  return (
    <Carousel
      variant="light"
      nextIcon={
        <NavigateNextIcon
          sx={{
            color: "black",
            fontSize: "3rem",
            ml: 20,
          }}
        />
      }
      prevIcon={
        <NavigateBeforeIcon sx={{ color: "black", fontSize: "3rem", mr: 20 }} />
      }
      indicators={false}
    >
      {imgs.map((img) => (
        <Carousel.Item>
          <img className="d-block mx-auto" src={img.src} alt={img.alt}></img>
        </Carousel.Item>
      ))}
    </Carousel>
  );
}
