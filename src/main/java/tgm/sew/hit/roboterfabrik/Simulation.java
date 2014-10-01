package tgm.sew.hit.roboterfabrik;

import java.util.Map;
import java.util.Properties;

import org.apache.commons.cli.ParseException;

import tgm.sew.hit.roboterfabrik.util.RoboterFabrikArgumentParser;

/**
 * Die Main Klasse, die die Simulation startet
 * 
 * @author Burkhard Hampl
 * @version 1.0
 */
public class Simulation {

	/**
	 * @param args
	 *            die Kommandozielenargumente
	 */
	public static void main(String[] args) {
		try {
			Map<String, String> param = RoboterFabrikArgumentParser.parseArgs(args);
			Properties props = System.getProperties();
			props.setProperty("sys.log", ""+param.get("logs"));
			Sekretariat sk = new Sekretariat(Integer.parseInt(param.get("monteure")), Integer.parseInt(param.get("lieferanten")), param.get("lager"));
		} catch (ParseException e) {
			System.err.println("Error while parsing: " + e.getMessage());
			RoboterFabrikArgumentParser.printHalp();
			System.exit(1);
		} catch (NumberFormatException e) {
			System.err.println("Error while parsing: montuere and lieferanten must be int");
			RoboterFabrikArgumentParser.printHalp();
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}
}
