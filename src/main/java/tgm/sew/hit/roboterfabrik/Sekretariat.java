package tgm.sew.hit.roboterfabrik;

import java.util.ArrayList;
import java.util.List;

import tgm.sew.hit.roboterfabrik.mitarbeiter.Lagermitarbeiter;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Mitarbeiter;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Montagemitarbeiter;

/**
 * 
 * Sekretariat in welchem die Mitarbeiter und die fertigen {@link Threadee}s
 * 
 * @author Stefan Geyer
 * @version 1.0
 */
public class Sekretariat {

	private Mitarbeiter lagermitarbeiter;
	private List<Mitarbeiter> montagemitarbeiter;

	private List<Threadee> threadees;
	
	private Lager lager;

	public Sekretariat(int anzahlMontagemitarbeiter, String lagerVerzeichnis) {
		this.lager = new Lager(lagerVerzeichnis);
		this.lagermitarbeiter = new Lagermitarbeiter(0, this.lager);
		this.montagemitarbeiter = new ArrayList<Mitarbeiter>();
		this.threadees = new ArrayList<Threadee>();

		for (int i = 0; i < anzahlMontagemitarbeiter; i++)
			montagemitarbeiterEinstellen();
	}

	public Mitarbeiter getLagermitarbeiter() {
		return this.lagermitarbeiter;
	}

	public List<Mitarbeiter> getMontagemitarbeiter() {
		return this.montagemitarbeiter;
	}

	public List<Threadee> getFertigeThreadees() {
		return this.threadees;
	}

	public void montagemitarbeiterEinstellen() {
		this.montagemitarbeiter.add(new Montagemitarbeiter(this.montagemitarbeiter.size() + 1));
	}

}
