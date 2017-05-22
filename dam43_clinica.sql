-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 16-05-2017 a las 19:54:38
-- Versión del servidor: 5.6.35
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dam43_clinica`
--
CREATE DATABASE IF NOT EXISTS `dam43_clinica` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dam43_clinica`;

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bill`
--

CREATE TABLE `bill` (
  `idbill` int(11) NOT NULL,
  `idper` varchar(9) NOT NULL,
  `date_bill` date NOT NULL,
  `observations` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bill`
--

INSERT INTO `bill` (`idbill`, `idper`, `date_bill`, `observations`) VALUES
(1, '45124578S', '2017-02-19', 'factura 1'),
(2, '12345678A', '2017-02-19', 'factura 2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bill_lines`
--

CREATE TABLE `bill_lines` (
  `idbill_lines` int(11) NOT NULL,
  `idbill` int(11) NOT NULL,
  `idproduct` int(11) NOT NULL,
  `quantity` int(11) DEFAULT '1',
  `price` double DEFAULT NULL,
  `taxes` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT '0',
  `idpet` int(11) DEFAULT NULL,
  `observations` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bill_lines`
--

INSERT INTO `bill_lines` (`idbill_lines`, `idbill`, `idproduct`, `quantity`, `price`, `taxes`, `discount`, `idpet`, `observations`) VALUES
(1, 2, 1, 1, 20, 21, 0, 1, 'revisión'),
(2, 2, 3, 1, 5, 21, 0, 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultation`
--

CREATE TABLE `consultation` (
  `idcons` int(11) NOT NULL,
  `idpet` int(11) NOT NULL,
  `date_consultation` date NOT NULL,
  `reason` varchar(200) NOT NULL,
  `diagnosis` varchar(200) NOT NULL,
  `treatment` varchar(200) DEFAULT NULL,
  `observation` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `consultation`
--

INSERT INTO `consultation` (`idcons`, `idpet`, `date_consultation`, `reason`, `diagnosis`, `treatment`, `observation`) VALUES
(3, 1, '2017-02-20', 'convulsiones', 'epilepsia', 'acariciar con estaca cuadrada', 'vender estaca 20x20'),
(23, 1, '2020-02-02', 'perdida de pelo', 'tiña', 'acariciar con estaca cuadrada', 'Si la envidia fuera tiña'),
(60, 2, '2010-12-12', 'prueba', 'prueba', 'prueba', 'prueba');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dates`
--

CREATE TABLE `dates` (
  `iddate` int(11) NOT NULL,
  `date` date NOT NULL,
  `hour` time NOT NULL,
  `idperson` varchar(9) NOT NULL,
  `type` tinyint(1) NOT NULL,
  `observations` varchar(45) DEFAULT NULL,
  `nameper` varchar(50) NOT NULL,
  `namepet` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `dates`
--

INSERT INTO `dates` (`iddate`, `date`, `hour`, `idperson`, `type`, `observations`, `nameper`, `namepet`) VALUES
(8, '2017-02-20', '09:00:00', '01234567A', 0, 'sangrado leve', 'Esau', 'bola de nieve I'),
(9, '2017-02-20', '09:30:00', '24587414D', 0, NULL, 'Emanuel', '-'),
(10, '2017-02-21', '10:30:00', '24587414D', 0, NULL, 'maria', '-'),
(11, '2017-02-20', '11:00:00', '12345678A', 1, NULL, 'Esau', 'bola de nieve II'),
(12, '2017-02-20', '11:30:00', '45124578S', 1, NULL, 'Irene', 'no indica'),
(13, '2017-02-20', '12:30:00', '77884455t', 0, NULL, 'La prima tuerta de irene', '-'),
(14, '2017-02-21', '10:30:00', '24587414D', 0, NULL, 'McArena\r\n', 'guau'),
(15, '2017-02-21', '12:30:00', '77884455t', 1, NULL, 'Victor', 'no indica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doc`
--

CREATE TABLE `doc` (
  `iddoc` int(11) NOT NULL,
  `idcons` int(11) NOT NULL,
  `date_doc` date NOT NULL,
  `description` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `fileattached` varchar(250) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `doc`
--

INSERT INTO `doc` (`iddoc`, `idcons`, `date_doc`, `description`, `fileattached`) VALUES
(4, 3, '2017-02-16', 'Radiografía columna\r\n', NULL),
(5, 3, '2017-02-18', 'Prueba de sangre', NULL),
(6, 23, '2017-02-19', 'biopsia', NULL),
(7, 60, '2017-02-18', 'prueba sangre', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person`
--

CREATE TABLE `person` (
  `idperson` varchar(9) NOT NULL,
  `name_per` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `role` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `person`
--

INSERT INTO `person` (`idperson`, `name_per`, `address`, `phone`, `email`, `password`, `role`) VALUES
('01234567A', 'Esau', 'Calle Falsa', '+adsasdas', 'email@gmail.com', 'admin', 1),
('12345678A', 'Victor', 'Calle Falsa', '+325135643', 'email@gmail.com', '66666666G', 4),
('24587414D', 'Emanuel', 'Calle Falsa', '+3451424', 'email@gmail.com', '24587414D', 4),
('45124578S', 'Maca', 'Calle Fake', '+3451424', 'email@gmail.com', 'pelu', 3),
('45654124T', 'Samu', 'Calle Falsa', '+3451424', 'email@gmail.com', 'vet', 2),
('77884455t', 'Optimus Prime', 'Cybertron', '000001', 'autobots222@email.com', '77884455t', 4),
('87654321B', 'Irene Infante', 'Calle Vicuña', '+3451424', 'beata@gmail.com', '8745544G', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pets`
--

CREATE TABLE `pets` (
  `idpets` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `animal` varchar(45) NOT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `race` varchar(45) DEFAULT NULL,
  `colour` varchar(45) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `idper` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pets`
--

INSERT INTO `pets` (`idpets`, `name`, `animal`, `gender`, `race`, `colour`, `birth_date`, `idper`) VALUES
(1, 'bola de nieve I', 'gato', 1, 'persa', 'negro', '2017-01-01', '01234567A'),
(2, 'bola de nieve II', 'gata', 0, 'angola', 'atigrado', '2015-01-01', '01234567A'),
(3, 'guau', 'perro', 1, 'chucho', 'marrón', '2000-05-12', '87654321B'),
(4, 'nani', 'perro', 0, 'bodeguera', 'blanca', '2000-05-12', '87654321B'),
(7, 'imperioso', 'caballo', 1, 'pse', 'marrón', '2012-02-02', '01234567A'),
(8, 'isidoro', 'gato', 1, '-', 'naranja', '2014-02-02', '01234567A'),
(9, 'rex', 'perro', 1, 'pastor alemán', 'marron claro', '2014-02-02', '01234567A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

CREATE TABLE `products` (
  `idproducts` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `taxes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `products`
--

INSERT INTO `products` (`idproducts`, `name`, `price`, `taxes`) VALUES
(1, 'Consulta', 22, 21),
(2, 'Consulta urgencia', 25, 21),
(3, 'Vitaminas', 10, 21),
(4, 'Estaca cuadrada', 0, 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vaccinecal`
--

CREATE TABLE `vaccinecal` (
  `name` varchar(45) NOT NULL,
  `typeanimal` varchar(45) NOT NULL,
  `periodicityMonths` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vaccinecal`
--

INSERT INTO `vaccinecal` (`name`, `typeanimal`, `periodicityMonths`) VALUES
('Parvovirus', 'perros', '12'),
('Parvovirus1', 'perros', '2'),
('Parvovirus2', 'perros', '1'),
('Polivalente', 'perros', '12'),
('Polivalente1', 'perros', '1'),
('Polivalente2', 'perros', '9'),
('Rabia', 'perros', '12'),
('Rabia1', 'perros', '8');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vaccines`
--

CREATE TABLE `vaccines` (
  `idvac` int(11) NOT NULL,
  `idpet` int(11) NOT NULL,
  `date_vaccine` date NOT NULL,
  `observations` varchar(70) DEFAULT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vaccines`
--

INSERT INTO `vaccines` (`idvac`, `idpet`, `date_vaccine`, `observations`, `name`) VALUES
(1, 1, '2020-01-01', 'requiere sedación', 'Rabia'),
(2, 1, '2017-02-18', '', 'Polivalente'),
(5, 2, '2017-02-18', '21:38', 'Rabia'),
(7, 1, '2010-01-02', '21:46', 'Rabia1'),
(8, 2, '2001-11-11', 'sangrado leve', 'Rabia1'),
(9, 2, '2050-05-05', 'requiere e. cuadrada', 'Polivalente'),
(10, 2, '1999-09-11', 'erupción', 'Parvovirus');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`idbill`),
  ADD KEY `idperbill_idx` (`idper`);

--
-- Indices de la tabla `bill_lines`
--
ALTER TABLE `bill_lines`
  ADD PRIMARY KEY (`idbill_lines`,`idbill`),
  ADD KEY `idpetbill_idx` (`idpet`),
  ADD KEY `idprod_idx` (`idproduct`),
  ADD KEY `idbill_idx` (`idbill`);

--
-- Indices de la tabla `consultation`
--
ALTER TABLE `consultation`
  ADD PRIMARY KEY (`idcons`),
  ADD KEY `idpet_idx` (`idpet`);

--
-- Indices de la tabla `dates`
--
ALTER TABLE `dates`
  ADD PRIMARY KEY (`iddate`,`date`,`idperson`,`type`),
  ADD KEY `idperdate_idx` (`idperson`);

--
-- Indices de la tabla `doc`
--
ALTER TABLE `doc`
  ADD PRIMARY KEY (`iddoc`),
  ADD KEY `idcons_idx` (`idcons`);

--
-- Indices de la tabla `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`idperson`);

--
-- Indices de la tabla `pets`
--
ALTER TABLE `pets`
  ADD PRIMARY KEY (`idpets`),
  ADD KEY `idper_idx` (`idper`);

--
-- Indices de la tabla `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`idproducts`);

--
-- Indices de la tabla `vaccinecal`
--
ALTER TABLE `vaccinecal`
  ADD PRIMARY KEY (`name`);

--
-- Indices de la tabla `vaccines`
--
ALTER TABLE `vaccines`
  ADD PRIMARY KEY (`idvac`),
  ADD KEY `idpetvac_idx` (`idpet`),
  ADD KEY `idvacname_idx` (`name`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bill`
--
ALTER TABLE `bill`
  MODIFY `idbill` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `bill_lines`
--
ALTER TABLE `bill_lines`
  MODIFY `idbill_lines` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `consultation`
--
ALTER TABLE `consultation`
  MODIFY `idcons` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;
--
-- AUTO_INCREMENT de la tabla `dates`
--
ALTER TABLE `dates`
  MODIFY `iddate` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT de la tabla `doc`
--
ALTER TABLE `doc`
  MODIFY `iddoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `pets`
--
ALTER TABLE `pets`
  MODIFY `idpets` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `products`
--
ALTER TABLE `products`
  MODIFY `idproducts` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `vaccines`
--
ALTER TABLE `vaccines`
  MODIFY `idvac` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `idperbill` FOREIGN KEY (`idper`) REFERENCES `person` (`idperson`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `bill_lines`
--
ALTER TABLE `bill_lines`
  ADD CONSTRAINT `idbill` FOREIGN KEY (`idbill`) REFERENCES `bill` (`idbill`) ON UPDATE CASCADE,
  ADD CONSTRAINT `idpetbill` FOREIGN KEY (`idpet`) REFERENCES `pets` (`idpets`) ON UPDATE CASCADE,
  ADD CONSTRAINT `idprod` FOREIGN KEY (`idproduct`) REFERENCES `products` (`idproducts`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `consultation`
--
ALTER TABLE `consultation`
  ADD CONSTRAINT `idpet` FOREIGN KEY (`idpet`) REFERENCES `pets` (`idpets`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `dates`
--
ALTER TABLE `dates`
  ADD CONSTRAINT `idperdate` FOREIGN KEY (`idperson`) REFERENCES `person` (`idperson`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `doc`
--
ALTER TABLE `doc`
  ADD CONSTRAINT `idcons` FOREIGN KEY (`idcons`) REFERENCES `consultation` (`idcons`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `pets`
--
ALTER TABLE `pets`
  ADD CONSTRAINT `idper` FOREIGN KEY (`idper`) REFERENCES `person` (`idperson`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `vaccines`
--
ALTER TABLE `vaccines`
  ADD CONSTRAINT `idpetvac` FOREIGN KEY (`idpet`) REFERENCES `pets` (`idpets`) ON UPDATE CASCADE,
  ADD CONSTRAINT `idvacname` FOREIGN KEY (`name`) REFERENCES `vaccinecal` (`name`) ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
