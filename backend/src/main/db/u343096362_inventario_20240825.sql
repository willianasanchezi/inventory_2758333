-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 192.168.0.3:3308:3306
-- Generation Time: Aug 25, 2024 at 07:52 PM
-- Server version: 9.0.1
-- PHP Version: 8.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `u343096362_inventario`
--

-- --------------------------------------------------------

--
-- Table structure for table `asignaciones`
--

CREATE TABLE `asignaciones` (
  `id_asignacion` int NOT NULL,
  `id_producto` int NOT NULL,
  `id_usuario` int NOT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_asignacion` timestamp NOT NULL,
  `fecha_devolucion_programada` timestamp NOT NULL,
  `fecha_devolucion_real` timestamp NOT NULL,
  `estado_asignacion` varchar(255) NOT NULL,
  `tipo_asignacion` varchar(255) NOT NULL COMMENT 'Prestamo, Asignacion',
  `observaciones` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `mantenimientos`
--

CREATE TABLE `mantenimientos` (
  `id_mantenimiento` int NOT NULL,
  `id_usuario` int NOT NULL COMMENT 'Usuario Equipo Mantenimiento',
  `id_producto` int NOT NULL,
  `estado_mantenimiento` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'en_mantenimiento, entregado, programado',
  `fecha_programacion_mantenimiento` timestamp NOT NULL,
  `fecha_devolucion_mantenimiento` timestamp NOT NULL,
  `fecha_mantenimiento` timestamp NOT NULL,
  `observacion_mantenimiento` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `productos`
--

CREATE TABLE `productos` (
  `id_producto` int NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `nombre_producto` varchar(255) NOT NULL,
  `descripcion` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `marca` varchar(50) DEFAULT NULL,
  `modelo` varchar(50) DEFAULT NULL,
  `cantidad_memoria` varchar(50) DEFAULT NULL,
  `capacidad_disco` varchar(50) DEFAULT NULL,
  `estado` varchar(50) NOT NULL,
  `cantidad` int NOT NULL,
  `precio_unitario` decimal(10,2) NOT NULL,
  `fecha_registro` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `user_creo_registro` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `productos`
--

INSERT INTO `productos` (`id_producto`, `codigo`, `nombre_producto`, `descripcion`, `marca`, `modelo`, `cantidad_memoria`, `capacidad_disco`, `estado`, `cantidad`, `precio_unitario`, `fecha_registro`, `user_creo_registro`) VALUES
(1, '1', 'Portatil', 'Portatil', 'Dell', 'z23', '1024', '256', 'Bueno', 1, 1000.00, '2024-08-08 19:28:55', ''),
(8, 'A005', 'Poratil', 'Color Azul', 'DELL', 'AD', '1024', '256', 's', 1, 1000.00, '2024-08-24 23:24:27', ''),
(9, 'A001', 'Poratil', 'Color Azul', 'DELL', 'AD', '1024', '256', 'n', 1, 1000.00, '2024-08-24 23:30:35', ''),
(10, 'A007', 'Portatil', 'a', 'DELL', '1010', '8000', '512', 'Disponible', 1, 2000.00, '2024-08-24 23:49:17', ''),
(11, 'A006', 'Poratil', 'Color Azul', 'DELL', 'AD', '1024', '256', 'Disponible', 1, 1000.00, '2024-08-25 00:20:05', 'administrador@com'),
(15, 'A008', 'Portatil', 'Color Azul', 'HP', 'AD', '1024', '128', 'Disponible', 1, 1000.00, '2024-08-25 20:31:51', 'administrador@com'),
(17, 'A009', 'Portatil', 'Temporal', 'DELL', '1234', '1024', '512', 'Disponible', 1, 1000.00, '2024-08-25 22:32:38', 'administrador@com'),
(18, 'A10', 'Portatil', 'Temporal', 'DELL', '9010', '1024', '512', 'Disponible', 1, 1000.00, '2024-08-26 00:43:35', 'administrador@com');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id_rol` int NOT NULL,
  `codigo_rol` int NOT NULL,
  `nombre_permiso` varchar(50) NOT NULL,
  `descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id_rol`, `codigo_rol`, `nombre_permiso`, `descripcion`) VALUES
(1, 1, 'ADMIN', 'Permiso de administrador con todos los privilegios'),
(2, 2, 'GESTION', 'Permiso para crear y editar'),
(3, 3, 'CONSULTA', 'Permiso solo de consulta.');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nombre_completo` varchar(255) NOT NULL,
  `identificacion` varchar(50) NOT NULL,
  `correo_electronico` varchar(255) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `codigo_rol` int NOT NULL,
  `estado_usuario` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Activo' COMMENT 'Activo, Inactivo',
  `user_creo_registro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `fecha_creacion`, `nombre_completo`, `identificacion`, `correo_electronico`, `contrasena`, `codigo_rol`, `estado_usuario`, `user_creo_registro`) VALUES
(2, '2024-08-11 16:01:39', 'Administrador', '1234567890', 'administrador@com', '$2a$12$0UeiEv1ecSEB/5tWkRXYz.THBOaxLdas0PYaJx3DGDj9bbXWmrXsy', 1, 'Activo', ''),
(3, '2024-08-11 16:01:39', 'user01', '7890009', 'user01@com', '$2a$12$ANrUJ0uD0o0hyWpyMbPGY.mp3hMmDzU8m5ePhg21fVREIbY7ctP26', 2, 'Inactivo', ''),
(12, '2024-08-11 16:01:39', 'user02', '123456', 'user02@com', '$2a$12$qSu1N0cq4Fz5O6Mv1yEGz.HDnddCmJNW5gNmubN8zS8ZJaCwap09O', 2, 'Activo', ''),
(15, '2024-08-11 16:01:39', 'user03', '1233', 'user03@com', '$2a$12$CmIq2KmsoJLp4SZ1jjhQ6eGiiUBQUGg7hZSckH4wRC.VuY5x9faLO', 3, 'Activo', ''),
(38, '2024-08-23 04:32:23', 'user14', '12345678', 'user14@com', '$2a$12$39QYq8U7mEjMtEeN.4WzWu.Q/FsEN1rKKEQXN9ueQXAhMUVKvq18K', 1, 'Activo', 'administrador@com'),
(39, '2024-08-26 00:40:41', 'user15', '123', 'user15@com', '$2a$12$eyNv1l0Tm.XRIJ7H2SIXzuNLtm8DkPyChsxrNr7t7z94Bg6e.xfeW', 1, 'Activo', 'administrador@com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `asignaciones`
--
ALTER TABLE `asignaciones`
  ADD PRIMARY KEY (`id_asignacion`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indexes for table `mantenimientos`
--
ALTER TABLE `mantenimientos`
  ADD PRIMARY KEY (`id_mantenimiento`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_usuario` (`id_usuario`) USING BTREE;

--
-- Indexes for table `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`),
  ADD UNIQUE KEY `codigo` (`codigo`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_rol`),
  ADD UNIQUE KEY `codigo_rol` (`codigo_rol`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `correo_electronico` (`correo_electronico`),
  ADD KEY `codigo_rol` (`codigo_rol`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `asignaciones`
--
ALTER TABLE `asignaciones`
  MODIFY `id_asignacion` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `mantenimientos`
--
ALTER TABLE `mantenimientos`
  MODIFY `id_mantenimiento` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `productos`
--
ALTER TABLE `productos`
  MODIFY `id_producto` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id_rol` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mantenimientos`
--
ALTER TABLE `mantenimientos`
  ADD CONSTRAINT `mantenimientos_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`);

--
-- Constraints for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`codigo_rol`) REFERENCES `roles` (`codigo_rol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
