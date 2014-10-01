package tgm.sew.hit.roboterfabrik.mitarbeiter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * Mitarbeiter welcher durch eine eindeutige Id identifiziert wird.
 * 
 * @author Stefan Geyer
 * @author Patrick Malik
 * @author Burkhard Hampl
 * @version 1.0
 */
public abstract class Mitarbeiter implements Runnable {

	private int id;
	private static final Logger logger = LogManager.getLogger("Logger");
	private boolean go;

	/**
	 * Konstruktor mit eindeutiger ID
	 * 
	 * @param id
	 *            die ID
	 */
	public Mitarbeiter(int id) {
		this.id = id;
	}

	/**
	 * gibt die ID zurueck
	 * 
	 * @return die ID
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * gibt den Logger zurueck
	 * 
	 * @return der {@link Logger}
	 */
	public static Logger getLogger() {
		return logger;
	}

	/**
	 * setzt den Zustand des Mitarbeiters
	 * 
	 * @param go
	 *            der Zustand
	 */
	public void setGo(boolean go) {
		this.go = go;
	}

}
