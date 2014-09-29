package tgm.sew.hit.roboterfabrik;

import java.io.File;
import java.io.IOException;

import tgm.sew.hit.roboterfabrik.bauteil.Arm;
import tgm.sew.hit.roboterfabrik.bauteil.Auge;
import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.bauteil.Kettenantrieb;
import tgm.sew.hit.roboterfabrik.bauteil.Rumpf;
import tgm.sew.hit.roboterfabrik.util.csv.CSVFile;
import tgm.sew.hit.roboterfabrik.util.csv.CSVLine;

public class Lager {

	private CSVFile augen;
	private CSVFile arme;
	private CSVFile antriebe;
	private CSVFile ruempfe;

	public Lager(String dataDir) {
		File fAugen = new File(dataDir, "augen.csv");
		File fArme = new File(dataDir, "arme.csv");
		File fAntriebe = new File(dataDir, "arme.csv");
		File fRuempfe = new File(dataDir, "ruempfe.csv");
		
		fAugen.mkdirs();
		
		try {
			fAugen.createNewFile();
			fArme.createNewFile();
			fAntriebe.createNewFile();
			fRuempfe.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.augen = new CSVFile(fAugen);
		this.arme = new CSVFile(fArme);
		this.antriebe = new CSVFile(fAntriebe);
		this.ruempfe = new CSVFile(fRuempfe);
	}
	
	public void addTeil(Bauteil t) {
		CSVFile file = null;
		
		switch(t.getClass().getName()) {
		case "Auge":
			file = this.augen;
			break;
		case "Arm":
			file = this.arme;
			break;
		case "Kettenantrieb":
			file = this.antriebe;
			break;
		case "Rumpf":
			file = this.ruempfe;
		}
		
		try {
			file.writeLine(CSVLine.parseLine(t.toString(), ','));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Arm getArm() {
		try {
			Arm a = Arm.parseCSVString(this.augen.getLastLine().toString());
			this.augen.deleteLastLine();
			return a;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Auge getAuge() {
		try {
			Auge a = Auge.parseCSVString(this.augen.getLastLine().toString());
			this.augen.deleteLastLine();
			return a;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Kettenantrieb getAntrieb() {
		try {
			Kettenantrieb k = Kettenantrieb.parseCSVString(this.augen.getLastLine().toString());
			this.augen.deleteLastLine();
			return k;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Rumpf getRumpf() {
		try {
			Rumpf r = Rumpf.parseCSVString(this.augen.getLastLine().toString());
			this.augen.deleteLastLine();
			return r;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
