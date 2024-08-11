// src/App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import LoginForm from './components/LoginForm';
import Menu from './components/Menu';
import NavBar from './components/NavBar';
import { AuthProvider, useAuth } from './contexts/AuthContext';

const PrivateRoute = ({ element }) => {
    const { isAuthenticated } = useAuth();
    return isAuthenticated ? element : <Navigate to="/login" />;
};

const App = () => {
    return (
        <Router>
            <AuthProvider>
                <Routes>
                    <Route path="/login" element={<LoginForm />} />
                    <Route path="/menu" element={<PrivateRoute element={<Menu />} />} />
                    <Route path="/" element={<Navigate to="/menu" />} />
                </Routes>
            </AuthProvider>
        </Router>
    );
};

export default App;

