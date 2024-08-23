// src/components/UserForm.js
import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { getRoles, createUser, getUser, updateUser } from '../services/userService';
import { useAuth } from '../contexts/AuthContext';

const UserForm = () => {
    const { hasRole, currentUser } = useAuth();
    const isAdmin = hasRole('ADMIN');
    const { id } = useParams();
    const navigate = useNavigate();
    const [roles, setRoles] = useState([]);
    const [formData, setFormData] = useState({
        nombreCompleto: '',
        identificacion: '',
        correoElectronico: '',
        contrasena: '',
        codigoRol: '',
        userCreoRegistro: ''
    });

    useEffect(() => {
        const fetchRoles = async () => {
            try {
                const rolesData = await getRoles();
                setRoles(rolesData);
            } catch (error) {
                console.error('Error al obtener los roles', error);
            }
        };

        const fetchUser = async () => {
            if (id) {
                try {
                    const userData = await getUser(id);
                    setFormData(userData);
                } catch (error) {
                    console.error('Error al obtener el usuario', error);
                }
            }
        };

        fetchRoles();
        fetchUser();
    }, [id]);

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
            if (!id) {
                if (!currentUser) {
                    throw new Error('Usuario no autenticado');
                }
                formData.userCreoRegistro = currentUser; //.user;
            }
            console.log('Formulario de datos:', formData);
            if (id) {
                await updateUser(id, formData);
                alert('Usuario actualizado exitosamente');
            } else {
                await createUser(formData);
                alert('Usuario creado exitosamente');
            }
            navigate('/users-list');
        } catch (error) {
            console.error('Error al guardar el usuario', error);
            alert('Error al guardar el usuario');
        }
    };

    return (
        <div className="container mt-5">
            <h2>{id ? 'Editar Usuario' : 'Crear Usuario'}</h2>
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
                    {!id && (
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
                    )}
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
                        {id ? 'Actualizar Usuario' : 'Crear Usuario'}
                    </button>
                </form>
            ) : (
                <p>No tienes permisos para acceder a esta sección.</p>
            )}
        </div>
    );
};

export default UserForm;
