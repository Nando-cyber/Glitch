package model;

public class ValidazioneOfferta {

	public static boolean checkPercentualeSconto(String sconto)
	{
		try {
			int numSconto=Integer.parseInt(sconto);
			if(numSconto>0 && numSconto<=100)
				return true;
		}catch(Exception e) {}
		
		return false;
	}
	
	public static boolean checkCategoria(String categoria)
	{
		if(categoria.equals("Videogioco") || categoria.equals("Console"))
			return true;
		else 
			return false;
	}
}
