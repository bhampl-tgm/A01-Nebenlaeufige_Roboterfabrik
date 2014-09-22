package tgm.sew.hit.roboterfabrik.mitarbeiter;

import java.util.List;

import tgm.sew.hit.roboterfabrik.Threadee;
import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;

public class Montagemitarbeiter extends Mitarbeiter {

	private List<Bauteil> parts;

	public Montagemitarbeiter(int id) {
		super(id);
	}

	public Threadee buildThreadee() {
		return null;
	}

}
