-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 08 jan. 2022 à 12:52
-- Version du serveur :  5.7.31
-- Version de PHP : 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `entreprise_service`
--

-- --------------------------------------------------------

--
-- Structure de la table `entreprise_entity`
--

DROP TABLE IF EXISTS `entreprise_entity`;
CREATE TABLE IF NOT EXISTS `entreprise_entity` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `dividende` decimal(19,2) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `nombre_action` decimal(19,2) DEFAULT NULL,
  `prix_actuel` bigint(20) DEFAULT NULL,
  `secteur` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ltrpc2ucygjqgviqmmna04vbj` (`reference`),
  KEY `FK6gsmh4juxjyw202l7bvoajq33` (`prix_actuel`),
  KEY `FK3geqstpta8umh4mljq00c5u5o` (`secteur`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `entreprise_entity`
--

INSERT INTO `entreprise_entity` (`id`, `created_at`, `reference`, `updated_at`, `adress`, `dividende`, `libelle`, `nombre_action`, `prix_actuel`, `secteur`) VALUES
(2, '2021-12-05 19:45:59', 'Apple1', '2021-12-13 16:11:33', 'rabat, agdal rue 5', '1000.00', 'Apple', '10.00', 37, 41),
(29, '2021-12-13 15:08:28', 'DanoneRabat,', '2021-12-13 21:01:40', 'Rabat, Agdal 21', '7000.00', 'Danone', '500158848.00', 38, 52),
(42, '2021-12-13 23:18:25', 'lenevoMarrakech,', '2021-12-13 23:18:25', 'Marrakech, rue allal fassi 1235', '1000.00', 'lenevo', '79841356.00', NULL, 41),
(44, '2021-12-19 12:48:57', 'JaoudaRabat,', '2021-12-19 12:48:57', 'Rabat, agdal', '7000.00', 'Jaouda', '125486898.00', NULL, 52),
(45, NULL, 'Somadairadress', NULL, 'adress', '23.30', 'Somadair', '2113.00', NULL, 48),
(58, '2022-01-08 12:48:55', 'AFMADefault', '2022-01-08 12:48:55', 'Default Adress', '10000.00', 'AFMA', '100000.00', NULL, 45),
(59, '2022-01-08 12:49:05', 'AGMADefault', '2022-01-08 12:49:05', 'Default Adress', '10000.00', 'AGMA', '100000.00', NULL, 45),
(60, '2022-01-08 12:49:21', 'WAFA ASSURANCEDefault', '2022-01-08 12:49:21', 'Default Adress', '10000.00', 'WAFA ASSURANCE', '100000.00', NULL, 45),
(61, '2022-01-08 12:49:42', 'CIHDefault', '2022-01-08 12:49:42', 'Default Adress', '10000.00', 'CIH', '100000.00', NULL, 46),
(62, '2022-01-08 12:49:53', 'BMCIDefault', '2022-01-08 12:49:53', 'Default Adress', '10000.00', 'BMCI', '100000.00', NULL, 46),
(63, '2022-01-08 12:50:07', 'BANK OF AFRICADefault', '2022-01-08 12:50:07', 'Default Adress', '10000.00', 'BANK OF AFRICA', '100000.00', NULL, 46),
(64, '2022-01-08 12:50:40', 'OULMESDefault', '2022-01-08 12:50:40', 'Default Adress', '10000.00', 'OULMES', '100000.00', NULL, 52),
(65, '2022-01-08 12:51:01', 'SNEPDefault', '2022-01-08 12:51:01', 'Default Adress', '10000.00', 'SNEP', '100000.00', NULL, 47),
(66, '2022-01-08 12:51:29', 'TAQA MOROCCODefault', '2022-01-08 12:51:29', 'Default Adress', '10000.00', 'TAQA MOROCCO', '100000.00', NULL, 49),
(67, '2022-01-08 12:52:09', 'SODEP-Marsa MarocDefault', '2022-01-08 12:52:09', 'Default Adress', '10000.00', 'SODEP-Marsa Maroc', '100000.00', NULL, 57);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
