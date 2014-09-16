package tgm.sew.hit.roboterfabrik;

import java.util.List;

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
