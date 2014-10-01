package tgm.sew.hit.roboterfabrik;

import java.util.Map;

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
			Sekretariat sk = new Sekretariat(Integer.parseInt(param.get("monteure")), param.get("lager"));
		} catch (ParseException e) {
			System.err.println("Error while parsing: " + e.getMessage());
			System.exit(1);
		} catch (NumberFormatException e) {
			System.err.println("Error while parsing: montuere must be int");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
