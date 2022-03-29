import logo from "./logo.svg";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { Container, Row } from "react-bootstrap";
import { Product } from "./components/Product";
import { ProductList } from "./components/ProductList";
import { SearchBar } from "./components/SearchBar";
import { useState, useEffect } from "react";
import { NavBar } from "./components/NavBar";
import { Footer } from "./components/Footer";
import { Homepage } from "./components/pages/Homepage";
import { Routes, Route } from "react-router-dom";
import { ProductsPage } from "./components/pages/ProductsPage";
import { LoginPage } from "./components/pages/LoginPage";
import { SignupPage } from "./components/pages/SignupPage";
import { backendLink, footerData } from "./defaults/InitData";
import { CartPage } from "./components/pages/CartPage";
import { ProductView } from "./components/ProductView";
import { OrderPage } from "./components/pages/OrderPage";
const axios = require("axios");
axios.defaults.headers.common = {
  Authorization: localStorage.getItem("token"),
};
function App() {
  const [cartCount, setCartCount] = useState(localStorage.getItem("cartCount"));
  function onCartChange() {
    axios.get(backendLink + "cart/").then((response) => {
      localStorage.setItem("cartCount", response.data.cartItems.length);
      setCartCount(response.data.length);
    });
  }
  return (
    <>
      <NavBar
        cartCount={cartCount}
        isLogged={window.localStorage.getItem("token") !== null}
      ></NavBar>
      <Routes>
        <Route path="/" element={<Homepage />} />
        <Route path="/products" element={<ProductsPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/signup" element={<SignupPage />} />
        <Route path="/orders" element={<OrderPage />} />
        <Route
          path="/cart"
          element={<CartPage onCartChange={onCartChange} />}
        />
        <Route
          path="/products/:id"
          element={<ProductView onProductAdd={onCartChange} />}
        />
        <Route path="/category/:name" element={<ProductsPage />} />
      </Routes>
      <Footer {...footerData} />
    </>
  );
}

export default App;
