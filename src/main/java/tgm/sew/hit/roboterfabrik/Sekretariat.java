package tgm.sew.hit.roboterfabrik;

import java.util.ArrayList;
import java.util.List;

import tgm.sew.hit.roboterfabrik.mitarbeiter.Lagermitarbeiter;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Lieferant;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Mitarbeiter;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Montagemitarbeiter;

/**
 * 
 * Sekretariat in welchem die Mitarbeiter und die fertigen {@link Threadee}s
 * 
 * @author Stefan Geyer
 * @author Burkhard Hampl
 * @version 1.0
 */
public class Sekretariat {

	private Mitarbeiter lagermitarbeiter;
	private List<Mitarbeiter> montagemitarbeiter;
	private List<Threadee> threadees;
	private List<Lieferant> lieferant;
	private Lager lager;

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
	public Sekretariat(int anzahlMontagemitarbeiter, int anzahlLieferanten, String lagerVerzeichnis) {

		this.lager = new Lager(lagerVerzeichnis);
		this.lagermitarbeiter = new Lagermitarbeiter(0, this.lager);
		this.montagemitarbeiter = new ArrayList<Mitarbeiter>();
		this.threadees = new ArrayList<Threadee>();
		this.lieferant = new ArrayList<Lieferant>();

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
	public Mitarbeiter getLagermitarbeiter() {
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
	 * Getter fuer {@link Threadee}
	 * 
	 * @return {@link List} von allen {@link Threadee}
	 */
	public List<Threadee> getFertigeThreadees() {
		return this.threadees;
	}

	/**
	 * Getter fuer {@link Montagemitarbeiter}
	 */
	public void montagemitarbeiterEinstellen() {
		this.montagemitarbeiter.add(new Montagemitarbeiter(this.montagemitarbeiter.size() + 1));
	}

	/**
	 * Getter für {@link Lieferant}
	 */
	public void lieferantEinstellen() {
		this.lieferant.add(new Lieferant(this.lieferant.size() + 1));

	}

}
