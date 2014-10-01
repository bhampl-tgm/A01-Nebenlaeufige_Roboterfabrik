package tgm.sew.hit.roboterfabrik.util.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * Diese Klasse hat das {@link ExtendedRAF} und die aus dem File geparste {@link CSVData}
 * 
 * @author Stefan Geyer
 * @version 1.0
 */
public class CSVFile {

	private ExtendedRAF raf;

	/**
	 * @param f File aus dem gelesen und auf dem schrieben wird.
	 */
	public CSVFile(File f) {
		try {
			this.raf = new ExtendedRAF(f, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Schreibt eine {@link CSVLine} ins File
	 * 
	 * @param line
	 *            CSV die ins File gespeichert wird.
	 * @throws IOException
	 */
	public void writeLine(CSVLine line) throws IOException {
		this.raf.writeBytes(line.toString() + "\r\n");
	}
	
	/**
	 * 
	 * Schreibt ungeparsets CSV ins file
	 * 
	 * @param rawCSV CSV String
	 * @throws IOException 
	 */
	public void writeRaw(String rawCSV) throws IOException {
		this.raf.writeBytes(rawCSV + "\r\n");
	}

	/**
	 * Liesst die laetzte Zeile aus dem File
	 * 
	 * @return Die letzte Zeile als {@link CSVLine} geparst
	 * @throws IOException
	 */
	public CSVLine getLastLine() throws IOException {
		return CSVLine.parseLine(this.raf.readLastLine(), ',');
	}

	/**
	 * Loescht die Letzte Zeile aus dem File
	 * 
	 * @throws IOException
	 */
	public void deleteLastLine() throws IOException {
		this.raf.deleteLastLine();
	}
}
