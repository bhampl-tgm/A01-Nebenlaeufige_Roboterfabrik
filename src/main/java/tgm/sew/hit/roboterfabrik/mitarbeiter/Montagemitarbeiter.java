package tgm.sew.hit.roboterfabrik.mitarbeiter;

import java.util.List;
import java.util.UUID;

import tgm.sew.hit.roboterfabrik.Threadee;
import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;

public class Montagemitarbeiter extends Mitarbeiter {

	private List<Bauteil> parts;

	public Montagemitarbeiter() {
		super(UUID.randomUUID());
	}

	public Threadee buildThreadee() {
		return null;
	}

}
