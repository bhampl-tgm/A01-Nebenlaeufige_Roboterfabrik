package tgm.sew.hit.roboterfabrik;

import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Montagemitarbeiter;

/**
 * 
 * Threadee der durch den {@link Montagemitarbeiter} hergestellt wird.
 * 
 * @author Stefan Geyer
 * @author Burkhard Hampl
 * @version 1.0
 */
public class Threadee {

	private int id;
	private int herstellerId;

	private Bauteil[] teile;

	/**
	 * Der Konstruktor der einen neuen {@link Threadee} erzeugt mit einer ID,
	 * einer HerstellerID und dem Array aller {@link Bauteil}
	 * 
	 * @param id
	 *            die ID des neune {@link Threadee}
	 * @param herstellerId
	 *            die HerstellerID des neune {@link Threadee}
	 * @param teile
	 *            die Teile des neuen {@link Threadee}
	 */
	public Threadee(int id, int herstellerId, Bauteil[] teile) {
		this.id = id;
		this.herstellerId = herstellerId;
		this.teile = teile;
	}

	/**
	 * Gibt ein Array aller {@link Bauteil} des {@link Threadee} zurueck
	 * 
	 * @return das Array aller {@link Bauteil}
	 */
	public Bauteil[] getBauteile() {
		return this.teile;
	}

	/**
	 * Gibt die ID des {@link Threadee} zurueck
	 * 
	 * @return die ID des {@link Threadee}
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Gibt die HerstellerID des {@link Threadee} zurueck
	 * 
	 * @return die HerstellerID des {@link Threadee}
	 */
	public int getHerstellerId() {
		return this.herstellerId;
	}

	@Override
	public String toString() {
		String out = "";

		out += "Threadee-ID" + (this.id == -1 ? "@" : this.id) + ",Mitarbeiter-ID" + this.herstellerId + ",";

		for (Bauteil t : this.teile) {
			out += t.toString() + ",";
		}

		out = out.substring(0, out.lastIndexOf(','));

		return out;
	}
}
