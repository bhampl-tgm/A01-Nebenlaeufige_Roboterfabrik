package tgm.sew.hit.roboterfabrik.mitarbeiter;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tgm.sew.hit.roboterfabrik.Lager;
import tgm.sew.hit.roboterfabrik.Threadee;
import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.bauteil.BauteilTyp;

public class Lagermitarbeiter extends Mitarbeiter {

	
	private Lager lager;

	public Lagermitarbeiter(int id, Lager lager) {
		super(id);
		this.lager = lager;
	}

	private boolean enoughParts() {
		return (this.lager.containsTeil(BauteilTyp.ARM, 2) && this.lager.containsTeil(BauteilTyp.AUGE, 2) && this.lager.containsTeil(BauteilTyp.KETTENANTRIEB, 1) && this.lager.containsTeil(BauteilTyp.RUMPF, 1));
	}

	public Bauteil[] teileBereitstellen() {
		synchronized (this.lager) {
			if (enoughParts()) {
				List<Bauteil> teile = new ArrayList<Bauteil>();

				teile.add(this.lager.getBauteil(BauteilTyp.AUGE));
				teile.add(this.lager.getBauteil(BauteilTyp.AUGE));

				teile.add(this.lager.getBauteil(BauteilTyp.ARM));
				teile.add(this.lager.getBauteil(BauteilTyp.ARM));

				teile.add(this.lager.getBauteil(BauteilTyp.KETTENANTRIEB));

				teile.add(this.lager.getBauteil(BauteilTyp.RUMPF));
				
				getLogger().trace(""+getClass()+" "+getId()+" hat sich ein Set teile aus dem Lager geholt.");
				return teile.toArray(new Bauteil[0]);
			}
		}
		
		return null;
	}
	
	public void threadeeEinlagern(Threadee t) {
		
	}

	public void teileEinlagern(Bauteil[] teile) {
		synchronized (this.lager) {
			// Teile werden nur eingelagert wenn sie nicht null sind
			for (Bauteil b : teile) {
				if (b != null) {
					this.lager.addTeil(b);
					
				} else {
					// TODO log, das teil nicht ins lager geadded wird
				}
			}
		}
	}
}
