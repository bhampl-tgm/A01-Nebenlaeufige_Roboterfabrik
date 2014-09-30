package tgm.sew.hit.roboterfabrik.mitarbeiter;

import java.util.Random;

import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.bauteil.BauteilTyp;

/**
 * 
 * Lieferant der ein Teil ans Lager liefert.
 * Die Klasse simuliert das erhalten eines weitern Teils
 * durch das aufrufen von neuesTeil()
 * 
 * @author Stefan Geyer
 * @version 1.0
 */
public class Lieferant {

	private Bauteil teil;
	
	public Bauteil getTeil() {
		neuesTeil();
		return this.teil;
	}
	
	/**
	 *
	 * Uebergibt dem Lieferanten ein neues Teil mit zufaelligem typ 
	 * und zufaellingen daten
	 * 
	 */
	public void neuesTeil() {
		BauteilTyp typ = BauteilTyp.values()[new Random().nextInt(BauteilTyp.values().length)];
		int[] data = new int[20];
		
		// daten mit zufaelligen Zahlen auffuellen
		for (int i = 0; i < 20; i++) {
			data[i] = new Random().nextInt(1000);
		}
		
		this.teil = new Bauteil(typ, data);
	}

}
