// src/components/ProductSearchForm.js
import React, { useState } from 'react';
import axios from 'axios';
import BackToMenuButton from './BackToMenuButton';

const ProductSearchForm = () => {
  const [searchParams, setSearchParams] = useState({
    idProducto: '',
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
    fechaRegistro: '',
  });
  const [products, setProducts] = useState([]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setSearchParams({ ...searchParams, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const queryParams = new URLSearchParams(searchParams).toString();
    axios.get(`http://localhost:8080/inventory/api/productos?${queryParams}`)
      .then(response => setProducts(response.data))
      .catch(error => console.error('Error fetching products:', error));
  };

  return (
    <div className="container">
      <h2 className="my-4">Busqueda Productos</h2>
      <form onSubmit={handleSubmit}>
        {Object.keys(searchParams).map((key) => (
          <input
            key={key}
            type="text"
            name={key}
            placeholder={key.charAt(0).toUpperCase() + key.slice(1).replace(/([A-Z])/g, ' $1').trim()}
            value={searchParams[key]}
            onChange={handleChange}
            style={{marginRight: '10px'}}
          />
        ))}
        <button type="submit" className="btn btn-primary">Buscar</button>
      </form>
      {products.length > 0 && (
        <table className="table table-striped mt-4">
          <thead>
            <tr>
              {Object.keys(products[0]).map((key) => (
                <th key={key}>{key.charAt(0).toUpperCase() + key.slice(1).replace(/([A-Z])/g, ' $1').trim()}</th>
              ))}
            </tr>
          </thead>
          <tbody>
            {products.map((product) => (
              <tr key={product.idProducto}>
                {Object.keys(product).map((key) => (
                  <td key={key}>{product[key]}</td>
                ))}
              </tr>
            ))}
          </tbody>
        </table>
      )}
      {/*<BackToMenuButton />*/}
    </div>
  );
};

export default ProductSearchForm;
