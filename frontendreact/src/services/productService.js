// src/services/productService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/inventory/api/productos';

export const createProduct = async (productData) => {
    try {
        const response = await axios.post(API_URL, productData);
        return response.data;
    } catch (error) {
        // Maneja el error como consideres necesario
        throw error;
    }
};

export const getProducts = async () => {  
    try {  
        const response = await axios.get(API_URL);  
        return response.data;  
    } catch (error) {  
        throw error;  
    }  
};  

export const updateProductStatus = async (idProducto, estado) => {
    const response = await axios.patch(`${API_URL}/${idProducto}`, { estado });
    console.log('Actualizacion estado:', response.data)
    return response.data;
};