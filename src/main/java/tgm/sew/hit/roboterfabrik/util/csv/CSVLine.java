package tgm.sew.hit.roboterfabrik.util.csv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Sammlung von Strings die mit dem speperator getrennt werden
 * 
 * @author Stefan Geyer
 * @version 1.0
 */
public class CSVLine {

	private List<String> items;
	private char seperator;
	
	public CSVLine(String... items) {
		this.items =  new ArrayList<String>();
		this.items.addAll(Arrays.asList(items));
		this.seperator = ',';
	}
	
	public CSVLine(char seperator, String... items) {
		this(items);
		this.seperator = seperator;
	}
	
	/**
	 * 
	 * Splitet einen String nach dem angegbenen seperator auf.
	 * 
	 * @param line String der aufgesplittet wird
	 * @param seperator Zeichen nach welchen gesplittet wird
	 * @return Die konvertierte {@link CSVLine}
	 */
	public static CSVLine parseLine(String line, char seperator) {
		return (line != null ? new CSVLine(line.split(seperator + "")) : new CSVLine(new String[0]));
	}
	
	public void addItem(String s) {
		this.items.add(s);
	}
	
	public String[] getItems() {
		return this.items.toArray(new String[0]);
	}
	
	public char getSeperator() {
		return seperator;
	}

	public void setSeperator(char seperator) {
		this.seperator = seperator;
	}

	/**
	 * 
	 * Fuegt alle items durch den seperator getrennt zusammen
	 * 
	 */
	public String toString() {
		String out = "";
		
		for (String s : items)
			out += s + ",";
		out = out.substring(0, out.lastIndexOf(','));
		
		return out;
	}
}
