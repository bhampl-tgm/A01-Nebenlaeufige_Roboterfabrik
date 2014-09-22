package tgm.sew.hit.roboterfabrik.util;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class RoboterFabrikArgumentParser {
	
	@SuppressWarnings("static-access")
	public static CommandLine parseArgs(String[] args) {
		Options options = new Options();
		Option logDir = OptionBuilder.withArgName("-logs").withDescription("Das Verzeichnis in welches die Logs gespeichert werden").hasArg().create(); //new Option("-logs", "Das Verzeichnis in welches die Logs gespeichert werden");
		Option anzahlLieferanten = OptionBuilder.withArgName("-lieferanten").withDescription("Anzahl an Lieferanten die Teile ans Lager liefern").hasArg().create(); //new Option("-lieferanten", "Anzahl an Lieferanten die Teile ans Lager liefern");
		Option anazhlMonteure = OptionBuilder.withArgName("-monteure").withDescription("Anzahl der Menteure die gleichzeitig Threadees bauen").hasArg().create(); //new Option("-monteure", "Anzahl der Monteure die gleichzeitig Threadees bauen");
		Option dauerLaufzeit = OptionBuilder.withArgName("-laufzeit").withDescription("Dauer der Laufzeit").hasArg().create(); //new Option("-laufzeit", "Dauer der Laufzeit");
		options.addOption(logDir);
		options.addOption(anzahlLieferanten);
		options.addOption(anazhlMonteure);
		options.addOption(dauerLaufzeit);
		
		CommandLineParser parser = new BasicParser();
		CommandLine line = null;
	    try {
			line = parser.parse(options, args);
		} catch (ParseException e) {
			System.err.println("Error while parsing: " + e.getMessage());
		}
	    
	    return line;
	}
}
