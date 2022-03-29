import { SignupForm } from "../SignupForm";
import { Container } from "@mui/material";
export function SignupPage() {
  return (
    <>
      <Container maxWidth="xl" sx={{ my: 6, minHeight: "100vh" }}>
        <SignupForm></SignupForm>
      </Container>
    </>
  );
}
