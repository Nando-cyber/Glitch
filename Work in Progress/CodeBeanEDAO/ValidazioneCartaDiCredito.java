package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.regex.Pattern;

public class ValidazioneCartaDiCredito {

	public static boolean checkNome(String nome){
		return Pattern.matches("[A-Za-z]+",nome) && Pattern.matches("[A-Z]+",nome.subSequence(0, 1));
	}
	
	public static boolean checkCognome(String cognome)
	{
		return Pattern.matches("[A-Za-z]+",cognome) && Pattern.matches("[A-Z]+",cognome.subSequence(0, 1));
	}
	
	public static boolean checkNumeroIdentificativo(String nI)
	{
		Long num=Long.parseLong(nI);
		
		if(num!=null && num>=1000000000000000L && num<10000000000000000L)
			return true;
		else
			return false;
	}
	
	//da verificare
	public static boolean checkScadenza(String date)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM-yy");
		Date scadenza;
		try {
			scadenza = formatter.parse(date);
			return true;
		} catch (ParseException e) {
			
			e.printStackTrace();
			return false;
		}
	
	}
	
	
	public static boolean checkCVV(String cVV)
	{
		try {
			int numCvv=Integer.parseInt(cVV);
			if(numCvv>99 && numCvv<1000)
				return true;
		}catch(Exception e) {}
		
		return false;
		
	}
	
	
	
	
	
	
	

}
