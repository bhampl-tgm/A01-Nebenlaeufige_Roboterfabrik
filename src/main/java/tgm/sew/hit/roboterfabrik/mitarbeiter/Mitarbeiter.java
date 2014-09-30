package tgm.sew.hit.roboterfabrik.mitarbeiter;

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

	public Mitarbeiter(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

}
