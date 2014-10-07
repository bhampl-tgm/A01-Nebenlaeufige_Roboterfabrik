package tgm.sew.hit.roboterfabrik;

import java.io.File;
import java.util.Map;

import org.apache.commons.cli.ParseException;

import tgm.sew.hit.roboterfabrik.util.FileUtils;
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
			FileUtils.removeRecursive(new File(param.get("lager")));
			System.setProperty("log", "" + param.get("logs"));
			new Sekretariat(Integer.parseInt(param.get("monteure")), Integer.parseInt(param.get("lieferanten")), param.get("lager"), Integer.parseInt(param.get("laufzeit")));
		} catch (ParseException e) {
			RoboterFabrikArgumentParser.printHelp();
			System.exit(1);
		} catch (NumberFormatException e) {
			RoboterFabrikArgumentParser.printHelp();
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}
}
