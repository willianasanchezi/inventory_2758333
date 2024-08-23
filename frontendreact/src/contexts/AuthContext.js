// src/contexts/AuthContext.js
import React, { createContext, useState, useContext } from 'react';
import { useNavigate } from 'react-router-dom';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [token, setToken] = useState(null);
    const [roles, setRoles] = useState([]);
    const [currentUser, setCurrentUser] = useState(null);
    const navigate = useNavigate();

    const login = (token, roles, user) => {
        setIsAuthenticated(true);
        setToken(token);
        setRoles(roles);
        setCurrentUser(user);
        console.log('Usuario autenticado:', user);
        navigate('/Dashboard');
    };

    const logout = () => {
        setIsAuthenticated(false);
        setToken(null);
        setRoles([]);
        setCurrentUser(null);
        navigate('/login');
    };

    const hasRole = (role) => {
        console.log('Rol:', roles);
        return roles && roles.includes(role);
    };

    return (
        <AuthContext.Provider value={{ isAuthenticated, login, logout, hasRole, currentUser }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => useContext(AuthContext);
