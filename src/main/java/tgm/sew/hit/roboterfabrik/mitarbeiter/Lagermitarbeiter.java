package tgm.sew.hit.roboterfabrik.mitarbeiter;

import java.util.List;

import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;

public class Lagermitarbeiter extends Mitarbeiter {

	public Lagermitarbeiter(int id) {

	}

	public boolean enoughParts() {
		return false;
	}

	public List<Bauteil> teileBereitstellen() {
		return null;
	}

	public void teileEinlagern(Bauteil[] teile) {

	}

}
