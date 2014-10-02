package au01;


import org.junit.Test;

import tgm.sew.hit.roboterfabrik.Lager;
import tgm.sew.hit.roboterfabrik.Threadee;
import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.bauteil.BauteilTyp;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Lagermitarbeiter;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Lieferant;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Montagemitarbeiter;
import static org.junit.Assert.*;

import org.junit.Test;




public class TestMontagemitarbeiter {

	@Test
	public void test_constructor(){
		Montagemitarbeiter m = new Montagemitarbeiter(1,new Lagermitarbeiter(1, new Lager("lager")));
	}
	
	@Test
	public void test_baueThreadee(){
		Montagemitarbeiter m = new Montagemitarbeiter(1,new Lagermitarbeiter(1, new Lager("lager")));
		Bauteil[] teile = new Bauteil[] {new Bauteil(BauteilTyp.ARM, new int[] { 7, 8, 9 }),new Bauteil(BauteilTyp.ARM, new int[] { 7, 8, 9 }),new Bauteil(BauteilTyp.AUGE, new int[] { 7, 8, 9 }),new Bauteil(BauteilTyp.AUGE, new int[] { 7, 8, 9 }),new Bauteil(BauteilTyp.KETTENANTRIEB, new int[] { 7, 8, 9 }),new Bauteil(BauteilTyp.RUMPF, new int[] { 7, 8, 9 })};;
		m.baueThreadee(teile);
	}
	
	@Test
	public void test_run(){
		Montagemitarbeiter m = new Montagemitarbeiter(1,new Lagermitarbeiter(1, new Lager("lager")));
		m.setGo(false);
		m.run();
	}
	
}
