// src/components/ProductListAvailableForm.js
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";

const ProductListAvailableForm = () => {
  const [products, setProducts] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    // Fetch products
    axios
      .get("http://localhost:8080/inventory/api/productos")
      .then((response) => setProducts(response.data))
      .catch((error) => console.error("Error fetching products:", error));
  }, []);

  const handleAssign = (idProducto) => {
    navigate(`/assigned`, { state: { idProducto } });
  };

  return (
    <div className="container">
      <h2 className="my-4">Equipos Disponibles</h2>

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
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {products
            .filter((product) => product.estado === "Disponible")
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
                <td>
                  <button
                    className="btn btn-success btn-sm"
                    onClick={() =>
                      handleAssign(product.idProducto, product.codigo)
                    }
                  >
                    Asignar
                  </button>
                </td>
              </tr>
            ))}
        </tbody>
      </table>
    </div>
  );
};

export default ProductListAvailableForm;
