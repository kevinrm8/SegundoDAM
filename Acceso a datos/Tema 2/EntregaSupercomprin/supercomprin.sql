-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: supercomprin
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `idCompra` int(11) NOT NULL AUTO_INCREMENT,
  `eWallet_id_eWallet` int(11) NOT NULL,
  `Producto_idProducto` int(11) NOT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `fk_Compra_e-Wallet_idx` (`eWallet_id_eWallet`),
  KEY `fk_Compra_Producto1_idx` (`Producto_idProducto`),
  CONSTRAINT `fk_Compra_Producto1` FOREIGN KEY (`Producto_idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_e-Wallet` FOREIGN KEY (`eWallet_id_eWallet`) REFERENCES `ewallet` (`id_eWallet`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,2,1),(2,2,3),(3,2,5),(5,2,1),(8,2,1),(9,2,1),(11,2,1),(13,2,1);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `devolucion`
--

DROP TABLE IF EXISTS `devolucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `devolucion` (
  `idDevolucion` int(11) NOT NULL AUTO_INCREMENT,
  `eWallet_id_eWallet` int(11) NOT NULL,
  `Producto_idProducto` int(11) NOT NULL,
  PRIMARY KEY (`idDevolucion`),
  KEY `fk_Devolucion_e-Wallet1_idx` (`eWallet_id_eWallet`),
  KEY `fk_Devolucion_Producto1_idx` (`Producto_idProducto`),
  CONSTRAINT `fk_Devolucion_Producto1` FOREIGN KEY (`Producto_idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Devolucion_e-Wallet1` FOREIGN KEY (`eWallet_id_eWallet`) REFERENCES `ewallet` (`id_eWallet`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devolucion`
--

LOCK TABLES `devolucion` WRITE;
/*!40000 ALTER TABLE `devolucion` DISABLE KEYS */;
/*!40000 ALTER TABLE `devolucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ewallet`
--

DROP TABLE IF EXISTS `ewallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ewallet` (
  `id_eWallet` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `DNI` varchar(45) NOT NULL,
  `Edad` varchar(45) NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `Telefono` int(11) NOT NULL,
  `Saldo` float NOT NULL,
  `Puntos` float NOT NULL,
  PRIMARY KEY (`id_eWallet`),
  UNIQUE KEY `DNI_UNIQUE` (`DNI`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ewallet`
--

LOCK TABLES `ewallet` WRITE;
/*!40000 ALTER TABLE `ewallet` DISABLE KEYS */;
INSERT INTO `ewallet` VALUES (2,'NombreTest','DNITest','20','2000-07-30',1,71,20),(4,'NombreTest','DNITest1','20','2000-07-30',1,1000,0);
/*!40000 ALTER TABLE `ewallet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Precio` float NOT NULL,
  `Puntos` float NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Monitor',100,10),(2,'Teclado Membrama',24.99,2),(3,'Teclado Mecanico',79.49,8),(4,'Raton',35,3),(5,'Auriculares',50,5),(6,'Placa Base 1.0',15,1),(7,'Placa Base 2.5 HDD',55,5),(8,'Alfombrilla',9.99,1),(9,'Microfono',134,13),(10,'WebCam HD',40,4),(11,'Webcam FULLHD',85,8),(12,'Altavoces 5.1',51,5),(13,'Altavoces 7.1',71,7);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-24 23:29:10
