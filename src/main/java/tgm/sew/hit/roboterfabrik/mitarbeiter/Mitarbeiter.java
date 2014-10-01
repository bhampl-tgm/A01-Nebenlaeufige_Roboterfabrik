package tgm.sew.hit.roboterfabrik.mitarbeiter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * Mitarbeiter welcher durch eine eindeutige Id
 * identifiziert wird.
 * 
 * @author Stefan Geyer
 * @version 1.0
 */
public abstract class Mitarbeiter {

	private int id;
	static final Logger logger = LogManager.getLogger("Logger");
	
	public Mitarbeiter(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

}
