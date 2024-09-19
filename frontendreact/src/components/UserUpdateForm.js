import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';

const UserUpdateForm = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        nombreCompleto: '',
        identificacion: '',
        correoElectronico: '',
        codigoRol: ''
    });
    const [roles, setRoles] = useState([]);

    useEffect(() => {
        const fetchRoles = async () => {
            try {
                const response = await axios.get('http://localhost:8080/inventory/api/roles');
                setRoles(response.data);
            } catch (error) {
                console.error('Error al obtener los roles', error);
            }
        };

        const fetchUser = async () => {
            if (id) {
                try {
                    const response = await axios.get(`http://localhost:8080/inventory/api/usuarios/${id}`);
                    setFormData(response.data);
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
            await axios.put(`http://localhost:8080/inventory/api/usuarios/${id}`, formData);
            alert('Usuario actualizado exitosamente');
            navigate('/users-list');
        } catch (error) {
            console.error('Error al actualizar el usuario', error);
            alert('Error al actualizar el usuario');
        }
    };

    return (
        <div className="container mt-5">
            <h2>Editar Usuario</h2>
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
                    Actualizar Usuario
                </button>
            </form>
        </div>
    );
};

export default UserUpdateForm;