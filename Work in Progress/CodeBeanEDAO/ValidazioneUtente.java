package model;

import java.util.regex.Pattern;

public class ValidazioneUtente {

	public static boolean checkNome(String nome)
	{
		return Pattern.matches("[A-Za-z]+",nome) && Pattern.matches("[A-Z]+",nome.subSequence(0, 1));
	}
	
	public static boolean checkCognome(String cognome)
	{
		return Pattern.matches("[A-Za-z]+",cognome) && Pattern.matches("[A-Z]+",cognome.subSequence(0, 1));
	}
	
	public static boolean checkEmail(String email)
	{
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	    return email.matches(regex);
	}
	
	
	public static boolean checkProvincia(String provincia)
	{
		return Pattern.matches("[A-Za-z0-9]+",provincia);
	}
	
	public static boolean checkCap(String cap)
	{
		return Pattern.matches("[A-Za-z0-9]+",cap);
	}
	
	public static boolean checkCitta(String citta)
	{
		return Pattern.matches("[A-Za-z0-9]+",citta);
	}
	
	public static boolean checkVia(String via)
	{
		return Pattern.matches("[A-Za-z0-9]+",via);
	}
	
	public static boolean checkNumero(String numero)
	{
		return Pattern.matches("[0-9]+",numero);
	}
	
	public static boolean checkUsername(String username)
	{
		return Pattern.matches("[A-Za-z0-9]+",username) && username.length()<=10;
	}
	
	
	public static boolean checkPassword(String password)
	{
		String pattern="((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,15})";
		return Pattern.matches(pattern,password);
		
	}
	
	
}
