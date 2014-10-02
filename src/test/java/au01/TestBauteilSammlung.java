/**
 * 
 */
package au01;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import tgm.sew.hit.roboterfabrik.Threadee;
import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.bauteil.BauteilSammlung;
import tgm.sew.hit.roboterfabrik.bauteil.BauteilTyp;

/**
 * Tests fuer {@link BauteilSammlung}
 * 
 * @author Burkhard Hampl
 * @version 1.0
 *
 */
public class TestBauteilSammlung {

	private static BauteilSammlung s;
	private static Bauteil[] teile;

	/**
	 * Testvorbereitungs Methode
	 */
	@BeforeClass
	public static void beforeClass() {
		TestBauteilSammlung.s = null;
		TestBauteilSammlung.teile = null;
	}

	/**
	 * Test von
	 * {@link BauteilSammlung#BauteilSammlung(tgm.sew.hit.roboterfabrik.bauteil.Bauteil...)}
	 */
	@Test
	public void test_bauteikSammlung() {
		TestBauteilSammlung.teile = new Bauteil[] { new Bauteil(BauteilTyp.ARM, new int[] { 1, 2, 3 }), new Bauteil(BauteilTyp.ARM, new int[] { 1, 2, 3 }), new Bauteil(BauteilTyp.AUGE, new int[] { 1, 2, 3 }), new Bauteil(BauteilTyp.AUGE, new int[] { 1, 2, 3 }), new Bauteil(BauteilTyp.KETTENANTRIEB, new int[] { 1, 2, 3 }), new Bauteil(BauteilTyp.RUMPF, new int[] { 1, 2, 3 }) };
		TestBauteilSammlung.s = new BauteilSammlung(TestBauteilSammlung.teile);
	}

	/**
	 * Test von {@link BauteilSammlung#isValid()}
	 */
	@Test
	public void test_containsBauteilTyp() {
		assertTrue(TestBauteilSammlung.s.isValid());
	}

	/**
	 * Test von
	 * {@link BauteilSammlung#getTeile()}
	 */
	@Test
	public void test_containsB() {
		assertArrayEquals(TestBauteilSammlung.teile, TestBauteilSammlung.s.getTeile());
	}
}
