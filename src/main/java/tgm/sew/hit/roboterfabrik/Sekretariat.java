package tgm.sew.hit.roboterfabrik;

import java.util.ArrayList;
import java.util.List;

import tgm.sew.hit.roboterfabrik.mitarbeiter.Lagermitarbeiter;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Lieferant;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Mitarbeiter;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Montagemitarbeiter;
import tgm.sew.hit.roboterfabrik.util.Watchdog;

/**
 * 
 * Sekretariat in welchem die Mitarbeiter und die fertigen {@link Threadee}s
 * 
 * @author Stefan Geyer
 * @author Burkhard Hampl
 * @version 1.0
 */
public class Sekretariat {

	private Lagermitarbeiter lagermitarbeiter;
	private List<Mitarbeiter> montagemitarbeiter;
	private List<Lieferant> lieferant;
	private Lager lager;
	private Watchdog watchdog;

	/**
	 * Konstruktor des Sekretariats
	 *
	 * @param anzahlMontagemitarbeiter
	 *            gibt die Anzahl der {@link Montagemitarbeiter} an
	 * @param anzahlLieferanten
	 *            git die Anzahl der {@link Lieferant} an
	 * @param lagerVerzeichnis
	 *            gibt das {@link Lager} Verzeichnis an
	 */
	public Sekretariat(int anzahlMontagemitarbeiter, int anzahlLieferanten, String lagerVerzeichnis,int laufzeit) {
		this.lager = new Lager(lagerVerzeichnis);
		this.lagermitarbeiter = new Lagermitarbeiter(0, this.lager);
		this.montagemitarbeiter = new ArrayList<Mitarbeiter>();
		this.lieferant = new ArrayList<Lieferant>();
		//TODO watchdog kriegt ein Mitarbeiterarray von allen mitarbeitern udn muss noch gestartet werden

		for (int i = 0; i < anzahlMontagemitarbeiter; i++)
			montagemitarbeiterEinstellen();

		for (int i = 0; i < anzahlLieferanten; i++)
			lieferantEinstellen();
	}

	/**
	 * Getter fuer {@link Lagermitarbeiter}
	 * 
	 * @return den {@link Lagermitarbeiter}
	 */
	public Lagermitarbeiter getLagermitarbeiter() {
		return this.lagermitarbeiter;
	}

	/**
	 * Getter fuer {@link Mitarbeiter}
	 * 
	 * @return {@link List} von allen {@link Mitarbeiter}
	 */
	public List<Mitarbeiter> getMontagemitarbeiter() {
		return this.montagemitarbeiter;
	}

	/**
	 * Getter fuer {@link Montagemitarbeiter}
	 */
	public void montagemitarbeiterEinstellen() {
		this.montagemitarbeiter.add(new Montagemitarbeiter(this.montagemitarbeiter.size() + 1, getLagermitarbeiter()));
	}

	/**
	 * Getter fuer {@link Lieferant}
	 */
	public void lieferantEinstellen() {
		this.lieferant.add(new Lieferant(this.lieferant.size() + 1, getLagermitarbeiter()));

	}

}
