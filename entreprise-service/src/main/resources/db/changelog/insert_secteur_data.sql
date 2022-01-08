-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 08 jan. 2022 à 13:05
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
-- Structure de la table `secteur_entity`
--

DROP TABLE IF EXISTS `secteur_entity`;
CREATE TABLE IF NOT EXISTS `secteur_entity` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `secteur_entity`
--

INSERT INTO `secteur_entity` (`id`, `libelle`) VALUES
(41, 'informatique'),
(45, 'assurances'),
(46, 'banques'),
(47, 'chimie'),
(48, 'immobilier'),
(49, 'electricité'),
(50, 'loisirs et hotels'),
(51, 'mines'),
(52, 'boissons'),
(53, 'distributeurs'),
(55, 'emballage'),
(56, 'electronique'),
(57, 'transport');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
