package model.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import model.dao.ConsoleJPA;
import model.dao.VideogiocoJPA;

@Singleton
@Startup
@DataSourceDefinition(
		className = "org.apache.derby.jdbc.EmbeddedDataSource", 
		name = "java:global/jdbc/GLITCH_DS",
		user = "root",
		password = "Nandonapoli98!",
		databaseName = "GLITCH_DB",
		properties = { "connectionAttributes=;create=true"}		
		)

public class DBPopulator {
	
	
	@Inject
	private ConsoleJPA cJPA;
	@Inject
	private VideogiocoJPA vJPA;
	
	private Videogioco v;
	private Console c;
	
	@PostConstruct
	public void populateDB() {
		
		v = new Videogioco("https://images-na.ssl-images-amazon.com/images/I/61rT8MezkYL._SL1000_.jpg",
				26.98f, "Il super-eroe più amato di sempre arriva finalmente su PS4.\r\n" + 
						"\r\n" + 
						"Vivi una storia Marvel mai raccontata prima, vestendo i panni di un Peter Parker ormai esperto nella lotta contro il crimine e nell'uso dei suoi incredibili poteri. New York non è mai stata così piena di criminali, quello che non sanno è che la città è il tuo parco giochi.\r\n" + 
						"\r\n" + 
						"Marvel e Insomniac Games hanno unito le forze per creare un'autentica storia di Spider-Man, ma con un approccio originale. Questo non è lo Spider-Man che conoscete o che avete visto nei film. È un Peter Parker più maturo, ormai esperto nella lotta ai crimini di New York City. Al tempo stesso, è un ragazzo alla ricerca di un equilibrio tra il caos della sua vita privata e quella professionale, gravato dalla responsabilità di salvare il destino di nove milioni di newyorkesi.\r\n" + 
						"\r\n" + 
						"Dopo otto anni dietro la maschera, Peter Parker è un veterano della lotta al crimine. Sperimenta gli immensi poteri di uno Spider-Man già esperto, in grado di improvvisare in combattimento, eseguire acrobazie estreme, muoversi con agilità e interagire con l'ambiente. Questo non è un principiante, ma lo Spider-Man più abile che tu abbia mai controllato.\r\n" + 
						"\r\n" + 
						"I destini di Peter Parker e Spider-Man si scontrano in una storia inedita all'insegna dell'azione. In questo nuovo universo, i personaggi simbolo delle vite di Peter e Spider-Man sono stati riscritti da zero, inserendo figure conosciute in ruoli appositi.\r\n" + 
						"\r\n" + 
						"La Grande mela prende vita nel mondo più esteso e interattivo mai creato da Insomniac. Oscilla con la ragnatela per attraversare quartieri brulicanti di vita e goditi la vista mozzafiato dei luoghi simbolo di Marvel e Manhattan. Sfrutta lo scenario per sconfiggere i criminali con eliminazioni in puro stile cinematografico.\r\n" + 
						"\r\n" + 
						"Caratteristiche:\r\n" + 
						"\r\n" + 
						"Una trama epica con personaggi memorabili in ruoli inaspettati\r\n" + 
						"Una dettagliatissima New York dell'universo Marvel, piena di vita e azione\r\n" + 
						"Gameplay vario grazie alla grande quantità di abilità ed accessori a disposizione.", 
						"Spiderman", "Adventure", "PlayStation4");
		
		c = new Console("https://images-na.ssl-images-amazon.com/images/I/514jjzTTaML._SL1000_.jpg",
				300, "PS4 F Chassis colore Jet Black con hard disk da 1 TeraByte + secondo DS4.", 
				"4", "PlayStation");
		
		vJPA.createProdotto(v);
		cJPA.createProdotto(c);	
		
	}
	
	@PreDestroy
	public void clearDB() {
		
		vJPA.removeProdotto(v);
		cJPA.removeProdotto(c);
		
	}
	

}
