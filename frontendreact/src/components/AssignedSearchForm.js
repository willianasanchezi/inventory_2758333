// src/components/AssignedSearchForm.js
import React, { useState } from 'react';  
import axios from 'axios';  
  
const AssignedSearchForm = () => {
    const [searchParams, setSearchParams] = useState({  
        idProducto: '',  
        idUsuario: '',  
        fechaCreacion: '',  
        fechaAsignacion: '',  
        fechaDevolucionProgramada: '',  
        fechaDevolucionReal: '',  
        estadoAsignacion: '',  
        tipoAsignacion: '',  
        observaciones: ''  
    });  
    const [asignaciones, setAsignaciones] = useState([]);  
  
    const handleChange = (e) => {  
        const { name, value } = e.target;  
        setSearchParams({ ...searchParams, [name]: value });  
    };  
  
    const handleSubmit = (e) => {  
        e.preventDefault();  
        const queryParams = new URLSearchParams(searchParams).toString();  
        axios.get(`http://localhost:8080/inventory/api/asignaciones?${queryParams}`)  
            .then(response => setAsignaciones(response.data))  
            .catch(error => console.error('Error fetching asignaciones:', error));  
    };  
  
    return (  
        <div className="container">  
            <h2 className="my-4">Búsqueda de Asignaciones</h2>  
            <form onSubmit={handleSubmit}>  
                {Object.keys(searchParams).map((key) => (  
                    <input  
                        key={key}  
                        type="text"  
                        name={key}  
                        placeholder={key.charAt(0).toUpperCase() + key.slice(1).replace(/([A-Z])/g, ' $1').trim()}  
                        value={searchParams[key]}  
                        onChange={handleChange}  
                        style={{ marginRight: '10px' }}  
                    />  
                ))}  
                <button type="submit" className="btn btn-primary">Buscar</button>  
            </form>  
            {asignaciones.length > 0 && (  
                <table className="table table-striped mt-4">  
                    <thead>  
                        <tr>  
                            {Object.keys(asignaciones[0]).map((key) => (  
                                <th key={key}>{key.charAt(0).toUpperCase() + key.slice(1).replace(/([A-Z])/g, ' $1').trim()}</th>  
                            ))}  
                        </tr>  
                    </thead>  
                    <tbody>  
                        {asignaciones.map((asignacion) => (  
                            <tr key={asignacion.idAsignacion}>  
                                {Object.keys(asignacion).map((key) => (  
                                    <td key={key}>{asignacion[key]}</td>  
                                ))}  
                            </tr>  
                        ))}  
                    </tbody>  
                </table>  
            )}  
        </div>  
    );  
};  
  
export default AssignedSearchForm;
