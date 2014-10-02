package tgm.sew.hit.roboterfabrik.util.csv;

import java.io.File;
import java.io.FileNotFoundException;
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
		long length = this.length() - 1L;
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
	public void deleteLastLine() throws IOException {
		long length = this.length() - 1;
		for (long cursor = length; cursor > -1; cursor -= 1) {
			if (cursor == 0) {
				this.setLength(0);
				return;
			}
			this.seek(cursor);
			byte readByte = this.readByte();
			if (readByte == 10) {
				this.setLength(cursor);
				return;
			}
		}
	}
}
