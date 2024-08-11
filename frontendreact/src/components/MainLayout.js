// src/components/MainLayout.js
import React from 'react';
import { Outlet } from 'react-router-dom';
import Menu from './Menu';

const MainLayout = () => {
    return (
        <div className="container-fluid">
            <div className="row">
                <div className="col-md-3">
                    <Menu />
                </div>
                <div className="col-md-9">
                    <Outlet />
                </div>
            </div>
        </div>
    );
};

export default MainLayout;
