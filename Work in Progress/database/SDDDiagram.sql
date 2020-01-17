create database Glitch;
use Glitch;

CREATE TABLE Utente (
  username  varchar(10) NOT NULL, 
  email     varchar(25) NOT NULL, 
  password  varchar(15) NOT NULL, 
  nome      char(15) NOT NULL, 
  cognome   char(15) NOT NULL, 
  provincia char(3), 
  CAP       int(5), 
  città     int(11), 
  via       char(20), 
  numero    int(3), 
  ruolo     ENUM("Catalogo", "Account", "Assistenza"), 
  PRIMARY KEY (username, 
  email));
CREATE TABLE Prodotto (
  ID            int(5) NOT NULL AUTO_INCREMENT, 
  immagine      blob, 
  prezzo        double NOT NULL, 
  descrizione   blob,  
  PRIMARY KEY (ID));
CREATE TABLE Console (
  prodottoID      int(5) NOT NULL, 
  modello         varchar(15) NOT NULL, 
  casaProduttrice char(15) NOT NULL, 
  PRIMARY KEY (prodottoID));
CREATE TABLE Videogioco (
  prodottoID  int(5) NOT NULL, 
  nome        varchar(40) NOT NULL, 
  genere      char(10) NOT NULL, 
  piattaforma varchar(15) NOT NULL, 
  PRIMARY KEY (prodottoID));
CREATE TABLE Carrello (
  prodottoID     int(5) NOT NULL, 
  utenteUsername varchar(10) NOT NULL, 
  utenteEmail    varchar(25) NOT NULL, 
  quantità       int(3) NOT NULL, 
  prezzoQuantità double NOT NULL, 
  PRIMARY KEY (prodottoID, 
  utenteUsername, 
  utenteEmail));
CREATE TABLE Ordine (
  carrelloUtenteUsername varchar(10) NOT NULL, 
  carrelloUtenteEmail    varchar(25) NOT NULL, 
  carrelloProdottoID     int(5) NOT NULL, 
  dataOrdinazione        date NOT NULL, 
  PRIMARY KEY (carrelloUtenteUsername, 
  carrelloUtenteEmail, 
  carrelloProdottoID));
CREATE TABLE Richiesta (
  id             int(3) NOT NULL, 
  utenteEmail    varchar(25) NOT NULL, 
  utenteUsername varchar(10) NOT NULL, 
  destinatario   varchar(25) NOT NULL, 
  descrizione    blob NOT NULL, 
  stato          bit(1) NOT NULL, 
  PRIMARY KEY (id, 
  utenteEmail));
CREATE TABLE Offerta (
  codice    int(5) NOT NULL AUTO_INCREMENT, 
  sconto    int(3) NOT NULL, 
  categoria char(10) NOT NULL, 
  PRIMARY KEY (codice));
CREATE TABLE `Carta di credito` (
  numeroCarta    int(16) NOT NULL, 
  utenteUsername varchar(10) NOT NULL, 
  utenteEmail    varchar(25) NOT NULL, 
  nome           char(15) NOT NULL, 
  cognome        char(15) NOT NULL, 
  scadenza       date NOT NULL, 
  CVV            int(3) NOT NULL, 
  PRIMARY KEY (numeroCarta, 
  utenteUsername, 
  utenteEmail));
ALTER TABLE Console ADD INDEX FKConsole133890 (prodottoID), ADD CONSTRAINT FKConsole133890 FOREIGN KEY (prodottoID) REFERENCES Prodotto (ID);
ALTER TABLE Videogioco ADD INDEX FKVideogioco351250 (prodottoID), ADD CONSTRAINT FKVideogioco351250 FOREIGN KEY (prodottoID) REFERENCES Prodotto (ID);
ALTER TABLE Carrello ADD INDEX FKCarrello618141 (utenteUsername, utenteEmail), ADD CONSTRAINT FKCarrello618141 FOREIGN KEY (utenteUsername, utenteEmail) REFERENCES Utente (username, email);
ALTER TABLE Ordine ADD INDEX FKOrdine835012 (carrelloProdottoID, carrelloUtenteUsername, carrelloUtenteEmail), ADD CONSTRAINT FKOrdine835012 FOREIGN KEY (carrelloProdottoID, carrelloUtenteUsername, carrelloUtenteEmail) REFERENCES Carrello (prodottoID, utenteUsername, utenteEmail);
ALTER TABLE Richiesta ADD INDEX FKRichiesta300529 (utenteUsername, utenteEmail), ADD CONSTRAINT FKRichiesta300529 FOREIGN KEY (utenteUsername, utenteEmail) REFERENCES Utente (username, email);
ALTER TABLE Carrello ADD INDEX FKCarrello511555 (prodottoID), ADD CONSTRAINT FKCarrello511555 FOREIGN KEY (prodottoID) REFERENCES Prodotto (ID);
ALTER TABLE `Carta di credito` ADD INDEX `FKCarta di c550472` (utenteUsername, utenteEmail), ADD CONSTRAINT `FKCarta di c550472` FOREIGN KEY (utenteUsername, utenteEmail) REFERENCES Utente (username, email);
