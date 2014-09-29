package tgm.sew.hit.roboterfabrik;

import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;

public class Threadee {

	private int id;
	private int herstellerId;

	private Bauteil[] teile;
	
	public Threadee(int id, int herstellerId, Bauteil[] teile) {
		this.id = id;
		this.herstellerId = herstellerId;
		this.teile = teile;
	}

	public Bauteil[] getBauteile() {
		return this.teile;
	}

	public int getId() {
		return this.id;
	}

	public int getHerstellerId() {
		return this.herstellerId;
	}

}
