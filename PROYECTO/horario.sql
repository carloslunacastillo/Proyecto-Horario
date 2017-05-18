-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 18-05-2017 a las 02:21:45
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `horario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--
CREATE DATABASE horario; 
USE horario;
CREATE TABLE IF NOT EXISTS `alumno` (
  `NoControl` char(4) NOT NULL,
  `Contraseña` char(6) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Semestre` int(1) NOT NULL,
  `NoGrupos` int(1) DEFAULT NULL,
  PRIMARY KEY (`NoControl`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`NoControl`, `Contraseña`, `Nombre`, `Semestre`, `NoGrupos`) VALUES
('1001', '301195', 'JUAN ERNESTO PEREZ QUINTANO', 1, 0),
('1002', '569021', 'MIGUEL ANGEL PADILLA RAMIREZ', 2, 0),
('1003', '109423', 'ELIZABETH NUÑEZ ANDRADE', 3, 0),
('1004', '408277', 'LUIS GOMEZ DURAN', 4, 0),
('1005', '901213', 'MARIA GUADALUPE HERNANDEZ TORRES', 1, 0),
('1006', '692516', 'ALEJANDRA SANCHEZ RODRIGUEZ', 2, 0),
('1007', '402118', 'XIMENA FERNANDEZ PEREZ', 3, 0),
('1008', '836120', 'HUGO FLORES CAVAZOS', 4, 0),
('1009', '320036', 'PEDRO JUAREZ TORRES', 1, 0),
('1010', '619947', 'VANESA REYES TERRONES', 2, 0),
('1011', '419523', 'ALFREDO QUIROZ GONZALEZ', 3, 0),
('1012', '510938', 'ANA CLAUDIA RODRIGUEZ ROMO', 4, 0),
('1013', '045234', 'ESTEFANIA HURTADO DOMINGUEZ', 1, 0),
('1014', '100235', 'ADRIANA VAZQUEZ PARRA', 2, 0),
('1015', '520009', 'MANUEL RICO ZAPATA', 3, 0),
('1016', '142405', 'HECTOR GOMEZ FIERRO', 4, 0),
('1017', '780932', 'RICARDO SOTO LINARES', 1, 0),
('1018', '903409', 'PILAR GONZALEZ PRADO', 2, 0),
('1019', '142434', 'ULISES RIVAS ALVARADO', 3, 0),
('1020', '010330', 'MARIA DOLORES JIMENEZ HUERTA', 4, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnogrupos`
--

CREATE TABLE IF NOT EXISTS `alumnogrupos` (
  `NoControl` char(4) NOT NULL,
  `CodigoGpo` char(4) NOT NULL,
  PRIMARY KEY (`NoControl`,`CodigoGpo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dias`
--

CREATE TABLE IF NOT EXISTS `dias` (
  `CodigoGpo` char(4) NOT NULL,
  `Lunes` varchar(15) DEFAULT NULL,
  `Martes` varchar(15) DEFAULT NULL,
  `Miercoles` varchar(15) DEFAULT NULL,
  `Jueves` varchar(15) DEFAULT NULL,
  `Viernes` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`CodigoGpo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `dias`
--

INSERT INTO `dias` (`CodigoGpo`, `Lunes`, `Martes`, `Miercoles`, `Jueves`, `Viernes`) VALUES
('LV01', '07:00 - 08:40', NULL, '07:00 - 08:40', NULL, '07:00 - 07:50'),
('LV02', '08:45 - 10:25', NULL, '08:45 - 10:25', NULL, '08:45 - 09:35'),
('LV03', '10:30 - 12:10', NULL, '10:30 - 12:10', NULL, '10:30 - 11:20'),
('LV07', '10:30 - 12:10', NULL, '10:30 - 12:10', NULL, '10:30 - 11:20'),
('LV08', '12:15 - 13:55', NULL, '12:15 - 13:55', NULL, '12:15 - 13:05'),
('LV09', '07:00 - 08:40', NULL, '07:00 - 08:40', NULL, '07:00 - 07:50'),
('LV12', '12:15 - 13:55', NULL, '12:15 - 13:55', NULL, '12:15 - 13:05'),
('LV13', '07:00 - 08:40', NULL, '07:00 - 08:40', NULL, '07:00 - 07:50'),
('LV15', '08:45 - 10:25', NULL, '08:45 - 10:25', NULL, '08:45 - 09:35'),
('LV17', '07:00 - 08:40', NULL, '07:00 - 08:40', NULL, '07:00 - 07:50'),
('LV18', '10:30 - 12:10', NULL, '10:30 - 12:10', NULL, '10:30 - 11:20'),
('LV19', '08:45 - 10:25', NULL, '08:45 - 10:25', NULL, '08:45 - 09:35'),
('LV20', '12:15 - 13:55', NULL, '12:15 - 13:55', NULL, '12:15 - 13:05'),
('LV22', '10:30 - 12:10', NULL, '10:30 - 12:10', NULL, '10:30 - 11:20'),
('LV24', '12:15 - 13:55', NULL, '12:15 - 13:55', NULL, '12:15 - 13:05'),
('LX04', '12:15 - 13:05', NULL, '12:15 - 13:05', NULL, NULL),
('LX05', '07:00 - 08:40', NULL, '07:00 - 08:40', NULL, NULL),
('LX06', '08:45 - 10:25', NULL, '08:45 - 10:25', NULL, NULL),
('LX10', '08:45 - 10:25', NULL, '08:45 - 10:25', NULL, NULL),
('LX11', '10:30 - 12:10', NULL, '10:30 - 12:10', NULL, NULL),
('LX14', '10:30 - 12:10', NULL, '10:30 - 12:10', NULL, NULL),
('LX16', '12:15 - 13:55', NULL, '12:15 - 13:55', NULL, NULL),
('LX21', '07:00 - 08:40', NULL, '07:00 - 08:40', NULL, NULL),
('LX23', '08:45 - 10:25', NULL, '08:45 - 10:25', NULL, NULL),
('MV01', NULL, '12:15 - 13:55', NULL, '12:15 - 13:55', '13:05 - 13:55'),
('MV02', NULL, '10:30 - 12:10', NULL, '10:30 - 12:10', '11:20 - 12:10'),
('MV03', NULL, '08:45 - 10:25', NULL, '08:45 - 10:25', '09:35 - 10:25'),
('MV07', NULL, '07:00 - 08:40', NULL, '07:00 - 08:40', '07:50 - 08:40'),
('MV08', NULL, '10:30 - 12:10', NULL, '10:30 - 12:10', '11:20 - 12:10'),
('MV09', NULL, '10:30 - 12:10', NULL, '10:30 - 12:10', '11:20 - 12:10'),
('MV12', NULL, '08:45 - 10:25', NULL, '08:45 - 10:25', '09:35 - 10:25'),
('MV13', NULL, '10:30 - 12:10', NULL, '10:30 - 12:10', '11:20 - 12:10'),
('MV15', NULL, '12:15 - 13:55', NULL, '12:15 - 13:55', '13:05 - 13:55'),
('MV17', NULL, '08:45 - 10:25', NULL, '08:45 - 10:25', '09:35 - 10:25'),
('MV18', NULL, '12:15 - 13:55', NULL, '12:15 - 13:55', '13:05 - 13:55'),
('MV19', NULL, '10:30 - 12:10', NULL, '10:30 - 12:10', '11:20 - 12:10'),
('MV20', NULL, '08:45 - 10:25', NULL, '08:45 - 10:25', '09:35 - 10:25'),
('MV22', NULL, '12:15 - 13:55', NULL, '12:15 - 13:55', '13:05 - 13:55'),
('MV24', NULL, '08:45 - 10:25', NULL, '08:45 - 10:25', '09:35 - 10:25'),
('MX04', NULL, '07:00 - 08:40', NULL, '07:00 - 08:40', NULL),
('MX05', NULL, '10:30 - 12:10', NULL, '10:30 - 12:10', NULL),
('MX06', NULL, '12:15 - 13:55', NULL, '12:15 - 13:55', NULL),
('MX10', NULL, '12:15 - 13:55', NULL, '12:15 - 13:55', NULL),
('MX11', NULL, '08:45 - 10:25', NULL, '08:45 - 10:25', NULL),
('MX14', NULL, '07:00 - 08:40', NULL, '07:00 - 08:40', NULL),
('MX16', NULL, '07:00 - 08:40', NULL, '07:00 - 08:40', NULL),
('MX21', NULL, '12:15 - 13:55', NULL, '12:15 - 13:55', NULL),
('MX23', NULL, '07:00 - 08:40', NULL, '07:00 - 08:40', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo`
--

CREATE TABLE IF NOT EXISTS `grupo` (
  `Codigo` char(4) NOT NULL,
  `ClaveMat` char(4) NOT NULL,
  `Profesor` varchar(50) NOT NULL,
  `MaxAlumnos` int(2) NOT NULL,
  `NoAlumnos` int(2) DEFAULT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `grupo`
--

INSERT INTO `grupo` (`Codigo`, `ClaveMat`, `Profesor`, `MaxAlumnos`, `NoAlumnos`) VALUES
('LV01', 'A101', 'ING. MIGUEL MORENO TORRES', 20, 0),
('LV02', 'A102', 'ING. PAULA RODRIGUEZ GUTIERREZ', 20, 0),
('LV03', 'A103', 'ING. XAVIER PRADO HUERTA', 20, 0),
('LV07', 'A201', 'ING. MIGUEL MORENO TORRES', 20, 0),
('LV08', 'A202', 'ING. PAULA RODRIGUEZ GUTIERREZ', 20, 0),
('LV09', 'A203', 'ING. GABRIELA ZAMBRANO PORTILLO', 20, 0),
('LV12', 'A206', 'ING. MIGUEL MORENO TORRES', 20, 0),
('LV13', 'A301', 'ING. MARIA GUADALUPE ESPARZA TRUJILLO', 20, 0),
('LV15', 'A303', 'ING. ANA CECILIA LOPEZ LINARES', 20, 0),
('LV17', 'A305', 'ING. ELISA ENRIQUEZ ACEVEDO', 20, 0),
('LV18', 'A306', 'ING. RAFAEL PERALES ROCHA', 20, 0),
('LV19', 'A401', 'ING. HECTOR JIMENEZ NUÑEZ', 20, 0),
('LV20', 'A402', 'ING. PATRICIA ROJAS TERRONES', 20, 0),
('LV22', 'A404', 'ING. CARLOS RAFAEL LEVY ROJAS', 20, 0),
('LV24', 'A406', 'ING. RAFAEL PERALES ROCHA', 20, 0),
('LX04', 'A104', 'LIC. JUAN PABLO MORENO ARIAS', 15, 0),
('LX05', 'A105', 'LIC. JUAN PABLO MORENO ARIAS', 15, 0),
('LX06', 'A106', 'LIC. SANDRA PEREZ ROSAS', 15, 0),
('LX10', 'A204', 'LIC. LUIS ALBERTO CASTILLO MURILLO', 15, 0),
('LX11', 'A205', 'ING. RICARDO HURTADO JUAREZ', 15, 0),
('LX14', 'A302', 'ING. RAMON RODRIGUEZ GOMEZ', 15, 0),
('LX16', 'A304', 'LIC. LUIS ALBERTO CASTILLO MURILLO', 15, 0),
('LX21', 'A403', 'ING. ALEJANDRA SUAREZ ORNELAS', 15, 0),
('LX23', 'A405', 'ING. LAURA RIVAS DOMINGUEZ', 15, 0),
('MV01', 'A101', 'ING. LAURA RIVAS DOMINGUEZ', 20, 0),
('MV02', 'A102', 'ING. TORIBIO QUINTANO PORRAS', 20, 0),
('MV03', 'A103', 'ING. TORIBIO QUINTANO PORRAS', 20, 0),
('MV07', 'A201', 'ING. HECTOR JIMENEZ NUÑEZ', 20, 0),
('MV08', 'A202', 'ING. FERNANDO NAVARRO DUARTE', 20, 0),
('MV09', 'A203', 'ING. XAVIER PRADO HUERTA', 20, 0),
('MV12', 'A206', 'ING. LAURA RIVAS DOMINGUEZ', 20, 0),
('MV13', 'A301', 'ING. LAURA RIVAS DOMINGUEZ', 20, 0),
('MV15', 'A303', 'ING. DIEGO ANDRADE GODINEZ', 20, 0),
('MV17', 'A305', 'LIC. VERONICA LOPEZ RIVAS', 20, 0),
('MV18', 'A306', 'ING. LETICIA TRUJILLO SOLANO', 20, 0),
('MV19', 'A401', 'ING. LAURA RIVAS DOMINGUEZ', 20, 0),
('MV20', 'A402', 'ING. MIGUEL MORENO TORRES', 20, 0),
('MV22', 'A404', 'ING. CARLOS RAFAEL LEVY ROJAS', 20, 0),
('MV24', 'A406', 'ING. LETICIA TRUJILLO SOLANO', 20, 0),
('MX04', 'A104', 'LIC. TERESA DURAN BECERRA', 15, 0),
('MX05', 'A105', 'ING. ALEJANDRA SUAREZ ORNELAS', 15, 0),
('MX06', 'A106', 'LIC. ALFREDO ROMO SILVA', 15, 0),
('MX10', 'A204', 'LIC. JUAN PABLO MORENO ARIAS', 15, 0),
('MX11', 'A205', 'ING. LILIANA SALAZAR TAPIA', 15, 0),
('MX14', 'A302', 'ING. RAMON RODRIGUEZ GOMEZ', 15, 0),
('MX16', 'A304', 'LIC. VERONICA LOPEZ RIVAS', 15, 0),
('MX21', 'A403', 'LIC. JUAN PABLO MORENO ARIAS', 15, 0),
('MX23', 'A405', 'ING. PAULA RODRIGUEZ GUTIERREZ', 15, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE IF NOT EXISTS `materia` (
  `Clave` char(4) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Semestre` int(2) NOT NULL,
  PRIMARY KEY (`Clave`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`Clave`, `Nombre`, `Semestre`) VALUES
('A101', 'CALCULO DIFERENCIAL', 1),
('A102', 'MATEMATICAS DISCRETAS', 1),
('A103', 'FUNDAMENTOS DE PROGRACION', 1),
('A104', 'TALLER DE ADMINISTRACION', 1),
('A105', 'FUNDAMENTOS DE INVESTIGACION', 1),
('A106', 'TALLER DE ETICA', 1),
('A201', 'CALCULO INTEGRAL', 2),
('A202', 'ALGEBRA LINEAL', 2),
('A203', 'PROGRAMACION ORIENTADA A OBJETOS', 2),
('A204', 'CONTABILIDAD FINANCIERA', 2),
('A205', 'QUIMICA', 2),
('A206', 'PROBABILIDAD Y ESTADISTICA', 2),
('A301', 'CALCULO VECTORIAL', 3),
('A302', 'INVESTIGACION DE OPERACIONES', 3),
('A303', 'ESTRUCTURA DE DATOS', 3),
('A304', 'CULTURA EMPRESARIAL', 3),
('A305', 'DESARROLLO SUSTENTABLE', 3),
('A306', 'FISICA GENERAL', 3),
('A401', 'ECUACIONES DIFERENCIALES', 4),
('A402', 'FUNDAMENTOS DE BASE DE DATOS', 4),
('A403', 'TALLER DE INVESTIGACION', 4),
('A404', 'TOPICOS AVANZADOS DE PROGRAMACION', 4),
('A405', 'METODOS NUMERICOS', 4),
('A406', 'PRINCIPIOS ELECTRICOS', 4);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
