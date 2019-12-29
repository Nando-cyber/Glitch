package com.example.demo;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface VideogiocoRemote {

	void addVideogioco(Videogioco l);
	void removeVideogioco(Videogioco l);
	void updateVideogioco(Videogioco l);
	List<Videogioco> findAllVideogioco();
	Videogioco findVideogiocoById(int id);
	
}
