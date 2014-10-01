package au01;

import org.junit.Test;

import tgm.sew.hit.roboterfabrik.Lager;
import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Lagermitarbeiter;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Lieferant;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestLieferant {

	
	@Test
	public void test_getID(){
		Lieferant l = new Lieferant(1, new Lagermitarbeiter(1, new Lager(new String())));
		assertEquals(1, l.getId());
	}
	
	@Test
	public void test_neuesTeilData(){
		Lieferant l = new Lieferant(1, new Lagermitarbeiter(1, new Lager(new String())));
		Bauteil b = l.neuesTeil();
		assertNotNull(b.getData());
	}
	
	@Test
	public void test_neuesTeilTyp(){
		Lieferant l = new Lieferant(1, new Lagermitarbeiter(1, new Lager(new String())));
		Bauteil b = l.neuesTeil();
		assertNotNull(b.getTyp());
	}
	
	@Test
	public void test_Go(){
		Lieferant l = new Lieferant(1, new Lagermitarbeiter(1, new Lager(new String())));
		assertTrue(l.getGo());
	}
	
	
}
