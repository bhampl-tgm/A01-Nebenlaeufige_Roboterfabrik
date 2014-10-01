package tgm.sew.hit.roboterfabrik.mitarbeiter;

import java.util.ArrayList;
import java.util.List;

import tgm.sew.hit.roboterfabrik.Lager;
import tgm.sew.hit.roboterfabrik.Threadee;
import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.bauteil.BauteilTyp;

/**
 * Der Lagermitarbeiter der das Lager verwaltet
 * 
 * @author Burkhard Hampl
 * @version 1.0
 */
public class Lagermitarbeiter extends Mitarbeiter {

	private Lager lager;

	/**
	 * Konstroktor des {@link Lagermitarbeiter}
	 * 
	 * @param id
	 *            die id des {@link Lagermitarbeiter}
	 * @param lager
	 *            das {@link Lager}r das er verwaltet
	 */
	public Lagermitarbeiter(int id, Lager lager) {
		super(id);
		this.lager = lager;
	}

	private boolean enoughParts() {
		return (this.lager.containsTeil(BauteilTyp.ARM, 2) && this.lager.containsTeil(BauteilTyp.AUGE, 2) && this.lager.containsTeil(BauteilTyp.KETTENANTRIEB, 1) && this.lager.containsTeil(BauteilTyp.RUMPF, 1));
	}

	/**
	 * Stellt {@link Bauteil} bereit
	 * 
	 * @return die {@link Bauteil}
	 */
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

				getLogger().trace("" + getClass() + " " + getId() + " hat sich ein Set teile aus dem Lager geholt.");
				return teile.toArray(new Bauteil[0]);
			}
		}

		return null;
	}

	/**
	 * Lagert einen {@link Threadee} ein
	 * 
	 * @param der
	 *            {@link Threadee} der eingelagert wird
	 */
	public void threadeeEinlagern(Threadee t) {
		getLogger().trace("" + getClass() + " " + getId() + " hat einen Threadee mit der ID "+t.getId()+" eingelagert.");
		this.lager.threadeeAblegen(t);
	}

	/**
	 * Lagert {@link Bauteil} ein
	 * 
	 * @param teile
	 *            die {@link Bauteil}
	 */
	public void teileEinlagern(Bauteil[] teile) {
		synchronized (this.lager) {
			// Teile werden nur eingelagert wenn sie nicht null sind
			for (Bauteil b : teile) {
				if (b != null) {
					getLogger().trace("" + getClass() + " " + getId() + " hat ein Bauteil der Art " + b.getTyp().getName() + "eingelagert");
					this.lager.addTeil(b);

				} else {
					// TODO log, das teil nicht ins lager geadded wird
				}
			}
		}
	}

	@Override
	public void run() {
		// TODO Lagermitarbeiter fertig machen

	}
}
