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
import { backend } from "../defaults/InitData";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { DialogAlert } from "./DialogAlert";
export function SignupForm() {
  const navigate = useNavigate();
  const [showDialog, setShowDialog] = useState(false);
  const [showRequired, setShowRequired] = useState(false);
  const [details, setDetails] = useState({
    username: "",
    password: "",
    firstName: "",
    lastName: "",
    isActive: "true",
  });
  function onSubmit() {
    axios
      .post(backend["signup"], details)
      .then(() => {
        return axios.post(backend["login"], {
          username: details["username"],
          password: details["password"],
        });
      })
      .then((response) => {
        window.localStorage.setItem("firstname", response.data.firstname);
        window.localStorage.setItem("lastname", response.data.lastname);
        window.localStorage.setItem("token", "Bearer " + response.data.token);
        window.localStorage.setItem("username", details["username"]);
        navigate("/");
        window.location.reload();
      })
      .catch((error) => setShowDialog(true));
  }
  return (
    <Container
      maxWidth="xl"
      sx={{ display: "flex", justifyContent: "center", my: 20 }}
    >
      <Grid item xs={4}>
        <Typography variant="h4">Sign up</Typography>
        <FormGroup>
          <TextField
            required
            label="Username"
            variant="standard"
            value={details["username"]}
            onChange={(e) => {
              setDetails({ ...details, username: e.target.value });
            }}
            sx={{ my: 1 }}
          />
          <TextField
            required
            label="Password"
            variant="standard"
            type="password"
            value={details["password"]}
            onChange={(e) => {
              setDetails({ ...details, password: e.target.value });
            }}
            sx={{ my: 1 }}
          />
          <TextField
            required
            label="First Name"
            variant="standard"
            value={details["firstName"]}
            onChange={(e) => {
              setDetails({ ...details, firstName: e.target.value });
            }}
            sx={{ my: 1 }}
          />
          <TextField
            required
            label="Last Name"
            variant="standard"
            value={details["lastName"]}
            onChange={(e) => {
              setDetails({ ...details, lastName: e.target.value });
            }}
            sx={{ my: 1 }}
          />
        </FormGroup>
        <Button
          type="submit"
          onClick={(e) => {
            e.preventDefault();
            let allCompleted = Object.values(details).every((v) => v);
            allCompleted ? onSubmit() : setShowRequired(true);
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
          Create Account
        </Button>
        {showRequired ? (
          <Typography variant="body1" color="red">
            All fields marked with * are required!
          </Typography>
        ) : (
          <></>
        )}
      </Grid>
      {showDialog ? (
        <DialogAlert
          title={"Username already taken!"}
          open={showDialog}
          onClose={() => setShowDialog(false)}
        />
      ) : (
        <></>
      )}
    </Container>
  );
}
