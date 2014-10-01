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
	private int tid;
	
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
		setTid(0);
	}

	public boolean enoughParts() {
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

				getLogger().info("" + getClass() + " " + getId() + " hat sich ein Set teile aus dem Lager geholt.");
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
		getLogger().info("" + getClass() + " " + getId() + " hat einen Threadee mit der ID " + t.getId() + " eingelagert.");
		t.toString().replace("@",""+tid);
		this.lager.threadeeAblegen(t);
		setTid(getTid()+1);
	}

	/**
	 * Lagert {@link Bauteil} ein
	 * 
	 * @param teile
	 *            die {@link Bauteil}
	 */
	public void teilEinlagern(Bauteil teil) {
		synchronized (this.lager) {
			// Teile werden nur eingelagert wenn sie nicht null sind

			if (teil != null) {
				getLogger().info("" + getClass() + " " + getId() + " hat ein Bauteil der Art " + teil.getTyp().getName() + " eingelagert");
				this.lager.addTeil(teil);
			} else {
				// TODO log, das teil nicht ins lager geadded wird
				getLogger().info("" + getClass() + " " + getId() + " hat ein ungültiges Teil welches übersprungen wurde");
			}

		}
	}

	@Override
	public void run() {
		// TODO Lagermitarbeiter fertig machen

	}
	
	public void setTid(int tid){
		this.tid = tid;
	}
	
	public int getTid(){
		return this.tid;
	}
}
