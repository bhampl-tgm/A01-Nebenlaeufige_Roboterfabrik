package tgm.sew.hit.roboterfabrik.bauteil;

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
