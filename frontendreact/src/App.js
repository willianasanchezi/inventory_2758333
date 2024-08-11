// src/App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import LoginForm from './components/LoginForm';
import Menu from './components/Menu';
import NavBar from './components/NavBar';
import RoleForm from './components/RoleForm';
import UserForm from './components/UserForm';
import ProductForm from './components/ProductForm';
import LoanForm from './components/LoanForm';
import MaintenanceForm from './components/MaintenanceForm';
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
                    <Route path="/roles" element={<PrivateRoute element={<RoleForm />} />} />
                    <Route path="/roles/:id" element={<PrivateRoute element={<RoleForm />} />} />
                    <Route path="/users" element={<PrivateRoute element={<UserForm />} />} />
                    <Route path="/products" element={<PrivateRoute element={<ProductForm />} />} />
                    <Route path="/loans" element={<PrivateRoute element={<LoanForm />} />} />
                    <Route path="/maintenance" element={<PrivateRoute element={<MaintenanceForm />} />} />
                    <Route path="/" element={<Navigate to="/menu" />} />
                </Routes>
            </AuthProvider>
        </Router>
    );
};

export default App;


