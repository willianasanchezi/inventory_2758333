// src/contexts/AuthContext.js
import React, { createContext, useState, useContext } from 'react';
import { useNavigate } from 'react-router-dom';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [token, setToken] = useState(null);
    const [roles, setRoles] = useState([]); // Inicializar roles con un array vacío
    const navigate = useNavigate();

    const login = (token, roles) => {
        setIsAuthenticated(true);
        setToken(token);
        setRoles(roles);
        console.log('Rol inicio sesion:', roles); // Agregar esta línea para depurar
        navigate('/Dashboard');
    };

    const logout = () => {
        setIsAuthenticated(false);
        setToken(null);
        setRoles([]);
        navigate('/login');
    };

    const hasRole = (role) => {
        console.log('Rol:', roles); // Agregar esta línea para depurar
        return roles && roles.includes(role); // Manejar el caso cuando roles es undefined
    };

    return (
        <AuthContext.Provider value={{ isAuthenticated, login, logout, hasRole }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => useContext(AuthContext);
