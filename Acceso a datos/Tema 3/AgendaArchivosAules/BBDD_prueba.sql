-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema agenda
--

CREATE DATABASE IF NOT EXISTS agenda;
USE agenda;

--
-- Definition of table `contactos`
--

DROP TABLE IF EXISTS `contactos`;
CREATE TABLE `contactos` (
  `idContacto` int(10) unsigned NOT NULL auto_increment,
  `nombre` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`idContacto`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contactos`
--

/*!40000 ALTER TABLE `contactos` DISABLE KEYS */;
INSERT INTO `contactos` (`idContacto`,`nombre`,`email`,`telefono`) VALUES 
 (19,'jsf3','rfre',9),
 (31,'contacto de prueba','prueba@Contacto.com',999999),
 (33,'mi contacto','mycontact@gmail.com',555);
/*!40000 ALTER TABLE `contactos` ENABLE KEYS */;


--
-- Definition of table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `idUsuario` int(10) unsigned NOT NULL auto_increment,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY  (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`password`) VALUES 
 (1,'test1','test1'),
 (2,'test2','test2'),
 (3,'test3','test3');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

--
-- Create schema almacen
--

CREATE DATABASE IF NOT EXISTS almacen;
USE almacen;

--
-- Definition of table `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos` (
  `idProducto` int(10) unsigned NOT NULL auto_increment,
  `nombre` varchar(45) NOT NULL,
  `idSeccion` int(10) unsigned NOT NULL,
  `precio` double NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY  (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productos`
--

/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` (`idProducto`,`nombre`,`idSeccion`,`precio`,`descripcion`) VALUES 
 (1,'Alicates 25m',1,10.4,'Disponibles en 10 dias'),
 (2,'Bombilla led 30w',3,5.7,'duración 10 años'),
 (3,'cable cobre 10mm',3,2,'flexible y resistente'),
 (4,'Tubo de cobre',2,3.6,'precio por metro'),
 (5,'Grifo gres',2,27.5,'Alta resistencia'),
 (6,'Taladradora 1000w',3,40.6,'Sistema silencioso'),
 (7,'Bote pintura blanca 10 l',4,25.8,'Doble capa'),
 (8,'Cerradura verja 30 mm',1,37.9,'Universal para exterior'),
 (9,'Candado 25 mm',1,13.5,'Llave incluida'),
 (10,'Interruptor doble',3,22.4,'Solo color blanco'),
 (11,'Rodillo pintura 25 cm',4,14.9,'se lava facilmente'),
 (12,'Bombilla led 10w luz blanca',3,4.8,'Gran potencia');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;


--
-- Definition of table `secciones`
--

DROP TABLE IF EXISTS `secciones`;
CREATE TABLE `secciones` (
  `idSeccion` int(10) unsigned NOT NULL auto_increment,
  `seccion` varchar(45) NOT NULL,
  `responsable` varchar(45) NOT NULL,
  PRIMARY KEY  (`idSeccion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `secciones`
--

/*!40000 ALTER TABLE `secciones` DISABLE KEYS */;
INSERT INTO `secciones` (`idSeccion`,`seccion`,`responsable`) VALUES 
 (1,'ferreteria','Juan López'),
 (2,'fontaneria','Ana Marcos'),
 (3,'electricidad','Ruth Esteban'),
 (4,'pintura','Pedro Ramos');
/*!40000 ALTER TABLE `secciones` ENABLE KEYS */;


--
-- Definition of table `sucursales`
--

DROP TABLE IF EXISTS `sucursales`;
CREATE TABLE `sucursales` (
  `nombre` varchar(45) NOT NULL,
  `calle` varchar(45) NOT NULL,
  `presupuesto` double NOT NULL,
  `innauguracion` int(11) NOT NULL,
  PRIMARY KEY  (`nombre`,`calle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sucursales`
--

/*!40000 ALTER TABLE `sucursales` DISABLE KEYS */;
INSERT INTO `sucursales` (`nombre`,`calle`,`presupuesto`,`innauguracion`) VALUES 
 ('bazar em','c/los altos',450000,2012),
 ('nueva era','c/povedilla',50000,2010),
 ('venta chin','c/povedilla',3000000,2009);
/*!40000 ALTER TABLE `sucursales` ENABLE KEYS */;


--
-- Definition of table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
CREATE TABLE `ventas` (
  `idVenta` int(10) unsigned NOT NULL auto_increment,
  `idProducto` int(10) unsigned NOT NULL,
  `unidades` int(10) unsigned NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  PRIMARY KEY  (`idVenta`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ventas`
--

/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` (`idVenta`,`idProducto`,`unidades`,`ciudad`) VALUES 
 (1,1,3,'Madrid'),
 (2,3,2,'Madrid'),
 (3,1,5,'Sevilla'),
 (4,10,4,'Avila'),
 (5,3,2,'Jaen'),
 (6,5,7,'Madrid'),
 (7,4,2,'Sevilla'),
 (8,10,3,'Salamanca'),
 (9,7,8,'Albacete'),
 (10,4,3,'Soria');
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;

--
-- Create schema bancabd
--

CREATE DATABASE IF NOT EXISTS bancabd;
USE bancabd;

--
-- Definition of table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `dni` int(10) unsigned NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clientes`
--

/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`dni`,`nombre`,`direccion`,`telefono`) VALUES 
 (1111,'Pepito','c/marte',1111),
 (2222,'Alicia','c/ jupiter',2222),
 (3333,'Marta','c/venus',3333);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;


--
-- Definition of table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
CREATE TABLE `cuentas` (
  `numeroCuenta` int(10) unsigned NOT NULL,
  `saldo` double NOT NULL,
  `tipocuenta` varchar(45) NOT NULL,
  PRIMARY KEY  (`numeroCuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cuentas`
--

/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` (`numeroCuenta`,`saldo`,`tipocuenta`) VALUES 
 (1000,300,'ahorro'),
 (2000,3450,'ahorro'),
 (3000,670,'recibos'),
 (4000,880,'ahorro'),
 (5000,6700,'recibos');
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;


--
-- Definition of table `titulares`
--

DROP TABLE IF EXISTS `titulares`;
CREATE TABLE `titulares` (
  `idCuenta` int(10) unsigned NOT NULL,
  `idCliente` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`idCuenta`,`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `titulares`
--

/*!40000 ALTER TABLE `titulares` DISABLE KEYS */;
INSERT INTO `titulares` (`idCuenta`,`idCliente`) VALUES 
 (1000,3333),
 (1000,5555),
 (2000,1111),
 (2000,3333),
 (3000,1111),
 (4000,2222),
 (5000,4444);
/*!40000 ALTER TABLE `titulares` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
