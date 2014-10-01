package tgm.sew.hit.roboterfabrik.mitarbeiter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * Mitarbeiter welcher durch eine eindeutige Id
 * identifiziert wird.
 * 
 * @author Stefan Geyer, pmalik
 * @version 1.0
 */
public abstract class Mitarbeiter {

	private int id;
	private final Logger logger;
	
	public Mitarbeiter(int id) {
		this.id = id;
		logger = LogManager.getLogger("Logger");
	}
	
	public int getId() {
		return this.id;
	}
	
	public Logger getLogger(){
		return this.logger;
	}

}
