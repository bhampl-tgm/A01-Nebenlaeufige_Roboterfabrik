/**
 * 
 */
package au01;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import tgm.sew.hit.roboterfabrik.Threadee;
import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.bauteil.BauteilTyp;

/**
 * Test Klasse fuer {@link Threadee}
 * 
 * @author Burkhard Hampl
 * @version 1.0
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestThreadee {

	private static Threadee t;
	private static int id;
	private static int herstelletId;
	private static Bauteil[] teile;
	
	/**
	 * 
	 */
	@BeforeClass
	public static void before() {
		t = null;
		id = 0;
		herstelletId = 0;
		teile = null;
	}
	
	
	/**
	 * Testen des Konstruktors
	 */
	@Test
	public void test_aThreadee() {
		TestThreadee.id = 123;
		TestThreadee.herstelletId = 456;
		TestThreadee.teile = new Bauteil[] { new Bauteil(BauteilTyp.ARM, new int[] { 7, 8, 9 }) };
		TestThreadee.t = new Threadee(id, herstelletId, teile);
	}
	
	/**
	 * Testen von {@link Threadee#getId()}
	 */
	@Test
	public void test_bGetId() {
		assertEquals(TestThreadee.id,TestThreadee.t.getId());
	}
	
	/**
	 * Testen von {@link Threadee#getHerstellerId()}
	 */
	@Test
	public void test_cGetHerstellerId() {
		assertEquals(TestThreadee.herstelletId,TestThreadee.t.getHerstellerId());
	}
	
	/**
	 * Testen von {@link Threadee#getBauteile()}
	 */
	@Test
	public void test_dGetBauteile() {
		assertArrayEquals(TestThreadee.teile,TestThreadee.t.getBauteile());
	}
	
	/**
	 * Testen von {@link Threadee#toString()}
	 */
	@Test
	public void test_dToString() {
		assertEquals("Threadee-ID123,Mitarbeiter-ID456," + TestThreadee.teile[0].toString(),TestThreadee.t.toString());
	}
	
	/**
	 * Testen von {@link Threadee#toString()} mit @
	 */
	@Test
	public void test_dToStringMitAt() {
		TestThreadee.t = new Threadee(-1, herstelletId, teile);
		assertEquals("Threadee-ID@,Mitarbeiter-ID456," + TestThreadee.teile[0].toString(),TestThreadee.t.toString());
	}

}
