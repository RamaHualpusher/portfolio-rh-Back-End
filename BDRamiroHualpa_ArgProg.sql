-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: containers-us-west-17.railway.app    Database: railway
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `education` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `degree` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `institution` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaw3ebf3585a1ndgqnk6k6hosc` (`user_id`),
  CONSTRAINT `FKaw3ebf3585a1ndgqnk6k6hosc` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` VALUES (10,'Técnicatura Universitaria en Programación','Fullstack Developer','2023-06-28','Universidad Tecnológica Nacional','2021-07-30',4),(17,'Desarrollo Backend | Java | Spring Boot',NULL,'2023-07-01','ONE Education - Alura','2022-12-02',4),(18,'Fundamentos de programación',NULL,'2022-06-29','Yo Programo | Argentina Programa 4.0','2022-03-29',4),(19,'Desarrollador FullStack',NULL,'2023-06-29','Se Programar | Argentina Programa 4.0','2022-10-29',4);
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experience`
--

DROP TABLE IF EXISTS `experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `experience` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `company` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK41lup37auw1bvwwqpgn0blbic` (`user_id`),
  CONSTRAINT `FK41lup37auw1bvwwqpgn0blbic` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experience`
--

LOCK TABLES `experience` WRITE;
/*!40000 ALTER TABLE `experience` DISABLE KEYS */;
INSERT INTO `experience` VALUES (13,'Assertiva SA','Desarrollador de soluciones para seguridad informática.',NULL,'Consultor IT de Seguridad Informática','2023-03-01',4),(15,'UTN','HelpDesk en el equipo de Gestión Tecnológica de la facultad.','2023-03-27','HelpDesk','2022-01-03',4);
/*!40000 ALTER TABLE `experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(1000) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo06v2e9kuapcugnyhttqa1vpt` (`user_id`),
  CONSTRAINT `FKo06v2e9kuapcugnyhttqa1vpt` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (11,'En primer lugar, se trata de un sistema que está diseñado para ofrecer servicios de comida en un modelo de negocio tipo \"Take Away\", lo que significa que los clientes realizan sus pedidos y luego los recogen en el local para llevarlos consigo. El sistema cuenta con distintas interfaces, las cuales están adaptadas según el rol que se le haya asignado a cada usuario. ','../../../assets/img/header-bg-purple.jpg','Proyecto Final | El Buen Sabor','https://github.com/RamaHualpusher/Illuminati-ElBuenSabor-Frontend',4),(12,'ABM consumiendo una API REST. ','../../../assets/img/header-bg-purple.jpg','Parcial Laboratorio 4 | Angular','https://github.com/RamaHualpusher/ABM-parcial-angular-lab4',4),(13,'ABM que consume un API REST. Para la misma diseñé un componente genérico que podrá ser usado en distintas aplicaciones con una adopción sencilla. Dejo video explicativo aquí: https://www.youtube.com/watch?v=pecAOkrRJro&t=84s','https://picsum.photos/200/300','Parcial Laboratorio 4 | ReactJS','https://github.com/RamaHualpusher/Tabla-Generica-React',4),(14,'El objetivo fue refactorizar el ABM para lograr un código más escalable haciendo uso de componentes y servicios genéricos que puedan ser fácilmente implementados para escalar éste u otro proyecto que necesite componentes (tablas y formularios) similares.','https://picsum.photos/200/300','Parcial Metodología de Sistemas | ReactJs','https://github.com/RamaHualpusher/abm-parcial-metodologia-front',4),(15,'Se realiza un portfolio web haciendo uso de diversas tecnologías para el curso de Argentina Programa 4.0. El mismo está desarrollado en AngularJs como cliente haciendo uso de HTML, CSS, TypeScript, Bootstrap y algunas librerías para resolver diversos problemas que se plantearon en el proceso. El servidor es un API REST desarrollado en Spring Boot 2.7 haciendo uso de Java 8 y consumiendo datos desde MySQL haciendo uso de JPA para el traslado de datos; también se agregó un rol para editar éste portfolio como administrador con Spring Security.','https://picsum.photos/200/300','Portfolio web | Argentina Programa 4.0 | AngularJs | Spring Boot | MySQL','https://github.com/RamaHualpusher/PortafolioFrontEnd',4);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `level` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `group_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2m4ok12es36c0nqewt5w2tu71` (`group_id`),
  CONSTRAINT `FK2m4ok12es36c0nqewt5w2tu71` FOREIGN KEY (`group_id`) REFERENCES `skill_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (26,80,'CSS',8),(27,85,'JavaScript',8),(28,90,'React',8),(29,70,'Node',8),(30,40,'MongoDB',8),(31,85,'Trabajo en equipo',9),(32,90,'Comunicación',9),(33,95,'Liderazgo',9),(34,80,'Creatividad',9),(35,85,'Resolución de problemas',9),(36,70,'Gestión del tiempo',9),(37,100,'Español',10),(38,70,'Inglés',10),(39,90,'HTML',8),(40,85,'AngularJs',8),(41,80,'MySQL',8),(42,90,'TypeScript',8),(43,95,'Java',8);
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill_group`
--

DROP TABLE IF EXISTS `skill_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill_group` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnhhd4mgs9ld40smtid11g9pow` (`user_id`),
  CONSTRAINT `FKnhhd4mgs9ld40smtid11g9pow` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill_group`
--

LOCK TABLES `skill_group` WRITE;
/*!40000 ALTER TABLE `skill_group` DISABLE KEYS */;
INSERT INTO `skill_group` VALUES (8,'Habilidades duras',4),(9,'Habilidades blandas',4),(10,'Idiomas',4);
/*!40000 ALTER TABLE `skill_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `social`
--

DROP TABLE IF EXISTS `social`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `social` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `icon` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk52g2kncer71vtbvy79eokil8` (`user_id`),
  CONSTRAINT `FKk52g2kncer71vtbvy79eokil8` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `social`
--

LOCK TABLES `social` WRITE;
/*!40000 ALTER TABLE `social` DISABLE KEYS */;
INSERT INTO `social` VALUES (1,'fab fa-linkedin-in','linkedin','https://www.linkedin.com/in/ramirohualpa/',4),(2,'fab fa-github','github','https://github.com/RamaHualpusher',4);
/*!40000 ALTER TABLE `social` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `aboutme` varchar(1000) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `alias` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `img_profile` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,'Soy un desarrollador de software Fullstack apasionado por la tecnología y especializado en el área de backend con Java. Mi experiencia en el desarrollo de aplicaciones me ha permitido adquirir una amplia gama de habilidades y conocimientos, los cuales estoy siempre buscando expandir a través del aprendizaje continuo.\n\nMi objetivo es ser un gran profesional y enseñar mis conocimientos a los demás para ayudarlos a crecer en sus carreras. Me encanta trabajar en equipo y colaborar en proyectos desafiantes que me permitan crecer profesionalmente y enfrentar nuevos desafíos.','Guaymallén, Mendoza, Argentina','Hualpusher DEV','hualpusher@gmail.com','../../../assets/img/perfil.png','Hualpa','Ramiro','519-999-9999','Software Engineer | Java Developer | IT Security Consultant');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-28 21:31:32
