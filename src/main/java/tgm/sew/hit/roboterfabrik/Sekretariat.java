package tgm.sew.hit.roboterfabrik;

import java.util.List;

import tgm.sew.hit.roboterfabrik.mitarbeiter.Lagermitarbeiter;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Montagemitarbeiter;

public class Sekretariat {

	private Lagermitarbeiter lagermitarbeiter;

	private List<Montagemitarbeiter> montagemitarebiter;

	private List<Threadee> threadees;

	public Sekretariat(int anzahlMontagemitarbeiter) {
		this.lagermitarbeiter = new Lagermitarbeiter(0);
	}

	public Lagermitarbeiter getLagermitarbeiter() {
		return null;
	}

	public List<Montagemitarbeiter> getMontagemitarbeiter() {
		return null;
	}

	public List<Threadee> getFertigeThreadees() {
		return null;
	}

	public void montagemitarbeiterEinstellen() {

	}

}
