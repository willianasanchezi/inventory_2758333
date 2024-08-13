// src/components/RoleForm.js
import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import BackToMenuButton from './BackToMenuButton';
import { useAuth } from '../contexts/AuthContext'; // Importa el contexto de autenticación

const RoleForm = () => {
    const [idRol, setIdRol] = useState('');
    const [codigoRol, setCodigoRol] = useState('');
    const [nombrePermiso, setNombrePermiso] = useState('');
    const [descripcion, setDescripcion] = useState('');
    const [isEditing, setIsEditing] = useState(false);
    const navigate = useNavigate();
    const { id } = useParams();
    const { hasRole } = useAuth(); // Utiliza el contexto de autenticación

    // Verificar si el usuario tiene el rol 'admin'
    const isAdmin = hasRole('ADMIN');

    useEffect(() => {
        // Si hay un id en los parámetros, estamos en modo edición
        if (id) {
            fetch(`http://localhost:8080/inventory/api/roles/${id}`)
                .then(response => response.json())
                .then(data => {
                    setIdRol(data.idRol);
                    setCodigoRol(data.codigoRol);
                    setNombrePermiso(data.nombrePermiso);
                    setDescripcion(data.descripcion);
                    setIsEditing(true);
                })
                .catch(error => console.error('Error al obtener el rol:', error));
        }
    }, [id]);

    const handleSubmit = async (event) => {
        event.preventDefault();
        const roleData = { idRol, codigoRol, nombrePermiso, descripcion };
        try {
            const response = await fetch(`http://localhost:8080/inventory/api/roles${isEditing ? `/${id}` : ''}`, {
                method: isEditing ? 'PUT' : 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(roleData)
            });
            if (!response.ok) {
                throw new Error('Error en la solicitud');
            }
            alert(`Rol ${isEditing ? 'actualizado' : 'creado'} con éxito`);
            navigate('/roles');
        } catch (error) {
            console.error('Error:', error);
            alert('Error al guardar el rol: ' + error.message);
        }
    };

    return (
        <div className="container mt-5">
            <h2>{isEditing ? 'Editar Rol' : 'Crear Rol'}</h2>
            {isAdmin ? (
                <form onSubmit={handleSubmit}>
                    <div className="mb-3">
                        <label htmlFor="codigoRol" className="form-label">Código Rol:</label>
                        <input
                            type="text"
                            id="codigoRol"
                            name="codigoRol"
                            className="form-control"
                            value={codigoRol}
                            onChange={(e) => setCodigoRol(e.target.value)}
                            required
                        />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="nombrePermiso" className="form-label">Nombre del Permiso:</label>
                        <input
                            type="text"
                            id="nombrePermiso"
                            name="nombrePermiso"
                            className="form-control"
                            value={nombrePermiso}
                            onChange={(e) => setNombrePermiso(e.target.value)}
                            required
                        />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="descripcion" className="form-label">Descripción:</label>
                        <input
                            type="text"
                            id="descripcion"
                            name="descripcion"
                            className="form-control"
                            value={descripcion}
                            onChange={(e) => setDescripcion(e.target.value)}
                            required
                        />
                    </div>
                    <button type="submit" className="btn btn-primary">
                        {isEditing ? 'Actualizar' : 'Crear'}
                    </button>
                </form>
            ) : (
                <p>No tienes permisos para acceder a esta sección.</p>
            )}
            {/* <BackToMenuButton /> */}
        </div>
    );
};

export default RoleForm;

