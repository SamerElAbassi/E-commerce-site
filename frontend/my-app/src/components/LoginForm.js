import { useState } from "react";
import {
  FormGroup,
  TextField,
  Typography,
  Button,
  Container,
  Box,
  Grid,
} from "@mui/material";
import { useNavigate } from "react-router-dom";

export function LoginForm({ onLoginSubmit }) {
  const navigate = useNavigate();

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  return (
    <>
      <Container maxWidth="xl" sx={{ mx: "auto", my: 20 }}>
        <Grid container direction="row" justifyContent="center">
          <Grid item xs={5}>
            <Typography variant="h4">Login</Typography>
            <FormGroup>
              <TextField
                id="standard-basic"
                label="Username"
                variant="standard"
                value={username}
                onChange={(e) => {
                  setUsername(e.target.value);
                }}
                sx={{ width: "50%", my: 1 }}
              />
              <TextField
                id="standard-basic"
                label="Password"
                type="password"
                variant="standard"
                value={password}
                onChange={(e) => {
                  setPassword(e.target.value);
                }}
                sx={{ width: "50%", my: 1 }}
              />
            </FormGroup>
            <Button
              type="submit"
              onClick={(e) => {
                e.preventDefault();
                onLoginSubmit(username, password);
                setUsername("");
                setPassword("");
              }}
              disableRipple
              disableElevation
              disableTouchRipple
              disableFocusRipple
              sx={{
                my: 2,
                width: "50%",
                backgroundColor: "black",
                color: "white!important",
                flex: 1,
                "&:hover": {
                  backgroundColor: "black",
                  color: "white!important",
                },
              }}
            >
              Login
            </Button>
          </Grid>
          <Grid container item xs={4} flex-grow="0.7">
            <Typography variant="h4" fontWeight="400" gutterBottom>
              Sign up
            </Typography>
            <Typography variant="body1" fontWeight="350" gutterBottom>
              {"If you don't already have an account on XARA.com, \
                Use this option to sign up. We will ask for relevant information\
                to speed up the buying process".toUpperCase()}
            </Typography>
            <Button
              type="submit"
              onClick={(e) => {
                e.preventDefault();
                navigate("/signup");
              }}
              disableRipple
              disableElevation
              disableTouchRipple
              disableFocusRipple
              sx={{
                my: 2,
                width: "62.5%",
                backgroundColor: "black",
                color: "white!important",
                alignSelf: "flex-end",
                "&:hover": {
                  backgroundColor: "black",
                  color: "white!important",
                },
              }}
            >
              Signup
            </Button>
          </Grid>
        </Grid>
      </Container>
    </>
  );
}
