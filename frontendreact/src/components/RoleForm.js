// src/components/RoleForm.js
import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import BackToMenuButton from './BackToMenuButton';

const RoleForm = () => {
    const [idRol, setIdRol] = useState('');
    const [codigoRol, setCodigoRol] = useState('');
    const [nombrePermiso, setNombrePermiso] = useState('');
    const [descripcion, setDescripcion] = useState('');
    const [isEditing, setIsEditing] = useState(false);
    const navigate = useNavigate();
    const { id } = useParams();

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
                .catch(error => console.error('Error fetching role:', error));
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
        <div>
            <h2>{isEditing ? 'Editar Rol' : 'Crear Rol'}</h2>

            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="codigoRol">Código Rol:</label>
                    <input
                        type="text"
                        id="codigoRol"
                        name="codigoRol"
                        value={codigoRol}
                        onChange={(e) => setCodigoRol(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="nombrePermiso">Nombre del Permiso:</label>
                    <input
                        type="text"
                        id="nombrePermiso"
                        name="nombrePermiso"
                        value={nombrePermiso}
                        onChange={(e) => setNombrePermiso(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="descripcion">Descripción:</label>
                    <input
                        type="text"
                        id="descripcion"
                        name="descripcion"
                        value={descripcion}
                        onChange={(e) => setDescripcion(e.target.value)}
                        required
                    />
                </div>
                <button type="submit">{isEditing ? 'Actualizar' : 'Crear'}</button>
            </form>
            <BackToMenuButton />
        </div>
    );
};

export default RoleForm;

