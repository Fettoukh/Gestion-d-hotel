-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Dim 03 Février 2019 à 20:57
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";
SET @@global.event_scheduler = 1;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bd_hotel_hancock`
--

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `MajClients` ()  NO SQL
BEGIN 
Declare v_finish INTEGER DEFAULT 0 ;
declare v_cin varchar(20) default"";
Declare v_res INTEGER ;
DECLARE C2_cin CURSOR FOR SELECT distinct reserver.CIN from `reserver` where DATE(NOW())>=DATE(reserver.DATEFIN) and reserver.CIN not IN ( select reserver.CIN from reserver where DATE(NOW())<=reserver.DATEDEBUT or DATE(NOW())<reserver.DATEFIN );
 
DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finish = 1;
open C2_cin; 
while(v_finish<>1) DO 
fetch C2_cin into v_cin ; 
 update compteclients set ACTIF=0 where CIN=v_cin;
 end WHILE; 
CLOSE C2_cin;
 END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `MajPersonnel` ()  NO SQL
BEGIN

Declare  v_finish INTEGER DEFAULT 0 ; 
declare v_cin  varchar(20) default "" ;

DECLARE C1_cin  CURSOR FOR
SELECT `CIN_E`  from `contratpersonnel` where 
DATE(NOW())>=DATE(`DATEFINC`);
DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finish = 1;

open C1_cin;
while(v_finish<>1) DO
fetch C1_cin into v_cin ;
insert into contratpersonnelhistorique  select * from contratpersonnel WHERE contratpersonnel.CIN_E=v_cin; 
delete from contratpersonnel where contratpersonnel.CIN_E=v_cin;
update  comptepersonnel set ACTIF=0 
where  CIN_E=v_cin;
end WHILE;
CLOSE C1_cin;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `allemploye`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `allemploye` (
`cin` varchar(20)
,`Role` varchar(30)
,`Nom` varchar(40)
,`Prenom` varchar(40)
,`Telephone` varchar(12)
,`date debut` date
,`date fin` date
);

-- --------------------------------------------------------

--
-- Structure de la table `chambres`
--

CREATE TABLE `chambres` (
  `NUMEROCH` int(11) NOT NULL,
  `IDCLASSE` int(11) NOT NULL,
  `NBPLACES` int(11) DEFAULT NULL,
  `PRIX` float DEFAULT NULL,
  `ETAGE` int(11) DEFAULT NULL,
  `DISPONIBILITE` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `chambres`
--

INSERT INTO `chambres` (`NUMEROCH`, `IDCLASSE`, `NBPLACES`, `PRIX`, `ETAGE`, `DISPONIBILITE`) VALUES
(1, 1, 1, 250, 1, 1),
(2, 1, 1, 250, 1, 1),
(3, 1, 2, 350, 1, 1),
(4, 2, 1, 150, 1, 1),
(5, 2, 1, 150, 1, 1),
(6, 2, 2, 230, 1, 1),
(7, 1, 1, 250, 2, 1),
(8, 1, 1, 250, 2, 1),
(9, 1, 2, 350, 2, 1),
(10, 2, 1, 150, 2, 1),
(11, 2, 1, 150, 2, 1),
(12, 2, 1, 150, 2, 1),
(13, 2, 2, 230, 2, 1),
(14, 2, 2, 230, 2, 1),
(15, 1, 1, 250, 3, 1),
(16, 1, 1, 250, 3, 1),
(17, 1, 2, 350, 3, 1),
(18, 2, 1, 150, 3, 1),
(19, 2, 1, 150, 3, 1),
(20, 2, 1, 150, 3, 1),
(21, 2, 2, 230, 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `classes`
--

CREATE TABLE `classes` (
  `IDCLASSE` int(11) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `classes`
--

INSERT INTO `classes` (`IDCLASSE`, `DESCRIPTION`) VALUES
(1, 'Classe1'),
(2, 'Classe2\n');

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE `clients` (
  `CIN` varchar(20) NOT NULL,
  `NOM` varchar(40) DEFAULT NULL,
  `PRENOM` varchar(40) DEFAULT NULL,
  `TEL` varchar(12) DEFAULT NULL,
  `EMAIL` varchar(252) DEFAULT NULL,
  `ADRESSE` varchar(250) DEFAULT NULL,
  `DATENAISSANCE` date DEFAULT NULL,
  `CODEPOSTALE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `clients`
--

INSERT INTO `clients` (`CIN`, `NOM`, `PRENOM`, `TEL`, `EMAIL`, `ADRESSE`, `DATENAISSANCE`, `CODEPOSTALE`) VALUES
('AD111111', 'El Hilali', 'Chaimae', '0651427895', 'chaimaeE@gmail.com', 'Rabat , Agdal', '1996-01-02', 12000),
('AD121111', 'Jihane', 'El Merchani', '06547895', 'JihaneE@gmail.com', 'Rabat , Agdal', '1997-03-13', 10001),
('AD131111', 'Razak', 'Issam', '06414587', 'IssamR@gmail.com', 'Kenitra , ....', '1994-04-15', 10000),
('AD141111', 'Wahab', 'Rachid', '0661547892', 'RachidW@gmail.com', 'Tanger , Boukhalef', '1980-01-18', 12000),
('AD151111', 'Stira', 'Kenza', '0661547896', 'KenzaS@gmail.com', 'Rabat , agdal', '1997-02-13', 10000),
('AD161111', 'Narjiss', 'Ayoub', '06614785', 'AyoubN@gmail.com', 'Tanger , Boukhalef', '1994-01-12', 10000),
('AD191111', 'ahmed', 'Youssef', '0678111456', 'AHMED-YOUSSEF@gmail.com', '14,rue maarif 44', '1998-02-05', 15000),
('AD785412', 'Mehdi', 'boharra', '0647851245', 'Mehdi@gmail.com', 'Tanger', '2019-02-13', 120000);

-- --------------------------------------------------------

--
-- Structure de la table `compteclients`
--

CREATE TABLE `compteclients` (
  `LOGINCL` varchar(40) NOT NULL,
  `CIN` varchar(20) NOT NULL,
  `PASSWORD` varchar(12) NOT NULL,
  `ACTIF` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compteclients`
--

INSERT INTO `compteclients` (`LOGINCL`, `CIN`, `PASSWORD`, `ACTIF`) VALUES
('admin2', 'AD111111', 'admin', 1),
('JihaneAD121111', 'AD121111', '383750', 1),
('MehdiAD785412', 'AD785412', '833018', 1),
('NarjissAD161111', 'AD161111', '912077', 1),
('RazakAD131111', 'AD131111', '218295', 1),
('StiraAD151111', 'AD151111', '126840', 1),
('test', 'AD191111', 'admin', 0),
('WahabAD141111', 'AD141111', '721390', 0);

-- --------------------------------------------------------

--
-- Structure de la table `comptepersonnel`
--

CREATE TABLE `comptepersonnel` (
  `LOGIN` varchar(120) NOT NULL,
  `CIN_E` varchar(20) NOT NULL,
  `PASSWORD` varchar(12) NOT NULL,
  `ACTIF` int(1) NOT NULL DEFAULT '0',
  `ROLE` varchar(120) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `comptepersonnel`
--

INSERT INTO `comptepersonnel` (`LOGIN`, `CIN_E`, `PASSWORD`, `ACTIF`, `ROLE`) VALUES
('admin', 'B456445', 'admin', 1, 'directeur'),
('admin1', 'AD253859', 'admin', 1, 'receptionniste'),
('adminGerant', 'AD247595', 'admin', 1, 'Gerant');

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `contrat`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `contrat` (
`IDC` int(11)
,`CIN_E` varchar(20)
,`CIN_D` varchar(20)
,`DATEDEBUC` date
,`DATEFINC` date
,`TYPECONTRAT` varchar(20)
,`ROLEPERSONNEL` varchar(30)
,`SALAIRE` float
,`DESCRIPTION` text
,`dateC` timestamp
);

-- --------------------------------------------------------

--
-- Structure de la table `contratpersonnel`
--

CREATE TABLE `contratpersonnel` (
  `IDC` int(11) NOT NULL,
  `CIN_E` varchar(20) NOT NULL,
  `CIN_D` varchar(20) NOT NULL,
  `DATEDEBUC` date DEFAULT NULL,
  `DATEFINC` date DEFAULT NULL,
  `TYPECONTRAT` varchar(20) DEFAULT NULL,
  `ROLEPERSONNEL` varchar(30) DEFAULT NULL,
  `SALAIRE` float DEFAULT NULL,
  `DESCRIPTION` varchar(1024) DEFAULT NULL,
  `dateC` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `contratpersonnel`
--

INSERT INTO `contratpersonnel` (`IDC`, `CIN_E`, `CIN_D`, `DATEDEBUC`, `DATEFINC`, `TYPECONTRAT`, `ROLEPERSONNEL`, `SALAIRE`, `DESCRIPTION`, `dateC`) VALUES
(1, 'AD253859', 'B456445', '2019-02-01', '2030-02-01', 'CDD', 'Receptionniste', 9000, 'Description Receptionniste', '2019-01-31 10:02:49'),
(82, 'AD247595', 'B456445', '2019-02-02', '2019-02-08', 'CDD', 'Gerant', 1500, NULL, '2019-02-03 20:13:53');

-- --------------------------------------------------------

--
-- Structure de la table `contratpersonnelhistorique`
--

CREATE TABLE `contratpersonnelhistorique` (
  `IDC` int(11) NOT NULL,
  `CIN_E` varchar(20) NOT NULL,
  `CIN_D` varchar(20) NOT NULL,
  `DATEDEBUC` date DEFAULT NULL,
  `DATEFINC` date DEFAULT NULL,
  `TYPECONTRAT` varchar(20) DEFAULT NULL,
  `ROLEPERSONNEL` varchar(30) DEFAULT NULL,
  `SALAIRE` float DEFAULT NULL,
  `DESCIPTION` varchar(1024) DEFAULT NULL,
  `dateC` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `contratpersonnelhistorique`
--

INSERT INTO `contratpersonnelhistorique` (`IDC`, `CIN_E`, `CIN_D`, `DATEDEBUC`, `DATEFINC`, `TYPECONTRAT`, `ROLEPERSONNEL`, `SALAIRE`, `DESCIPTION`, `dateC`) VALUES
(80, 'AD247595', 'B456445', '2020-01-01', '2022-01-13', 'CDD', 'Gerant', 9000, 'Gerant', '2019-01-31 11:26:59');

-- --------------------------------------------------------

--
-- Structure de la table `demander`
--

CREATE TABLE `demander` (
  `CIN` varchar(20) NOT NULL,
  `IDS` int(11) NOT NULL,
  `DATE` date NOT NULL,
  `ID_D` int(11) NOT NULL,
  `payée` int(1) NOT NULL DEFAULT '0',
  `effectuée` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `demander`
--

INSERT INTO `demander` (`CIN`, `IDS`, `DATE`, `ID_D`, `payée`, `effectuée`) VALUES
('AD111111', 2, '2019-01-31', 1, 0, 0),
('AD111111', 2, '2019-01-31', 2, 0, 0),
('AD111111', 11, '2019-01-31', 3, 0, 0),
('AD111111', 11, '2019-01-31', 4, 0, 0),
('AD111111', 11, '2019-01-31', 5, 1, 1),
('AD111111', 11, '2019-01-31', 6, 0, 0),
('AD111111', 12, '2019-01-31', 7, 0, 0),
('AD111111', 9, '2019-01-15', 8, 1, 1),
('AD121111', 9, '2019-01-08', 9, 1, 1),
('AD141111', 13, '2018-09-03', 10, 1, 1),
('AD131111', 13, '2019-01-22', 11, 1, 1),
('AD131111', 9, '2017-08-28', 12, 1, 1),
('AD161111', 14, '2016-08-28', 13, 1, 1),
('AD121111', 9, '2016-01-08', 14, 1, 1),
('AD141111', 13, '2016-09-03', 15, 1, 1),
('AD131111', 13, '2016-01-22', 16, 1, 1),
('AD131111', 9, '2017-08-28', 17, 1, 1),
('AD161111', 14, '2016-08-28', 18, 1, 1),
('AD161111', 9, '2016-01-08', 19, 1, 1),
('AD141111', 13, '2018-09-03', 20, 1, 1),
('AD131111', 13, '2019-01-22', 21, 1, 1),
('AD131111', 9, '2017-08-28', 22, 1, 1),
('AD161111', 14, '2016-08-28', 23, 1, 1),
('AD141111', 9, '2019-01-08', 24, 1, 1),
('AD141111', 13, '2017-09-03', 25, 1, 1),
('AD131111', 13, '2017-01-22', 26, 1, 1),
('AD131111', 9, '2018-08-28', 27, 1, 1),
('AD161111', 14, '2016-08-28', 28, 1, 1),
('AD111111', 1, '2019-02-01', 29, 0, 0),
('AD111111', 2, '2019-02-01', 30, 0, 0),
('AD111111', 9, '2019-02-01', 31, 0, 0),
('AD111111', 9, '2019-02-01', 32, 0, 1),
('AD111111', 9, '2019-02-01', 33, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `directeur`
--

CREATE TABLE `directeur` (
  `CIN_D` varchar(20) NOT NULL,
  `NOM` varchar(40) DEFAULT NULL,
  `PRENOM` varchar(40) DEFAULT NULL,
  `DATE_NAISSANCE` date DEFAULT NULL,
  `EMAIL` varchar(252) DEFAULT NULL,
  `TELEPHONE` varchar(12) DEFAULT NULL,
  `SEXE` varchar(10) DEFAULT NULL,
  `ADRESSE` varchar(250) DEFAULT NULL,
  `CODEPOSTAL` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `directeur`
--

INSERT INTO `directeur` (`CIN_D`, `NOM`, `PRENOM`, `DATE_NAISSANCE`, `EMAIL`, `TELEPHONE`, `SEXE`, `ADRESSE`, `CODEPOSTAL`) VALUES
('B456445', 'Srir', 'omar', '1997-10-14', 'omar.srir@gmail.com', '2565656', 'H', '49,lotis,taibya,kenitra', 140000);

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `employe` (
  `CIN_E` varchar(20) NOT NULL,
  `NOM` varchar(40) DEFAULT NULL,
  `PRENOM` varchar(40) DEFAULT NULL,
  `DATE_NAISSANCE` date DEFAULT NULL,
  `EMAIL` varchar(252) DEFAULT NULL,
  `TELEPHONE` varchar(12) DEFAULT NULL,
  `SEXE` varchar(10) DEFAULT NULL,
  `ADRESSE` varchar(250) DEFAULT NULL,
  `CODEPOSTAL` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `employe`
--

INSERT INTO `employe` (`CIN_E`, `NOM`, `PRENOM`, `DATE_NAISSANCE`, `EMAIL`, `TELEPHONE`, `SEXE`, `ADRESSE`, `CODEPOSTAL`) VALUES
('AD247595', 'Hamid', 'Achraf', '1995-04-14', 'AchrafH@gmail.com', '0661547852', 'Homme', 'Tanger , Boukhalef', 10000),
('AD253859', 'Fettoukh', 'Mohamed Amine', '1997-04-03', 'Amine@gmail.com', '0661105748', 'M', 'Tanger , Boukhalef', 12000);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `employeactuel`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `employeactuel` (
`cin` varchar(20)
,`Role` varchar(30)
,`Nom` varchar(40)
,`Prenom` varchar(40)
,`Telephone` varchar(12)
,`date debut` date
,`date fin` date
);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `employeprecedent`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `employeprecedent` (
`cin` varchar(20)
,`Role` varchar(30)
,`Nom` varchar(40)
,`Prenom` varchar(40)
,`Telephone` varchar(12)
,`date debut` date
,`date fin` date
);

-- --------------------------------------------------------

--
-- Structure de la table `gerant`
--

CREATE TABLE `gerant` (
  `CIN_GR` varchar(20) NOT NULL,
  `NOM` varchar(40) DEFAULT NULL,
  `PRENOM` varchar(40) DEFAULT NULL,
  `DATE_NAISSANCE` date DEFAULT NULL,
  `EMAIL` varchar(252) DEFAULT NULL,
  `TELEPHONE` varchar(12) DEFAULT NULL,
  `SEXE` varchar(10) DEFAULT NULL,
  `ADRESSE` varchar(250) DEFAULT NULL,
  `CODEPOSTAL` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `gerant`
--

INSERT INTO `gerant` (`CIN_GR`, `NOM`, `PRENOM`, `DATE_NAISSANCE`, `EMAIL`, `TELEPHONE`, `SEXE`, `ADRESSE`, `CODEPOSTAL`) VALUES
('AD247595', 'Hamid', 'Achraf', '1995-04-14', 'AchrafH@gmail.com', '0661547852', 'Homme', 'Tanger , Boukhalef', 10000);

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

CREATE TABLE `personnel` (
  `CIN_E` varchar(20) NOT NULL,
  `NOM` varchar(40) DEFAULT NULL,
  `PRENOM` varchar(40) DEFAULT NULL,
  `DATE_NAISSANCE` date DEFAULT NULL,
  `EMAIL` varchar(252) DEFAULT NULL,
  `TELEPHONE` varchar(12) DEFAULT NULL,
  `SEXE` varchar(10) DEFAULT NULL,
  `ADRESSE` varchar(250) DEFAULT NULL,
  `CODEPOSTAL` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `personnel`
--

INSERT INTO `personnel` (`CIN_E`, `NOM`, `PRENOM`, `DATE_NAISSANCE`, `EMAIL`, `TELEPHONE`, `SEXE`, `ADRESSE`, `CODEPOSTAL`) VALUES
('AD247595', 'Hamid', 'Achraf', '1995-04-14', 'AchrafH@gmail.com', '0661547852', 'Homme', 'Tanger , Boukhalef', 10000),
('AD253859', 'Fettoukh', 'Mohamed Amine', '1997-04-03', 'Amine@gmail.com', '0661105748', 'M', 'Tanger , Boukhalef', 12000),
('B456445', 'Srir', 'Omar', '1997-10-14', 'omar.srir@gmail.com', '2565656', 'H', '49,lotis,taibya,kenitra', 140000);

-- --------------------------------------------------------

--
-- Structure de la table `plaintes`
--

CREATE TABLE `plaintes` (
  `IDP` int(11) NOT NULL,
  `CIN` varchar(20) NOT NULL,
  `CIN_GR` varchar(150) DEFAULT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `DATEP` date DEFAULT NULL,
  `REMARQUE` varchar(120) NOT NULL DEFAULT 'Aucune remarque'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `plaintes`
--

INSERT INTO `plaintes` (`IDP`, `CIN`, `CIN_GR`, `DESCRIPTION`, `DATEP`, `REMARQUE`) VALUES
(23, 'AD111111', 'AD247595', 'Problem 1', '2019-01-31', 'Solved 1'),
(24, 'AD121111', 'AD247595', 'Coupure d\'electricité', '2018-10-30', 'Aucune remarque'),
(25, 'AD131111', 'AD247595', 'Coupure d\'electricité', '2015-10-30', 'Aucune remarque'),
(26, 'AD141111', 'AD247595', 'Problem 2', '2016-10-30', 'Solved 2 '),
(27, 'AD151111', 'AD247595', 'Problem 3', '2017-10-30', 'Solved 3');

-- --------------------------------------------------------

--
-- Structure de la table `receptionistes`
--

CREATE TABLE `receptionistes` (
  `CIN_R` varchar(20) NOT NULL,
  `NOM` varchar(40) DEFAULT NULL,
  `PRENOM` varchar(40) DEFAULT NULL,
  `DATE_NAISSANCE` date DEFAULT NULL,
  `EMAIL` varchar(252) DEFAULT NULL,
  `TELEPHONE` varchar(12) DEFAULT NULL,
  `SEXE` varchar(10) DEFAULT NULL,
  `ADRESSE` varchar(250) DEFAULT NULL,
  `CODEPOSTAL` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `receptionistes`
--

INSERT INTO `receptionistes` (`CIN_R`, `NOM`, `PRENOM`, `DATE_NAISSANCE`, `EMAIL`, `TELEPHONE`, `SEXE`, `ADRESSE`, `CODEPOSTAL`) VALUES
('AD253859', 'Fettoukh', 'Mohamed Amine', '1997-04-03', 'Amine@gmail.com', '0661105748', 'Homme', 'Tanger , Boukhalef', 12000);

-- --------------------------------------------------------

--
-- Structure de la table `reserver`
--

CREATE TABLE `reserver` (
  `CIN_R` varchar(20) NOT NULL,
  `CIN` varchar(20) NOT NULL,
  `NUMEROCH` int(11) NOT NULL,
  `DATEDEBUT` date NOT NULL,
  `DATEFIN` date NOT NULL,
  `Payée` int(1) NOT NULL DEFAULT '0',
  `ID_R` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `reserver`
--

INSERT INTO `reserver` (`CIN_R`, `CIN`, `NUMEROCH`, `DATEDEBUT`, `DATEFIN`, `Payée`, `ID_R`) VALUES
('AD253859', 'AD191111', 10, '2019-01-02', '2019-01-31', 1, 1),
('AD253859', 'AD111111', 1, '2019-02-02', '2019-02-28', 1, 13),
('AD253859', 'AD121111', 8, '2019-02-07', '2019-02-19', 1, 14),
('AD253859', 'AD131111', 9, '2019-02-05', '2019-02-21', 1, 15),
('AD253859', 'AD151111', 17, '2019-02-08', '2019-02-15', 0, 19),
('AD253859', 'AD161111', 8, '2019-02-22', '2019-02-24', 0, 20),
('AD253859', 'AD151111', 13, '2019-03-07', '2019-03-10', 0, 21),
('AD253859', 'AD111111', 2, '2018-09-10', '2018-09-27', 1, 22),
('AD253859', 'AD121111', 20, '2018-09-10', '2018-09-27', 1, 23),
('AD253859', 'AD121111', 20, '2018-09-10', '2018-09-27', 1, 25),
('AD253859', 'AD131111', 21, '2016-05-10', '2016-05-27', 1, 26),
('AD253859', 'AD141111', 17, '2016-04-10', '2016-04-27', 1, 27),
('AD253859', 'AD151111', 4, '2016-04-10', '2016-04-27', 1, 28),
('AD253859', 'AD161111', 3, '2017-10-10', '2017-10-27', 1, 29),
('AD253859', 'AD121111', 2, '2017-08-10', '2017-08-27', 1, 30),
('AD253859', 'AD121111', 2, '2017-05-10', '2017-05-27', 1, 31),
('AD253859', 'AD121111', 1, '2017-04-10', '2017-04-27', 1, 32),
('AD253859', 'AD191111', 10, '2019-01-02', '2019-02-03', 1, 34),
('AD253859', 'AD785412', 7, '2019-02-02', '2019-02-22', 1, 35),
('AD253859', 'AD785412', 16, '2019-02-03', '2019-02-10', 1, 36);

-- --------------------------------------------------------

--
-- Structure de la table `services`
--

CREATE TABLE `services` (
  `IDS` int(11) NOT NULL,
  `CIN_D` varchar(20) NOT NULL,
  `PRIX` float DEFAULT NULL,
  `Designation` varchar(120) DEFAULT NULL,
  `actif` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `services`
--

INSERT INTO `services` (`IDS`, `CIN_D`, `PRIX`, `Designation`, `actif`) VALUES
(1, 'B456445', 50, 'Petit Déjeuner\r\n', 1),
(2, 'B456445', 100, 'Déjeuner', 1),
(9, 'B456445', 100, 'diner', 1),
(10, 'B456445', 50, 'Nettoyage', 1),
(11, 'B456445', 20, 'café', 1),
(12, 'B456445', 150, 'Massage', 1),
(13, 'B456445', 200, 'SPA', 1),
(14, 'B456445', 40, 'Réservation Taxi', 1),
(15, 'B456445', 20, 'hamburger', 0),
(16, 'B456445', 150, 'Omellete', 0);

-- --------------------------------------------------------

--
-- Structure de la vue `allemploye`
--
DROP TABLE IF EXISTS `allemploye`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `allemploye`  AS  select `e`.`CIN_E` AS `cin`,`cp`.`ROLEPERSONNEL` AS `Role`,`e`.`NOM` AS `Nom`,`e`.`PRENOM` AS `Prenom`,`e`.`TELEPHONE` AS `Telephone`,`cp`.`DATEDEBUC` AS `date debut`,`cp`.`DATEFINC` AS `date fin` from (`employe` `e` join `contratpersonnelhistorique` `cp` on((`e`.`CIN_E` = `cp`.`CIN_E`))) where (`cp`.`dateC` >= all (select max(`cplh`.`dateC`) from `contratpersonnelhistorique` `cplh` where (`cplh`.`CIN_E` = `cp`.`CIN_E`)) and (not(`cp`.`CIN_E` in (select `contratpersonnel`.`CIN_E` from `contratpersonnel`)))) union select `e`.`CIN_E` AS `cin`,`cp`.`ROLEPERSONNEL` AS `Role`,`e`.`NOM` AS `Nom`,`e`.`PRENOM` AS `Prenom`,`e`.`TELEPHONE` AS `Telephone`,`cp`.`DATEDEBUC` AS `date debut`,`cp`.`DATEFINC` AS `date fin` from (`employe` `e` join `contratpersonnel` `cp` on((`e`.`CIN_E` = `cp`.`CIN_E`))) ;

-- --------------------------------------------------------

--
-- Structure de la vue `contrat`
--
DROP TABLE IF EXISTS `contrat`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `contrat`  AS  select `result`.`IDC` AS `IDC`,`result`.`CIN_E` AS `CIN_E`,`result`.`CIN_D` AS `CIN_D`,`result`.`DATEDEBUC` AS `DATEDEBUC`,`result`.`DATEFINC` AS `DATEFINC`,`result`.`TYPECONTRAT` AS `TYPECONTRAT`,`result`.`ROLEPERSONNEL` AS `ROLEPERSONNEL`,`result`.`SALAIRE` AS `SALAIRE`,`result`.`DESCRIPTION` AS `DESCRIPTION`,`result`.`dateC` AS `dateC` from (select `contratpersonnel`.`IDC` AS `IDC`,`contratpersonnel`.`CIN_E` AS `CIN_E`,`contratpersonnel`.`CIN_D` AS `CIN_D`,`contratpersonnel`.`DATEDEBUC` AS `DATEDEBUC`,`contratpersonnel`.`DATEFINC` AS `DATEFINC`,`contratpersonnel`.`TYPECONTRAT` AS `TYPECONTRAT`,`contratpersonnel`.`ROLEPERSONNEL` AS `ROLEPERSONNEL`,`contratpersonnel`.`SALAIRE` AS `SALAIRE`,`contratpersonnel`.`DESCRIPTION` AS `DESCRIPTION`,`contratpersonnel`.`dateC` AS `dateC` from `contratpersonnel` union select `cph`.`IDC` AS `IDC`,`cph`.`CIN_E` AS `CIN_E`,`cph`.`CIN_D` AS `CIN_D`,`cph`.`DATEDEBUC` AS `DATEDEBUC`,`cph`.`DATEFINC` AS `DATEFINC`,`cph`.`TYPECONTRAT` AS `TYPECONTRAT`,`cph`.`ROLEPERSONNEL` AS `ROLEPERSONNEL`,`cph`.`SALAIRE` AS `SALAIRE`,`cph`.`DESCIPTION` AS `DESCRIPTION`,`cph`.`dateC` AS `dateC` from `contratpersonnelhistorique` `cph` where (`cph`.`dateC` >= all (select max(`cplh`.`dateC`) from `contratpersonnelhistorique` `cplh` where (`cplh`.`CIN_E` = `cph`.`CIN_E`)) and (not(`cph`.`CIN_E` in (select `contratpersonnel`.`CIN_E` from `contratpersonnel`))))) `result` order by `result`.`dateC` desc ;

-- --------------------------------------------------------

--
-- Structure de la vue `employeactuel`
--
DROP TABLE IF EXISTS `employeactuel`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employeactuel`  AS  select `e`.`CIN_E` AS `cin`,`cp`.`ROLEPERSONNEL` AS `Role`,`e`.`NOM` AS `Nom`,`e`.`PRENOM` AS `Prenom`,`e`.`TELEPHONE` AS `Telephone`,`cp`.`DATEDEBUC` AS `date debut`,`cp`.`DATEFINC` AS `date fin` from (`employe` `e` join `contratpersonnel` `cp` on((`e`.`CIN_E` = `cp`.`CIN_E`))) ;

-- --------------------------------------------------------

--
-- Structure de la vue `employeprecedent`
--
DROP TABLE IF EXISTS `employeprecedent`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employeprecedent`  AS  select `e`.`CIN_E` AS `cin`,`cp`.`ROLEPERSONNEL` AS `Role`,`e`.`NOM` AS `Nom`,`e`.`PRENOM` AS `Prenom`,`e`.`TELEPHONE` AS `Telephone`,`cp`.`DATEDEBUC` AS `date debut`,`cp`.`DATEFINC` AS `date fin` from (`employe` `e` join `contratpersonnelhistorique` `cp` on((`e`.`CIN_E` = `cp`.`CIN_E`))) where (`cp`.`dateC` >= all (select max(`cplh`.`dateC`) from `contratpersonnelhistorique` `cplh` where (`cplh`.`CIN_E` = `cp`.`CIN_E`)) and (not(`cp`.`CIN_E` in (select `contratpersonnel`.`CIN_E` from `contratpersonnel`)))) ;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `chambres`
--
ALTER TABLE `chambres`
  ADD PRIMARY KEY (`NUMEROCH`),
  ADD KEY `FK_APPARTIENT` (`IDCLASSE`);

--
-- Index pour la table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`IDCLASSE`);

--
-- Index pour la table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`CIN`);

--
-- Index pour la table `compteclients`
--
ALTER TABLE `compteclients`
  ADD PRIMARY KEY (`LOGINCL`),
  ADD KEY `FK_POSSEDE_UN` (`CIN`);

--
-- Index pour la table `comptepersonnel`
--
ALTER TABLE `comptepersonnel`
  ADD PRIMARY KEY (`LOGIN`),
  ADD UNIQUE KEY `CIN_E` (`CIN_E`),
  ADD UNIQUE KEY `LOGIN` (`LOGIN`);

--
-- Index pour la table `contratpersonnel`
--
ALTER TABLE `contratpersonnel`
  ADD PRIMARY KEY (`IDC`),
  ADD UNIQUE KEY `CIN_E` (`CIN_E`),
  ADD KEY `FK_ajouter` (`CIN_D`);

--
-- Index pour la table `contratpersonnelhistorique`
--
ALTER TABLE `contratpersonnelhistorique`
  ADD PRIMARY KEY (`IDC`),
  ADD KEY `FK_SIGNER2` (`CIN_E`),
  ADD KEY `FK_ajouter` (`CIN_D`);

--
-- Index pour la table `demander`
--
ALTER TABLE `demander`
  ADD PRIMARY KEY (`ID_D`),
  ADD KEY `FK_DEMANDER2` (`IDS`),
  ADD KEY `FK_demander1` (`CIN`,`IDS`) USING BTREE;

--
-- Index pour la table `directeur`
--
ALTER TABLE `directeur`
  ADD PRIMARY KEY (`CIN_D`);

--
-- Index pour la table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`CIN_E`);

--
-- Index pour la table `gerant`
--
ALTER TABLE `gerant`
  ADD PRIMARY KEY (`CIN_GR`);

--
-- Index pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD PRIMARY KEY (`CIN_E`);

--
-- Index pour la table `plaintes`
--
ALTER TABLE `plaintes`
  ADD PRIMARY KEY (`IDP`),
  ADD KEY `FK_EVALUER` (`CIN_GR`),
  ADD KEY `FK_RECLAMER` (`CIN`);

--
-- Index pour la table `receptionistes`
--
ALTER TABLE `receptionistes`
  ADD PRIMARY KEY (`CIN_R`);

--
-- Index pour la table `reserver`
--
ALTER TABLE `reserver`
  ADD PRIMARY KEY (`ID_R`),
  ADD KEY `FK_RESERVER` (`CIN`),
  ADD KEY `FK_RESERVER2` (`CIN_R`),
  ADD KEY `FK_RESERVER3` (`NUMEROCH`);

--
-- Index pour la table `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`IDS`),
  ADD KEY `FK_AJOUTER_DES` (`CIN_D`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `chambres`
--
ALTER TABLE `chambres`
  MODIFY `NUMEROCH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT pour la table `classes`
--
ALTER TABLE `classes`
  MODIFY `IDCLASSE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `contratpersonnel`
--
ALTER TABLE `contratpersonnel`
  MODIFY `IDC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;
--
-- AUTO_INCREMENT pour la table `contratpersonnelhistorique`
--
ALTER TABLE `contratpersonnelhistorique`
  MODIFY `IDC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;
--
-- AUTO_INCREMENT pour la table `demander`
--
ALTER TABLE `demander`
  MODIFY `ID_D` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT pour la table `plaintes`
--
ALTER TABLE `plaintes`
  MODIFY `IDP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT pour la table `reserver`
--
ALTER TABLE `reserver`
  MODIFY `ID_R` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT pour la table `services`
--
ALTER TABLE `services`
  MODIFY `IDS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `chambres`
--
ALTER TABLE `chambres`
  ADD CONSTRAINT `FK_APPARTIENT` FOREIGN KEY (`IDCLASSE`) REFERENCES `classes` (`IDCLASSE`);

--
-- Contraintes pour la table `compteclients`
--
ALTER TABLE `compteclients`
  ADD CONSTRAINT `FK_POSSEDE_UN` FOREIGN KEY (`CIN`) REFERENCES `clients` (`CIN`);

--
-- Contraintes pour la table `comptepersonnel`
--
ALTER TABLE `comptepersonnel`
  ADD CONSTRAINT `FK_POSSEDER` FOREIGN KEY (`CIN_E`) REFERENCES `personnel` (`CIN_E`);

--
-- Contraintes pour la table `contratpersonnel`
--
ALTER TABLE `contratpersonnel`
  ADD CONSTRAINT `FK_SIGNER2` FOREIGN KEY (`CIN_E`) REFERENCES `employe` (`CIN_E`),
  ADD CONSTRAINT `FK_ajouter` FOREIGN KEY (`CIN_D`) REFERENCES `directeur` (`CIN_D`);

--
-- Contraintes pour la table `demander`
--
ALTER TABLE `demander`
  ADD CONSTRAINT `FK_DEMANDER` FOREIGN KEY (`CIN`) REFERENCES `clients` (`CIN`),
  ADD CONSTRAINT `FK_DEMANDER2` FOREIGN KEY (`IDS`) REFERENCES `services` (`IDS`);

--
-- Contraintes pour la table `directeur`
--
ALTER TABLE `directeur`
  ADD CONSTRAINT `FK_INHERITANCE_1` FOREIGN KEY (`CIN_D`) REFERENCES `personnel` (`CIN_E`);

--
-- Contraintes pour la table `employe`
--
ALTER TABLE `employe`
  ADD CONSTRAINT `FK_INHERITANCE_2` FOREIGN KEY (`CIN_E`) REFERENCES `personnel` (`CIN_E`);

--
-- Contraintes pour la table `gerant`
--
ALTER TABLE `gerant`
  ADD CONSTRAINT `FK_INHERITANCE_3` FOREIGN KEY (`CIN_GR`) REFERENCES `employe` (`CIN_E`);

--
-- Contraintes pour la table `plaintes`
--
ALTER TABLE `plaintes`
  ADD CONSTRAINT `FK_EVALUER` FOREIGN KEY (`CIN_GR`) REFERENCES `gerant` (`CIN_GR`),
  ADD CONSTRAINT `FK_RECLAMER` FOREIGN KEY (`CIN`) REFERENCES `clients` (`CIN`);

--
-- Contraintes pour la table `receptionistes`
--
ALTER TABLE `receptionistes`
  ADD CONSTRAINT `FK_INHERITANCE_4` FOREIGN KEY (`CIN_R`) REFERENCES `employe` (`CIN_E`);

--
-- Contraintes pour la table `reserver`
--
ALTER TABLE `reserver`
  ADD CONSTRAINT `FK_RESERVER` FOREIGN KEY (`CIN`) REFERENCES `clients` (`CIN`),
  ADD CONSTRAINT `FK_RESERVER2` FOREIGN KEY (`CIN_R`) REFERENCES `receptionistes` (`CIN_R`),
  ADD CONSTRAINT `FK_RESERVER3` FOREIGN KEY (`NUMEROCH`) REFERENCES `chambres` (`NUMEROCH`);

--
-- Contraintes pour la table `services`
--
ALTER TABLE `services`
  ADD CONSTRAINT `FK_AJOUTER_DES` FOREIGN KEY (`CIN_D`) REFERENCES `directeur` (`CIN_D`);

DELIMITER $$
--
-- Événements
--
CREATE DEFINER=`root`@`localhost` EVENT `Majpersonnel` ON SCHEDULE EVERY 1 DAY STARTS '2019-01-22 00:00:00' ENDS '2038-01-09 00:00:00' ON COMPLETION NOT PRESERVE ENABLE DO CALL  MajPersonnel()$$

CREATE DEFINER=`root`@`localhost` EVENT `Majclients` ON SCHEDULE EVERY 1 DAY STARTS '2019-02-01 12:00:00' ENDS '2020-01-09 00:00:00' ON COMPLETION NOT PRESERVE ENABLE DO CALL MajClients()$$
SET @@global.event_scheduler = 1;
DELIMITER ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
