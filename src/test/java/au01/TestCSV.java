package au01;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import tgm.sew.hit.roboterfabrik.util.csv.CSVData;
import tgm.sew.hit.roboterfabrik.util.csv.CSVFile;
import tgm.sew.hit.roboterfabrik.util.csv.CSVLine;

public class TestCSV {

	/**
	 * 
	 * Konstruktor mit default seperator wird aufgerufen. Die Getter und Setter werden getestet 
	 * 
	 */
	@Test
	public void testCSVLine1() {
		CSVLine line = new CSVLine("Arm", "1", "3");
		line.getItems();
		line.addItem("4");
		line.getSeperator();
		line.setSeperator('.');
	}
	
	/**
	 * 
	 * Konstruktor mit spezifischem seperator wird aufgerufen
	 * 
	 */
	@Test
	public void testCSVLine2() {
		CSVLine line = new CSVLine(',', "Auge", "2", "5", "15");
		line.getItems();
		line.toString();
	}
	
	
	/**
	 * 
	 * Zeile wird aus String geparst
	 * 
	 */
	@Test
	public void testCSVLine3() {
		CSVLine line = CSVLine.parseLine("Rumpf,1,2,3,4", ',');
		line.getItems();
		line = CSVLine.parseLine(null, ',');
	}

	
	/**
	 * 
	 * CSVData wrid getestet
	 * 
	 */
	@Test
	public void testCSVData1() {
		CSVData data = new CSVData();
		data.addLine(CSVLine.parseLine("Arm,1,2,3", ','));
		data.getLines();
	}
	
	@Test
	public void testCSVFile1() {
		File f = new File("out/test", "test.csv");
		f.mkdir();
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		CSVFile cf = new CSVFile(f);
		try {
			cf.writeLine(CSVLine.parseLine("1,2,3,4", ','));
			cf.writeRaw("1,2,3,4,5,6");
			cf.deleteLastLine();
			cf.getLastLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
