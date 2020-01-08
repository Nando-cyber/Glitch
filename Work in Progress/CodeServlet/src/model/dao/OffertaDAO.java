package model.dao;

import java.util.List;

import javax.ejb.Local;

import model.bean.Offerta;

@Local
public interface OffertaDAO {

	//Rende l'offerta "off" (passata come parametro) persistente
	void createOfferta(Offerta off);
	
	//Rimuove l'offerta avente come id l'intero passato come argomento, dal database
	void deleteOfferta(int id);
	
	//Restituisce l'offerta avente come id l'intero passato come argomento
	Offerta retriveOffertaById(int id);
	
	//Restituisce la lista di offerte associate ad una categoria passata come argomento
	List<Offerta> retriveByCategoria(String categoria);
	
}
