// src/components/MainLayout.js
import React from 'react';
import { Outlet } from 'react-router-dom';
import Menu from './Dashboard';

const MainLayout = () => {
    return (
        <div className="container-fluid">
            <div className="row">
                <div className="col-md-3" style={{ position: 'fixed', height: '100vh', overflow: 'hidden' }}>
                    <Menu />
                </div>
                <div className="col-md-9 offset-md-3" style={{ height: '100vh', overflow: 'auto' }}>
                    <Outlet />
                </div>
            </div>
        </div>
    );
};

export default MainLayout;
