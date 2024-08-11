// src/services/userService.js
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/inventory/api';

export const getRoles = async () => {
    try {
        const response = await axios.get(`${API_BASE_URL}/roles`);
        return response.data;
    } catch (error) {
        console.error('Error al obtener los roles', error);
        throw error;
    }
};

export const createUser = async (userData) => {
    try {
        const response = await axios.post(`${API_BASE_URL}/usuarios`, userData);
        return response.data;
    } catch (error) {
        console.error('Error al crear el usuario', error);
        throw error;
    }
};
