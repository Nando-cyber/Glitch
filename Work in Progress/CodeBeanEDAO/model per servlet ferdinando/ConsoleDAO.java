package model;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ConsoleDAO extends ProdottoDAO{

	List<Console> findAllConsole();
	List<Console> doRetriveConsoleAllRange(int min, int max);
	
}
