package tgm.sew.hit.roboterfabrik.util.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class ExtendedRAF extends RandomAccessFile {

	public ExtendedRAF(File file, String mode) throws FileNotFoundException {
		super(file, mode);
	}

	public String[] readLastLines(int amount) throws IOException {
		List<String> lines = new ArrayList<String>();
		StringBuilder builder = new StringBuilder();
		long length = this.length() - 1;
		this.seek(length);
		for (long seek = length; seek >= 0; --seek) {
			this.seek(seek);
			char c = (char) this.read();
			builder.append(c);
			if (c == '\n') {
				builder = builder.reverse();
				lines.add(builder.toString());
				if (lines.size() >= amount)
					builder = new StringBuilder();
			}

		}
		
		return lines.toArray(new String[0]);
	}

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
