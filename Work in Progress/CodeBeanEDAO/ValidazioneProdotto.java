package model;

import java.util.regex.Pattern;

public class ValidazioneProdotto {

	public static boolean checkPrezzo(String prezzo)
	{
		
		try {
			double numPrezzo=Integer.parseInt(prezzo);
			if(numPrezzo>99 && numPrezzo<1000)
				return true;
		}catch(Exception e) {}
		
		return false;
		
	}
	
	public static boolean checkDescrizione(String descrizione)
	{
		return Pattern.matches("[A-Za-z0-9]+",descrizione);
	}
	
	
	
}
