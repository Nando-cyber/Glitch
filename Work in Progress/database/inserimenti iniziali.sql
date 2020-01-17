use Glitch;

/*Prodotto*/
INSERT INTO Prodotto (id, immagine, prezzo, descrizione) 
VALUES(1,"https://images-na.ssl-images-amazon.com/images/I/81X9Pj5JY6L._SX425_.jpg",54.99, "Call of Duty: Modern Warfare offre ai fan una storia avvincente, cruda, provocatoria e dall'intensità impareggiabile, che mette in evidenza la natura mutevole della guerra moderna.
");
INSERT INTO Prodotto (id, immagine, prezzo, descrizione)
VALUES(2, "https://images-na.ssl-images-amazonprodotto.com/images/I/71BpeOHt2yL._SX679_.jpg", 249, "PS4 500GB+DS4V2+FORTNITE VCH");
/*Videogiochi*/
INSERT INTO Videogioco (prodottoId, nome, genere, piattaforma) VALUES(1, "Call of Duty: Modern Warfare","FPS", "PlayStation 4");


/*Console*/
INSERT INTO Console (prodottoID, modello, casaProduttrice) VALUES(2, "PS4", "Playstation");