package tgm.sew.hit.roboterfabrik.mitarbeiter;

/**
 * 
 * Typ der einen MMitarbeiter identifiziert. Zusaetzlich wird die Mitarbeiterart uebergeben
 * 
 * @author Stefan Geyer
 * @version 1.0
 */
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
