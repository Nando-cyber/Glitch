package com.example.demo;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface VideogiocoDAO {

	void addVideogioco(Videogioco l);
	void removeVideogioco(Videogioco l);
	void updateVideogioco(Videogioco l);
	List<Videogioco> findAllVideogioco();
	List<Videogioco> doRetriveVideogiocoAllRange(int min, int max);
	Videogioco findVideogiocoById(int id);
	
	
}
