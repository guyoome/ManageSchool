-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 08 juin 2019 à 17:54
-- Version du serveur :  5.7.21
-- Version de PHP :  7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projetjava`
--

-- --------------------------------------------------------

--
-- Structure de la table `anneescolaire`
--

DROP TABLE IF EXISTS `anneescolaire`;
CREATE TABLE IF NOT EXISTS `anneescolaire` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `bulletin`
--

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE IF NOT EXISTS `bulletin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `appreciation` varchar(255) NOT NULL,
  `id_trimestre` int(11) NOT NULL,
  `id_inscription` int(11) NOT NULL,
  `id_eleve` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_trimestre` (`id_trimestre`),
  KEY `id_inscription` (`id_inscription`)
) ENGINE=MyISAM AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `bulletin`
--

INSERT INTO `bulletin` (`id`, `appreciation`, `id_trimestre`, `id_inscription`, `id_eleve`) VALUES
(1, 'AB', 0, 0, 1),
(2, 'AB', 0, 0, 2),
(3, 'AB', 0, 0, 3),
(4, 'AB', 0, 0, 1),
(5, 'AB', 0, 1, 2),
(6, 'AB', 0, 0, 3),
(7, 'AB', 0, 0, 1),
(8, 'AB', 0, 0, 2),
(9, 'AB', 0, 0, 3),
(10, 'AB', 0, 0, 1),
(11, 'AB', 0, 0, 2),
(12, 'AB', 0, 0, 3),
(13, 'AB', 0, 0, 1),
(14, 'AB', 0, 0, 2),
(15, 'AB', 0, 0, 3),
(16, 'AB', 0, 0, 1),
(17, 'AB', 0, 0, 2),
(18, 'AB', 0, 0, 3),
(19, 'AB', 0, 0, 1),
(20, 'AB', 0, 0, 2),
(21, 'AB', 0, 0, 3),
(22, 'AB', 0, 0, 1),
(23, 'AB', 0, 0, 2),
(24, 'AB', 0, 0, 3),
(25, 'AB', 0, 0, 1),
(26, 'AB', 0, 0, NULL),
(27, 'AB', 0, 0, NULL),
(28, 'AB', 0, 0, NULL),
(29, 'AB', 0, 0, NULL),
(30, 'AB', 0, 0, NULL),
(31, 'AB', 0, 0, NULL),
(32, 'AB', 0, 0, NULL),
(33, 'AB', 0, 0, NULL),
(34, 'AB', 0, 0, NULL),
(35, 'AB', 0, 0, NULL),
(36, 'AB', 0, 0, NULL),
(37, 'AB', 0, 0, NULL),
(38, 'AB', 0, 0, NULL),
(39, 'AB', 0, 0, NULL),
(40, 'AB', 0, 0, NULL),
(41, 'AB', 0, 0, NULL),
(42, 'AB', 0, 0, NULL),
(43, 'AB', 0, 0, NULL),
(44, 'AB', 0, 0, NULL),
(45, 'AB', 0, 0, NULL),
(46, 'AB', 0, 0, NULL),
(47, 'AB', 0, 0, NULL),
(48, 'AB', 0, 0, NULL),
(49, 'AB', 0, 0, NULL),
(50, 'AB', 0, 0, NULL),
(51, 'AB', 0, 0, NULL),
(52, 'AB', 0, 0, NULL),
(53, 'AB', 0, 0, NULL),
(54, 'AB', 0, 0, NULL),
(55, 'AB', 0, 0, NULL),
(56, 'AB', 0, 0, NULL),
(57, 'AB', 0, 0, NULL),
(58, 'AB', 0, 0, NULL),
(59, 'AB', 0, 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `id_ecole` int(11) NOT NULL,
  `id_niveau` int(11) NOT NULL,
  `id_anneeScolaire` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_ecole` (`id_ecole`),
  KEY `id_niveau` (`id_niveau`),
  KEY `id_anneeScolaire` (`id_anneeScolaire`)
) ENGINE=MyISAM AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`id`, `nom`, `id_ecole`, `id_niveau`, `id_anneeScolaire`) VALUES
(63, 'TD4', 0, 0, 0),
(62, 'TD3', 0, 0, 0),
(61, 'TD2', 0, 0, 0),
(60, 'TD1', 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `detailbulletin`
--

DROP TABLE IF EXISTS `detailbulletin`;
CREATE TABLE IF NOT EXISTS `detailbulletin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `appreciation` varchar(255) NOT NULL,
  `id_bulletin` int(11) NOT NULL,
  `id_enseignement` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_bulletin` (`id_bulletin`),
  KEY `id_enseignement` (`id_enseignement`)
) ENGINE=MyISAM AUTO_INCREMENT=79 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `detailbulletin`
--

INSERT INTO `detailbulletin` (`id`, `appreciation`, `id_bulletin`, `id_enseignement`) VALUES
(1, 'Bon travail', 0, 0),
(2, 'Bon travail', 0, 0),
(3, 'Bon travail', 0, 0),
(4, 'Bon travail', 0, 0),
(5, 'Bon travail', 0, 0),
(6, 'Bon travail', 0, 0),
(7, 'Bon travail', 0, 0),
(8, 'Bon travail', 0, 0),
(9, 'Bon travail', 0, 0),
(10, 'Bon travail', 0, 0),
(11, 'Bon travail', 0, 0),
(12, 'Bon travail', 0, 0),
(13, 'Bon travail', 0, 0),
(14, 'Bon travail', 0, 0),
(15, 'Bon travail', 0, 0),
(16, 'Bon travail', 0, 0),
(17, 'Bon travail', 0, 0),
(18, 'Bon travail', 0, 0),
(19, 'Bon travail', 0, 0),
(20, 'Bon travail', 0, 0),
(21, 'Bon travail', 0, 0),
(22, 'Bon travail', 0, 0),
(23, 'Bon travail', 0, 0),
(24, 'Bon travail', 0, 0),
(25, 'Bon travail', 0, 0),
(26, 'Bon travail', 0, 0),
(27, 'Bon travail', 0, 0),
(28, 'Bon travail', 0, 0),
(29, 'Bon travail', 0, 0),
(30, 'Bon travail', 0, 0),
(31, 'Bon travail', 0, 0),
(32, 'Bon travail', 0, 0),
(33, 'Bon travail', 0, 0),
(34, 'Bon travail', 0, 0),
(35, 'Bon travail', 0, 0),
(36, 'Bon travail', 0, 0),
(37, 'Bon travail', 0, 0),
(38, 'Bon travail', 0, 0),
(39, 'Bon travail', 0, 0),
(40, 'Bon travail', 0, 0),
(41, 'Bon travail', 0, 0),
(42, 'Bon travail', 0, 0),
(43, 'Bon travail', 0, 0),
(44, 'Bon travail', 0, 0),
(45, 'Bon travail', 0, 0),
(46, 'Bon travail', 0, 0),
(47, 'Bon travail', 0, 0),
(48, 'Bon travail', 0, 0),
(49, 'Il faut encore poussser les efforts', 1, 3),
(50, 'Bon travail', 0, 0),
(51, 'Bon travail', 0, 0),
(52, 'Bon travail', 0, 0),
(53, 'Bon travail', 0, 0),
(54, 'Bon travail', 0, 0),
(55, 'Bon travail', 0, 0),
(56, 'Bon travail', 0, 0),
(57, 'Bon travail', 0, 0),
(58, 'Bon travail', 0, 0),
(59, 'Bon travail', 0, 0),
(60, 'Bon travail', 0, 0),
(61, 'Bon travail', 0, 0),
(62, 'Bon travail', 0, 0),
(63, 'Bon travail', 0, 0),
(64, 'Bon travail', 0, 0),
(65, 'Bon travail', 0, 0),
(66, 'Bon travail', 0, 0),
(67, 'Bon travail', 0, 0),
(68, 'Bon travail', 0, 0),
(69, 'Bon travail', 0, 0),
(70, 'Bon travail', 0, 0),
(71, 'Bon travail', 0, 0),
(72, 'Bon travail', 0, 0),
(73, 'Bon travail', 0, 0),
(74, 'Bon travail', 0, 0),
(75, 'Bon travail', 0, 0),
(76, 'Bon travail', 0, 0),
(77, 'Bon travail', 0, 0),
(78, 'Bon travail', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=79 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `discipline`
--

INSERT INTO `discipline` (`id`, `nom`) VALUES
(1, 'art'),
(2, 'art'),
(3, 'art'),
(4, 'art'),
(5, 'art'),
(6, 'art'),
(7, 'art'),
(8, 'art'),
(9, 'art'),
(10, 'art'),
(11, 'art'),
(12, 'art'),
(13, 'art'),
(14, 'art'),
(15, 'art'),
(16, 'art'),
(17, 'art'),
(18, 'art'),
(19, 'art'),
(20, 'art'),
(21, 'art'),
(22, 'art'),
(23, 'art'),
(24, 'art'),
(25, 'art'),
(26, 'art'),
(27, 'art'),
(28, 'art'),
(29, 'art'),
(30, 'art'),
(31, 'art'),
(32, 'art'),
(33, 'art'),
(34, 'art'),
(35, 'art'),
(36, 'art'),
(37, 'art'),
(38, 'art'),
(39, 'art'),
(40, 'art'),
(41, 'art'),
(42, 'art'),
(43, 'art'),
(44, 'art'),
(45, 'art'),
(46, 'art'),
(47, 'art'),
(48, 'art'),
(49, 'art'),
(50, 'art'),
(51, 'art'),
(52, 'art'),
(53, 'art'),
(54, 'art'),
(55, 'art'),
(56, 'art'),
(57, 'littérature'),
(58, 'art'),
(59, 'art'),
(60, 'art'),
(61, 'art'),
(62, 'art'),
(63, 'art'),
(64, 'art'),
(65, 'art'),
(66, 'art'),
(67, 'art'),
(68, 'art'),
(69, 'art'),
(70, 'art'),
(71, 'art'),
(72, 'art'),
(73, 'art'),
(74, 'art'),
(75, 'art'),
(76, 'art'),
(77, 'art'),
(78, 'art');

-- --------------------------------------------------------

--
-- Structure de la table `ecole`
--

DROP TABLE IF EXISTS `ecole`;
CREATE TABLE IF NOT EXISTS `ecole` (
  `id_ecole` int(11) NOT NULL AUTO_INCREMENT,
  `nom_ecole` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  PRIMARY KEY (`id_ecole`)
) ENGINE=MyISAM AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ecole`
--

INSERT INTO `ecole` (`id_ecole`, `nom_ecole`, `adresse`) VALUES
(1, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(2, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(3, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(4, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(5, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(6, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(7, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(8, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(9, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(10, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(11, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(12, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(13, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(14, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(15, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(16, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(17, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(18, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(19, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(20, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(21, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(22, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(23, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(24, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(25, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(26, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(27, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(28, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(29, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(30, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(31, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(32, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(33, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(34, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(35, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(36, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(37, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(38, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(39, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(40, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(41, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(42, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(43, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(44, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(45, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(46, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(47, 'Tuck Stell', 'Rueil Malmaison'),
(48, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(49, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(50, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(51, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(52, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(53, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(54, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(55, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(56, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(57, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(58, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison'),
(59, 'Lycee Richelieu', 'rue Gorges Sand, Rueil Malmaison');

-- --------------------------------------------------------

--
-- Structure de la table `enseignement`
--

DROP TABLE IF EXISTS `enseignement`;
CREATE TABLE IF NOT EXISTS `enseignement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_classe` int(11) NOT NULL,
  `id_discipline` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_classe` (`id_classe`),
  KEY `id_discipline` (`id_discipline`),
  KEY `id_personne` (`id_personne`)
) ENGINE=MyISAM AUTO_INCREMENT=79 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `enseignement`
--

INSERT INTO `enseignement` (`id`, `id_classe`, `id_discipline`, `id_personne`) VALUES
(1, 0, 0, 0),
(2, 1, 1, 1),
(3, 0, 0, 0),
(4, 0, 0, 0),
(5, 0, 0, 0),
(6, 0, 0, 0),
(7, 0, 0, 0),
(8, 0, 0, 0),
(9, 0, 0, 0),
(10, 0, 0, 0),
(11, 0, 0, 0),
(12, 0, 0, 0),
(13, 0, 0, 0),
(14, 0, 0, 0),
(15, 0, 0, 0),
(16, 0, 0, 0),
(17, 0, 0, 0),
(18, 0, 0, 0),
(19, 0, 0, 0),
(20, 0, 0, 0),
(21, 0, 0, 0),
(22, 0, 0, 0),
(23, 0, 0, 0),
(24, 0, 0, 0),
(25, 0, 0, 0),
(26, 0, 0, 0),
(27, 0, 0, 0),
(28, 0, 0, 0),
(29, 0, 0, 0),
(30, 0, 0, 0),
(31, 0, 0, 0),
(32, 0, 0, 0),
(33, 0, 0, 0),
(34, 0, 0, 0),
(35, 0, 0, 0),
(36, 0, 0, 0),
(37, 0, 0, 0),
(38, 0, 0, 0),
(39, 0, 0, 0),
(40, 0, 0, 0),
(41, 0, 0, 0),
(42, 0, 0, 0),
(43, 0, 0, 0),
(44, 0, 0, 0),
(45, 0, 0, 0),
(46, 0, 0, 0),
(47, 0, 0, 0),
(48, 0, 0, 0),
(49, 0, 0, 0),
(50, 0, 0, 0),
(51, 0, 0, 0),
(52, 0, 0, 0),
(53, 0, 0, 0),
(54, 0, 0, 0),
(55, 0, 0, 0),
(56, 0, 0, 0),
(57, 0, 0, 0),
(58, 0, 0, 0),
(59, 0, 0, 0),
(60, 0, 0, 0),
(61, 0, 0, 0),
(62, 0, 0, 0),
(63, 0, 0, 0),
(64, 0, 0, 0),
(65, 0, 0, 0),
(66, 0, 0, 0),
(67, 0, 0, 0),
(68, 0, 0, 0),
(69, 0, 0, 0),
(70, 0, 0, 0),
(71, 0, 0, 0),
(72, 0, 0, 0),
(73, 0, 0, 0),
(74, 0, 0, 0),
(75, 0, 0, 0),
(76, 0, 0, 0),
(77, 0, 0, 0),
(78, 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `appreciation` varchar(255) NOT NULL,
  `note` int(11) NOT NULL,
  `id_detail_bulletin` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_detail_bulletin` (`id_detail_bulletin`)
) ENGINE=MyISAM AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `evaluation`
--

INSERT INTO `evaluation` (`id`, `appreciation`, `note`, `id_detail_bulletin`) VALUES
(1, 'Attention aux fautes de calculs', 13, 0),
(2, 'Attention aux fautes de calculs', 13, 0),
(3, 'Attention aux fautes de calculs', 13, 0),
(4, 'Attention aux fautes de calculs', 13, 0),
(5, 'Attention aux fautes de calculs', 13, 0),
(6, 'TB', 5, 2),
(7, 'Attention aux fautes de calculs', 13, 0),
(8, 'Attention aux fautes de calculs', 13, 0),
(9, 'Attention aux fautes de calculs', 13, 0),
(10, 'Attention aux fautes de calculs', 13, 0),
(11, 'Attention aux fautes de calculs', 13, 0),
(12, 'Attention aux fautes de calculs', 13, 0),
(13, 'Attention aux fautes de calculs', 13, 0),
(14, 'Attention aux fautes de calculs', 13, 0),
(15, 'Attention aux fautes de calculs', 13, 0),
(16, 'Attention aux fautes de calculs', 13, 0),
(17, 'Attention aux fautes de calculs', 13, 0),
(18, 'Attention aux fautes de calculs', 13, 0),
(19, 'Attention aux fautes de calculs', 13, 0),
(20, 'Attention aux fautes de calculs', 13, 0),
(21, 'Attention aux fautes de calculs', 13, 0),
(22, 'Attention aux fautes de calculs', 13, 0),
(23, 'Attention aux fautes de calculs', 13, 0),
(24, 'Attention aux fautes de calculs', 13, 0),
(25, 'Attention aux fautes de calculs', 13, 0),
(26, 'Attention aux fautes de calculs', 13, 0),
(27, 'Attention aux fautes de calculs', 13, 0),
(28, 'Attention aux fautes de calculs', 13, 0),
(29, 'Attention aux fautes de calculs', 13, 0),
(30, 'Attention aux fautes de calculs', 13, 0),
(31, 'Attention aux fautes de calculs', 13, 0),
(32, 'Attention aux fautes de calculs', 13, 0),
(33, 'Attention aux fautes de calculs', 13, 0),
(34, 'Attention aux fautes de calculs', 13, 0),
(35, 'Attention aux fautes de calculs', 13, 0),
(36, 'Attention aux fautes de calculs', 13, 0),
(37, 'Attention aux fautes de calculs', 13, 0),
(38, 'Attention aux fautes de calculs', 13, 0),
(39, 'Attention aux fautes de calculs', 13, 0),
(40, 'Attention aux fautes de calculs', 13, 0),
(41, 'Attention aux fautes de calculs', 13, 0),
(42, 'Attention aux fautes de calculs', 13, 0),
(43, 'Attention aux fautes de calculs', 13, 0),
(44, 'Attention aux fautes de calculs', 13, 0),
(45, 'Attention aux fautes de calculs', 13, 0),
(46, 'Attention aux fautes de calculs', 13, 0),
(47, 'Attention aux fautes de calculs', 13, 0),
(48, 'Attention aux fautes de calculs', 13, 0),
(49, 'Attention aux fautes de calculs', 13, 0),
(50, 'Attention aux fautes de calculs', 13, 0),
(51, 'Attention aux fautes de calculs', 13, 0),
(52, 'Attention aux fautes de calculs', 13, 0),
(53, 'Attention aux fautes de calculs', 13, 0),
(54, 'Attention aux fautes de calculs', 13, 0),
(55, 'Attention aux fautes de calculs', 13, 0),
(56, 'Attention aux fautes de calculs', 13, 0),
(57, 'Attention aux fautes de calculs', 13, 0),
(58, 'Attention aux fautes de calculs', 13, 0),
(59, 'Attention aux fautes de calculs', 13, 0);

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_classe` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_classe` (`id_classe`),
  KEY `id_personne` (`id_personne`)
) ENGINE=MyISAM AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`id`, `id_classe`, `id_personne`) VALUES
(1, 1, 3),
(2, 1, 3),
(3, 1, 3),
(4, 1, 3),
(5, 2, 2),
(6, 1, 3),
(7, 1, 3),
(8, 1, 3),
(9, 1, 3),
(10, 1, 3),
(11, 1, 3),
(12, 1, 3),
(13, 1, 3),
(14, 1, 3),
(15, 1, 3),
(16, 1, 3),
(17, 1, 3),
(18, 1, 3),
(19, 1, 3),
(20, 1, 3),
(21, 1, 3),
(22, 1, 3),
(23, 1, 3),
(24, 1, 3),
(25, 1, 3),
(26, 1, 3),
(27, 1, 3),
(28, 1, 3),
(29, 1, 3),
(30, 1, 3),
(31, 1, 3),
(32, 1, 3),
(33, 1, 3),
(34, 1, 3),
(35, 1, 3),
(36, 1, 3),
(37, 1, 3),
(38, 1, 3),
(39, 1, 3),
(40, 1, 3),
(41, 1, 3),
(42, 1, 3),
(43, 1, 3),
(44, 1, 3),
(45, 1, 3),
(46, 1, 3),
(47, 1, 3),
(48, 1, 3),
(49, 1, 3),
(50, 1, 3),
(51, 1, 3),
(52, 1, 3),
(53, 1, 3),
(54, 1, 3),
(55, 1, 3),
(56, 1, 3),
(57, 1, 3),
(58, 1, 3),
(59, 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `niveau`
--

INSERT INTO `niveau` (`id`, `nom`) VALUES
(1, 'CE1'),
(2, 'CE1'),
(3, 'CE1'),
(4, 'CE2'),
(5, 'CE1'),
(6, 'CE1'),
(7, 'CE1'),
(8, 'CE1'),
(9, 'CE1'),
(10, 'CE1'),
(11, 'CE1'),
(12, 'CE1'),
(13, 'CE1'),
(14, 'CE1'),
(15, 'CE1'),
(16, 'CE1'),
(17, 'CE1'),
(18, 'CE1'),
(19, 'CE1'),
(20, 'CE1'),
(21, 'CE1'),
(22, 'CE1'),
(23, 'CE1'),
(24, 'CE1'),
(25, 'CE1'),
(26, 'CE1'),
(27, 'CE1'),
(28, 'CE1'),
(29, 'CE1'),
(30, 'CE1'),
(31, 'CE1'),
(32, 'CE1'),
(33, 'CE1'),
(34, 'CE1'),
(35, 'CE1'),
(36, 'CE1'),
(37, 'CE1'),
(38, 'CE1'),
(39, 'CE1'),
(40, 'CE1'),
(41, 'CE1'),
(42, 'CE1'),
(43, 'CE1'),
(44, 'CE1'),
(45, 'CE1'),
(46, 'CE1'),
(47, 'CE1'),
(48, 'CE1'),
(49, 'CE1'),
(50, 'CE1'),
(51, 'CE1'),
(52, 'CE1'),
(53, 'CE1'),
(54, 'CE1'),
(55, 'CE1'),
(56, 'CE1'),
(57, 'CE1'),
(58, 'CE1'),
(59, 'CE1');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `type_` varchar(255) NOT NULL,
  `userP` varchar(255) DEFAULT NULL,
  `mdp` varchar(255) DEFAULT NULL,
  `id_classe` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`, `type_`, `userP`, `mdp`, `id_classe`) VALUES
(1, 'maurin', 'guillaume', 'stud', NULL, NULL, 60),
(2, 'Clara', 'Sabatey', 'stud', 'Clacla', 'love', 60),
(3, 'carlier', 'helene', 'stud', NULL, NULL, 60),
(4, 'segado', 'jp', 'prof', NULL, NULL, NULL),
(5, 'dupont', 'alain', 'prof', NULL, NULL, NULL),
(6, 'diedler', 'florent', 'prof', NULL, NULL, NULL),
(57, 'Helene', 'Carlier-Gubler', 'prof', 'LogNep', 'coucou', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `trimestre`
--

DROP TABLE IF EXISTS `trimestre`;
CREATE TABLE IF NOT EXISTS `trimestre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  `debut` varchar(255) NOT NULL,
  `fin` varchar(255) NOT NULL,
  `id_anneeScolaire` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_anneeScolaire` (`id_anneeScolaire`)
) ENGINE=MyISAM AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `trimestre`
--

INSERT INTO `trimestre` (`id`, `numero`, `debut`, `fin`, `id_anneeScolaire`) VALUES
(1, 3, '01/09/2018', '31/06/2019', 0),
(2, 1, '02/09/2017', '15/06/2018', 2),
(3, 3, '01/09/2018', '31/06/2019', 0),
(4, 3, '01/09/2018', '31/06/2019', 0),
(5, 3, '01/09/2018', '31/06/2019', 0),
(6, 3, '01/09/2018', '31/06/2019', 0),
(7, 3, '01/09/2018', '31/06/2019', 0),
(8, 3, '01/09/2018', '31/06/2019', 0),
(9, 3, '01/09/2018', '31/06/2019', 0),
(10, 3, '01/09/2018', '31/06/2019', 0),
(11, 3, '01/09/2018', '31/06/2019', 0),
(12, 3, '01/09/2018', '31/06/2019', 0),
(13, 3, '01/09/2018', '31/06/2019', 0),
(14, 3, '01/09/2018', '31/06/2019', 0),
(15, 3, '01/09/2018', '31/06/2019', 0),
(16, 3, '01/09/2018', '31/06/2019', 0),
(17, 3, '01/09/2018', '31/06/2019', 0),
(18, 3, '01/09/2018', '31/06/2019', 0),
(19, 3, '01/09/2018', '31/06/2019', 0),
(20, 3, '01/09/2018', '31/06/2019', 0),
(21, 3, '01/09/2018', '31/06/2019', 0),
(22, 3, '01/09/2018', '31/06/2019', 0),
(23, 3, '01/09/2018', '31/06/2019', 0),
(24, 3, '01/09/2018', '31/06/2019', 0),
(25, 3, '01/09/2018', '31/06/2019', 0),
(26, 3, '01/09/2018', '31/06/2019', 0),
(27, 3, '01/09/2018', '31/06/2019', 0),
(28, 3, '01/09/2018', '31/06/2019', 0),
(29, 3, '01/09/2018', '31/06/2019', 0),
(30, 3, '01/09/2018', '31/06/2019', 0),
(31, 3, '01/09/2018', '31/06/2019', 0),
(32, 3, '01/09/2018', '31/06/2019', 0),
(33, 3, '01/09/2018', '31/06/2019', 0),
(34, 3, '01/09/2018', '31/06/2019', 0),
(35, 3, '01/09/2018', '31/06/2019', 0),
(36, 3, '01/09/2018', '31/06/2019', 0),
(37, 3, '01/09/2018', '31/06/2019', 0),
(38, 3, '01/09/2018', '31/06/2019', 0),
(39, 3, '01/09/2018', '31/06/2019', 0),
(40, 3, '01/09/2018', '31/06/2019', 0),
(41, 3, '01/09/2018', '31/06/2019', 0),
(42, 3, '01/09/2018', '31/06/2019', 0),
(43, 3, '01/09/2018', '31/06/2019', 0),
(44, 3, '01/09/2018', '31/06/2019', 0),
(45, 3, '01/09/2018', '31/06/2019', 0),
(46, 3, '01/09/2018', '31/06/2019', 0),
(47, 3, '01/09/2018', '31/06/2019', 0),
(48, 3, '01/09/2018', '31/06/2019', 0),
(49, 3, '01/09/2018', '31/06/2019', 0),
(50, 3, '01/09/2018', '31/06/2019', 0),
(51, 3, '01/09/2018', '31/06/2019', 0),
(52, 3, '01/09/2018', '31/06/2019', 0),
(53, 3, '01/09/2018', '31/06/2019', 0),
(54, 3, '01/09/2018', '31/06/2019', 0),
(55, 3, '01/09/2018', '31/06/2019', 0),
(56, 3, '01/09/2018', '31/06/2019', 0),
(57, 3, '01/09/2018', '31/06/2019', 0),
(58, 3, '01/09/2018', '31/06/2019', 0),
(59, 3, '01/09/2018', '31/06/2019', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
