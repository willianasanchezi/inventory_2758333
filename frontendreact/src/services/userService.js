// src/services/userService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/inventory/api';

export const getRoles = async () => {
    try {
        const response = await axios.get(`${API_URL}/roles`);
        return response.data;
    } catch (error) {
        console.error('Error al obtener los roles', error);
        throw error;
    }
};

export const createUser = async (userData) => {
    try {
        const response = await axios.post(`${API_URL}/usuarios`, userData);
        return response.data;
    } catch (error) {
        console.error('Error al crear el usuario', error);
        throw error;
    }
};

export const getUser = async (id) => {
    try {
        const response = await axios.get(`${API_URL}/usuarios/${id}`);
        return response.data;
    } catch (error) {
        console.error('Error al obtener el usuario con id ${id}', error);
        throw error;
    }
};

export const updateUser = async (id, userData) => {
    try {
        const response = await axios.put(`${API_URL}/usuarios/${id}`, userData);
        return response.data;
    } catch (error) {
        console.error('Error al actualizar el usuario con id ${id}', error);
        throw error;
    }
};

