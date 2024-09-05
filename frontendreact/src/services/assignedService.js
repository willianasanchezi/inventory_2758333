// src/services/AssignedService.js
import axios from 'axios';  
  
const API_URL = 'http://localhost:8080/inventory/api/asignaciones';  
  
export const createAssigned = async (assignedData) => {
    try {  
        const response = await axios.post(API_URL, assignedData);
        return response.data;  
    } catch (error) {  
        // Maneja el error como consideres necesario  
        throw error;  
    }  
};  
