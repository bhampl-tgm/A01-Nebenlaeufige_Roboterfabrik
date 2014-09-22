package tgm.sew.hit.roboterfabrik.util.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVFile {
	
	private File file;
	private ExtendedRAF raf;
	private CSVData data;
	
	public CSVFile(File f) {
		this.file = f;
		this.data = new CSVData();
		try {
			this.raf = new ExtendedRAF(f, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public CSVData readFromFile(char seperator) throws IOException {
		CSVData data = new CSVData();
		
		BufferedReader br = new BufferedReader(new FileReader(this.file));
		
		String line = null;
		while ((line = br.readLine()) != null) {
			data.addLine(CSVLine.parseLine(line, seperator));
		}
		
		br.close();
		
		this.data = data;
		
		return data;
	}
	
	public void saveToFile() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(this.file));
		
		for (CSVLine line : data.getLines()) {
			bw.write(line.toString() + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public void writeLine(CSVLine line) throws IOException {
		this.raf.writeBytes(line.toString() + "\n");
	}
	
	public CSVLine getLastLine() throws IOException{
		return CSVLine.parseLine(this.raf.readLastLine(), ',');
	}
	
	public void deleteLastLine() throws IOException {
		this.raf.deleteLastLine();
	}
}
