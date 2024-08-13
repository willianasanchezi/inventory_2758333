// src/components/Dashboard.js
import React from 'react';
import { Link } from 'react-router-dom';
import { useAuth } from '../contexts/AuthContext';

const Menu = () => {
    const { hasRole, logout } = useAuth();
    const handleLogout = () => {
        logout();
    };
    // Verificar si el usuario tiene el rol 'admin'
    const isAdmin = hasRole('ADMIN');

    return (
        <div className="d-flex flex-column vh-100 bg-light p-3">
            <h2>Menú</h2>
            <p>Bienvenido al menú.</p>
            <ul className="list-group list-group-flush mb-3">
                {isAdmin && (
                    <>
                        <li className="list-group-item">
                            <Link to="/roles" className="nav-link">Roles</Link>
                        </li>
                        <li className="list-group-item">
                            <Link to="/users-list" className="nav-link">Usuarios</Link>
                        </li>
                    </>
                )}
                <li className="list-group-item">
                    <Link to="/products" className="nav-link">Productos</Link>
                </li>
                <li className="list-group-item">
                    <Link to="/loans" className="nav-link">Préstamos</Link>
                </li>
                <li className="list-group-item">
                    <Link to="/maintenance" className="nav-link">Mantenimiento</Link>
                </li>
                <li className="list-group-item">
                    <Link to="/queries" className="nav-link">Consultas</Link>
                </li>

            </ul>
            <button className="btn btn-danger mt-auto" onClick={handleLogout}>Logout</button>
        </div>
    );
};

export default Menu;

