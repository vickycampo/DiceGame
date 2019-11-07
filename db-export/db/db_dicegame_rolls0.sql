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
-- Table structure for table `rolls`
--

DROP TABLE IF EXISTS `rolls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rolls` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `playersid` varchar(45) NOT NULL,
  `result` set('WIN','LOOSE') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rolls`
--

LOCK TABLES `rolls` WRITE;
/*!40000 ALTER TABLE `rolls` DISABLE KEYS */;
INSERT INTO `rolls` VALUES (1,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(2,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','WIN'),(3,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(4,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(5,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(6,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(7,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(8,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(9,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(10,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(11,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(12,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(13,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(14,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(15,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(16,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','WIN'),(17,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','WIN'),(18,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(19,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(20,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(21,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(22,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(23,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(24,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(25,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(26,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','WIN'),(27,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','WIN'),(28,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(29,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(30,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(31,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(32,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(33,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(34,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(35,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(36,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(37,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(38,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(39,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(40,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(41,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(42,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(43,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(44,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(45,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(46,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(47,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(48,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(49,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(50,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','WIN'),(51,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(52,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(53,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(54,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(55,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(56,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(57,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(58,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(59,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE'),(60,'a48ffb69-5784-47ca-8a0c-4d27bf7e37fc','LOOSE');
/*!40000 ALTER TABLE `rolls` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-07 14:46:52
