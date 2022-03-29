import { Grid, Typography, Timeline } from "@mui/material";
import { dateToText } from "../utils";
import { OrderItem } from "./OrderItem";

export function Order({ orderItems, dateCreated, status, price }) {
  return (
    <Grid item container direction="row" spacing={4}>
      <Grid item xs={12}>
        <Typography variant="body1" fontWeight="300">
          {status}{" "}
          <span
            className="colored-circle"
            style={{ backgroundColor: "rgb(1, 170, 1)" }}
          ></span>
        </Typography>

        <Typography variant="h6" fontWeight="400">
          {dateToText(dateCreated)}
        </Typography>
        <Typography variant="body1" fontWeight="300">
          ${price.toFixed(2)}
        </Typography>
      </Grid>
      {orderItems.map((item) => (
        <OrderItem key={item.id} {...item} />
      ))}
    </Grid>
  );
}
