-- ecomm preconfiguration

CREATE DATABASE ecomm;
USE ecomm;

-- ecomm.commande definition

CREATE TABLE `commande` (
  `numCde` int NOT NULL,
  `dateCde` date DEFAULT NULL,
  PRIMARY KEY (`numCde`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


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
  KEY `numcli` (`numcli`),
  CONSTRAINT `cdecli_ibfk_1` FOREIGN KEY (`numcli`) REFERENCES `client` (`numCli`),
  CONSTRAINT `cdecli_ibfk_2` FOREIGN KEY (`numcde`) REFERENCES `commande` (`numCde`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ecomm.procde definition

CREATE TABLE `procde` (
  `numpro` int NOT NULL,
  `numcde` int NOT NULL,
  `qte` int DEFAULT NULL,
  PRIMARY KEY (`numpro`,`numcde`),
  KEY `numcde` (`numcde`),
  CONSTRAINT `procde_ibfk_1` FOREIGN KEY (`numpro`) REFERENCES `produit` (`numPro`),
  CONSTRAINT `procde_ibfk_2` FOREIGN KEY (`numcde`) REFERENCES `commande` (`numCde`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ecomm inserts

INSERT INTO ecomm.utilisateur
(numUtil, nomUtil, prenomUtil, addrUtil, passUtil, typeCompte)
VALUES(0, '', '', '', '', '');

INSERT INTO ecomm.administrateur
(numAdmin)
VALUES(0);

INSERT INTO ecomm.client
(numCli)
VALUES(0);

INSERT INTO ecomm.commande
(numCde, dateCde)
VALUES(0, now());

INSERT INTO ecomm.cdecli
(numcde, numcli)
VALUES(0, 0);

INSERT INTO ecomm.famille
(numFam, nomFam)
VALUES(0, '');

INSERT INTO ecomm.produit
(numPro, puPro, nomPro, famPro)
VALUES(0, 0, '', 0);

INSERT INTO ecomm.procde
(numpro, numcde, qte)
VALUES(0, 0, 0);