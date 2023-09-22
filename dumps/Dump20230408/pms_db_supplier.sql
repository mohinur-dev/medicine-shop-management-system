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
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `s_id` int NOT NULL,
  `s_name` varchar(45) DEFAULT NULL,
  `s_type` varchar(45) DEFAULT NULL,
  `product_group` varchar(45) DEFAULT NULL,
  `mpo_name` varchar(45) DEFAULT NULL,
  `mpo_contract` varchar(45) DEFAULT NULL,
  `mpo_location` varchar(45) DEFAULT NULL,
  `s_credit_limit` double DEFAULT NULL,
  `s_credit` double DEFAULT NULL,
  `payment` double DEFAULT NULL,
  `trns_date` date DEFAULT NULL,
  `added_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'ACI Limited','Manufacturer','Pharma Product','Rasel Rana','01733878578','Kushtia',25000,NULL,NULL,NULL,NULL),(2,'ACME Laboratories Ltd.','Manufacturer','Pharma Product','Alamin Hosen','01710034643','Mirpur',10000,NULL,NULL,NULL,NULL),(3,'Aristopharma Ltd.','Manufacturer','Pharma Product','Mobassir Hosen','0170000000','Bheramara',15000,NULL,NULL,NULL,NULL),(4,'Beximco Pharmaceuticals Ltd.','Manufacturer','Pharma Product','Rasedul Islam','019000000000','kushtia',30000,NULL,NULL,NULL,NULL),(5,'Drug International Ltd.','Manufacturer','AgroVet & Pesticides Product','Mamunul Islam','01800000000','Amla',50000,NULL,NULL,NULL,NULL),(6,'Healthcare Pharmaceuticals Ltd.','Manufacturer','Pharma Product','Forruk Ahmed','0150000000','Kushtia',10000,NULL,NULL,NULL,NULL),(7,'General Pharmaceuticals Ltd.','Manufacturer','Pharma Product','Rony Ahamed','0130000000','Kushtia',50000,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-08 12:17:05
