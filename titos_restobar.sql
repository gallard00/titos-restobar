-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-03-2024 a las 00:27:18
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `titos_restobar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `items`
--

CREATE TABLE `items` (
  `id_items` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `costo_total` double NOT NULL,
  `id_productos` int(11) NOT NULL,
  `id_pedidos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `items`
--

INSERT INTO `items` (`id_items`, `cantidad`, `costo_total`, `id_productos`, `id_pedidos`) VALUES
(5, 3, 3900, 10, 1),
(8, 2, 10400, 11, 1),
(11, 2, 2600, 10, 1),
(12, 5, 13000, 15, 1),
(13, 4, 10400, 16, 1),
(14, 2, 10400, 11, 1),
(17, 10, 13000, 10, 3),
(18, 10, 26000, 16, 3),
(19, 10, 26000, 15, 3),
(24, 10, 52000, 11, 3),
(26, 11, 14300, 10, 5),
(27, 3, 3900, 10, 8),
(28, 3, 15600, 11, 8),
(29, 3, 7800, 15, 8),
(30, 3, 7800, 16, 8),
(35, 5, 13000, 15, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesas`
--

CREATE TABLE `mesas` (
  `id_mesas` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mesas`
--

INSERT INTO `mesas` (`id_mesas`, `nombre`) VALUES
(1, 'Mesa 1'),
(2, 'Mesa 2'),
(3, 'Mesa 3'),
(5, 'Mesa 5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `id_pedidos` int(11) NOT NULL,
  `fecha_apertura` datetime NOT NULL,
  `fecha_cierre` datetime DEFAULT NULL,
  `descuento` double NOT NULL,
  `costo_total` double NOT NULL,
  `id_mesas` int(11) NOT NULL,
  `estado_pedido` enum('ACTIVO','CERRADO') NOT NULL DEFAULT 'ACTIVO'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`id_pedidos`, `fecha_apertura`, `fecha_cierre`, `descuento`, `costo_total`, `id_mesas`, `estado_pedido`) VALUES
(1, '2024-02-29 18:33:36', '2024-03-08 00:00:00', 0, 50700, 1, 'CERRADO'),
(3, '2024-02-29 18:58:20', '2024-03-08 21:04:06', 0, 117000, 3, 'CERRADO'),
(4, '2024-02-29 18:58:43', '2024-03-09 15:45:47', 0, 13000, 3, 'CERRADO'),
(5, '2024-02-29 18:59:30', '2024-03-08 00:00:00', 2860, 11440, 1, 'CERRADO'),
(6, '2024-02-29 19:02:19', NULL, 0, 0, 2, 'ACTIVO'),
(7, '2024-02-29 19:04:34', NULL, 0, 0, 5, 'ACTIVO'),
(8, '2024-03-09 15:41:30', '2024-03-09 15:41:57', 7020, 28080, 1, 'CERRADO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precios`
--

CREATE TABLE `precios` (
  `id_precios` int(11) NOT NULL,
  `valor` double NOT NULL,
  `fecha` datetime NOT NULL,
  `id_productos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `precios`
--

INSERT INTO `precios` (`id_precios`, `valor`, `fecha`, `id_productos`) VALUES
(14, 1300, '2024-02-25 15:47:22', 10),
(15, 5200, '2024-02-25 15:49:44', 11),
(20, 2600, '2024-02-26 17:22:27', 15),
(21, 2600, '2024-02-29 19:04:14', 16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_productos` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `costo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_productos`, `nombre`, `descripcion`, `costo`) VALUES
(10, 'Agua Mineral Villa Vicencio', 'Bottella 700 ml', 1000),
(11, 'Milanesa Napolitana', 'Guarnicion de papas fritas', 4000),
(15, 'Coca Cola Original', '700 ml', 2000),
(16, 'Mani', 'Cervecero', 2000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_no_elaborados`
--

CREATE TABLE `productos_no_elaborados` (
  `id_productos_no_elaborados` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `id_productos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos_no_elaborados`
--

INSERT INTO `productos_no_elaborados` (`id_productos_no_elaborados`, `stock`, `id_productos`) VALUES
(8, 30, 10),
(11, 60, 15),
(12, 40, 16);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id_items`),
  ADD KEY `id_productos` (`id_productos`),
  ADD KEY `id_pedidos` (`id_pedidos`);

--
-- Indices de la tabla `mesas`
--
ALTER TABLE `mesas`
  ADD PRIMARY KEY (`id_mesas`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id_pedidos`),
  ADD KEY `id_mesas` (`id_mesas`);

--
-- Indices de la tabla `precios`
--
ALTER TABLE `precios`
  ADD PRIMARY KEY (`id_precios`),
  ADD KEY `id_productos` (`id_productos`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_productos`);

--
-- Indices de la tabla `productos_no_elaborados`
--
ALTER TABLE `productos_no_elaborados`
  ADD PRIMARY KEY (`id_productos_no_elaborados`),
  ADD KEY `id_productos` (`id_productos`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `items`
--
ALTER TABLE `items`
  MODIFY `id_items` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `mesas`
--
ALTER TABLE `mesas`
  MODIFY `id_mesas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `id_pedidos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `precios`
--
ALTER TABLE `precios`
  MODIFY `id_precios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_productos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `productos_no_elaborados`
--
ALTER TABLE `productos_no_elaborados`
  MODIFY `id_productos_no_elaborados` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `items`
--
ALTER TABLE `items`
  ADD CONSTRAINT `items_ibfk_1` FOREIGN KEY (`id_productos`) REFERENCES `productos` (`id_productos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `items_ibfk_2` FOREIGN KEY (`id_pedidos`) REFERENCES `pedidos` (`id_pedidos`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ibfk_2` FOREIGN KEY (`id_mesas`) REFERENCES `mesas` (`id_mesas`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `precios`
--
ALTER TABLE `precios`
  ADD CONSTRAINT `precios_ibfk_1` FOREIGN KEY (`id_productos`) REFERENCES `productos` (`id_productos`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos_no_elaborados`
--
ALTER TABLE `productos_no_elaborados`
  ADD CONSTRAINT `productos_no_elaborados_ibfk_1` FOREIGN KEY (`id_productos`) REFERENCES `productos` (`id_productos`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
