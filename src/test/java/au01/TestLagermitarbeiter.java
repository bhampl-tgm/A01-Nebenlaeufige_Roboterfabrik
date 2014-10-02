package au01;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import tgm.sew.hit.roboterfabrik.Lager;
import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.bauteil.BauteilTyp;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Lagermitarbeiter;
import tgm.sew.hit.roboterfabrik.util.csv.CSVData;
import tgm.sew.hit.roboterfabrik.util.csv.CSVFile;
import tgm.sew.hit.roboterfabrik.util.csv.CSVLine;


public class TestLagermitarbeiter {
	
	@Test
	public void test_Tid(){
		Lagermitarbeiter l = new Lagermitarbeiter(1, new Lager("testlager"));
		l.setTid(1);
		assertEquals(1,l.getTid());
	}
	
	@Test
	public void test_constructor(){
		Lagermitarbeiter l = new Lagermitarbeiter(1, new Lager("testlager"));
	}
	
	@Test
	public void test_enoughParts(){
		Lagermitarbeiter l = new Lagermitarbeiter(1, new Lager("testlager"));
		assertFalse(l.enoughParts());
	}
	
	@Test
	public void test_enoughParts2(){
		Lager lager = new Lager("testlager");
		Lagermitarbeiter l = new Lagermitarbeiter(1, lager);
		l.teilEinlagern( new Bauteil(BauteilTyp.ARM, new int[] { 7, 8, 9 }));
		l.teilEinlagern( new Bauteil(BauteilTyp.ARM, new int[] { 7, 8, 9 }));
		l.teilEinlagern( new Bauteil(BauteilTyp.AUGE, new int[] { 7, 8, 9 }));
		l.teilEinlagern( new Bauteil(BauteilTyp.AUGE, new int[] { 7, 8, 9 }));
		l.teilEinlagern( new Bauteil(BauteilTyp.RUMPF, new int[] { 7, 8, 9 }));
		l.teilEinlagern( new Bauteil(BauteilTyp.KETTENANTRIEB, new int[] { 7, 8, 9 }));
		assertTrue(l.enoughParts());
	}	
	
	@Test
	public void test_teileBereitstellen(){
		Lagermitarbeiter l = new Lagermitarbeiter(1, new Lager("testlager"));
		l.teileBereitstellen();
	}
	
	@Test
	public void test_teileBereitstellen2(){
		Lager lager = new Lager("testlager2");
		lager.addTeil( new Bauteil(BauteilTyp.ARM, new int[] { 7, 8, 9 }));
		lager.addTeil( new Bauteil(BauteilTyp.ARM, new int[] { 7, 8, 9 }));
		lager.addTeil( new Bauteil(BauteilTyp.AUGE, new int[] { 7, 8, 9 }));
		lager.addTeil( new Bauteil(BauteilTyp.AUGE, new int[] { 7, 8, 9 }));
		lager.addTeil( new Bauteil(BauteilTyp.RUMPF, new int[] { 7, 8, 9 }));
		lager.addTeil( new Bauteil(BauteilTyp.KETTENANTRIEB, new int[] { 7, 8, 9 }));
		Lagermitarbeiter l = new Lagermitarbeiter(1,lager);
		l.teileBereitstellen();
		
	}
	
}
