/**
 * 
 */
package au01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tgm.sew.hit.roboterfabrik.Lager;
import tgm.sew.hit.roboterfabrik.Threadee;
import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.bauteil.BauteilTyp;

/**
 * Test Klasse fuer {@link Lager}
 * 
 * @author Burkhard Hampl
 * @version 1.0
 */
public class TestLager {

	private Lager l;

	/**
	 * wird zuerst ausgefuehrt
	 */
	@Before
	public void before() {
		this.l = new Lager("test");
	}

	/**
	 * Test des Konstruktors mit einem richtigen Ordner
	 */
	@Test
	public void test_konstruktorRichtig() {
		this.l = new Lager("test");
	}

	/**
	 * Test des Konstruktors mit null
	 */
	@Test
	public void test_konstruktorNull() {
		this.l = new Lager(null);
	}

	/**
	 * Test von {@link Lager#addTeil(tgm.sew.hit.roboterfabrik.bauteil.Bauteil)}
	 * mit {@link Bauteil}
	 */
	@Test
	public void test_addTeil() {
		this.l.addTeil(new Bauteil(BauteilTyp.AUGE, new int[] { 1, 2, 3 }));
		this.l.addTeil(new Bauteil(BauteilTyp.ARM, new int[] { 1, 2, 3 }));
		this.l.addTeil(new Bauteil(BauteilTyp.KETTENANTRIEB, new int[] { 1, 2, 3 }));
		this.l.addTeil(new Bauteil(BauteilTyp.RUMPF, new int[] { 1, 2, 3 }));

	}

	/**
	 * Test von {@link Lager#containsTeil(BauteilTyp, int)} mit {@link Bauteil}
	 */
	@Test
	public void test_containsTeil() {
		assertTrue("containsTeil mit AUGE", this.l.containsTeil(BauteilTyp.AUGE, 1));
		assertTrue("containsTeil mit ARM", this.l.containsTeil(BauteilTyp.ARM, 1));
		assertTrue("containsTeil mit KETTENANTRIEB", this.l.containsTeil(BauteilTyp.KETTENANTRIEB, 1));
		assertTrue("containsTeil mit RUMPF", this.l.containsTeil(BauteilTyp.RUMPF, 1));
	}

	/**
	 * Test von {@link Lager#getBauteil(BauteilTyp)} mit {@link Bauteil}
	 */
	@Test
	public void test_getBauteil() {
		this.l.getBauteil(BauteilTyp.AUGE);
		this.l.getBauteil(BauteilTyp.ARM);
		this.l.getBauteil(BauteilTyp.KETTENANTRIEB);
		this.l.getBauteil(BauteilTyp.RUMPF);
	}
	
	/**
	 * Test von {@link Lager#threadeeAblegen(tgm.sew.hit.roboterfabrik.Threadee)} mit {@link Threadee}
	 */
	@Test
	public void test_threadeeAblegen() {
		this.l.threadeeAblegen("Hallo");
	}
}
