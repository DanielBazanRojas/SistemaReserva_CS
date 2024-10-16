-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-07-2024 a las 02:19:01
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistemareserva`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `idCargo` int(11) NOT NULL,
  `nombreCargo` varchar(30) NOT NULL,
  `estado` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`idCargo`, `nombreCargo`, `estado`) VALUES
(1, 'Empleado', b'1'),
(2, 'Administrador', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nombreCliente` varchar(30) NOT NULL,
  `apellidoCliente` varchar(30) NOT NULL,
  `tipoDocumento` varchar(30) NOT NULL,
  `numDocumento` varchar(15) NOT NULL,
  `contacto` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nombreCliente`, `apellidoCliente`, `tipoDocumento`, `numDocumento`, `contacto`) VALUES
(1, 'Sebastían', 'Torre Yampufe', 'DNI', '74859612', '951753852'),
(2, 'Vanessa', 'Figueroa Salazar', 'RUC', '10784523964', '963741456'),
(3, 'Juanito', 'Perez', 'DNI', '11997733', '992288335'),
(4, 'fabricio', 'hoyos', 'DNI', '12345678', '123456789'),
(5, 'lionel', 'messi', 'DNI', '7777', '944111000'),
(7, 'Jose', 'Juan', 'DNI', '55555', '999888777'),
(8, 'Francisco', 'Perez', 'DNI', '5555', '911222333');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallereserva`
--

CREATE TABLE `detallereserva` (
  `idDetalle_Reserva` int(11) NOT NULL,
  `idReserva` int(11) NOT NULL,
  `idHabitacion` int(11) NOT NULL,
  `cantidadDias` tinyint(4) NOT NULL,
  `montoTotal` decimal(7,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detallereserva`
--

INSERT INTO `detallereserva` (`idDetalle_Reserva`, `idReserva`, `idHabitacion`, `cantidadDias`, `montoTotal`) VALUES
(1, 1, 1, 2, 200.00),
(2, 2, 2, 2, 240.00),
(3, 3, 3, 2, 100.00),
(4, 4, 4, 2, 300.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `idHabitacion` int(11) NOT NULL,
  `numeroHabitacion` varchar(4) NOT NULL,
  `pisoHabitacion` varchar(7) NOT NULL,
  `precioDiario` decimal(7,2) NOT NULL,
  `estado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`idHabitacion`, `numeroHabitacion`, `pisoHabitacion`, `precioDiario`, `estado`) VALUES
(1, '201', 'Piso 02', 100.00, 'Reservado'),
(2, '202', 'Piso 02', 120.00, 'Reservado'),
(3, '503', 'Piso 05', 50.00, 'Reservado'),
(4, '704', 'Piso 06', 150.00, 'Reservado'),
(5, '500', 'Piso 05', 50.00, 'Disponible');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `idPago` int(11) NOT NULL,
  `formaPago` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`idPago`, `formaPago`) VALUES
(1, 'Efectivo'),
(2, 'Yape'),
(3, 'Plim');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL,
  `serieReserva` varchar(10) NOT NULL,
  `correlativoReserva` varchar(10) NOT NULL,
  `fechaReserva` date NOT NULL,
  `idPago` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idTrabajador` int(11) NOT NULL,
  `montoTotal` decimal(7,2) NOT NULL,
  `estado` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`idReserva`, `serieReserva`, `correlativoReserva`, `fechaReserva`, `idPago`, `idCliente`, `idTrabajador`, `montoTotal`, `estado`) VALUES
(1, 'R0001', '00001', '2023-10-14', 1, 1, 1, 200.00, b'1'),
(2, 'R0001', '00002', '2023-10-14', 2, 2, 1, 240.00, b'1'),
(3, 'R0001', '00003', '2023-10-14', 1, 3, 1, 100.00, b'1'),
(4, 'R0001', '00004', '2024-07-10', 1, 5, 1, 300.00, b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipohabitacion`
--

CREATE TABLE `tipohabitacion` (
  `tipoHabitacion` varchar(20) NOT NULL,
  `caracteristicas` varchar(255) NOT NULL,
  `idHabitacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipohabitacion`
--

INSERT INTO `tipohabitacion` (`tipoHabitacion`, `caracteristicas`, `idHabitacion`) VALUES
('Simple', '1 Cama plaza y media, Tv 50\'\' Samsung, Acceso Wifi... 	', 1),
('Simple', 'Wifi, tv 50\'\', recamara equipada', 2),
('Pobre', 'No tiene nada', 3),
('Doble', 'Todo', 4),
('Simple', 'Simple', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajador`
--

CREATE TABLE `trabajador` (
  `idTrabajador` int(11) NOT NULL,
  `nombreTrabajador` varchar(30) NOT NULL,
  `apellidoTrabajador` varchar(30) NOT NULL,
  `tipoDocumento` varchar(30) NOT NULL,
  `numDocumento` varchar(15) NOT NULL,
  `idCargo` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `trabajador`
--

INSERT INTO `trabajador` (`idTrabajador`, `nombreTrabajador`, `apellidoTrabajador`, `tipoDocumento`, `numDocumento`, `idCargo`, `idUsuario`) VALUES
(1, 'Fabrizio', 'Hoyos Obando', 'DNI', '75841296', 1, 2),
(2, 'Stephano', 'Sanchez Medina', 'DNI', '72271235', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombreUsuario` varchar(30) NOT NULL,
  `claveUsuario` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombreUsuario`, `claveUsuario`) VALUES
(1, 'Stephano', 'Sanchez'),
(2, 'Fabrizio', 'Hoyos');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`idCargo`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`),
  ADD UNIQUE KEY `uk_documento` (`numDocumento`),
  ADD UNIQUE KEY `uk_contacto` (`contacto`);

--
-- Indices de la tabla `detallereserva`
--
ALTER TABLE `detallereserva`
  ADD PRIMARY KEY (`idDetalle_Reserva`),
  ADD KEY `fk_DetalleReserva_Habitacion` (`idHabitacion`),
  ADD KEY `fk_DetalleReserva_Reserva` (`idReserva`);

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`idHabitacion`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`idPago`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idReserva`),
  ADD KEY `fk_ReservaCliente` (`idCliente`),
  ADD KEY `fk_ReservaTrabajador` (`idTrabajador`),
  ADD KEY `fk_ReservaPago` (`idPago`);

--
-- Indices de la tabla `tipohabitacion`
--
ALTER TABLE `tipohabitacion`
  ADD KEY `fk_Tipo_Habitacion` (`idHabitacion`);

--
-- Indices de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  ADD PRIMARY KEY (`idTrabajador`),
  ADD UNIQUE KEY `uk_documento` (`numDocumento`),
  ADD KEY `fk_CargoTrabajador` (`idCargo`),
  ADD KEY `fk_TrabajadorUsuario` (`idUsuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `idCargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `detallereserva`
--
ALTER TABLE `detallereserva`
  MODIFY `idDetalle_Reserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `idHabitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `idPago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  MODIFY `idTrabajador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detallereserva`
--
ALTER TABLE `detallereserva`
  ADD CONSTRAINT `fk_DetalleReserva_Habitacion` FOREIGN KEY (`idHabitacion`) REFERENCES `habitacion` (`idHabitacion`),
  ADD CONSTRAINT `fk_DetalleReserva_Reserva` FOREIGN KEY (`idReserva`) REFERENCES `reserva` (`idReserva`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `fk_ReservaCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  ADD CONSTRAINT `fk_ReservaPago` FOREIGN KEY (`idPago`) REFERENCES `pago` (`idPago`),
  ADD CONSTRAINT `fk_ReservaTrabajador` FOREIGN KEY (`idTrabajador`) REFERENCES `trabajador` (`idTrabajador`);

--
-- Filtros para la tabla `tipohabitacion`
--
ALTER TABLE `tipohabitacion`
  ADD CONSTRAINT `fk_Tipo_Habitacion` FOREIGN KEY (`idHabitacion`) REFERENCES `habitacion` (`idHabitacion`);

--
-- Filtros para la tabla `trabajador`
--
ALTER TABLE `trabajador`
  ADD CONSTRAINT `fk_CargoTrabajador` FOREIGN KEY (`idCargo`) REFERENCES `cargo` (`idCargo`),
  ADD CONSTRAINT `fk_TrabajadorUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
