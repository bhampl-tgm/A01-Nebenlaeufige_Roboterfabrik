package au01;

import static org.junit.Assert.*;

import org.junit.Test;

import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.bauteil.BauteilTyp;

public class TestBauteil {

	@Test
	public void testBauteil1() {
		Bauteil b = new Bauteil(BauteilTyp.AUGE, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		b.getData();
		b.setData(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		b.getTyp();
		b.setTyp(BauteilTyp.ARM);
		assertEquals("Arm,0,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9", b.toString());
	}
	
	@Test
	public void testBauteil2() {
		Bauteil.parseCSVString(null);
	}
	
	@Test
	public void testBauteil3() {
		Bauteil.parseCSVString("Arm,0,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9");
	}
	
	@Test
	public void testBauteil4() {
		Bauteil.parseCSVString("Arm,0,bla");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testBauteil5() {
		Bauteil.parseCSVString("Test,0,1");
	}

}
