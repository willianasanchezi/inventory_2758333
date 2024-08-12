// src/components/Menu.js
import React from 'react';
import { Link } from 'react-router-dom';
import { useAuth } from '../contexts/AuthContext';

const Menu = () => {
    const { logout } = useAuth();

    const handleLogout = () => {
        logout();
    };

    return (
        <div className="d-flex flex-column vh-100 bg-light p-3">
            <h2>Menú</h2>
            <p>Bienvenido al menú.</p>
            <ul className="list-group list-group-flush mb-3">
                <li className="list-group-item">
                    <Link to="/roles" className="nav-link">Roles</Link>
                </li>
                <li className="list-group-item">
                    <Link to="/users" className="nav-link">Usuarios</Link>
                </li>
                <li className="list-group-item">
                    <Link to="/products" className="nav-link">Productos</Link>
                </li>
                <li className="list-group-item">
                    <Link to="/loans" className="nav-link">Préstamos</Link>
                </li>
                <li className="list-group-item">
                    <Link to="/maintenance" className="nav-link">Mantenimiento</Link>
                </li>
            </ul>
            <button className="btn btn-danger mt-auto" onClick={handleLogout}>Logout</button>
        </div>
    );
};

export default Menu;
