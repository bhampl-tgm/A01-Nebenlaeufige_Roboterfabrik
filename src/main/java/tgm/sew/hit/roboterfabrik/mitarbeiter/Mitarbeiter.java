package tgm.sew.hit.roboterfabrik.mitarbeiter;

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
