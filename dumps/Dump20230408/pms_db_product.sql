CREATE DATABASE  IF NOT EXISTS `pms_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pms_db`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: pms_db
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `p_id` int NOT NULL,
  `p_doges` varchar(45) DEFAULT NULL,
  `p_name` varchar(45) DEFAULT NULL,
  `p_strength` varchar(45) DEFAULT NULL,
  `p_generic` varchar(45) DEFAULT NULL,
  `p_manufecturer` varchar(45) DEFAULT NULL,
  `p_group` varchar(45) DEFAULT NULL,
  `order_no` varchar(45) DEFAULT NULL,
  `p_mpp` double DEFAULT NULL,
  `p_mrp` double DEFAULT NULL,
  `mfg_date` date DEFAULT NULL,
  `exp_date` date DEFAULT NULL,
  `p_stock` int DEFAULT NULL,
  `added_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Tablet','Napa','500mg','Paracetamol','Beximco','Human','202301',1.056,1.2,'2021-04-15','2023-05-17',510,'Mohinur'),(2,'Eye Drop','Eyedew','10ml','Carboxymethylcellulose Sodium + Glycerin','ACME Laboratories Ltd.','Human','202302',235,260,'2022-10-01','2024-09-30',5,'Mohinur'),(3,'Tablet','Monas','10mg','Montelecust','ACME Laboratories Ltd.','Human','202303',14,16,'2020-04-14','2024-04-14',100,'Mohinur'),(4,'IV Injection','Sergel','40mg','Esomeprazol','Healthcare Pharmaceuticals Ltd.','Human','202310',90,120,'2022-04-13','2024-04-18',12,'Mohinur'),(5,'Gel','Voligel','50mg','Diclofenac Sodium','Beximco Pharmaceuticals Ltd.','Human','202315',100,88,'2022-04-14','2024-04-11',5,'Mohinur');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-08 12:17:04
