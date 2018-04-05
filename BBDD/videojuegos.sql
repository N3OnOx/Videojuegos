-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-04-2018 a las 12:20:44
-- Versión del servidor: 5.5.59-0ubuntu0.14.04.1
-- Versión de PHP: 5.5.9-1ubuntu4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `videojuegos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `cod_cli` int(4) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `nif` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`cod_cli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE IF NOT EXISTS `facturas` (
  `cod_factura` int(4) NOT NULL,
  `cod_cli` int(4) NOT NULL,
  `fecha` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `importe` int(4) NOT NULL,
  PRIMARY KEY (`cod_factura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lfactura`
--

CREATE TABLE IF NOT EXISTS `lfactura` (
  `cod_lfactura` int(4) NOT NULL,
  `cod_factura` int(4) NOT NULL,
  `cod_cli` int(4) NOT NULL,
  `cod_prod` int(4) NOT NULL,
  `importe` int(4) NOT NULL,
  PRIMARY KEY (`cod_lfactura`,`cod_factura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `cod_prod` int(4) NOT NULL,
  `descripcion` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `importe` int(4) NOT NULL,
  PRIMARY KEY (`cod_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
