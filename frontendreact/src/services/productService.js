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
