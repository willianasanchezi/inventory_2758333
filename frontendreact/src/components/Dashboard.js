// src/components/Dashboard.js  
import React, { useState } from 'react';  
import { Link } from 'react-router-dom';  
import { useAuth } from '../contexts/AuthContext';  
  
const Menu = () => {  
    const { hasRole, logout } = useAuth();  
    const handleLogout = () => {  
        logout();  
    };  
    const isAdmin = hasRole('ADMIN');  
    const [showProductsSubmenu, setShowProductsSubmenu] = useState(false);  
    const [showAsignacionesSubmenu, setShowAsignacionesSubmenu] = useState(false);  
  
    const toggleProductsSubmenu = () => {  
        setShowProductsSubmenu(!showProductsSubmenu);  
    };  
  
    const toggleAsignacionesSubmenu = () => {  
        setShowAsignacionesSubmenu(!showAsignacionesSubmenu);  
    };  
  
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
                    <button className="btn btn-toggle align-items-center rounded collapsed nav-link" onClick={toggleProductsSubmenu}>  
                        Productos  
                    </button>  
                    {showProductsSubmenu && (  
                        <ul className="list-group list-group-flush">  
                            <li className="list-group-item">  
                                <Link to="/create-product" className="nav-link">Crear Producto</Link>  
                            </li>  
                            <li className="list-group-item">  
                                <Link to="/products-search" className="nav-link">Búsqueda de Productos</Link>  
                            </li>  
 
                        </ul>  
                    )}  
                </li>  
                <li className="list-group-item">  
                    <button className="btn btn-toggle align-items-center rounded collapsed nav-link" onClick={toggleAsignacionesSubmenu}>  
                        Asignaciones  
                    </button>  
                    {showAsignacionesSubmenu && (  
                        <ul className="list-group list-group-flush">  
						{/*
							<li className="list-group-item">  
                                <Link to="/create-asignacion" className="nav-link">Crear Asignación</Link>  
                            </li>  
						*/}
                            <li className="list-group-item">  
                                <Link to="/products-list-available" className="nav-link">Equipos Disponibles</Link>
                            </li>
                            <li className="list-group-item">
                                <Link to="/products-list-assigned" className="nav-link">Equipos Asignados</Link>
                            </li>
                            {/*
                            <li className="list-group-item">  
                                <Link to="/asignaciones-search" className="nav-link">Búsqueda de Asignaciones</Link>  
                            </li>
                            */}
                        </ul>  
                    )}  
                </li>  
                {/*<li className="list-group-item">  
                    <Link to="/loans" className="nav-link">Préstamos</Link>  
                </li>*/}  
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
