package com.example.demo;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ConsoleDAO {

	void addConsole(Console l);
	void removeConsole(Console l);
	void updateConsole(Console l);
	List<Console> findAllConsole();
	List<Console> doRetriveConsoleAllRange(int min, int max);
	Console findConsoleById(int id);
}
