// src/components/BackToMenuButton.js
import React from 'react';
import { useNavigate } from 'react-router-dom';

const BackToMenuButton = () => {
    const navigate = useNavigate();

    return (
        <button onClick={() => navigate('/menu')}>
            Regresar al Menú
        </button>
    );
};

export default BackToMenuButton;
