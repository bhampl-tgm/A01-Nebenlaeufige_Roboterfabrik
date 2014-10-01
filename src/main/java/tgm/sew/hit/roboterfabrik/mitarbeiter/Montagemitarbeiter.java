package tgm.sew.hit.roboterfabrik.mitarbeiter;

import tgm.sew.hit.roboterfabrik.Threadee;
import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.bauteil.BauteilSammlung;

/**
 * 
 * Der Montagemitarbeiter dient nur dazu die Teile die ihm uebergeben werden zusammenzusetzen
 * 
 * @author Stefan Geyer
 * @version 1.0
 */
public class Montagemitarbeiter extends Mitarbeiter {

	public Montagemitarbeiter(int id) {
		super(id);
	}

	/**
	 * 
	 * Simuliert das zusammenbauen des Threadees sofern alle Teile vorhanden sind.
	 * 
	 * @param teile Teile die zusammengebaut werden
	 * @param threadeeId Die ID die dem Threadee zugewiesen werden soll.
	 * @return Der fertige Threadee
	 */
	public Threadee baueThreadee(Bauteil[] teile, int threadeeId) {
		if (new BauteilSammlung(teile).isValid()) {
			getLogger().trace(""+getClass()+" "+getId()+" hat den Threadee mit der ID:"+threadeeId+"fertiggestellt.");
			return new Threadee(threadeeId, getId(), teile);
		}
		
		return null;
	}
}
