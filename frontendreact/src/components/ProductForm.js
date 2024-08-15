// src/components/ProductForm.js
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { createProduct } from '../services/productService';

const ProductForm = () => {
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        codigo: '',
        nombreProducto: '',
        descripcion: '',
        marca: '',
        modelo: '',
        cantidadMemoria: '',
        capacidadDisco: '',
        estado: '',
        cantidad: '',
        precioUnitario: '',
        fechaRegistro: ''
    });

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
            await createProduct(formData);
            alert('Producto creado exitosamente');
            navigate('/products-search');
        } catch (error) {
            console.error('Error al guardar el producto', error);
            alert('Error al guardar el producto');
        }
    };

    return (
        <div className="container mt-5">
            <h2>Crear Producto</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Código</label>
                    <input
                        type="text"
                        className="form-control"
                        name="codigo"
                        value={formData.codigo}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Nombre del Producto</label>
                    <input
                        type="text"
                        className="form-control"
                        name="nombreProducto"
                        value={formData.nombreProducto}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Descripción</label>
                    <input
                        type="text"
                        className="form-control"
                        name="descripcion"
                        value={formData.descripcion}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Marca</label>
                    <input
                        type="text"
                        className="form-control"
                        name="marca"
                        value={formData.marca}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Modelo</label>
                    <input
                        type="text"
                        className="form-control"
                        name="modelo"
                        value={formData.modelo}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Cantidad de Memoria</label>
                    <input
                        type="text"
                        className="form-control"
                        name="cantidadMemoria"
                        value={formData.cantidadMemoria}
                        onChange={handleChange}
                    />
                </div>
                <div className="form-group">
                    <label>Capacidad del Disco</label>
                    <input
                        type="text"
                        className="form-control"
                        name="capacidadDisco"
                        value={formData.capacidadDisco}
                        onChange={handleChange}
                    />
                </div>
                <div className="form-group">
                    <label>Estado</label>
                    <select
                        className="form-control"
                        name="estado"
                        value={formData.estado}
                        onChange={handleChange}
                        required
                    >
                        <option value="">Seleccione un estado</option>
                        <option value="s">Disponible</option>
                        <option value="n">No disponible</option>
                    </select>
                </div>
                <div className="form-group">
                    <label>Cantidad</label>
                    <input
                        type="number"
                        className="form-control"
                        name="cantidad"
                        value={formData.cantidad}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Precio Unitario</label>
                    <input
                        type="number"
                        step="0.01"
                        className="form-control"
                        name="precioUnitario"
                        value={formData.precioUnitario}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Fecha de Registro</label>
                    <input
                        type="datetime-local"
                        className="form-control"
                        name="fechaRegistro"
                        value={formData.fechaRegistro}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit" className="btn btn-primary mt-3">
                    Crear Producto
                </button>
            </form>
        </div>
    );
};

export default ProductForm;

