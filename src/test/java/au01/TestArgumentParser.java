/**
 * 
 */
package au01;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.cli.ParseException;
import org.junit.Test;

import tgm.sew.hit.roboterfabrik.util.RoboterFabrikArgumentParser;

/**
 * Test Cases fuer {@link RoboterFabrikArgumentParser}
 * 
 * @author Burkhard Hampl
 *
 */
public class TestArgumentParser {

	/**
	 * Test fure den {@link RoboterFabrikArgumentParser}
	 */
	@Test
	public void test_parseArgsRichtig() {
		String[] args = { "-lager", "/verzeichnis/zum/lager", "--logs", "/verzeichnis/zum/loggen", "--lieferanten", "12", "--monteure", "25", "--laufzeit", "10000" };
		Map<String, String> argsmap = null;
		try {
			argsmap = RoboterFabrikArgumentParser.parseArgs(args);
		} catch (ParseException e) {
			e.printStackTrace();
			fail("Exception");
		}
		Map<String, String> exmap = new HashMap<String, String>();
		exmap.put("lager", "/verzeichnis/zum/lager");
		exmap.put("logs", "/verzeichnis/zum/loggen");
		exmap.put("lieferanten", "12");
		exmap.put("monteure", "25");
		exmap.put("laufzeit", "10000");
		assertEquals("Parser arbeitet nicht Richtig", exmap, argsmap);
	}

	/**
	 * Test fure den {@link RoboterFabrikArgumentParser}
	 * 
	 * @throws ParseException
	 */
	@Test(expected = ParseException.class)
	public void test_parseArgsFalsch() throws ParseException {
		String[] args = { "-lager", "/verzeichnis/zum/lager", "--lieferanten", "12", "--monteure", "25", "--laufzeit", "10000" };
		RoboterFabrikArgumentParser.parseArgs(args);
		fail("Keine Exception");
	}

}
