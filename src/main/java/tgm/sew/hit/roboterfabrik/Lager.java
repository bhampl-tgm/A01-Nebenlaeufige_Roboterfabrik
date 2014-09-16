package tgm.sew.hit.roboterfabrik;

import java.util.ArrayList;
import java.util.List;

import tgm.sew.hit.roboterfabrik.bauteil.Arm;
import tgm.sew.hit.roboterfabrik.bauteil.Auge;
import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.bauteil.Kettenantrieb;
import tgm.sew.hit.roboterfabrik.bauteil.Rumpf;

public class Lager {

	private List<Bauteil> teile;

	public Lager() {
		this.teile = new ArrayList<Bauteil>();
	}
	
	public void addTeil(Bauteil b) {
		this.teile.add(b);
	}
	
	public Bauteil[] getTeile() {
		return this.teile.toArray(new Bauteil[0]);
	}
	
	public Auge[] getAugen() {
		List<Bauteil> augen = new ArrayList<Bauteil>();

		for (Bauteil b : this.teile) {
			if (b instanceof Auge)
				augen.add(b);
		}

		return augen.toArray(new Auge[0]);
	}

	public Arm[] getArme() {
		List<Bauteil> arme = new ArrayList<Bauteil>();

		for (Bauteil b : this.teile) {
			if (b instanceof Arm)
				arme.add(b);
		}

		return arme.toArray(new Arm[0]);
	}

	public Kettenantrieb[] getKettenantriebe() {
		List<Bauteil> antriebe = new ArrayList<Bauteil>();

		for (Bauteil b : this.teile) {
			if (b instanceof Kettenantrieb)
				antriebe.add(b);
		}

		return antriebe.toArray(new Kettenantrieb[0]);
	}

	public Rumpf[] getRuempfe() {
		List<Bauteil> ruempfe = new ArrayList<Bauteil>();

		for (Bauteil b : this.teile) {
			if (b instanceof Rumpf)
				ruempfe.add(b);
		}

		return ruempfe.toArray(new Rumpf[0]);
	}

}
