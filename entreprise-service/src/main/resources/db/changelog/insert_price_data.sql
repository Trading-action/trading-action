-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 08 jan. 2022 à 14:05
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
-- Structure de la table `price_entity`
--

DROP TABLE IF EXISTS `price_entity`;
CREATE TABLE IF NOT EXISTS `price_entity` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `prix` decimal(19,2) DEFAULT NULL,
  `entreprise` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bb06g2yu7a7fv53g60f45qg5x` (`reference`),
  KEY `FKeqjp1y7u0aw5x76om5r7iq441` (`entreprise`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `price_entity`
--

INSERT INTO `price_entity` (`id`, `created_at`, `reference`, `updated_at`, `prix`, `entreprise`) VALUES
(3, '2021-12-05 23:04:47', 'Ap__Mon Dec 06 00:04:46 WEST 2021', '2021-12-05 23:04:47', '10.00', 2),
(10, '2021-12-06 09:48:05', 'Ap__Mon Dec 06 10:48:04 WEST 2021', '2021-12-06 09:48:05', '50.00', 2),
(12, '2021-12-06 09:53:02', 'Ap__Mon Dec 06 10:53:02 WEST 2021', '2021-12-06 09:53:02', '88.00', 2),
(36, '2021-12-13 15:21:32', 'Da__Mon Dec 13 16:21:32 WEST 2021', '2021-12-13 15:21:32', '111.00', 29),
(37, '2021-12-13 16:11:33', 'Ap__Mon Dec 13 17:11:32 WEST 2021', '2021-12-13 16:11:33', '500.00', 2),
(38, '2021-12-13 21:01:39', 'Da__Mon Dec 13 22:01:39 WEST 2021', '2021-12-13 21:01:39', '200.00', 29);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
