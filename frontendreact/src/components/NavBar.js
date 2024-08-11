// src/components/NavBar.js
import React from 'react';
import { Link } from 'react-router-dom';
import { useAuth } from '../contexts/AuthContext';

const NavBar = () => {
    const { logout } = useAuth();

    return (
        <nav>
            <ul>

                <li><button onClick={logout}>Logout</button></li>
            </ul>
        </nav>
    );
};

export default NavBar;

