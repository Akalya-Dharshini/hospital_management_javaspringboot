// File: src/App.js
import React from "react";
import { Routes, Route, useLocation } from "react-router-dom";

import NavBar from "./components/NavBar";
import Footer from "./components/Footer";
import ProtectedRoute from "./components/ProtectedRoute";

// Pages
import Home from "./pages/Home";
import About from "./pages/About";
import Services from "./pages/Services";
import Doctors from "./pages/Doctors";
import Patients from "./pages/Patients";
import Appointment from "./pages/Appointment";
import HealthTips from "./pages/HealthTips";
import Login from "./pages/Login";
import Register from "./pages/Register";

function App() {
  const location = useLocation();

  // Pages where navbar + footer should be hidden
  const hideLayout = ["/login", "/register"].includes(location.pathname);

  return (
    <>
      {/* Show navbar only when not on login/register */}
      {!hideLayout && <NavBar />}

      <Routes>
        <Route path="/" element={<Home />} />

        <Route path="/about" element={<div className="container py-4"><About /></div>} />

        <Route path="/services" element={<div className="container py-4"><Services /></div>} />

        <Route path="/doctors" element={<div className="container py-4"><Doctors /></div>} />

        <Route
          path="/patients"
          element={
            <ProtectedRoute>
              <div className="container py-4"><Patients /></div>
            </ProtectedRoute>
          }
        />

        <Route
          path="/appointment"
          element={
            <ProtectedRoute>
              <div className="container py-4"><Appointment /></div>
            </ProtectedRoute>
          }
        />

        <Route path="/healthtips" element={<div className="container py-4"><HealthTips /></div>} />

        {/* Auth Pages */}
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
      </Routes>

      {/* Show footer only when not on login/register */}
      {!hideLayout && <Footer />}
    </>
  );
}

export default App;
