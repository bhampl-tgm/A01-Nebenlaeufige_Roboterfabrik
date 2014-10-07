package tgm.sew.hit.roboterfabrik.bauteil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Erweitertes {@link Bauteil} Array welches auf gueltigkeit ueberprueft werden
 * kann
 * 
 * @author Stefan Geyer
 * @version 1.0
 */
public class BauteilSammlung {

	private List<Bauteil> teile;

	public BauteilSammlung(Bauteil... teile) {
		this.teile = Arrays.asList(teile);
	}

	/**
	 * 
	 * Ueberprueft ob ein Teil mit dem angegebenen Teiltyp in den Teilen
	 * vorhanden ist
	 * 
	 * @param t
	 *            Der Teiltyp
	 * @return Ob der Typ vorhanden ist oder nicht
	 */
	private boolean containsBauteilTyp(BauteilTyp t) {
		return this.containsBauteilTyp(t, 1);
	}

	/**
	 * 
	 * Ueberprueft ob ein Teil mit dem angegebenen Teiltyp in den Teilen
	 * vorhanden ist.
	 * 
	 * @param t
	 *            Der Teiltyp
	 * @param amount
	 *            Wie oft mindestens
	 * @return Ob der Typ vorhanden ist oder nicht
	 */
	private boolean containsBauteilTyp(BauteilTyp t, int amount) {
		List<Bauteil> passende = new ArrayList<Bauteil>();

		for (Bauteil b : this.teile) {
			if (b != null) {
				if (b.getTyp() == t) {
					passende.add(b);
				}
			}
		}

		return (passende.size() >= amount);
	}

	/**
	 * 
	 * Ueberprueft ob die Teile mindestens ein Teil pro Typ enthalten
	 * 
	 * @return Ob alle Typen vorhanden sind
	 */
	public boolean isValid() {
		boolean valid = true;

		if (this.teile != null) {
			if (!containsBauteilTyp(BauteilTyp.AUGE, 2) || !containsBauteilTyp(BauteilTyp.ARM, 2) || !containsBauteilTyp(BauteilTyp.KETTENANTRIEB) || !containsBauteilTyp(BauteilTyp.RUMPF))
				valid = false;

			return valid;
		} else
			return false;
	}

	public Bauteil[] getTeile() {
		return this.teile.toArray(new Bauteil[0]);
	}
}
