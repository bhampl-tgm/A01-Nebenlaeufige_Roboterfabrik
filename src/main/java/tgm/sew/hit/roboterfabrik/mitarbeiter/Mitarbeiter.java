package tgm.sew.hit.roboterfabrik.mitarbeiter;

/**
 * 
 * Mitarbeiter welcher durch seinen Typen und eine eindeutige Id
 * identifiziert wird.
 * 
 * @author Stefan Geyer
 * @version 1.0
 */
public class Mitarbeiter {

	private MitarbeiterTyp typ;
	private int id;

	public Mitarbeiter(MitarbeiterTyp typ, int id) {
		this.id = id;
	}
	
	public MitarbeiterTyp getTyp() {
		return this.typ;
	}
	
	public int getId() {
		return this.id;
	}

}
