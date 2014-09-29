package tgm.sew.hit.roboterfabrik;

import java.util.ArrayList;
import java.util.List;

import tgm.sew.hit.roboterfabrik.mitarbeiter.Mitarbeiter;
import tgm.sew.hit.roboterfabrik.mitarbeiter.MitarbeiterTyp;

public class Sekretariat {

	private Mitarbeiter lagermitarbeiter;
	private List<Mitarbeiter> montagemitarbeiter;

	private List<Threadee> threadees;

	public Sekretariat(int anzahlMontagemitarbeiter) {
		this.lagermitarbeiter = new Mitarbeiter(MitarbeiterTyp.LAGER, 0);
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
		this.montagemitarbeiter.add(new Mitarbeiter(MitarbeiterTyp.MONTAGE, this.montagemitarbeiter.size() + 1));
	}

}
