-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 02, 2020 at 11:45 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank`
--
CREATE DATABASE IF NOT EXISTS `bank` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bank`;

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation_timestamp` datetime DEFAULT NULL,
  `modification_timestamp` datetime DEFAULT NULL,
  `version_number` bigint(20) NOT NULL,
  `balance` decimal(15,2) DEFAULT NULL,
  `number_account` decimal(11,0) DEFAULT NULL,
  `id_currency_type` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKci2gqhfbnokoat9thdjphxbfe` (`id_currency_type`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `account`
--

TRUNCATE TABLE `account`;
--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `creation_timestamp`, `modification_timestamp`, `version_number`, `balance`, `number_account`, `id_currency_type`) VALUES
(13, '2020-07-02 18:38:26', NULL, 4, '6712005.67', '123456789', 3),
(12, '2020-07-02 18:38:15', NULL, 4, '989049.70', '12345678', 2),
(11, '2020-07-02 18:37:55', NULL, 3, '1139999.50', '1234567', 1);

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
CREATE TABLE IF NOT EXISTS `country` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation_timestamp` datetime DEFAULT NULL,
  `modification_timestamp` datetime DEFAULT NULL,
  `version_number` bigint(20) NOT NULL,
  `iso_code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `country`
--

TRUNCATE TABLE `country`;
--
-- Dumping data for table `country`
--

INSERT INTO `country` (`id`, `creation_timestamp`, `modification_timestamp`, `version_number`, `iso_code`, `name`) VALUES
(1, '2020-06-29 21:52:07', '2020-06-29 21:52:07', 1, 'AR', 'ARGENTINA'),
(2, '2020-06-29 21:52:07', '2020-06-29 21:52:07', 1, 'BR', 'BRASIL'),
(3, '2020-06-29 21:52:07', '2020-06-29 21:52:07', 1, 'UY', 'URUGUAY'),
(4, '2020-06-29 21:52:07', '2020-06-29 21:52:07', 1, 'CH', 'CHILE');

-- --------------------------------------------------------

--
-- Table structure for table `currency_account`
--

DROP TABLE IF EXISTS `currency_account`;
CREATE TABLE IF NOT EXISTS `currency_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation_timestamp` datetime DEFAULT NULL,
  `modification_timestamp` datetime DEFAULT NULL,
  `version_number` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `min_value` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `currency_account`
--

TRUNCATE TABLE `currency_account`;
--
-- Dumping data for table `currency_account`
--

INSERT INTO `currency_account` (`id`, `creation_timestamp`, `modification_timestamp`, `version_number`, `code`, `currency`, `min_value`) VALUES
(1, '2020-06-29 21:52:07', '2020-06-29 21:52:07', 1, '$', 'peso', '1000.00'),
(2, '2020-06-29 21:52:07', '2020-06-29 21:52:07', 1, '$', 'dolar', '300.00'),
(3, '2020-06-29 21:52:07', '2020-06-29 21:52:07', 1, '€', 'euro', '150.00');

-- --------------------------------------------------------

--
-- Table structure for table `holder`
--

DROP TABLE IF EXISTS `holder`;
CREATE TABLE IF NOT EXISTS `holder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation_timestamp` datetime DEFAULT NULL,
  `modification_timestamp` datetime DEFAULT NULL,
  `version_number` bigint(20) NOT NULL,
  `rut` varchar(255) DEFAULT NULL,
  `id_holder_type` bigint(20) DEFAULT NULL,
  `legal_entity_id` bigint(20) DEFAULT NULL,
  `natural_person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6ft45iy1w61v15o8sre5sby9` (`rut`),
  KEY `FK7gsmpjp5ny4s8a35tns9e6w7f` (`id_holder_type`),
  KEY `FK7yd6l3pcg52xdsyw011xjiko0` (`legal_entity_id`),
  KEY `FK508nm36xlp19biyug5o7a9e2m` (`natural_person_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `holder`
--

TRUNCATE TABLE `holder`;
--
-- Dumping data for table `holder`
--

INSERT INTO `holder` (`id`, `creation_timestamp`, `modification_timestamp`, `version_number`, `rut`, `id_holder_type`, `legal_entity_id`, `natural_person_id`) VALUES
(12, '2020-07-02 18:04:18', NULL, 0, '1037616283', 1, NULL, 14),
(11, '2020-07-02 18:03:27', NULL, 0, '1037616282', 1, NULL, 13),
(13, '2020-07-02 18:33:37', NULL, 0, '12345678', 2, 5, NULL),
(10, '2020-07-02 17:55:33', NULL, 2, '2345678', 2, 4, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `holder_type`
--

DROP TABLE IF EXISTS `holder_type`;
CREATE TABLE IF NOT EXISTS `holder_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation_timestamp` datetime DEFAULT NULL,
  `modification_timestamp` datetime DEFAULT NULL,
  `version_number` bigint(20) NOT NULL,
  `holder_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `holder_type`
--

TRUNCATE TABLE `holder_type`;
--
-- Dumping data for table `holder_type`
--

INSERT INTO `holder_type` (`id`, `creation_timestamp`, `modification_timestamp`, `version_number`, `holder_type`) VALUES
(1, '2020-06-29 21:52:07', '2020-06-29 21:52:07', 1, 'NATURAL'),
(2, '2020-06-29 21:52:07', '2020-06-29 21:52:07', 1, 'JURIDICO');

-- --------------------------------------------------------

--
-- Table structure for table `legal_entity`
--

DROP TABLE IF EXISTS `legal_entity`;
CREATE TABLE IF NOT EXISTS `legal_entity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation_timestamp` datetime DEFAULT NULL,
  `modification_timestamp` datetime DEFAULT NULL,
  `version_number` bigint(20) NOT NULL,
  `foundation_year` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `legal_entity`
--

TRUNCATE TABLE `legal_entity`;
--
-- Dumping data for table `legal_entity`
--

INSERT INTO `legal_entity` (`id`, `creation_timestamp`, `modification_timestamp`, `version_number`, `foundation_year`, `name`) VALUES
(5, NULL, NULL, 0, 2009, 'Company S.A'),
(4, NULL, NULL, 3, 2013, 'TECSO');

-- --------------------------------------------------------

--
-- Table structure for table `movement`
--

DROP TABLE IF EXISTS `movement`;
CREATE TABLE IF NOT EXISTS `movement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation_timestamp` datetime DEFAULT NULL,
  `modification_timestamp` datetime DEFAULT NULL,
  `version_number` bigint(20) NOT NULL,
  `amount` decimal(15,2) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `id_movement_type` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoemeananv9w9qnbcoccbl70a0` (`account_id`),
  KEY `FKtcvyg6ld0hnbj5ukfryxft53n` (`id_movement_type`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `movement`
--

TRUNCATE TABLE `movement`;
--
-- Dumping data for table `movement`
--

INSERT INTO `movement` (`id`, `creation_timestamp`, `modification_timestamp`, `version_number`, `amount`, `description`, `account_id`, `id_movement_type`) VALUES
(16, '2020-07-02 18:42:02', NULL, 0, '-599.65', 'Compra de navera', 12, 2),
(15, '2020-07-02 18:41:47', NULL, 0, '-350.65', 'Compra de televisor ', 12, 2),
(14, '2020-07-02 18:40:52', NULL, 0, '120000.00', 'Consignación Desde Cajero', 13, 1),
(13, '2020-07-02 18:39:59', NULL, 0, '-157628.98', 'Compra supermercado', 13, 2),
(12, '2020-07-02 18:39:35', NULL, 0, '-250365.35', 'Pago servicios públicos', 13, 2),
(11, '2020-07-02 18:38:56', NULL, 0, '6000000.00', 'Pago de nómina', 13, 1),
(17, '2020-07-02 18:42:23', NULL, 0, '-20000.00', 'Compra de carro', 12, 2),
(18, '2020-07-02 18:42:38', NULL, 0, '10000.00', 'Pago de nómina', 12, 1),
(19, '2020-07-02 18:42:55', NULL, 0, '10000.00', 'Pago de nómina', 11, 1),
(20, '2020-07-02 18:43:11', NULL, 0, '250000.00', 'Consignación desde cajero', 11, 1),
(21, '2020-07-02 18:43:30', NULL, 0, '-120000.50', 'Compra supermercado', 11, 2);

-- --------------------------------------------------------

--
-- Table structure for table `movement_type`
--

DROP TABLE IF EXISTS `movement_type`;
CREATE TABLE IF NOT EXISTS `movement_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation_timestamp` datetime DEFAULT NULL,
  `modification_timestamp` datetime DEFAULT NULL,
  `version_number` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `movement_type`
--

TRUNCATE TABLE `movement_type`;
--
-- Dumping data for table `movement_type`
--

INSERT INTO `movement_type` (`id`, `creation_timestamp`, `modification_timestamp`, `version_number`, `type`) VALUES
(1, '2020-06-29 21:52:07', '2020-06-29 21:52:07', 1, 'débito'),
(2, '2020-06-29 21:52:07', '2020-06-29 21:52:07', 1, 'crédito');

-- --------------------------------------------------------

--
-- Table structure for table `natural_person`
--

DROP TABLE IF EXISTS `natural_person`;
CREATE TABLE IF NOT EXISTS `natural_person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation_timestamp` datetime DEFAULT NULL,
  `modification_timestamp` datetime DEFAULT NULL,
  `version_number` bigint(20) NOT NULL,
  `last_name` varchar(250) NOT NULL,
  `name` varchar(80) NOT NULL,
  `nit` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `natural_person`
--

TRUNCATE TABLE `natural_person`;
--
-- Dumping data for table `natural_person`
--

INSERT INTO `natural_person` (`id`, `creation_timestamp`, `modification_timestamp`, `version_number`, `last_name`, `name`, `nit`) VALUES
(14, '2020-07-02 18:04:18', NULL, 1, 'Baracaldo Roldan', 'Matias', 1037616283),
(13, '2020-07-02 18:03:27', NULL, 0, 'Baracaldo Marín', 'Juan Manuel', 1037616282);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
