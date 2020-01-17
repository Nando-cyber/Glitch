package com.glitch.demo.model.bean;

import java.util.regex.Pattern;

public class ValidazioneVideogioco extends ValidazioneProdotto{

	//Controlla che sia rispettata la sintassi (Deve avere caratteri alfanumerici) di "nome"
	public static boolean checkNome(String Nome)
	{
		return Pattern.matches("[A-Za-z0-9]+",Nome);
	}
	
	//Controlla che sia rispettata la sintassi (Deve avere caratteri alfabetici) di "genere"
	public static boolean checkGenere(String genere)
	{
		return Pattern.matches("[A-Za-z]+",genere);
	}
	
	//Controlla che sia rispettata la sintassi (Deve avere caratteri alfanumerici) di "piattaforma"
	public static boolean checkPiattaforma(String piattaforma)
	{
		return Pattern.matches("[A-Za-z0-9]+",piattaforma);
	}
}
