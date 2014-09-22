package tgm.sew.hit.roboterfabrik.mitarbeiter;

public abstract class Mitarbeiter {

	private int id;

	public Mitarbeiter(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

}
