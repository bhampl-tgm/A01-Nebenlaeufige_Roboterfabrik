package tgm.sew.hit.roboterfabrik.util.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * Erwitert das {@link RandomAccessFile} um die Moeglichkeit die letzte Zeile zu
 * lesen und zu loeschen.
 * 
 * @author Stefan Geyer
 * @version 1.0
 */
public class ExtendedRAF extends RandomAccessFile {

	private File file;
	
	public ExtendedRAF(File file, String mode) throws FileNotFoundException {
		super(file, mode);
		this.file = file;
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
		if (amount > -1) {
			BufferedReader br = new BufferedReader(new FileReader(this.file));
			for (int i = 0; i < amount; i++) {
				if (br.readLine() == null) {
					br.close();
					return false;
				}
			}
			
			br.close();
			return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * Liesst die letzte Zeile aus einem File
	 * 
	 * @return Die letzte Zeile
	 * @throws IOException
	 */
	public String readLastLine() throws IOException {
		long length = this.length() - 1;
		StringBuilder sb = new StringBuilder();
		long cursor = 0;
		for (cursor = length; cursor != -1; cursor -= 1) {
			this.seek(cursor);
			byte readByte = this.readByte();
			if (readByte == 10) {
				break;
			}
			sb.append((char) readByte);
		}
		
		if (cursor == -1) {
			this.setLength(0);
		} else {
			this.setLength(cursor);
		}
		String line = sb.reverse().toString();
		if (line.equals("")) {
			return null;
		}

		return sb.reverse().toString();
	}

	/**
	 * 
	 * Loescht die letzte Zeile aus einem File
	 * 
	 * @throws IOException
	 */
	public String readAndDeleteLastLine() throws IOException {
		long length = this.length();
		StringBuffer sb = new StringBuffer();
		byte b = 0;
		
		do {
			length -= 1;
			if (length == -1) {
				this.setLength(0);
				return "";
			} else {
				this.seek(length);
			}
			b = this.readByte();
			if (b != 10)
				sb.append((char) b);
		} while (b != 10 && length > 0);
		
		this.setLength(length);
		return sb.reverse().toString();
	}
}
