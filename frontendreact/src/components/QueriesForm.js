// src/components/QueriesForm.js
import React from 'react';
import { useAuth } from '../contexts/AuthContext'; // Importa el contexto de autenticación

const QueriesForm = () => {
    const { hasRole } = useAuth(); // Utiliza el hook useAuth
    const isAdmin = hasRole('ADMIN'); // Verifica si el usuario tiene el rol 'ADMIN'

    if (!isAdmin) {

        return <div>No tienes permisos para acceder a esta página.</div>;
    }

    return (
        <div>
            <h2>Queries Management</h2>
        </div>
    );
};

export default QueriesForm;
