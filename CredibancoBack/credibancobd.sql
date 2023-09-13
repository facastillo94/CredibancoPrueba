-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-09-2023 a las 04:51:02
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `credibancobd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjeta`
--

CREATE TABLE `tarjeta` (
  `id_tarjeta` int(11) NOT NULL,
  `numeroproducto` varchar(255) DEFAULT NULL,
  `numerotarjeta` varchar(255) DEFAULT NULL,
  `fechacreacion` datetime(6) DEFAULT NULL,
  `fechavencimiento` datetime(6) DEFAULT NULL,
  `saldo` decimal(38,2) DEFAULT NULL,
  `activa_tarjeta` int(2) NOT NULL COMMENT '1=Activa 0=Inactiva',
  `bloqueada_tarjeta` int(2) NOT NULL COMMENT '1=Bloqueada 0=No Bloqueada'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tarjeta`
--

INSERT INTO `tarjeta` (`id_tarjeta`, `numeroproducto`, `numerotarjeta`, `fechacreacion`, `fechavencimiento`, `saldo`, `activa_tarjeta`, `bloqueada_tarjeta`) VALUES
(3, '1234567890', '1234567890123456', '2023-09-12 00:00:00.000000', '2025-09-12 00:00:00.000000', '1000000.00', 1, 1),
(4, '1234567890', '1234567890121456', '2023-09-12 00:00:00.000000', '2025-09-12 00:00:00.000000', '10100.00', 1, 1),
(5, '1234567890', '1234567890263467', '2023-09-12 00:00:00.000000', '2025-10-12 00:00:00.000000', '2000000.00', 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaccion`
--

CREATE TABLE `transaccion` (
  `id_transaccion` int(11) NOT NULL,
  `id_tarjeta_transaccion` int(11) NOT NULL,
  `monto_transaccion` decimal(12,2) NOT NULL,
  `fecha_transaccion` datetime NOT NULL DEFAULT current_timestamp(),
  `anulado` int(2) NOT NULL COMMENT '1=Anulada 0=No Anulada'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD PRIMARY KEY (`id_tarjeta`);

--
-- Indices de la tabla `transaccion`
--
ALTER TABLE `transaccion`
  ADD PRIMARY KEY (`id_transaccion`),
  ADD KEY `id_tarjeta_transaccion` (`id_tarjeta_transaccion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  MODIFY `id_tarjeta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `transaccion`
--
ALTER TABLE `transaccion`
  MODIFY `id_transaccion` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `transaccion`
--
ALTER TABLE `transaccion`
  ADD CONSTRAINT `transaccion_ibfk_1` FOREIGN KEY (`id_tarjeta_transaccion`) REFERENCES `tarjeta` (`id_tarjeta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
