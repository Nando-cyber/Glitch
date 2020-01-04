package model;

import java.util.regex.Pattern;

public class ValidazioneCartaDiCredito {

	//Controlla che sia rispettata la sintassi (caratteri alfabetici e prima lettera maiuscola) di "nome"
	public static boolean checkNome(String nome){
		return Pattern.matches("[A-Za-z\\s]+",nome) && Pattern.matches("[A-Z]+",nome.subSequence(0, 1));
	}
	
	//Controlla che sia rispettata la sintassi (caratteri alfabetici e prima lettera maiuscola) di "cognome"
	public static boolean checkCognome(String cognome)
	{
		return Pattern.matches("[A-Za-z\\s]+",cognome) && Pattern.matches("[A-Z]+",cognome.subSequence(0, 1));
	}
	
	//Controlla che sia rispettata la sintassi (Deve essere formato da 16 cifre numeriche) di "nI" (Numero identificativo)
	public static boolean checkNumeroIdentificativo(String nI)
	{
		if(nI.length()!=16)
			return false;
		else
			return Pattern.matches("[0-9]+",nI);
	}
	
	//Controlla che sia rispettata la sintassi (Deve contenere 4 caratteri numerici nel formato “MMAA”) di "date" (Scadenza)
	public static boolean checkScadenza(String date)
	{
		if(date.length()!=4)
			return false;
		int mese=Integer.parseInt(date.substring(0,2));
		int anno=Integer.parseInt(date.substring(2,4));
		
		if(mese>0 && mese<=12 && anno>=20)
		{
			return true;
		}
		else
			return false;	
	}
	
	//Controlla che sia rispettata la sintassi (Deve essere formato da 3 caratteri numerici) di "cVV"
	public static boolean checkCVV(String cVV)
	{
		if(cVV.length()!=3)
			return false;
		else
			return Pattern.matches("[0-9]+",cVV);
		
	}
	
	
	
	
	
	
	

}
