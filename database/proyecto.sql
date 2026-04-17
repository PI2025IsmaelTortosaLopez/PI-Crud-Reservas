

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `telefono_guardia` varchar(20) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES
('660-330-220',15),
('660-330-221',16),
('660-330-222',18),
('660-330-223',19),
('660-330-224',20);
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disponibleen`
--

DROP TABLE IF EXISTS `disponibleen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `disponibleen` (
  `id_recurso` int(11) NOT NULL,
  `id_horario` int(11) NOT NULL,
  PRIMARY KEY (`id_recurso`,`id_horario`),
  KEY `fk_disp_horario` (`id_horario`),
  CONSTRAINT `fk_disp_horario` FOREIGN KEY (`id_horario`) REFERENCES `horario` (`id_horario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_disp_recurso` FOREIGN KEY (`id_recurso`) REFERENCES `recurso` (`id_recurso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disponibleen`
--

LOCK TABLES `disponibleen` WRITE;
/*!40000 ALTER TABLE `disponibleen` DISABLE KEYS */;
INSERT INTO `disponibleen` VALUES
(2,1),
(1,4),
(3,7),
(4,9),
(5,10);
/*!40000 ALTER TABLE `disponibleen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `horario` (
  `id_horario` int(11) NOT NULL AUTO_INCREMENT,
  `dia_semana` enum('Lunes','Martes','Miércoles','Jueves','Viernes','Sábado','Domingo') NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fin` time NOT NULL,
  PRIMARY KEY (`id_horario`),
  CONSTRAINT `CONSTRAINT_1` CHECK (`hora_fin` > `hora_inicio`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
INSERT INTO `horario` VALUES
(1,'Lunes','09:00:00','20:00:00'),
(2,'Martes','09:00:00','20:00:00'),
(3,'Miércoles','09:00:00','20:00:00'),
(4,'Jueves','09:00:00','20:00:00'),
(5,'Viernes','09:00:00','22:00:00'),
(6,'Lunes','09:00:00','13:00:00'),
(7,'Martes','09:00:00','12:00:00'),
(8,'Miércoles','17:00:00','20:00:00'),
(9,'Jueves','09:00:00','12:00:00'),
(10,'Viernes','19:00:00','22:00:00');
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recurso`
--

DROP TABLE IF EXISTS `recurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `recurso` (
  `id_recurso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `ubicacion` varchar(200) DEFAULT NULL,
  `capacidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_recurso`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recurso`
--

LOCK TABLES `recurso` WRITE;
/*!40000 ALTER TABLE `recurso` DISABLE KEYS */;
INSERT INTO `recurso` VALUES
(1,'Pista 1','Pista pequeña','Planta 1',12),
(2,'Pista 2','Pista mediana','Platna 1',16),
(3,'Pista 3','Pista mediana','Planta 2',16),
(4,'Pista 4','Pista grande','Planta baja',20),
(5,'Pista 5','Pista grande','Planta baja',20);
/*!40000 ALTER TABLE `recurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `id_recurso` int(11) NOT NULL,
  `id_reserva_local` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fin` time NOT NULL,
  `coste` decimal(10,0) DEFAULT NULL,
  `numero_plazas` int(11) DEFAULT NULL,
  `motivo` text DEFAULT NULL,
  `observaciones` text DEFAULT NULL,
  PRIMARY KEY (`id_recurso`,`id_reserva_local`),
  KEY `fk_reserva_usuario` (`id_usuario`),
  CONSTRAINT `fk_reserva_recurso` FOREIGN KEY (`id_recurso`) REFERENCES `recurso` (`id_recurso`),
  CONSTRAINT `fk_reserva_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarionormal` (`id_usuario`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES
(1,1,11,'2025-12-05','17:00:00','20:00:00',50,12,'Fútbol 5','Ninguna.'),
(2,1,12,'2025-12-22','11:00:00','13:00:00',50,16,'Partido','Ninguna.'),
(2,2,12,'2025-12-27','18:00:00','21:00:00',60,16,'Partido','Ninguna.'),
(3,1,14,'2025-12-12','09:00:00','12:00:00',60,16,'Entrenamiento','Ninguna.'),
(4,2,13,'2025-12-02','20:00:00','23:00:00',75,20,'Entrenamiento','Ninguna.'),
(5,1,17,'2025-12-01','16:00:00','18:00:00',40,20,'Partido niños','Ninguna.');
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `correo_electronico` varchar(100) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `tipo_usuario` enum('administrador','usuarionormal') NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `correo_electronico` (`correo_electronico`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES
(11,'usuario1@gmail.com','contraseña1','Aaron','1983-03-09','usuarionormal'),
(12,'usuario2@gmail.com','contraseña2','Mari','2004-12-15','usuarionormal'),
(13,'usuario3@gmail.com','contraseña3','Paco','1978-10-17','usuarionormal'),
(14,'usuario4@gmail.com','contraseña4','Laura','1998-08-27','usuarionormal'),
(15,'usuario5@gmail.com','contraseña5','Ismael Tortosa Lopez','2003-05-29','administrador'),
(16,'usuario6@gmail.com','contraseña6','Luis','1994-06-07','administrador'),
(17,'usuario7@gmail.com','contraseña7','Teresa','1964-07-23','usuarionormal'),
(18,'usuario8@gmail.com','contraseña8','Carlos','2001-04-15','administrador'),
(19,'usuario9@gmail.com','contraseña9','Xavi','1987-12-12','administrador'),
(20,'usuario10@gmail.com','contraseña10','Fran','1999-06-19','administrador');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarionormal`
--

DROP TABLE IF EXISTS `usuarionormal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarionormal` (
  `direcion` varchar(200) DEFAULT NULL,
  `telefono_movil` varchar(20) DEFAULT NULL,
  `fotografia` varchar(255) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarionormal`
--

LOCK TABLES `usuarionormal` WRITE;
/*!40000 ALTER TABLE `usuarionormal` DISABLE KEYS */;
INSERT INTO `usuarionormal` VALUES
('C/Severo Ochoa 1, Elche','670-340-230','/fotos/u1.png',11),
('C/Severo Ochoa 2, Elche','670-340-231','/fotos/u2.png',12),
('C/Severo Ochoa 3, Elche','670-340-232','/fotos/u3.pmg',13),
('C/Severo Ochoa 4, Elche','670-340-233','/fotos/u4.pmg',14),
('C/Severo Ochoa 5, Elche','670-340-234','/fotos/u17.pmg',17);
/*!40000 ALTER TABLE `usuarionormal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'proyecto'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2025-12-07  9:51:39
