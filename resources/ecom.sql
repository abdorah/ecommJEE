CREATE DATABASE `ecomm` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `ecomm`;

-- ecomm.administrateur definition

CREATE TABLE `administrateur` (
  `numAdmin` int NOT NULL,
  PRIMARY KEY (`numAdmin`),
  CONSTRAINT `administrateur_FK` FOREIGN KEY (`numAdmin`) REFERENCES `utilisateur` (`numUtil`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ecomm.cdecli definition

CREATE TABLE `cdecli` (
  `numcde` int NOT NULL,
  `numcli` int NOT NULL,
  PRIMARY KEY (`numcde`,`numcli`),
  KEY `cdecli_FK_1` (`numcli`),
  CONSTRAINT `cdecli_FK` FOREIGN KEY (`numcde`) REFERENCES `commande` (`numCde`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cdecli_FK_1` FOREIGN KEY (`numcli`) REFERENCES `client` (`numCli`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ecomm.commande definition

CREATE TABLE `commande` (
  `numCde` int NOT NULL AUTO_INCREMENT,
  `dateCde` date DEFAULT NULL,
  PRIMARY KEY (`numCde`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ecomm.famille definition

CREATE TABLE `famille` (
  `numFam` int NOT NULL,
  `nomFam` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`numFam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ecomm.utilisateur definition

CREATE TABLE `utilisateur` (
  `numUtil` int NOT NULL,
  `nomUtil` varchar(100) DEFAULT NULL,
  `prenomUtil` varchar(100) DEFAULT NULL,
  `addrUtil` varchar(100) DEFAULT NULL,
  `passUtil` varchar(100) DEFAULT NULL,
  `typeCompte` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`numUtil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ecomm.client definition

CREATE TABLE `client` (
  `numCli` int NOT NULL,
  PRIMARY KEY (`numCli`),
  CONSTRAINT `client_FK` FOREIGN KEY (`numCli`) REFERENCES `utilisateur` (`numUtil`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ecomm.produit definition

CREATE TABLE `produit` (
  `numPro` int NOT NULL,
  `puPro` decimal(10,0) DEFAULT NULL,
  `nomPro` varchar(50) DEFAULT NULL,
  `famPro` int DEFAULT NULL,
  `stock` int DEFAULT NULL,
  PRIMARY KEY (`numPro`),
  KEY `famPro` (`famPro`),
  CONSTRAINT `produit_ibfk_1` FOREIGN KEY (`famPro`) REFERENCES `famille` (`numFam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ecomm.procde definition

CREATE TABLE `procde` (
  `numpro` int NOT NULL,
  `numcde` int NOT NULL,
  `qte` int DEFAULT NULL,
  PRIMARY KEY (`numpro`,`numcde`),
  KEY `procde_FK` (`numcde`),
  CONSTRAINT `procde_FK` FOREIGN KEY (`numcde`) REFERENCES `commande` (`numCde`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `procde_FK_1` FOREIGN KEY (`numpro`) REFERENCES `produit` (`numPro`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;