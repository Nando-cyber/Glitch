package model;

import java.util.regex.Pattern;

public class ValidazioneRichiesta {

	public static boolean checkDescrizione(String descrizione)
	{
		return Pattern.matches("[A-Za-z0-9]+",descrizione);
	}
}
