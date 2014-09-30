package tgm.sew.hit.roboterfabrik.bauteil;

/**
 * 
 * Typ der ein Bauteil identifiziert. Zusaetzlich wird der Bauteilsname uebergeben
 * 
 * @author Stefan Geyer
 * @version 1.0
 */
public enum BauteilTyp {

	AUGE("Auge"),ARM("Arm"),KETTENANTRIEB("Kettenantrieb"),RUMPF("Rumpf");
	
	private String name;
	
	private BauteilTyp(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
