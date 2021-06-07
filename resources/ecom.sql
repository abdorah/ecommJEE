#DROP TABLE famille;
#DROP TABLE produit;
#DROP TABLE client;
#DROP TABLE commande;
#DROP TABLE procde;
#DROP TABLE cdecli;
CREATE TABLE famille (numFam INT PRIMARY KEY,  nomFam VARCHAR(40));
CREATE TABLE produit (numPro INT PRIMARY KEY, puPro NUMERIC, nomPro VARCHAR (50), famPro INT, FOREIGN KEY (famPro) REFERENCES famille (numFam));
CREATE TABLE client (numCli INT PRIMARY KEY, nomCli VARCHAR(40), prenomCli VARCHAR(40), adrCli VARCHAR(100), pass VARCHAR(12));
CREATE TABLE commande (numCde INT PRIMARY KEY, dateCde DATE);
CREATE TABLE procde (numpro INT, numcde INT, qte INT, PRIMARY KEY(numpro,numcde), FOREIGN KEY (numPro) REFERENCES produit (numPro), FOREIGN KEY (numCde) REFERENCES commande (numCde));
CREATE TABLE cdecli (numcde INT, numcli INT, PRIMARY KEY (numcde,numcli), FOREIGN KEY (numcli) REFERENCES client (numCli), FOREIGN KEY (numCde) REFERENCES commande (numCde)); 


INSERT INTO famille VALUES(1,'PDA');
INSERT INTO famille VALUES(2,'laptop');

INSERT INTO produit VALUES(1,100.0,'Palm Zire 31',1);
INSERT INTO produit VALUES(2,149.99,'Palm Zire 71',1);
INSERT INTO produit VALUES(3,199.99,'Palm Zire 91',1);
INSERT INTO produit VALUES(4,1499.0,'Dell Latitude D800',2);
INSERT INTO produit VALUES(5,1599.0,'Dell Latitude X1',2);
INSERT INTO produit VALUES(6,1699.0,'Dell Latitude D850',2);

INSERT INTO client VALUES(1,'cure','olivier','5 bd Descartes','toto');
INSERT INTO client VALUES(2,'davis','miles','6 rue du Jazz','trane');

INSERT INTO commande VALUES(1,'2009-02-02');

INSERT INTO procde VALUES (2,1,2);
INSERT INTO procde VALUES (5,1,2);

INSERT INTO cdecli VALUES (1,1);
