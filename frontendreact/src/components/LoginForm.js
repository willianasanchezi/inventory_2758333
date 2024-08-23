// src/components/LoginForm.js
import React, { useState } from 'react';
import { useAuth } from '../contexts/AuthContext';
import { jwtDecode } from 'jwt-decode';

const LoginForm = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const { login } = useAuth();

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await fetch('http://localhost:8080/inventory/api/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ username, password })
            });
            if (!response.ok) {
                throw new Error('Invalid username or password');
            }
            const data = await response.json();
            console.log('Data JSON:', data);
            const decodedToken = jwtDecode(data.token);
            console.log('Decoded Token:', decodedToken);
            const roles = decodedToken.roles;
            console.log('Roles from token:', roles);
            const user = decodedToken.sub
            console.log('Usuario:', user);
            console.log('Token:', data.token);
            login(data.token, roles, user); // Asegúrate de pasar el objeto `user`
        } catch (error) {
            console.error('Error:', error);
            setError('Login failed: ' + error.message);
        }
    };

    return (
        <div className="container mt-5">
            <h2>Login</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label htmlFor="username">Username:</label>
                    <input
                        type="text"
                        className="form-control"
                        id="username"
                        name="username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password:</label>
                    <input
                        type="password"
                        className="form-control"
                        id="password"
                        name="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>
                <button type="submit" className="btn btn-primary">Login</button>
            </form>
            {error && <div className="alert alert-danger mt-3">{error}</div>}
        </div>
    );
};

export default LoginForm;
