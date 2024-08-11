// src/components/Menu.js
import React from 'react';
import NavBar from './NavBar';
import { Link } from 'react-router-dom';

const Menu = () => {
    return (
        <div>
            <NavBar />
            <h2>Menu</h2>
            <p>Bienvenido al menú.</p>
            <ul>
                <li><Link to="/roles">Roles</Link></li>
                <li><Link to="/users">Usuarios</Link></li>
                <li><Link to="/products">Productos</Link></li>
                <li><Link to="/loans">Préstamos</Link></li>
                <li><Link to="/maintenance">Mantenimiento</Link></li>
            </ul>
        </div>
    );
};

export default Menu;

