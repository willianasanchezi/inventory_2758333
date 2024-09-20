// src/components/ProductListAssignedForm.js
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";

const ProductListAssignedForm = () => {
  const [products, setProducts] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    // Fetch products
    axios
      .get("http://localhost:8080/inventory/api/productosusuarios")
      .then((response) => setProducts(response.data))
      .catch((error) => console.error("Error fetching products:", error));
  }, []);

  const handleAssign = (idProducto) => {
    navigate(`/assigned-edit`, { state: { idProducto } });
  };

  return (
    <div className="container">
      <h2 className="my-4">Equipos Asignados</h2>

      <table className="table table-striped">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nombre del Producto</th>
            <th>Descripción</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Cantidad de Memoria</th>
            <th>Capacidad del Disco</th>
            <th>Estado</th>
            <th>Usuario Asignado</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {products
            .filter((product) => product.estado === "Asignado")
            .map((product) => (
              <tr key={product.idProducto}>
                <td>{product.idProducto}</td>
                <td>{product.nombreProducto}</td>
                <td>{product.descripcion}</td>
                <td>{product.marca}</td>
                <td>{product.modelo}</td>
                <td>{product.cantidadMemoria}</td>
                <td>{product.capacidadDisco}</td>
                <td>{product.estado}</td>
                <td>{product.nombreCompleto}</td>
                <td>
                  <button
                    className="btn btn-success btn-sm"
                    onClick={() =>
                      handleAssign(product.idProducto, product.codigo)
                    }
                  >
                    Editar
                  </button>
                </td>
              </tr>
            ))}
        </tbody>
      </table>
    </div>
  );
};

export default ProductListAssignedForm;
