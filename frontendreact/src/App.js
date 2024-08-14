// src/App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import LoginForm from './components/LoginForm';
import Dashboard from './components/Dashboard';
import MainLayout from './components/MainLayout';
import NavBar from './components/NavBar';
import RoleForm from './components/RoleForm';
import UserForm from './components/UserForm';
import ProductForm from './components/ProductForm';
import ProductSearchForm from './components/ProductSearchForm';
import LoanForm from './components/LoanForm';
import MaintenanceForm from './components/MaintenanceForm';
import QueriesForm from './components/QueriesForm';
import UserListForm from './components/UserListForm';
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
                        <Route path="users/edit/:id" element={<UserForm />} />
                        <Route path="users-list" element={<UserListForm />} />
                        <Route path="products" element={<ProductForm />} />
                        <Route path="productssearch" element={<ProductSearchForm />} />
                        <Route path="loans" element={<LoanForm />} />
                        <Route path="maintenance" element={<MaintenanceForm />} />
                        <Route path="queries" element={<QueriesForm />} />
                    </Route>
                    <Route path="*" element={<Navigate to="/" />} />
                </Routes>             </AuthProvider>
        </Router>
    );
};

export default App;


