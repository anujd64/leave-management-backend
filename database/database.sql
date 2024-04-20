-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: leave_management
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
-- Table structure for table `company_holidays`
--

DROP TABLE IF EXISTS `company_holidays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_holidays` (
  `holiday_id` binary(16) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `holiday_date` date DEFAULT NULL,
  PRIMARY KEY (`holiday_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_holidays`
--

LOCK TABLES `company_holidays` WRITE;
/*!40000 ALTER TABLE `company_holidays` DISABLE KEYS */;
INSERT INTO `company_holidays` VALUES (_binary '\‘.\‰tN%Å≠\„¿+(','New Year\'s Day','2024-01-01'),(_binary '\Ê≤õ\ÌFdÜ\Œànq]','Mahatma Gandhi Jayanti','2024-10-02'),(_binary 'ØZ˚<G¿ª€ø•4îì','Labour Day','2024-05-01'),(_binary '&zñÚLFóãETk\”\”K','Ambedkar Jayanti','2024-04-14'),(_binary ')¸t\≈aB‘≥¶ú¯>¯æ','Mahavir Jayanti','2024-04-06'),(_binary 'MÿºF˜\ÓH€åzµû&\›l|','Dussehra','2024-10-07'),(_binary 'Oó√ã;sJsì\‘≠wDC','Christmas Day','2024-12-25'),(_binary 'q\ÀÃ≤∑Hﬂã\Ì1x∂\ÓF\ ','Muharram','2024-08-19'),(_binary 'à\\iRØmOª•n-Ú,R','Guru Nanak Jayanti','2024-11-12'),(_binary '•MD¢B4†S]Û\‡\Õ$','Ganesh Chaturthi','2024-09-02'),(_binary '¬∂äÇÇ\0J¨ßC,\Â\ÊÄ\r#','Diwali','2024-10-28'),(_binary 'Ÿú_úDÚò†7ö\Ê˚}\Î','Good Friday','2024-03-29'),(_binary '\⁄\‚Añﬂ≤Eb∏¶öÜ?\…','Holi','2024-03-10'),(_binary '\ÍK\ƒN!Bu¨D|\·K•«Ñ','Independence Day','2024-08-15'),(_binary '˙´\≈\√qíCóærˆ@P2p\–','Republic Day','2024-01-26');
/*!40000 ALTER TABLE `company_holidays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departments` (
  `department_id` binary(16) NOT NULL,
  `department_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (_binary '\≈XZÅLHÒ±\"p\‹\»4','Human Resources'),(_binary '3∏ˇ\n\n\\DÆüï\Î\Ì8\‰¢m','Marketing'),(_binary 'Q7TY¿5L/çe¨4TïW\’','Finance'),(_binary 'n†ÑÚNêÄ08ØA1i•','Board of Directors'),(_binary 'nk1Æ}∑Kπ≠ñî	g','Quality Assurance'),(_binary 'ò±˙Z$OD™+9P\Ï\Õ\Ï','Lower Management'),(_binary '°ˇ±´\€UELé–àï\'\÷','Middle Management'),(_binary 'ª>©\›\·˜L∂ÇC\„Lõ|π','Engineering'),(_binary 'Õ¢BµınLG∂\Ó?r7TB˛','Product Management'),(_binary '\”~,µâC:é˜uèÖ˜/\À','Sales'),(_binary '\÷S\Â\Á\Z#Lù∏Ef“ç@t','Higher Management');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `employee_id` binary(16) NOT NULL,
  `department_id` binary(16) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `is_manager` bit(1) DEFAULT NULL,
  `manager_id` binary(16) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (_binary '	3:\ÍTJFÖ\"\‡§gª',_binary 'ª>©\›\·˜L∂ÇC\„Lõ|π','','abcd','male',_binary '',NULL,'',''),(_binary '	\ÿ\⁄—∑\ÏHòÆ∑Eëuò',_binary '\≈XZÅLHÒ±\"p\‹\»4','abcssfdzdsds@mail.com','abc@mail.com','male',_binary '',NULL,'$2a$10$EBErzm5Me8GlcJ2u/K2wdufaM.1k8ZF6GzRBGOOasDGii8uMHf8zC','abcsdfddasas'),(_binary 'ú`¡\ÂN˛õ\Õ\Ìè˙=ù',_binary '\≈XZÅLHÒ±\"p\‹\»4','abcssfds@mail.com','abc@mail.com','male',_binary '',NULL,'$2a$10$mtO4S6NtozS5C9kUn8w5ku.oFLnvWd8A6.3c7uksGbr6V6W9M.BCO','abcsdfd'),(_binary '`6_%¯K<®{tôS\ÎPç',_binary 'ª>©\›\·˜L∂ÇC\„Lõ|π','abcdsfsdfdsf@mail.com','abc@mail.com','female',_binary '\0',_binary '	3:\ÍTJFÖ\"\‡§gª','$2a$10$sdw4LVzwY4npSDGy2wM9AuDsmjqTQCGIUn0TkZRmDKXx85e75Rhya','abcfdfdf'),(_binary 'bÇ\€\¬C®ïØ¢ºO\Óá\ ',_binary 'n†ÑÚNêÄ08ØA1i•','tlmgmt@mail.com','tlmgmt','male',_binary '',NULL,'$2a$10$hz002E.4kNr8bhsxvqB2VeoZ03K8NmY8BG/VEpkhZUDMXpyCSkit.','tlmgmt'),(_binary ' \œ_\‡@•öüt\‹øìÇ',_binary 'ª>©\›\·˜L∂ÇC\„Lõ|π','ASD@MAIL.COM','SDFGH','male',_binary '\0',_binary '	3:\ÍTJFÖ\"\‡§gª','$2a$10$nmaA8wNekm3WQ0Dk6.MMI.CLrhSoek.0qwJueNyKQ.ntH2pf0ybPe','ASDFGH'),(_binary '$˙¥\"YNrÜZ5\„\œ<Ä',_binary 'ª>©\›\·˜L∂ÇC\„Lõ|π','','dvcvx','male',_binary '\0',_binary '	3:\ÍTJFÖ\"\‡§gª','$2a$10$pO.L7dieAwOVsC1q2nvhgel1Ti1Ig2PZe8R/yjdinkSZyxP2KW05a','abcvc'),(_binary '2ˆ\Ê$®hK–ø\'>\√/à\œ',_binary 'ª>©\›\·˜L∂ÇC\„Lõ|π','enggM@gmail.com','abc','male',_binary '',NULL,'$2a$10$NthnnqYzQ0/1k6qMYY2XeOIXNGtJtOwQgPhBH0qKutOG490NA22mG','enggM'),(_binary '9%\Œ/\÷zL¿™\∆j˙¬üå\›',_binary 'ª>©\›\·˜L∂ÇC\„Lõ|π','engg1@mail.com','engg1','male',_binary '\0',_binary '	3:\ÍTJFÖ\"\‡§gª','$2a$10$5g5KBFKNBEizjYR36OY6VentYraH/morWxulZRsOKx5tvt4FN3vs.','engg1'),(_binary '=7\Ô\ÕHJ∂êîL◊ãZ',_binary '\”~,µâC:é˜uèÖ˜/\À','adfdsfafa@mail.com','dfdfas','male',_binary '\0',NULL,'$2a$10$P9/8/8ye21eD6cVhYwKYVuuK/yvgNvtSAuIrUGOM8hmx13a5RXUU6','adfasdf'),(_binary 'F\0i=çBräaffS.î\€',_binary 'n†ÑÚNêÄ08ØA1i•','ceo@mail.com','XZY','male',_binary '',NULL,'$2a$10$v0e3n1Q7oDYDqbTmAAfxV.zgsIEPTaKAyU0IcpjDDsCdDOLaCNcwC','ceo'),(_binary 'HX\ÂP2K\"Å¶eI/C\Í\—',_binary 'ª>©\›\·˜L∂ÇC\„Lõ|π','dvc@mai.com','vcxv','male',_binary '\0',_binary '	3:\ÍTJFÖ\"\‡§gª','$2a$10$1Z1ijOytqtTrB7aU.2LkPOosyIM1.4ifT1zkQhpSZQ4dJrlxsWvdS','abcxvccvc'),(_binary 'PÖ\\ƒèA\Áú5ˆM\\∞\Ê',_binary '\”~,µâC:é˜uèÖ˜/\À','DFDAD@MAIL.COM','DFSD','male',_binary '\0',NULL,'$2a$10$LxcjRjIm8srMChWqH1wOdurovIsaZjbbY08Qw6qFgtNG8gSZvdWsm','dsfsdfs'),(_binary '\\1:£M8JÆ©dR; \√',_binary '0>W\ÔXîF;éìÄΩ∂»§','abcdDDz.ddsfoSSe@example.com','Johnathan Doe','male',_binary '',NULL,'$2a$10$kx/hA3NEzEyW5TGoAlof9.uluTx8zc1KuaawJMi1N.4Z1Tx5tCq1O','abcxxxDcCVcsdd'),(_binary '`\∆D\‡`\"D˙à\‡ãí|\‘/',_binary '0>W\ÔXîF;éìÄΩ∂»§','abcdDD.ddsfoSSe@example.com','Johnathan Doe','male',_binary '',NULL,'$2a$10$0r9D7CnwQIBx58zQsp7x0u9F6R5qC0YgxYlImtiQRcq6eso1z.SJ.','abcDDcCVcsdd'),(_binary 'fí¶\Â\0M•Üw\0Cã`<',_binary '\”~,µâC:é˜uèÖ˜/\À','RFGFGF@MAIL.COM','FGGF','male',_binary '',NULL,'$2a$10$rV4heNwCMiMvT1pgeTLcreuAuPyZdrTCuAcdMMaCa0b9istfwHfEu','dfgdg'),(_binary 'p\Ÿ<-)MGYπ¨(\—\ËıM}',_binary '0>W\ÔXîF;éìÄΩ∂»§','abcdDDzz.ddsfoSSe@example.com','Johnathan Doe','male',_binary '',NULL,'$2a$10$.XXQPTstiqNSgP6HAHV5vOdcytJsLl/Zof.O1TIc7Ack2LUtWhj16','abcDxxxDcCVcsdd'),(_binary '}\Ÿ	âQKOø\Ígê@{ˆè',_binary '0>W\ÔXîF;éìÄΩ∂»§','adddbcd.ddsfoe@example.com','Johnathan Doe','male',_binary '',NULL,'$2a$10$NRJDQJQJRYZMo62ubAjJHeBoXXbddvlWeq4odjZ7y5jDVMN3kJpXm','abcccsdd'),(_binary 'Å1cŸ≥LFh∂ÚYFu:û',_binary '\”~,µâC:é˜uèÖ˜/\À','abcefdfdf@mail.com','abc@mail.com','male',_binary '\0',_binary 'fí¶\Â\0M•Üw\0Cã`<','$2a$10$nh/ij2gUbO8cevwL7uT6Q.Q5GKOLRfUTR0jetTG2JFn8HVoub5UXm','abcdsfsdf'),(_binary 'és}◊™0E⁄®\0Dò\ <e9',_binary '\≈XZÅLHÒ±\"p\‹\»4','dgafgd@m.com','dfflsdf','male',_binary '',NULL,'$2a$10$Xnj.D1gswSVeB2tJx4E9fucI5SZPkeYIsMDnW6U5vjS1mY80fkmk2','dafdsafa'),(_binary 'ó\Ÿ*(òM∏®˝\Z\'|\·',_binary '0>W\ÔXîF;éìÄΩ∂»§','abcde.doe@example.com','Johnathan Doe','male',_binary '',NULL,'$2a$10$9AdJ7jfrg9IReSVC72VyuunHUESUyy5CtNiFYPdMAfeFTRi5l7Xei','abcde'),(_binary '°∞ìnLO“´.ıÒ7√∂\Á',_binary '0>W\ÔXîF;éìÄΩ∂»§','abcd.ddsfoe@example.com','Johnathan Doe','male',_binary '',NULL,'$2a$10$kw3YZJU.MtCeOeLZCXZSWutmzMmGip9BZEqBMHxEVyzZg6U0tauVG','abcsdd'),(_binary '¥v$L\ÓüLï\ÍTï\'\Íh',_binary '0>W\ÔXîF;éìÄΩ∂»§','abcd.ddsfoSSe@example.com','Johnathan Doe','male',_binary '',NULL,'$2a$10$gbfNJzEYy7ZuVF01Mcy87u8bGIvpXXm9KR2kQdQi0B1CkrHvV1W2O','abccCVcsdd'),(_binary 'ªê§\√\ÔöN‘®éë.§#L',_binary 'ª>©\›\·˜L∂ÇC\„Lõ|π','ab262c@mail.com','abc@mail.com','male',_binary '\0',_binary '	3:\ÍTJFÖ\"\‡§gª','$2a$10$pUPfLutnkQZ9XKNux1q9b.kWbXvxarzWsXBxWt98zXjJFlruZoqIe','abc559'),(_binary 'Ω¢doïÇKÒ±\Ã~•k 0á',_binary '\”~,µâC:é˜uèÖ˜/\À','rakesh@gmail.com','Rakesh Arora','male',_binary '',NULL,'$2a$10$z46T0yIXk6iPD13SQI2bbuc1I.s50wjpaFeQLmTzD6yHVdbSBav8a','rakesh@111'),(_binary '\ 4üñaD¸ìüD37O',_binary 'ª>©\›\·˜L∂ÇC\„Lõ|π','abc@mail.com','abc','male',_binary '',NULL,'$2a$10$QkDg9QcdS9VV7eX7VMk7ZeXAS27CeFEHwdTWxxMt.PRcZou6ZgdqG','abc'),(_binary '\œ˘Ö/yEr™∂¯\Ô˚D\n',_binary 'ª>©\›\·˜L∂ÇC\„Lõ|π','engg2@mail.com','abc@mail.com','male',_binary '\0',_binary '	3:\ÍTJFÖ\"\‡§gª','$2a$10$O4y05GuScquXvysJ2KOOpes.q.t41tiCxfx6jkcRwXAHuQtEbvgLG','engg2'),(_binary '\€¿{öFN\ÍøÚ\ﬂN©\·´',_binary 'ª>©\›\·˜L∂ÇC\„Lõ|π','faadff@mail.com','dsfsd','male',_binary '\0',_binary '	3:\ÍTJFÖ\"\‡§gª','$2a$10$qpPiXBeTiuuPW69wOzg/WO0007xIfllJ2pIOV6rBzQR6B9X1SFFu2','ffdffd'),(_binary '\‹\Œq¨z®A∂≠&W+\\~',_binary 'ª>©\›\·˜L∂ÇC\„Lõ|π','absdc@mail.com','vccc','male',_binary '\0',_binary '	3:\ÍTJFÖ\"\‡§gª','$2a$10$j.LJaIy2hhsqc8iOEGTn5OLPBuQzdG4MeLtzWdI.YBJGGqctH0U.y','eng'),(_binary 'ßcèUKG∏í\≈~\ﬂNM',_binary '\≈XZÅLHÒ±\"p\‹\»4','assd@maili.com','qsg','male',_binary '',NULL,'$2a$10$OrE3zOf8l.sPpreytnBmCO6BV23o9rHIfky6c9ralE2.j9PrqdJfu','adsfg'),(_binary 'ˆFó\Í^\¬Kuû;HùìÖˇE',_binary 'ª>©\›\·˜L∂ÇC\„Lõ|π','Johndoe.@avc.com','John Doe','male',_binary '',NULL,'$2a$10$VaUAov.f3twuK7fDY2M8Kuf2FoW09n3G2FZTKfZXNY8pW6F1LPMb6','JohnDoe');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_request_images`
--

DROP TABLE IF EXISTS `leave_request_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leave_request_images` (
  `leave_request_request_id` binary(16) NOT NULL,
  `images` varchar(255) DEFAULT NULL,
  KEY `FKjukgdioo9ln41oqvryox9sujg` (`leave_request_request_id`),
  CONSTRAINT `FKjukgdioo9ln41oqvryox9sujg` FOREIGN KEY (`leave_request_request_id`) REFERENCES `leave_requests` (`request_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_request_images`
--

LOCK TABLES `leave_request_images` WRITE;
/*!40000 ALTER TABLE `leave_request_images` DISABLE KEYS */;
INSERT INTO `leave_request_images` VALUES (_binary '‰Üª:Y\ﬁO+ô\0\\∫™î','https://firebasestorage.googleapis.com/v0/b/leave-management-38c55.appspot.com/o/ca349f96-6105-44fc-939f-441e1333374f%2F2024-05-02-2024-05-09%2Fimage_1?alt=media&token=2639dfb3-7335-4d19-b056-80579b220e6e'),(_binary '‰Üª:Y\ﬁO+ô\0\\∫™î','https://firebasestorage.googleapis.com/v0/b/leave-management-38c55.appspot.com/o/ca349f96-6105-44fc-939f-441e1333374f%2F2024-05-02-2024-05-09%2Fimage_2?alt=media&token=7bef6f7e-f437-48ba-b68e-1b10fb5833d0');
/*!40000 ALTER TABLE `leave_request_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_requests`
--

DROP TABLE IF EXISTS `leave_requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leave_requests` (
  `request_id` binary(16) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `employee_id` binary(16) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `leave_type_id` binary(16) DEFAULT NULL,
  `manager_feedback` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `images` varbinary(255) DEFAULT NULL,
  PRIMARY KEY (`request_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_requests`
--

LOCK TABLES `leave_requests` WRITE;
/*!40000 ALTER TABLE `leave_requests` DISABLE KEYS */;
INSERT INTO `leave_requests` VALUES (_binary '‰Üª:Y\ﬁO+ô\0\\∫™î','2024-04-20 05:30:00.000000',_binary '\ 4üñaD¸ìüD37O','2024-05-09 05:30:00.000000',_binary '†ôÇtüBÉ—∂I\Ï{\∆','','1234567890','2024-05-02 05:30:00.000000','pending','2024-04-20 05:30:00.000000',NULL);
/*!40000 ALTER TABLE `leave_requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_types`
--

DROP TABLE IF EXISTS `leave_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leave_types` (
  `leave_type_id` binary(16) NOT NULL,
  `default_allowance` int NOT NULL,
  `leave_type_name` varchar(255) DEFAULT NULL,
  `docs_required` bit(1) NOT NULL,
  PRIMARY KEY (`leave_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_types`
--

LOCK TABLES `leave_types` WRITE;
/*!40000 ALTER TABLE `leave_types` DISABLE KEYS */;
INSERT INTO `leave_types` VALUES (_binary '%V\‡wÇvCœè\ﬂfô\÷\Ÿ',5,'Sick Leave',_binary '\0'),(_binary 'o,¢3˜JÇ≠§+K\ uè',10,'Study Leave',_binary '\0'),(_binary 'éä¿8\‹\…Nˆê\Èm\’ ˚Äô',5,'Remote Work Leave',_binary '\0'),(_binary 'ö¯K\Z:\›DV£\»Ùo.\‡',60,'Maternity Leave',_binary ''),(_binary '†ôÇtüBÉ—∂I\Ï{\∆',7,'Paternity Leave',_binary ''),(_binary '\Ê^8.É\…Mà6\œG∫.R\ ',7,'Emergency Leave',_binary '\0');
/*!40000 ALTER TABLE `leave_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `managers`
--

DROP TABLE IF EXISTS `managers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `managers` (
  `manager_id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managers`
--

LOCK TABLES `managers` WRITE;
/*!40000 ALTER TABLE `managers` DISABLE KEYS */;
/*!40000 ALTER TABLE `managers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-20 13:15:26
