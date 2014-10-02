package tgm.sew.hit.roboterfabrik.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Ein Argumenten Parser fuer die RoboterFabrik
 * 
 * @author Burkhard Hampl
 * @version 1.0
 */
public class RoboterFabrikArgumentParser {

	/**
	 * Commandline {@link Options}
	 */
	public static final Options options = new Options();

	/**
	 * Parst die angegebenen argumente in eine {@link Map}
	 * 
	 * @param args
	 *            argumente, die geparst werde soll
	 * @return eine {@link Map}, die alle fuer uns notwendige Parameter
	 *         zurueckgibt
	 * @throws ParseException
	 *             Wenn ein fehler beim parsen auftetet
	 */
	@SuppressWarnings("static-access")
	public static Map<String, String> parseArgs(String[] args) throws ParseException {
		Map<String, String> pars = new HashMap<String, String>();

		// Defenieren der notwendigen Parameter
		Option lagerdir = OptionBuilder.isRequired().withLongOpt("lager").withDescription("Das Verzeichnis in welches das Lager gespeichert wird").hasArg().withArgName("verzeichnis").create();
		Option logDir = OptionBuilder.isRequired().withLongOpt("logs").withDescription("Das Verzeichnis in welches die Logs gespeichert werden").hasArg().withArgName("verzeichnis").create();
		Option anzahlLieferanten = OptionBuilder.isRequired().withLongOpt("lieferanten").withDescription("Anzahl an Lieferanten die Teile ans Lager liefern").hasArg().withArgName("anzahl").create();
		Option anazhlMonteure = OptionBuilder.isRequired().withLongOpt("monteure").withDescription("Anzahl der Menteure die gleichzeitig Threadees bauen").hasArg().withArgName("anzahl").create();
		Option dauerLaufzeit = OptionBuilder.isRequired().withLongOpt("laufzeit").withDescription("Dauer der Laufzeit").hasArg().withArgName("zeit").create();

		// Hinzufuegen zu den Options
		options.addOption(lagerdir);
		options.addOption(logDir);
		options.addOption(anzahlLieferanten);
		options.addOption(anazhlMonteure);
		options.addOption(dauerLaufzeit);

		CommandLineParser parser = new BasicParser();
		CommandLine line = null;
		// parsen der Argumente
		line = parser.parse(options, args);

		// zur Hashmap hinzufuegen
		pars.put("lager", line.getOptionValue("lager"));
		pars.put("logs", line.getOptionValue("logs"));
		pars.put("lieferanten", line.getOptionValue("lieferanten"));
		pars.put("monteure", line.getOptionValue("monteure"));
		pars.put("laufzeit", line.getOptionValue("laufzeit"));

		return pars;
	}

	/**
	 * Gibt den Helptext aus
	 */
	public static void printHelp() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("Simulation der RoboterFabrik", RoboterFabrikArgumentParser.options);
	}
}
