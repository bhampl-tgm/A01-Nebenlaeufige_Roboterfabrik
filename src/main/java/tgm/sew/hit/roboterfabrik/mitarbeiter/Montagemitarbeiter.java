package tgm.sew.hit.roboterfabrik.mitarbeiter;

import tgm.sew.hit.roboterfabrik.Threadee;
import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.bauteil.BauteilSammlung;

/**
 * 
 * Der Montagemitarbeiter dient nur dazu die Teile die ihm uebergeben werden
 * zusammenzusetzen
 * 
 * @author Stefan Geyer
 * @author Burkhard Hampl
 * @author Patrick Malik
 * @version 1.0
 */
public class Montagemitarbeiter extends Mitarbeiter {
	
	private Lagermitarbeiter lm;
	
	/**
	 * Konstruktor des {@link Montagemitarbeiter}
	 * 
	 * @param id
	 *            die id des {@link Montagemitarbeiter}
	 */
	public Montagemitarbeiter(int id,Lagermitarbeiter lm) {
		super(id);
		this.lm = lm;
		setGo(true);
	}

	/**
	 * 
	 * Simuliert das zusammenbauen des Threadees sofern alle Teile vorhanden
	 * sind.
	 * 
	 * @param teile
	 *            Teile die zusammengebaut werden
	 * @param threadeeId
	 *            Die ID die dem Threadee zugewiesen werden soll.
	 * @return Der fertige Threadee
	 */
	public void baueThreadee(Bauteil[] teile) {
		if (new BauteilSammlung(teile).isValid()) {
			getLogger().info("" + getClass() + " " + getId() + " hat den Threadee fertiggestellt.");
			Threadee t = new Threadee(-1, getId(), teile);
			for (Bauteil b : t.getBauteile())
				b.sortData();
			lm.threadeeEinlagern(t);
		}

	}

	@Override
	public void run() {
		while(getGo()){
			if(lm.enoughParts()){
				this.baueThreadee(lm.teileBereitstellen());
			}
		}

	}
}
