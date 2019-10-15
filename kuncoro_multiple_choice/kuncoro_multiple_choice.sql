/*
SQLyog Ultimate v10.42 
MySQL - 5.5.5-10.1.9-MariaDB : Database - kuncoro_multiple_choice
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kuncoro_multiple_choice` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `kuncoro_multiple_choice`;

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `menu` */

insert  into `menu`(`id`,`nama`) values (1,'Ayam Goreng'),(2,'Ayam Bakar'),(3,'Ketang Goreng'),(4,'Gurami Goreng'),(5,'Cumi'),(6,'Nila Goreng'),(7,'Bakso'),(8,'Mie Ayam'),(9,'Mie So'),(10,'Ramen'),(11,'Sashimi'),(12,'Sushi'),(13,'Onigiri'),(14,'Tempura'),(15,'Sosis Bakar'),(16,'Empek-empek'),(17,'Gaplek'),(18,'Opor Ayam'),(19,'Tahu Gimbal'),(20,'Pizza');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
