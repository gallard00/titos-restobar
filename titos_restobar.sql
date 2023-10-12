-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 11-10-2023 a las 21:48:23
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.2.0

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

DROP TABLE IF EXISTS `items`;
CREATE TABLE IF NOT EXISTS `items` (
  `id_items` int NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `costo_total` double NOT NULL,
  `id_productos` int NOT NULL,
  `id_pedidos` int NOT NULL,
  PRIMARY KEY (`id_items`),
  KEY `id_productos` (`id_productos`),
  KEY `id_pedidos` (`id_pedidos`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesas`
--

DROP TABLE IF EXISTS `mesas`;
CREATE TABLE IF NOT EXISTS `mesas` (
  `id_mesas` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `id_pedidos` int NOT NULL,
  PRIMARY KEY (`id_mesas`),
  KEY `id_pedidos` (`id_pedidos`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
CREATE TABLE IF NOT EXISTS `pedidos` (
  `id_pedidos` int NOT NULL AUTO_INCREMENT,
  `fecha_apertura` datetime NOT NULL,
  `fecha_cierre` datetime NOT NULL,
  `descuento` double NOT NULL,
  `costo_total` double NOT NULL,
  `id_items` int NOT NULL,
  PRIMARY KEY (`id_pedidos`),
  KEY `id_items` (`id_items`),
  KEY `id_items_2` (`id_items`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precios`
--

DROP TABLE IF EXISTS `precios`;
CREATE TABLE IF NOT EXISTS `precios` (
  `id_precios` int NOT NULL AUTO_INCREMENT,
  `valor` double NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id_precios`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE IF NOT EXISTS `productos` (
  `id_productos` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `costo` double NOT NULL,
  `id_precios` int NOT NULL,
  PRIMARY KEY (`id_productos`),
  KEY `id_precios` (`id_precios`),
  KEY `id_precios_2` (`id_precios`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_no_elaborados`
--

DROP TABLE IF EXISTS `productos_no_elaborados`;
CREATE TABLE IF NOT EXISTS `productos_no_elaborados` (
  `id_productos_no_elaborados` int NOT NULL AUTO_INCREMENT,
  `stock` int NOT NULL,
  `id_productos` int NOT NULL,
  PRIMARY KEY (`id_productos_no_elaborados`),
  KEY `id_productos` (`id_productos`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
