import axios from "axios";
import { LoginForm } from "../LoginForm";
import { backendLink } from "./../../defaults/InitData";
import { useNavigate } from "react-router-dom";
import { Container } from "@mui/material";
export function LoginPage() {
  const navigate = useNavigate();
  function onLoginSubmit(username, password) {
    axios
      .post(backendLink + "login", {
        username: username,
        password: password,
      })
      .then((response) => {
        window.localStorage.setItem("firstname", response.data.firstname);
        window.localStorage.setItem("lastname", response.data.lastname);
        window.localStorage.setItem("token", "Bearer " + response.data.token);
        window.localStorage.setItem("username", username);
        navigate("/");
        window.location.reload();
      })
      .catch((reject) => alert("Wrong credentials!"));
  }
  return (
    <>
      <Container maxWidth="xl" sx={{ my: 6, minHeight: "100vh" }}>
        <LoginForm onLoginSubmit={onLoginSubmit}></LoginForm>
      </Container>
    </>
  );
}
