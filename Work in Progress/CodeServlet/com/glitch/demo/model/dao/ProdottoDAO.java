package com.glitch.demo.model.dao;


import java.util.List;

import com.glitch.demo.model.bean.Prodotto;


public interface ProdottoDAO {

	
	List<Prodotto> doRetrieveAllRange(int offset, int limit);
	
	//Restituisce un prodotto avente come id l'intero passato come argomento
	Prodotto findProdottoById(int id);
	
	void createProdotto(Prodotto prodotto);
	
	void removeProdotto(int id);
}
