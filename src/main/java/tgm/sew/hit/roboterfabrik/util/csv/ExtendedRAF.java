package tgm.sew.hit.roboterfabrik.util.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * Erwitert das {@link RandomAccessFile} um die Moeglichkeit die letzte Zeile
 * zu lesen und zu loeschen.
 * 
 * @author Stefan Geyer
 * @version 1.0
 */
public class ExtendedRAF extends RandomAccessFile {

	public ExtendedRAF(File file, String mode) throws FileNotFoundException {
		super(file, mode);
	}

	/**
	 * 
	 * Liesst die letzte Zeile aus einem File
	 * 
	 * @return Die letzte Zeile
	 * @throws IOException
	 */
	public String readLastLine() throws IOException {
		StringBuilder builder = new StringBuilder();
		long length = this.length() - 1;
		this.seek(length);
		for (long seek = length; seek >= 0; --seek) {
			this.seek(seek);
			char c = (char) this.read();
			builder.append(c);
			if (c == '\n') {
				builder = builder.reverse();
			}
		}

		return builder.toString();
	}
	
	/**
	 * 
	 * Loescht die letzte Zeile aus einem File
	 * 
	 * @throws IOException
	 */
	public void deleteLastLine() throws IOException {
		long length = this.length() - 1;
		byte b = this.readByte();
		do {
			length -= 1;
			this.seek(length);
			b = this.readByte();
		} while (b != 10);
		this.setLength(length + 1);
	}
}
