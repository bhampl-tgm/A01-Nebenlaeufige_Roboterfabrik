package au01;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import tgm.sew.hit.roboterfabrik.Lager;
import tgm.sew.hit.roboterfabrik.Sekretariat;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Lagermitarbeiter;
import tgm.sew.hit.roboterfabrik.mitarbeiter.Montagemitarbeiter;
import tgm.sew.hit.roboterfabrik.util.csv.CSVData;
import tgm.sew.hit.roboterfabrik.util.csv.CSVFile;
import tgm.sew.hit.roboterfabrik.util.csv.CSVLine;


public class TestSekretariat {

	@Test
	public void test_constructor(){
		new Sekretariat(1,1,"testlager",1000);
	}
	
	@Test
	public void test_getLagermitarbeiter(){
		Sekretariat s = new Sekretariat(1,1,"testlager",1000);
		assertEquals(new Lagermitarbeiter(0, new Lager("testlager")), s.getLagermitarbeiter());
	}
	
	@Test
	public void test_getMontagemitarbeiter(){
		
		Sekretariat s = new Sekretariat(0,1,"testlager",1000);
		s.montagemitarbeiterEinstellen();
		Lager l = new Lager("testlager");
		Lagermitarbeiter lm = new Lagermitarbeiter(0,l);
		Montagemitarbeiter m = new Montagemitarbeiter(1, lm);
		Montagemitarbeiter mtest =  s.getMontagemitarbeiter().get(0);
		assertEquals(m, mtest);
	}
	
}
