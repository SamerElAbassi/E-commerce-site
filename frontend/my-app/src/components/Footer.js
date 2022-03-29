import { Container, List, ListItemText, Typography } from "@mui/material";

export function Footer({ title, phoneNum }) {
  return (
    <Container
      maxWidth="xl"
      sx={{ p: 0, m: 0, mt: 10, position: "relative", bottom: 0 }}
    >
      <Typography variant="h4" gutterBottom>
        XARA
      </Typography>

      <List>
        <Typography variant="h5">
          <ListItemText
            primaryTypographyProps={{ variant: "h6", fontWeight: "400" }}
          >
            Phone number: +1-202-555-0106
          </ListItemText>
          <ListItemText
            primaryTypographyProps={{ variant: "h6", fontWeight: "400" }}
          >
            E-mail: support@xara.com
          </ListItemText>
        </Typography>
      </List>
    </Container>
  );
}
