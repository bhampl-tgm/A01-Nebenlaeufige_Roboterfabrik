package tgm.sew.hit.roboterfabrik.mitarbeiter;

public enum MitarbeiterTyp {

	MONTAGE("Montagemitarbeiter"), LAGER("Lagermitarbeiter");

	private String name;

	private MitarbeiterTyp(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
