-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: amadeus
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `havaalanı`
--

DROP TABLE IF EXISTS `havaalanı`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `havaalanı` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `sehir` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `havaalanı`
--

LOCK TABLES `havaalanı` WRITE;
/*!40000 ALTER TABLE `havaalanı` DISABLE KEYS */;
INSERT INTO `havaalanı` VALUES (1,'istanbul'),(2,'karabük'),(3,'izmir'),(4,'ankara'),(5,'kars'),(6,'ağrı'),(7,'aydın'),(8,'bursa');
/*!40000 ALTER TABLE `havaalanı` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ucus`
--

DROP TABLE IF EXISTS `ucus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ucus` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dönüs_tarih` datetime DEFAULT NULL,
  `fiyat` double DEFAULT NULL,
  `kalkıs_tarih` datetime DEFAULT NULL,
  `havaalanı_kalkis_id` bigint DEFAULT NULL,
  `havaalanı_varıs_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc9lhq3u8ddgl8gscnpti6k3h6` (`havaalanı_kalkis_id`),
  KEY `FK3y9we0bqfdi9h6s72id8dm04d` (`havaalanı_varıs_id`),
  CONSTRAINT `FK3y9we0bqfdi9h6s72id8dm04d` FOREIGN KEY (`havaalanı_varıs_id`) REFERENCES `havaalanı` (`id`),
  CONSTRAINT `FKc9lhq3u8ddgl8gscnpti6k3h6` FOREIGN KEY (`havaalanı_kalkis_id`) REFERENCES `havaalanı` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ucus`
--

LOCK TABLES `ucus` WRITE;
/*!40000 ALTER TABLE `ucus` DISABLE KEYS */;
INSERT INTO `ucus` VALUES (1,'2021-12-03 16:30:00',321.32,'2021-12-01 12:30:00',1,2),(2,'2021-12-03 17:30:00',500.32,'2021-12-02 11:30:00',1,3),(3,'2021-12-02 19:30:00',800.32,'2021-12-01 18:30:00',1,4),(4,'2021-12-03 08:30:00',800.32,'2021-12-02 14:30:00',1,4);
/*!40000 ALTER TABLE `ucus` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-21 20:01:57
