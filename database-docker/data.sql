CREATE DATABASE  IF NOT EXISTS `iefleetx` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `iefleetx`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: iefleetx
-- ------------------------------------------------------
-- Server version	5.7.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  `fleet_size` int(11) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `UKc0r9atamxvbhjjvy5j8da1kam` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'zainamin22@live.com','zainamin22','Zain','Amin','https://firebasestorage.googleapis.com/v0/b/fleetx-1530369852255.appspot.com/o/1546660284477-13179069_519167514936034_1475862095189464615_n.jpg?alt=media&token=a8f1c03e-5723-4ce6-82a6-c8dc28f79f32','FleetioX',25,'Rawalpindi','Pakistan','03005513608'),(3,'admin@admin.com','admin','','','https://firebasestorage.googleapis.com/v0/b/fleetx-1530369852255.appspot.com/o/1571069119453-DSC_0889%20copy.jpg?alt=media&token=ae8aa38f-17bf-424d-bfde-2997b97294dc','',NULL,'','','');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver` (
  `driver_id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `image` varchar(1000) DEFAULT NULL,
  `date_of_birth` bigint(200) DEFAULT NULL,
  `cnic` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `licence_no` varchar(100) DEFAULT NULL,
  `licence_expiry_date` bigint(200) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `average_score` int(11) DEFAULT NULL,
  `total_distance_covered` double DEFAULT NULL,
  `total_trips` int(11) DEFAULT NULL,
  `firebase_id` varchar(500) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `approved` int(11) DEFAULT NULL,
  PRIMARY KEY (`driver_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `UKfchuyotq64tagkwktlh4qttyy` (`email`),
  KEY `ad_id_idx` (`admin_id`),
  CONSTRAINT `ad_id` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES (-858572013,'zainamin22@live.com','Zain','Amin','https://graph.facebook.com/848898888629560/picture',849812401150,'3740532699787','25/06/1996','Pakistan','House 8 Street 8 lane 3 dhamial camp rawalpindi','grh4g4vebdjd',1545850843271,1,80,2,3,'FFb9qojeofQuBpu5y2cNXjSO4PG3',NULL,NULL),(-533510686,'abdulbasit77.ab@gmail.com','Abdul','Basit','https://lh5.googleusercontent.com/-5Xuf7jVUXgk/AAAAAAAAAAI/AAAAAAAAAs4/SD3nusQCT34/s96-c/photo.jpg',1544295643236,'1235578','Islamabad','Pakistan','G6, Isl','8661616',1547665232319,1,50,1,2,'KEfQlvJ1huaVfQEQN881xRvYb203',NULL,NULL),(1918220640,'zubairshaheen77@gmail.com','Zubair','Shaheen','https://lh4.googleusercontent.com/-JU3qRJ-wfsA/AAAAAAAAAAI/AAAAAAAAAAA/AGDgw-iFRKMId5fFZrzjAGnOP5b1ec8kSQ/s96-c/photo.jpg',809377237871,'3740532699787','Islamabad','Pakistan','naval enclave','3gdhe83hrbeh3',1545937248529,1,60,5,1,'g8TId9evfhQGZ8NTdwizx1MoAzR2',NULL,NULL);
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver_trips`
--

DROP TABLE IF EXISTS `driver_trips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver_trips` (
  `trip_id` int(11) NOT NULL AUTO_INCREMENT,
  `starting_time` bigint(200) DEFAULT NULL,
  `ending_time` bigint(200) DEFAULT NULL,
  `starting_lat` double DEFAULT NULL,
  `starting_lon` double DEFAULT NULL,
  `ending_lat` double DEFAULT NULL,
  `ending_lon` double DEFAULT NULL,
  `driver_id` int(11) DEFAULT NULL,
  `speeding_score` int(11) DEFAULT NULL,
  `fuel_start_reading` double DEFAULT NULL,
  `average_score` int(11) DEFAULT NULL,
  `fuel_end_reading` double DEFAULT NULL,
  `fuel_increase_counter` int(11) DEFAULT NULL,
  `fuel_increase_quantity` double DEFAULT NULL,
  PRIMARY KEY (`trip_id`),
  KEY `dri_id32_idx` (`driver_id`),
  CONSTRAINT `dri_id32` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`driver_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_trips`
--

LOCK TABLES `driver_trips` WRITE;
/*!40000 ALTER TABLE `driver_trips` DISABLE KEYS */;
INSERT INTO `driver_trips` VALUES (27,1544087715846,1544087730120,33.5660734,73.0302131,33.649269104003906,73.16059112548828,-858572013,5,NULL,100,NULL,NULL,NULL),(28,1544088046826,1544088054198,33.5660734,73.0302131,33.649269104003906,73.16059112548828,-858572013,0,NULL,100,NULL,NULL,NULL),(29,1544088076269,1544088081541,33.5660734,73.0302131,33.65012741088867,73.1558609008789,-533510686,0,NULL,100,NULL,NULL,NULL),(30,1544088122867,1544088140639,33.5660734,73.0302131,33.650142669677734,73.15587615966797,-533510686,0,NULL,100,NULL,NULL,NULL),(31,1544088162592,1544088172673,33.5660734,73.0302131,33.64997482299805,73.15577697753906,1918220640,0,NULL,100,NULL,NULL,NULL),(32,1544088231238,1544088243737,33.5660734,73.0302131,33.65007019042969,73.15594482421875,1918220640,0,NULL,100,NULL,NULL,NULL),(33,1545110732305,1545110735913,33.5754149,73.0455085,33.5758056640625,73.04320526123047,-858572013,0,NULL,100,NULL,NULL,NULL),(34,1545110910324,1545110923799,33.5789615,73.0514116,33.579132080078125,73.05136108398438,-858572013,0,NULL,100,NULL,NULL,NULL),(39,1545111349956,1545111379849,33.5975272,73.0602659,33.59636306762695,73.06431579589844,-858572013,1,NULL,95,NULL,NULL,NULL);
/*!40000 ALTER TABLE `driver_trips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver_vehicle`
--

DROP TABLE IF EXISTS `driver_vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver_vehicle` (
  `driver_vehicle_id` int(11) NOT NULL AUTO_INCREMENT,
  `driver_id` int(11) DEFAULT NULL,
  `vehicle_id` int(11) DEFAULT NULL,
  `assignment_time` int(110) DEFAULT NULL,
  PRIMARY KEY (`driver_vehicle_id`),
  KEY `driver_id_idx` (`driver_id`),
  KEY `vehicle_id_idx` (`vehicle_id`),
  CONSTRAINT `driver_id` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`driver_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `vehicle_id` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_vehicle`
--

LOCK TABLES `driver_vehicle` WRITE;
/*!40000 ALTER TABLE `driver_vehicle` DISABLE KEYS */;
INSERT INTO `driver_vehicle` VALUES (21,-858572013,64,NULL),(26,-533510686,65,NULL);
/*!40000 ALTER TABLE `driver_vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inspection`
--

DROP TABLE IF EXISTS `inspection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inspection` (
  `inspection_id` int(11) NOT NULL AUTO_INCREMENT,
  `driver_id` int(11) DEFAULT NULL,
  `vehicle_id` int(11) DEFAULT NULL,
  `odometer_reading` int(11) DEFAULT NULL,
  `ending_time` bigint(200) DEFAULT NULL,
  `starting_time` bigint(200) DEFAULT NULL,
  `istatus` varchar(500) DEFAULT NULL,
  `ititle` varchar(500) DEFAULT NULL,
  `idescription` varchar(1000) CHARACTER SET big5 DEFAULT NULL,
  `ilast_performed` bigint(200) DEFAULT NULL,
  `iparts` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`inspection_id`),
  KEY `dre_id_idx` (`driver_id`),
  KEY `wehic_id_idx` (`vehicle_id`),
  CONSTRAINT `dre_id` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`driver_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `wehic_id` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inspection`
--

LOCK TABLES `inspection` WRITE;
/*!40000 ALTER TABLE `inspection` DISABLE KEYS */;
INSERT INTO `inspection` VALUES (60,-533510686,65,69,1544088603701,1544088512733,'submitted','Basit Inspecstion','First Inspection Check',1544088603701,'[\n  {\n    \"id\": \"iclutch\",\n    \"name\": \"Clutch\",\n    \"status\": \"no\"\n  },\n  {\n    \"id\": \"isteeringMechanism\",\n    \"name\": \"Steering Mechanism\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"itires\",\n    \"name\": \"Tires\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"iparkingBrake\",\n    \"name\": \"Parking Brake\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"ihorn\",\n    \"name\": \"Horn\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"irearVisionMirror\",\n    \"name\": \"Rear Vision Mirror\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"iserviceBrake\",\n    \"name\": \"Service Brake\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"itransmission\",\n    \"name\": \"Transmission\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"iengine\",\n    \"name\": \"Engine\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"icouplingDevice\",\n    \"name\": \"Coupling Device\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"iwindsheildWipers\",\n    \"name\": \"Wind Sheild Wipers\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"iwheelRims\",\n    \"name\": \"Wheel Rims\",\n    \"status\": \"yes\"\n  }\n]'),(61,-858572013,64,2585,1544093117266,1544088639952,'submitted','Driver Daily Inspection','bhjcdjbhbchjdhjbvvd',1544093117266,'[\n  {\n    \"id\": \"iclutch\",\n    \"name\": \"Clutch\",\n    \"status\": \"no\"\n  },\n  {\n    \"id\": \"isteeringMechanism\",\n    \"name\": \"Steering Mechanism\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"itires\",\n    \"name\": \"Tires\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"iparkingBrake\",\n    \"name\": \"Parking Brake\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"ihorn\",\n    \"name\": \"Horn\",\n    \"status\": \"no\"\n  },\n  {\n    \"id\": \"irearVisionMirror\",\n    \"name\": \"Rear Vision Mirror\",\n    \"status\": \"no\"\n  },\n  {\n    \"id\": \"iserviceBrake\",\n    \"name\": \"Service Brake\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"itransmission\",\n    \"name\": \"Transmission\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"iengine\",\n    \"name\": \"Engine\",\n    \"status\": \"no\"\n  },\n  {\n    \"id\": \"icouplingDevice\",\n    \"name\": \"Coupling Device\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iwindsheildWipers\",\n    \"name\": \"Wind Sheild Wipers\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iwheelRims\",\n    \"name\": \"Wheel Rims\",\n    \"status\": \"uncheck\"\n  }\n]'),(62,-533510686,65,NULL,NULL,1544089185053,'started','Test1 Inspection','Well check reminder',NULL,'[\n  {\n    \"id\": \"iclutch\",\n    \"name\": \"Clutch\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"isteeringMechanism\",\n    \"name\": \"Steering Mechanism\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"itires\",\n    \"name\": \"Tires\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iparkingBrake\",\n    \"name\": \"Parking Brake\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"ihorn\",\n    \"name\": \"Horn\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"irearVisionMirror\",\n    \"name\": \"Rear Vision Mirror\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iserviceBrake\",\n    \"name\": \"Service Brake\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"itransmission\",\n    \"name\": \"Transmission\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iengine\",\n    \"name\": \"Engine\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"icouplingDevice\",\n    \"name\": \"Coupling Device\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iwindsheildWipers\",\n    \"name\": \"Wind Sheild Wipers\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iwheelRims\",\n    \"name\": \"Wheel Rims\",\n    \"status\": \"uncheck\"\n  }\n]'),(63,-858572013,64,NULL,NULL,1544089873762,'in_progress','Zain Inpection','n vd c bd d bfdf',1544779487204,'[\n  {\n    \"id\": \"iclutch\",\n    \"name\": \"Clutch\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"isteeringMechanism\",\n    \"name\": \"Steering Mechanism\",\n    \"status\": \"no\"\n  },\n  {\n    \"id\": \"itires\",\n    \"name\": \"Tires\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"iparkingBrake\",\n    \"name\": \"Parking Brake\",\n    \"status\": \"no\"\n  },\n  {\n    \"id\": \"ihorn\",\n    \"name\": \"Horn\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"irearVisionMirror\",\n    \"name\": \"Rear Vision Mirror\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iserviceBrake\",\n    \"name\": \"Service Brake\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"itransmission\",\n    \"name\": \"Transmission\",\n    \"status\": \"no\"\n  },\n  {\n    \"id\": \"iengine\",\n    \"name\": \"Engine\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"icouplingDevice\",\n    \"name\": \"Coupling Device\",\n    \"status\": \"no\"\n  },\n  {\n    \"id\": \"iwindsheildWipers\",\n    \"name\": \"Wind Sheild Wipers\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"iwheelRims\",\n    \"name\": \"Wheel Rims\",\n    \"status\": \"yes\"\n  }\n]'),(64,-858572013,64,NULL,NULL,1544089950102,'started','b mdcgh','bgdvghsdc',NULL,'[\n  {\n    \"id\": \"iclutch\",\n    \"name\": \"Clutch\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"isteeringMechanism\",\n    \"name\": \"Steering Mechanism\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"itires\",\n    \"name\": \"Tires\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iparkingBrake\",\n    \"name\": \"Parking Brake\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"ihorn\",\n    \"name\": \"Horn\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"irearVisionMirror\",\n    \"name\": \"Rear Vision Mirror\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iserviceBrake\",\n    \"name\": \"Service Brake\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"itransmission\",\n    \"name\": \"Transmission\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iengine\",\n    \"name\": \"Engine\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"icouplingDevice\",\n    \"name\": \"Coupling Device\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iwindsheildWipers\",\n    \"name\": \"Wind Sheild Wipers\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iwheelRims\",\n    \"name\": \"Wheel Rims\",\n    \"status\": \"uncheck\"\n  }\n]'),(65,-858572013,64,NULL,NULL,1544093005129,'started','Daily Inspection','vgdshvgvgds',NULL,'[\n  {\n    \"id\": \"iclutch\",\n    \"name\": \"Clutch\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"isteeringMechanism\",\n    \"name\": \"Steering Mechanism\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"itires\",\n    \"name\": \"Tires\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iparkingBrake\",\n    \"name\": \"Parking Brake\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"ihorn\",\n    \"name\": \"Horn\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"irearVisionMirror\",\n    \"name\": \"Rear Vision Mirror\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iserviceBrake\",\n    \"name\": \"Service Brake\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"itransmission\",\n    \"name\": \"Transmission\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iengine\",\n    \"name\": \"Engine\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"icouplingDevice\",\n    \"name\": \"Coupling Device\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iwindsheildWipers\",\n    \"name\": \"Wind Sheild Wipers\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iwheelRims\",\n    \"name\": \"Wheel Rims\",\n    \"status\": \"uncheck\"\n  }\n]'),(66,-858572013,64,524,1545274182076,1545273232784,'submitted','Driver Daily Inspection','This is just a sample inspection',1545274182076,'[\n  {\n    \"id\": \"iclutch\",\n    \"name\": \"Clutch\",\n    \"status\": \"no\"\n  },\n  {\n    \"id\": \"iparkingBrake\",\n    \"name\": \"Parking Brake\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"ihorn\",\n    \"name\": \"Horn\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"irearVisionMirror\",\n    \"name\": \"Rear Vision Mirror\",\n    \"status\": \"no\"\n  },\n  {\n    \"id\": \"iserviceBrake\",\n    \"name\": \"Service Brake\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"itransmission\",\n    \"name\": \"Transmission\",\n    \"status\": \"no\"\n  },\n  {\n    \"id\": \"icouplingDevice\",\n    \"name\": \"Coupling Device\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"iwindsheildWipers\",\n    \"name\": \"Wind Sheild Wipers\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iwheelRims\",\n    \"name\": \"Wheel Rims\",\n    \"status\": \"uncheck\"\n  }\n]'),(67,-858572013,64,NULL,NULL,1545370089805,'in_progress','test','hjhgutg',1546660921162,'[\n  {\n    \"id\": \"iclutch\",\n    \"name\": \"Clutch\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"isteeringMechanism\",\n    \"name\": \"Steering Mechanism\",\n    \"status\": \"no\"\n  },\n  {\n    \"id\": \"itires\",\n    \"name\": \"Tires\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"iparkingBrake\",\n    \"name\": \"Parking Brake\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"ihorn\",\n    \"name\": \"Horn\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"irearVisionMirror\",\n    \"name\": \"Rear Vision Mirror\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iserviceBrake\",\n    \"name\": \"Service Brake\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"itransmission\",\n    \"name\": \"Transmission\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iengine\",\n    \"name\": \"Engine\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"icouplingDevice\",\n    \"name\": \"Coupling Device\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iwindsheildWipers\",\n    \"name\": \"Wind Sheild Wipers\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iwheelRims\",\n    \"name\": \"Wheel Rims\",\n    \"status\": \"uncheck\"\n  }\n]'),(68,-858572013,64,NULL,NULL,1546661387871,'started','Driver Daily Inspection','vhbdhjdh',NULL,'[\n  {\n    \"id\": \"iclutch\",\n    \"name\": \"Clutch\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"isteeringMechanism\",\n    \"name\": \"Steering Mechanism\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"itires\",\n    \"name\": \"Tires\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iparkingBrake\",\n    \"name\": \"Parking Brake\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"ihorn\",\n    \"name\": \"Horn\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"irearVisionMirror\",\n    \"name\": \"Rear Vision Mirror\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iserviceBrake\",\n    \"name\": \"Service Brake\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"itransmission\",\n    \"name\": \"Transmission\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iengine\",\n    \"name\": \"Engine\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"icouplingDevice\",\n    \"name\": \"Coupling Device\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iwindsheildWipers\",\n    \"name\": \"Wind Sheild Wipers\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iwheelRims\",\n    \"name\": \"Wheel Rims\",\n    \"status\": \"uncheck\"\n  }\n]'),(69,-858572013,64,NULL,NULL,1546661438700,'in_progress','Zubair Inspection','bhhjbfds',1546677166533,'[\n  {\n    \"id\": \"iclutch\",\n    \"name\": \"Clutch\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"isteeringMechanism\",\n    \"name\": \"Steering Mechanism\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"itires\",\n    \"name\": \"Tires\",\n    \"status\": \"no\"\n  },\n  {\n    \"id\": \"iparkingBrake\",\n    \"name\": \"Parking Brake\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"ihorn\",\n    \"name\": \"Horn\",\n    \"status\": \"no\"\n  },\n  {\n    \"id\": \"irearVisionMirror\",\n    \"name\": \"Rear Vision Mirror\",\n    \"status\": \"no\"\n  },\n  {\n    \"id\": \"iserviceBrake\",\n    \"name\": \"Service Brake\",\n    \"status\": \"yes\"\n  },\n  {\n    \"id\": \"itransmission\",\n    \"name\": \"Transmission\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iengine\",\n    \"name\": \"Engine\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"icouplingDevice\",\n    \"name\": \"Coupling Device\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iwindsheildWipers\",\n    \"name\": \"Wind Sheild Wipers\",\n    \"status\": \"uncheck\"\n  },\n  {\n    \"id\": \"iwheelRims\",\n    \"name\": \"Wheel Rims\",\n    \"status\": \"uncheck\"\n  }\n]');
/*!40000 ALTER TABLE `inspection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reminders`
--

DROP TABLE IF EXISTS `reminders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reminders` (
  `reminder_id` int(11) NOT NULL AUTO_INCREMENT,
  `reminder_type` varchar(500) DEFAULT NULL,
  `reminder_title` varchar(500) DEFAULT NULL,
  `reminder_description` varchar(500) DEFAULT NULL,
  `issued_to` varchar(500) DEFAULT NULL,
  `issued_time` bigint(200) DEFAULT NULL,
  `issued_type` varchar(500) DEFAULT NULL,
  `issued_to_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`reminder_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminders`
--

LOCK TABLES `reminders` WRITE;
/*!40000 ALTER TABLE `reminders` DISABLE KEYS */;
INSERT INTO `reminders` VALUES (8,'service','First service reminder','bvddvdghvfdhfd','vendor',1544036400000,'issued',641664942),(9,'service','First service reminder','bhcjbhcdbcbdgcdc','vendor',1544036400000,'issued',1957618479),(10,'driver_renewal','1st driver renewal d','bhcdhgvgcdshvcdgs','driver',1544036400000,'issued',-858572013),(11,'service','First service reminder','bhcdbhhbjsdhjbfsd','vendor',1544036400000,'issued',1957618479),(12,'vehicle_renewal','gvsvgdhv','bgvdcvgdsc','driver',1544036400000,'issued',-533510686),(13,'driver_renewal','1st driver renewal ','check this reminder','driver',1546628400000,'issued',-858572013);
/*!40000 ALTER TABLE `reminders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_entry`
--

DROP TABLE IF EXISTS `service_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_entry` (
  `service_entry_id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_id` int(11) DEFAULT NULL,
  `vender_id` int(11) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `odometer_reading` int(11) DEFAULT NULL,
  `wstatus` varchar(250) DEFAULT NULL,
  `start_time` bigint(200) DEFAULT NULL,
  `end_time` bigint(200) DEFAULT NULL,
  `last_performed` bigint(200) DEFAULT NULL,
  `wlabels` varchar(1000) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `wtitle` varchar(500) DEFAULT NULL,
  `service_task_name` varchar(500) DEFAULT NULL,
  `service_task_description` varchar(1000) DEFAULT NULL,
  `service_task_status` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`service_entry_id`),
  KEY `veaa_id_idx` (`vehicle_id`),
  KEY `venaa_id_idx` (`vender_id`),
  KEY `admaa_id_idx` (`admin_id`),
  CONSTRAINT `admaa_id` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `veaa_id` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `venaa_id` FOREIGN KEY (`vender_id`) REFERENCES `vendor` (`vendor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_entry`
--

LOCK TABLES `service_entry` WRITE;
/*!40000 ALTER TABLE `service_entry` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle` (
  `vehicle_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL,
  `vin` varchar(500) DEFAULT NULL,
  `license_plate` varchar(500) DEFAULT NULL,
  `type` varchar(500) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `model` varchar(500) DEFAULT NULL,
  `company` varchar(500) DEFAULT NULL,
  `registration_province` varchar(45) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `fuel_type` varchar(500) DEFAULT NULL,
  `fuel_tank1_capacity` double DEFAULT NULL,
  `fuel_tank2_capacity` double DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `archived` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`vehicle_id`),
  KEY `ad_id2_idx` (`admin_id`),
  CONSTRAINT `ad_id2` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES (64,'Hon-77','00123','IDK-898','',2018,'Civic','Honda','57755899','https://firebasestorage.googleapis.com/v0/b/fleetx-1530369852255.appspot.com/o/1544086982447-40ce9584629d52b5e29003a6dd9143ffx.jpg?alt=media&token=9185e5ea-61d7-4a06-bdc1-fa100fa015f4','Petrol',94,115,1,'yes'),(65,'Viz-98','00865','IDk-965','car',2018,'vizel','Honda','7857644','https://firebasestorage.googleapis.com/v0/b/fleetx-1530369852255.appspot.com/o/1544087435419-download.jpg?alt=media&token=2c19fab3-6d25-40d2-aec8-83c935dd230e','Petrol',100,79,1,'no'),(66,'Para-773','00365','KHI-847','car',2015,'Parado','Toyota','7647689','https://firebasestorage.googleapis.com/v0/b/fleetx-1530369852255.appspot.com/o/1544087580307-download%20(1).jpg?alt=media&token=22b881c1-82af-443c-bf50-a6b85a4bc031','Petrol',212,122,1,'no'),(67,'Benz','00111','LHR-111','car',2014,'Mercedes','Mercedes Benz','7876768','https://firebasestorage.googleapis.com/v0/b/fleetx-1530369852255.appspot.com/o/1544087717529-download%20(2).jpg?alt=media&token=dc1c5343-45b9-4b3b-94be-ab8cc901a8f6','Petrol',788,88,1,'no'),(68,'Lia-434','00765','IDK-785','car',2011,'Liana','Suzuki','79678899','https://firebasestorage.googleapis.com/v0/b/fleetx-1530369852255.appspot.com/o/1544087840449-download%20(3).jpg?alt=media&token=060ed3be-824c-459e-9b59-9af16302f887','Petrol',50,50,1,'no');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor` (
  `vendor_id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `approved` varchar(45) DEFAULT NULL,
  `firebase_id` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`vendor_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `UKjyjmopegfp4iape655lu75sml` (`email`),
  KEY `ad_id33_idx` (`admin_id`),
  CONSTRAINT `ad_id33` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` VALUES (-297264100,'zainamin22@live.com','Zain','Amin','https://graph.facebook.com/993904614128986/picture','Rawalpindi','Pakistan','House 8 Street 8 Lane 3 Quiad e azam colony dhamial road rawalpindi ',NULL,1,NULL,'MsgkIKTKIvh23QvGwVWNOjFYJZS2'),(641664942,'abdulbasit77.ab@gmail.com','Abdul','Basit','https://lh5.googleusercontent.com/-5Xuf7jVUXgk/AAAAAAAAAAI/AAAAAAAAAs4/SD3nusQCT34/s96-c/photo.jpg','Islamabad','Pakistan','G7, Isb',NULL,1,NULL,'KMtBqnPxssMFBVui0acoZQErU062'),(823721311,'zubairshaheen77@hotmail.com','Rao','Zubair','https://graph.facebook.com/2089287874450533/picture','Islamabad','Pakistan','Naval Anchorage islamabad',NULL,1,NULL,'ltf8H7T0LFU4XaDnP6CWp59Pxvx2'),(1957618479,'zainamin1267@gmail.com','Zain','amin','https://lh6.googleusercontent.com/-Z2Nd9IXZrmY/AAAAAAAAAAI/AAAAAAAAA90/FBIVM2IZxzE/s96-c/photo.jpg','Rawalpindi','Pakistan','House no 8 Street no 8 Lanr no 3 Quiad e Adam colony dhamial road rawalpindi camp',NULL,1,NULL,'Zq2pJNUBPygtDke41jDVebXy4L73');
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_orders`
--

DROP TABLE IF EXISTS `work_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_orders` (
  `work_orders_id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_id` int(11) DEFAULT NULL,
  `vender_id` int(11) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `odometer_reading` int(11) DEFAULT NULL,
  `wstatus` varchar(250) DEFAULT NULL,
  `start_time` bigint(200) DEFAULT NULL,
  `end_time` bigint(200) DEFAULT NULL,
  `last_performed` bigint(200) DEFAULT NULL,
  `wlabels` varchar(1000) DEFAULT NULL,
  `wissues` varchar(3000) DEFAULT NULL,
  `service_tasks` varchar(3000) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `comments` varchar(1500) DEFAULT NULL,
  `wtitle` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`work_orders_id`),
  KEY `ve_id_idx` (`vehicle_id`),
  KEY `ven_id_idx` (`vender_id`),
  KEY `adm_id_idx` (`admin_id`),
  CONSTRAINT `adm_id` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ve_id` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ven_id` FOREIGN KEY (`vender_id`) REFERENCES `vendor` (`vendor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_orders`
--

LOCK TABLES `work_orders` WRITE;
/*!40000 ALTER TABLE `work_orders` DISABLE KEYS */;
INSERT INTO `work_orders` VALUES (25,67,641664942,1,434343,'submitted',1544036400000,1544089540402,1544089540402,'[{\"value\":\"First\"},{\"value\":\"History\"},{\"value\":\"Check\"}]','[\n  {\n    \"cause\": \"\",\n    \"description\": \"\",\n    \"id\": 1,\n    \"name\": \"issue test 1\",\n    \"reported_by\": \"\",\n    \"status\": \"resolved\"\n  },\n  {\n    \"cause\": \"Oil lest\",\n    \"description\": \"vgvgdbhjvhbjvhjbdf\",\n    \"id\": 2,\n    \"name\": \"Issue tes 2 \",\n    \"reported_by\": \"Zain Amin\",\n    \"status\": \"resolved\"\n  }\n]','[\n  {\n    \"description\": \"Tire Failed\",\n    \"name\": \"Tire\",\n    \"status\": \"no\"\n  },\n  {\n    \"description\": \"Brake failed\",\n    \"name\": \"Brake\",\n    \"status\": \"yes\"\n  }\n]','bhdsfvdsfhydssfvds',NULL,'1st Work Order'),(26,66,1957618479,1,4343,'in_progress',1544036400000,NULL,1544093336970,'[{\"value\":\"ew\"},{\"value\":\"bvbv\"},{\"value\":\"dssds\"}]','[\n  {\n    \"cause\": \"hfdhd\",\n    \"description\": \"fdfd\",\n    \"id\": 1,\n    \"name\": \"tire break fail\",\n    \"reported_by\": \"Zain Amin\",\n    \"status\": \"resolved\"\n  },\n  {\n    \"cause\": \"\",\n    \"description\": \"\",\n    \"id\": 2,\n    \"name\": \"ccxcx\",\n    \"reported_by\": \"\",\n    \"status\": \"resolved\"\n  }\n]','[{\"name\":\"tire\",\"description\":\"v  vcsz\",\"status\":\"uncheck\"},{\"name\":\"horn\",\"description\":\"bhjfdgds\",\"status\":\"uncheck\"},{\"name\":\"engine\",\"description\":\"\",\"status\":\"uncheck\"}]','gvchsghdgshvds',NULL,'bgdsgsgs'),(27,64,1957618479,1,230,'submitted',1545246000000,1545274354624,1545274354624,'[{\"value\":\"Fuel Check\"},{\"value\":\"Brake Fail\"}]','[\n  {\n    \"cause\": \"Fuel Leakage\",\n    \"description\": \"Fix this asap\",\n    \"id\": 1,\n    \"name\": \"issue test 1\",\n    \"reported_by\": \"Zain Amin\",\n    \"status\": \"resolved\"\n  },\n  {\n    \"cause\": \"HeadLights failure\",\n    \"description\": \"headlights are not working fix it asap\",\n    \"id\": 2,\n    \"name\": \"issue test 2\",\n    \"reported_by\": \"Zain Amin\",\n    \"status\": \"resolved\"\n  }\n]','[\n  {\n    \"description\": \"Please fix this issue\",\n    \"name\": \"Tire Puncture\",\n    \"status\": \"yes\"\n  },\n  {\n    \"description\": \"Check the brake oil\",\n    \"name\": \"Brake Fail\",\n    \"status\": \"no\"\n  }\n]','This is just a sample Work order.',NULL,'Vendor Daily Work Order');
/*!40000 ALTER TABLE `work_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'iefleetx'
--

--
-- Dumping routines for database 'iefleetx'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-14 21:49:40
