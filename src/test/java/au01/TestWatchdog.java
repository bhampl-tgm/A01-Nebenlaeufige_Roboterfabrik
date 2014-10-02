package au01;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import tgm.sew.hit.roboterfabrik.Lager;
import tgm.sew.hit.roboterfabrik.Threadee;
import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.bauteil.BauteilTyp;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Lagermitarbeiter;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Mitarbeiter;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Montagemitarbeiter;
import tgm.sew.hit.roboterfabrik.util.Watchdog;


public class TestWatchdog {

	@Test
	public void test_constructor(){
		List<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();
		Watchdog w = new Watchdog(1,mitarbeiter);
	}
	
	@Test
	public void test_startThreads(){
		List<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();
		Montagemitarbeiter m =new Montagemitarbeiter(1, new Lagermitarbeiter(1,new Lager("testlager")));
		mitarbeiter.add(m);
		Watchdog w = new Watchdog(1,mitarbeiter);
		w.startThreads();
		assertTrue(m.getGo());
		w.stopThreads();
	}
	
	@Test
	public void test_stopThreads(){
		List<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();
		Montagemitarbeiter m =new Montagemitarbeiter(1, new Lagermitarbeiter(1,new Lager("testlager")));
		mitarbeiter.add(m);
		Watchdog w = new Watchdog(1,mitarbeiter);
		w.startThreads();
		w.stopThreads();
		assertFalse(m.getGo());
	}
	
	@Test
	public void test_getZeit(){
		List<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();
		Watchdog w = new Watchdog(1,mitarbeiter);
		assertEquals(1,w.getZeit());
	}
	
	@Test
	public void test_getThreads(){
		List<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();
		Montagemitarbeiter m =new Montagemitarbeiter(1, new Lagermitarbeiter(1,new Lager("testlager")));
		mitarbeiter.add(m);
		Watchdog w = new Watchdog(1,mitarbeiter);
		assertArrayEquals(mitarbeiter.toArray(), w.getThreads());
	}
}
