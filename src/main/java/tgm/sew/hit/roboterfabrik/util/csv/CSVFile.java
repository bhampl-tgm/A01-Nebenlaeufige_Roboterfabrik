package tgm.sew.hit.roboterfabrik.util.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * Diese Klasse hat das {@link ExtendedRAF} und die aus dem File geparste
 * {@link CSVData}
 * 
 * @author Stefan Geyer
 * @version 1.0
 */
public class CSVFile {

	private ExtendedRAF raf;

	/**
	 * @param f
	 *            File aus dem gelesen und auf dem schrieben wird.
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
		this.raf.seek(this.raf.length());
		if (this.raf.length() > 0)
			this.raf.writeBytes("\n" + line.toString());
		else
			this.raf.writeBytes(line.toString());
	}

	/**
	 * 
	 * Schreibt ungeparsets CSV ins file
	 * 
	 * @param rawCSV
	 *            CSV String
	 * @throws IOException
	 */
	public void writeRaw(String rawCSV) throws IOException {
		this.raf.seek(this.raf.length());
		if (this.raf.length() > 0)
			this.raf.writeBytes("\n" + rawCSV);
		else
			this.raf.writeBytes(rawCSV);
	}
	
	/**
	 * 
	 * Ueberprueft ob das File eine gewisse anzahl an Zeilen beinhaelt
	 * 
	 * @param amount Die Anzahl der Zeilen
	 * @return Ob das File die Zeilen Enthaelt
	 * @throws IOException
	 */
	public boolean hasLine(int amount) throws IOException {
		return this.raf.hasLine(amount);
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
	public String readAndDeleteLastLine() throws IOException {
		return this.raf.readAndDeleteLastLine();
	}
}
