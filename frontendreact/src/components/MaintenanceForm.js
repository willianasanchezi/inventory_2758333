// src/components/MaintenanceForm.js
import React from 'react';
import BackToMenuButton from './BackToMenuButton';
import { useAuth } from '../contexts/AuthContext';

const MaintenanceForm = () => {
    const { hasRole } = useAuth();
    // Verificar si el usuario tiene el rol 'admin'
    const isAdmin = hasRole('ADMIN');
    console.log('isAdmin:', isAdmin); // Agregar esta línea para depurar

    return (
        <div>
            <h2>Maintenance Management</h2>
            {isAdmin && (
                <>
                    {/* Formulario CRUD para mantenimiento */}
                <p>CON PERMISOS.</p>
                </>
            )}
            {!isAdmin && (
                <p>No tienes permisos para acceder a esta sección.</p>
            )}
        </div>
    );
};

export default MaintenanceForm;
