// src/components/UserListForm.js
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import BackToMenuButton from './BackToMenuButton';

const UserListForm = () => {
    const [users, setUsers] = useState([]);
    const [roles, setRoles] = useState([]);

    useEffect(() => {
        // Fetch users
        axios.get('http://localhost:8080/inventory/api/usuarios')
            .then(response => setUsers(response.data))
            .catch(error => console.error('Error fetching users:', error));

        // Fetch roles
        axios.get('http://localhost:8080/inventory/api/roles')
            .then(response => setRoles(response.data))
            .catch(error => console.error('Error fetching roles:', error));
    }, []);

    const getRoleName = (codigoRol) => {
        const role = roles.find(role => role.codigoRol === codigoRol);
        return role ? role.nombrePermiso : 'Desconocido';
    };

    return (
        <div className="container">
            <h2 className="my-4">Listado de usuarios</h2>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre Completo</th>
                        <th>Identificación</th>
                        <th>Correo Electrónico</th>
                        {/* <th>Contraseña</th> */}
                        <th>Rol</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    {users.map(user => (
                        <tr key={user.idUsuario}>
                            <td>{user.idUsuario}</td>
                            <td>{user.nombreCompleto}</td>
                            <td>{user.identificacion}</td>
                            <td>{user.correoElectronico}</td>
                            {/* <td>{user.contrasena}</td>  */}
                            <td>{getRoleName(user.codigoRol)}</td>
                            <td>
                                <Link to={`/users/edit/${user.idUsuario}`} className="btn btn-warning btn-sm">Editar</Link>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <div className="mt-4">
                <Link to="/users" className="btn btn-primary">Crear Usuario</Link>
            </div>
            {/* <BackToMenuButton /> */}
        </div>
    );
};

export default UserListForm;

