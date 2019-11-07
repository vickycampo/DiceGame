-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_dicegame
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `players` (
  `playerId` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`playerId`),
  UNIQUE KEY `playerId_UNIQUE` (`playerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES ('108bf6f4-dad5-4dbb-bbf8-d46f01456782','Patricia','2019-09-21'),('47c275c0-b307-4e83-8297-99981034b9fa','Jorge','2019-10-25'),('48da80e4-45bc-4012-ba94-81a19760615f','Anonymous','2019-11-07'),('55a55fbc-2d54-4e2e-9fc2-4094abc93239','Anonymous','2017-01-25'),('5fcb1bdd-79f0-491b-b761-222acecaf68c','Anonymous','2019-11-07'),('89d4e18d-c1fd-4a57-86fa-008eed01677d','Anonymous','2019-11-07'),('91b3a43d-fd85-4590-a5c9-a23d02e98a78','Anonymous','2019-11-07'),('9ac4b223-3c70-4ff4-8b70-ed93f77381f5','Anonymous','2019-11-07'),('9d1ccd50-0386-40f5-bd87-14caf502865b','Rodrigo','2019-12-01'),('a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','Mario','2019-11-01'),('aff79042-163d-4cc8-a929-02edf2b8b6e1','Anonymous','2019-11-07'),('d574984a-9663-4477-89b8-894889546afa','Ana','2019-08-10'),('e0c0898d-0fc7-4907-9bca-3a81c8ad6aec','Anonymous','2019-11-07'),('e4862703-cc23-4966-8868-ef022ed6f65b','Anonymous','2019-11-07');
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-07 14:46:51
