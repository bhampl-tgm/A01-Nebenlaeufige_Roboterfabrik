package tgm.sew.hit.roboterfabrik.mitarbeiter;

import java.util.UUID;

public abstract class Mitarbeiter {

	private UUID id;

	public Mitarbeiter(UUID id) {
		this.id = id;
	}
	
	public UUID getId() {
		return this.id;
	}

}
