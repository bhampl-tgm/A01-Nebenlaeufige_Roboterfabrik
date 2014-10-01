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
		b.toString();
	}
	
	@Test
	public void testBauteil2() {
		Bauteil pB = Bauteil.parseCSVString(null);
		pB = Bauteil.parseCSVString("Arm,0,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9");
	}
	
	@Test(expected=NumberFormatException.class)
	public void testBauteil3() {
		Bauteil pB = Bauteil.parseCSVString(null);
		pB = Bauteil.parseCSVString("Arm,0,bla");
	}

}
