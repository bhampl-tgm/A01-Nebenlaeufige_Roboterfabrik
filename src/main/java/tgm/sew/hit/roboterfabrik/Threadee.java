package tgm.sew.hit.roboterfabrik;

import java.util.List;

public class Threadee {

	private int id;

	private int herstellerID;

	private Auge links;

	private Auge rechts;

	private Rumpf rumpf;

	private Kettenantrieb antrieb;

	private Arm rechterArm;

	private Arm linkerArm;

	public Threadee(int id, int herstellerID, Auge[] augen, Kettenantrieb kette, Rumpf rumpf, Arm[] arme) {
		
	}

	public List<Bauteil> getBauteile() {
		return null;
	}

	public int getID() {
		return 0;
	}

	public int getHerstellerID() {
		return 0;
	}

}
