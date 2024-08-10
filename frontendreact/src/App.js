// src/App.js
import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './components/Login';
import NavBar from './components/NavBar';

const Home = () => <h2>Home Page</h2>;
const About = () => <h2>About Page</h2>;
const Contact = () => <h2>Contact Page</h2>;

const App = () => {
    const [isAuthenticated, setIsAuthenticated] = useState(false);

    const handleLogin = (username, password) => {
        // Simula autenticación
        if (username === 'admin' && password === 'admin') {
            setIsAuthenticated(true);
        }
    };

    if (!isAuthenticated) {
        // Mostrar el componente de login si no está autenticado
        return <Login onLogin={handleLogin} />;
    }

    return (
        <Router>
            <NavBar />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/about" element={<About />} />
                <Route path="/contact" element={<Contact />} />
            </Routes>
        </Router>
    );
};

export default App;
