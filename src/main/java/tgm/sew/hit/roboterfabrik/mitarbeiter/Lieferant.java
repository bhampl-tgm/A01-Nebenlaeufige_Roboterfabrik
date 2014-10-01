package tgm.sew.hit.roboterfabrik.mitarbeiter;

import java.util.Random;

import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.bauteil.BauteilTyp;

/**
 * 
 * Lieferant der ein Teil ans Lager liefert. Die Klasse simuliert das erhalten
 * eines weitern Teils durch das aufrufen von neuesTeil()
 * 
 * @author Stefan Geyer, pmalik
 * @version 1.0
 */
public class Lieferant {

	private int id;
	private boolean go;

	public Lieferant(int id) {
		this.id = id;
	}

	/**
	 *
	 * Uebergibt dem Lieferanten ein neues Teil mit zufaelligem typ und
	 * zufaellingen daten
	 * 
	 */
	public Bauteil neuesTeil() {
		BauteilTyp typ = BauteilTyp.values()[new Random().nextInt(BauteilTyp.values().length)];
		int[] data = new int[20];

		// daten mit zufaelligen Zahlen auffuellen
		for (int i = 0; i < 20; i++) {
			data[i] = new Random().nextInt(1000);
		}

		Mitarbeiter.getLogger().trace("" + getClass() + " " + getId() + " hat das Bauteil " + typ.getName() + " geliefert.");
		return new Bauteil(typ, data);
	}

	public int getId() {
		return this.id;
	}

	public void setGo(boolean go) {
		this.go = go;
	}
}
