use Glitch;

/*Prodotto*/
INSERT INTO Prodotto (id, immagine, prezzo, descrizione) 
VALUES(1,"https://images-na.ssl-images-amazon.com/images/I/81X9Pj5JY6L._SX425_.jpg",54.99, "Call of Duty: Modern Warfare offre ai fan una storia avvincente, cruda, provocatoria e dall'intensità impareggiabile, che mette in evidenza la natura mutevole della guerra moderna.
");
INSERT INTO Prodotto (id, immagine, prezzo, descrizione)
VALUES(2, "https://images-na.ssl-images-amazon.com/images/I/514jjzTTaML._SX679_.jpg", 249, "PS4 500GB+DS4V2+FORTNITE VCH");

INSERT INTO Prodotto (id, immagine, prezzo, descrizione) 
VALUES(3,"https://images-na.ssl-images-amazon.com/images/I/81cHm50auZL._SL1500_.jpg",49.99, "Aiuta Luigi a salvare Mario e amici in un'avventura da brividi");
INSERT INTO Prodotto (id, immagine, prezzo, descrizione) 
VALUES(4,"https://images-na.ssl-images-amazon.com/images/I/91-VfRp-i0L._SL1500_.jpg",49.99, "Esplora un enorme regno in 3D pieno di segreti e sorprese, con nuovi costumi per Mario e moltissimi modi per interagire con i diversi scenari");

INSERT INTO Prodotto (id, immagine, prezzo, descrizione) 
VALUES(5,"https://images-na.ssl-images-amazon.com/images/I/71NaHhGzY7L._SL1500_.jpg",308.20, "La confezione contiene: console, base per Nintendo Switch, un Joy-Con sinistro (blu/neon), un Joy-Con destro (rosso/neon), impugnatura joy-con, alimentatore, un set di laccetti per Joy-Con, cavo HDMI
La trasportabilità di una console portatile si combina con la potenza di una console casalinga
");

INSERT INTO Prodotto (id, immagine, prezzo, descrizione) 
VALUES(6,"https://images-na.ssl-images-amazon.com/images/I/81quqk%2BA98L._SL1500_.jpg",54.99, "Call of Duty: Modern Warfare offre ai fan una storia avvincente, cruda, provocatoria e dall'intensità impareggiabile, che mette in evidenza la natura mutevole della guerra moderna.
");

/*Videogiochi*/
INSERT INTO Videogioco (prodottoId, nome, genere, piattaforma) VALUES(1, "Call of Duty: Modern Warfare","FPS", "PlayStation 4");

INSERT INTO Videogioco (prodottoId, nome, genere, piattaforma) VALUES(3, "Luigi's Mansion 3","Adventure", "Switch");

INSERT INTO Videogioco (prodottoId, nome, genere, piattaforma) VALUES(4, "Super Mario Odyssey","FPS", "Switch");

INSERT INTO Videogioco (prodottoId, nome, genere, piattaforma) VALUES(6, "Call of Duty: Modern Warfare","FPS", "XBOX ONE");

/*Console*/
INSERT INTO Console (prodottoID, modello, casaProduttrice) VALUES(2, "PS4", "Playstation");

INSERT INTO Console (prodottoID, modello, casaProduttrice) VALUES(5, "Switch", "Nintendo");

/*Utente*/
INSERT INTO Utente (username, email, cartaDiCredito, password, nome, cognome, provincia, cap, citta, via, numero, ruolo) 
VALUES("Ferdinando98","nando998@libero.it",null,"Ferdinando98", "Ferdinando","Napolitano", "NA", 80030, "Visciano", "Galileo Galilei", 1, null);

INSERT INTO Utente (username, email, cartaDiCredito, password, nome, cognome, provincia, cap, citta, via, numero, ruolo) 
VALUES("Admin98","adminCat99@glitch.com",null,"admin98", "Ferdinando","Napolitano", "NA", 80030, "Visciano", "Galileo Galilei", 1, "Catalogo");

INSERT INTO Utente (username, email, cartaDiCredito, password, nome, cognome, provincia, cap, citta, via, numero, ruolo) 
VALUES("botGlitch","generAutoMail@live.com",null,"botGlitch99", "bot","bot", "GL", 00000, "Glitch", "Glitch", 1, null);

INSERT INTO Utente (username, email, cartaDiCredito, password, nome, cognome, provincia, cap, citta, via, numero, ruolo) 
VALUES("Nunzia98","nunzia98@libero.it",null,"Nunzia98", "Nunzia","Elefante", "NA", 80030, "Visciano", "Galileo Galilei", 1, "Assistenza");

INSERT INTO Utente (username, email, cartaDiCredito, password, nome, cognome, provincia, cap, citta, via, numero, ruolo) 
VALUES("Sandro98","sandro98@glitch.com",null,"Sandro98", "Sandro","Mutone", "NA", 80030, "Visciano", "Galileo Galilei", 1, "Account");
