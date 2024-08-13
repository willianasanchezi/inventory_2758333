// src/components/UserForm.js
import React, { useState, useEffect } from 'react';
import { getRoles, createUser } from '../services/userService';
import { useAuth } from '../contexts/AuthContext'; // Importa el contexto de autenticación

const UserForm = () => {
    const { hasRole } = useAuth(); // Usa el hook de autenticación
    const isAdmin = hasRole('ADMIN'); // Verifica si el usuario tiene el rol de admin

    const [roles, setRoles] = useState([]);
    const [formData, setFormData] = useState({
        nombreCompleto: '',
        identificacion: '',
        correoElectronico: '',
        contrasena: '',
        codigoRol: ''
    });

    useEffect(() => {
        const fetchRoles = async () => {
            try {
                const rolesData = await getRoles();
                setRoles(rolesData);
            } catch (error) {
                console.error('Error al obtene el rol', error);
            }
        };
        fetchRoles();
    }, []);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await createUser(formData);
            alert('Usuario creado exitosamente');
            // Limpiar el formulario después de la creación exitosa
            setFormData({
                nombreCompleto: '',
                identificacion: '',
                correoElectronico: '',
                contrasena: '',
                codigoRol: ''
            });
        } catch (error) {
            console.error('Error al crear el usuario', error);
            alert('Error al crear el usuario');
        }
    };

    return (
        <div className="container mt-5">
            <h2>Gestión de Usuarios</h2>
            {isAdmin ? (
                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label>Nombre Completo</label>
                        <input
                            type="text"
                            className="form-control"
                            name="nombreCompleto"
                            value={formData.nombreCompleto}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label>Identificación</label>
                        <input
                            type="text"
                            className="form-control"
                            name="identificacion"
                            value={formData.identificacion}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label>Correo Electrónico</label>
                        <input
                            type="email"
                            className="form-control"
                            name="correoElectronico"
                            value={formData.correoElectronico}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label>Contraseña</label>
                        <input
                            type="password"
                            className="form-control"
                            name="contrasena"
                            value={formData.contrasena}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label>Rol</label>
                        <select
                            className="form-control"
                            name="codigoRol"
                            value={formData.codigoRol}
                            onChange={handleChange}
                            required
                        >
                            <option value="">Seleccione un rol</option>
                            {roles.map((role) => (
                                <option key={role.codigoRol} value={role.codigoRol}>
                                    {role.nombrePermiso}
                                </option>
                            ))}
                        </select>
                    </div>
                    <button type="submit" className="btn btn-primary mt-3">
                        Crear Usuario
                    </button>
                </form>
            ) : (
                <p>No tienes permisos para acceder a esta sección.</p>
            )}
        </div>
    );
};

export default UserForm;
