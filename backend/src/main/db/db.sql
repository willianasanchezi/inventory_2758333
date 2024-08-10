-- Creación de la tabla de roles  
CREATE TABLE roles (  
    id_rol INT AUTO_INCREMENT PRIMARY KEY,  
    codigo_rol INT NOT NULL UNIQUE,
	nombre_permiso VARCHAR(50) NOT NULL,  
    descripcion VARCHAR(255) NOT NULL  
);  
  
-- Creación de la tabla de usuarios  
CREATE TABLE usuarios (  
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,  
    nombre_completo VARCHAR(255) NOT NULL,  
    identificacion VARCHAR(50) NOT NULL,  
    correo_electronico VARCHAR(255) NOT NULL,  
    contrasena VARCHAR(255) NOT NULL, -- Asegúrese de que la contraseña esté encriptada  
    codigo_rol INT NOT NULL,  
    FOREIGN KEY (codigo_rol) REFERENCES roles(codigo_rol)  
);  
  
-- Creación de la tabla de productos (equipos de cómputo)  
CREATE TABLE productos (  
    id_producto INT AUTO_INCREMENT PRIMARY KEY,  
    codigo VARCHAR(50) NOT NULL,  
    nombre_producto VARCHAR(255) NOT NULL,  
    descripcion TEXT,  
    marca VARCHAR(50),  
    modelo VARCHAR(50),  
    cantidad_memoria VARCHAR(50),  
    capacidad_disco VARCHAR(50),  
    estado VARCHAR(50) NOT NULL,  
    cantidad INT NOT NULL,  
    precio_unitario DECIMAL(10, 2) NOT NULL,  
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP  
);  
  
-- Creación de la tabla de préstamos  
CREATE TABLE prestamos (  
    id_prestamo INT AUTO_INCREMENT PRIMARY KEY,  
    id_usuario INT NOT NULL,  
    id_producto INT NOT NULL,  
    fecha_prestamo TIMESTAMP NOT NULL, -- DATE  
    fecha_devolucion TIMESTAMP, --DATE
    estado VARCHAR(50) NOT NULL,  
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),  
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)  
);  
  
-- Creación de la tabla de mantenimientos  
CREATE TABLE mantenimientos (  
    id_mantenimiento INT AUTO_INCREMENT PRIMARY KEY,  
    id_producto INT NOT NULL,  
    fecha_mantenimiento TIMESTAMP NOT NULL, --DATE  
    descripcion TEXT,  
    estado VARCHAR(50) NOT NULL,  
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)  
);  
