// src/components/AssignedForm.js
import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import { createAssigned } from '../services/assignedService';
import { getProducts, updateProductStatus } from '../services/productService';
import { getUsers } from '../services/userService';
import { useAuth } from '../contexts/AuthContext';

const AssignedForm = () => {
    const { hasRole, currentUser } = useAuth();
    const isAdmin = hasRole('ADMIN');
    const navigate = useNavigate();
    const location = useLocation();
    const { idProducto: selectedIdProducto, idUsuario: selectedidUsuario } = location.state || {};

    const [formData, setFormData] = useState({
        idProducto: selectedIdProducto || '',
        idUsuario: selectedidUsuario || '',
        fechaAsignacion: '',
        fechaDevolucionProgramada: '',
        tipoAsignacion: '',
        observaciones: ''
    });

    const [productos, setProductos] = useState([]);
    const [usuarios, setUsuarios] = useState([]);

    useEffect(() => {
        const fetchProductos = async () => {
            try {
                const productosData = await getProducts();
                setProductos(productosData);
            } catch (error) {
                console.error('Error al obtener productos', error);
            }
        };

        const fetchUsuarios = async () => {
            try {
                const usuariosData = await getUsers();
                setUsuarios(usuariosData);
            } catch (error) {
                console.error('Error al obtener usuarios', error);
            }
        };

        fetchProductos();
        fetchUsuarios();
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
            if (!currentUser) {
                throw new Error('Usuario no autenticado');
            }
            console.log('Formulario de datos:', formData);

            // Convertir idProducto e idUsuario a enteros
            const dataToSend = {
                ...formData,
                idProducto: parseInt(formData.idProducto, 10),
                idUsuario: parseInt(formData.idUsuario, 10),
            };

            await createAssigned(dataToSend);

            // Actualizar el estado del producto
            try {
                await updateProductStatus(dataToSend.idProducto, 'Asignado');
            } catch (updateError) {
                console.error('Error al actualizar el estado del producto', updateError);
                alert('Asignación creada, pero hubo un error al actualizar el estado del producto');
            }

            alert('Asignación creada exitosamente');
            navigate('/products-list-available');
        } catch (error) {
            console.error('Error al guardar la asignación', error);
            if (error.response) {
                console.error('Detalles del error:', error.response.data);
            }
            alert('Error al guardar la asignación');
        }
    };

    return (
        <div className="container mt-5">
            <h2>Asignar</h2>
            {isAdmin ? (
                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label>Producto</label>
                        <select
                            className="form-control"
                            name="idProducto"
                            value={formData.idProducto}
                            onChange={handleChange}
                            required
                            disabled={selectedIdProducto}
                        >
                            <option value="">Seleccione un producto</option>
                            {productos.map((producto) => (
                                <option key={producto.idProducto} value={producto.idProducto}>
                                    {producto.nombreProducto}
                                </option>
                            ))}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Usuario</label>
                        <select
                            className="form-control"
                            name="idUsuario"
                            value={formData.idUsuario}
                            onChange={handleChange}
                            required
                        >
                            <option value="">Seleccione un usuario</option>
                            {usuarios.map((usuario) => (
                                <option key={usuario.idUsuario} value={usuario.idUsuario}>
                                    {usuario.nombreCompleto}
                                </option>
                            ))}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Fecha Asignación</label>
                        <input
                            type="datetime-local"
                            className="form-control"
                            name="fechaAsignacion"
                            value={formData.fechaAsignacion}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label>Fecha Devolución Programada</label>
                        <input
                            type="datetime-local"
                            className="form-control"
                            name="fechaDevolucionProgramada"
                            value={formData.fechaDevolucionProgramada}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label>Tipo Asignación</label>
                        <select
                            className="form-control"
                            name="tipoAsignacion"
                            value={formData.tipoAsignacion}
                            onChange={handleChange}
                            required
                        >
                            <option value="">Seleccione un tipo</option>
                            <option value="Prestamo">Préstamo</option>
                            <option value="Asignacion">Asignación</option>
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Observaciones</label>
                        <textarea
                            className="form-control"
                            name="observaciones"
                            value={formData.observaciones}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <button type="submit" className="btn btn-primary mt-3">
                        Crear Asignación
                    </button>
                </form>
            ) : (
                <p>No tienes permisos para acceder a esta sección.</p>
            )}
        </div>
    );
};

export default AssignedForm;