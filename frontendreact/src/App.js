// src/App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import LoginForm from './components/LoginForm';
import Menu from './components/Menu';
import MainLayout from './components/MainLayout';
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
                    <Route path="/" element={<PrivateRoute element={<MainLayout />} />}>
                        <Route path="roles" element={<RoleForm />} />
                        <Route path="users" element={<UserForm />} />
                        <Route path="products" element={<ProductForm />} />
                        <Route path="loans" element={<LoanForm />} />
                        <Route path="maintenance" element={<MaintenanceForm />} />
                    </Route>
                    <Route path="*" element={<Navigate to="/" />} />
                </Routes>             </AuthProvider>
        </Router>
    );
};

export default App;


