package tgm.sew.hit.roboterfabrik;

import java.io.File;
import java.io.IOException;

import tgm.sew.hit.roboterfabrik.bauteil.Bauteil;
import tgm.sew.hit.roboterfabrik.bauteil.BauteilTyp;
import tgm.sew.hit.roboterfabrik.util.csv.CSVFile;
import tgm.sew.hit.roboterfabrik.util.csv.CSVLine;

/**
 * 
 * Lager in welchem alle Bauteile gespeichert werden. Jeder Teiltyp wird in ein
 * anderes File geschrieben.
 * 
 * @author Stefan Geyer
 * @version 1.0
 */
public class Lager {

	private CSVFile augen;
	private CSVFile arme;
	private CSVFile antriebe;
	private CSVFile ruempfe;
	private CSVFile auslieferung;

	/**
	 * 
	 * Erstellt ein neues Lager
	 * 
	 * @param dataDir
	 *            Das Verzeichnis in welches die Files gespeichert werden
	 */
	public Lager(String dataDir) {
		if (dataDir != null) {
			File fAugen = new File(dataDir, "augen.csv");
			File fArme = new File(dataDir, "arme.csv");
			File fAntriebe = new File(dataDir, "arme.csv");
			File fRuempfe = new File(dataDir, "ruempfe.csv");
			File fAuslieferung = new File(dataDir, "auslieferung.csv");
			
			// Verzeichnise werden erstellt falls nicht vorhanden
			fAugen.mkdirs();

			// Files erstellen
			try {
				fAugen.createNewFile();
				fArme.createNewFile();
				fAntriebe.createNewFile();
				fRuempfe.createNewFile();
				fAuslieferung.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

			this.augen = new CSVFile(fAugen);
			this.arme = new CSVFile(fArme);
			this.antriebe = new CSVFile(fAntriebe);
			this.ruempfe = new CSVFile(fRuempfe);
			this.auslieferung = new CSVFile(fAuslieferung);
		}
	}

	/**
	 * 
	 * Fuegt ein Bauteil ins zum Typ gehoerenden File hinzu
	 * 
	 * @param t
	 *            Das hinzuzufuegende Teil
	 */
	public void addTeil(Bauteil t) {
		CSVFile file = null;

		switch (t.getTyp()) {
		case AUGE:
			file = this.augen;
			break;
		case ARM:
			file = this.arme;
			break;
		case KETTENANTRIEB:
			file = this.antriebe;
			break;
		case RUMPF:
			file = this.ruempfe;
		}

		try {
			file.writeLine(CSVLine.parseLine(t.toString(), ','));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Ueberprueft ob ein oder mehrere (bis zu amount) Teile des Typs im Lager liegen.
	 * 
	 * @param t Der Bauteiltyp
	 * @param amount Wie oft
	 * @return Ob das Teil im Lager liegt
	 */
	public boolean containsTeil(BauteilTyp t, int amount) {
		CSVFile file = null;

		switch (t) {
		case AUGE:
			file = this.augen;
			break;
		case ARM:
			file = this.arme;
			break;
		case KETTENANTRIEB:
			file = this.antriebe;
			break;
		case RUMPF:
			file = this.ruempfe;
		}

		try {
			boolean contains = false;
			CSVLine last = file.getLastLine();
			if (last.toString().length() != 0)
				file.deleteLastLine();
			else
				return false;
			
			if (last.toString().length() != 0)
				contains = true;
			else
				return false;
			
			file.writeLine(last);
			
			return contains;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * 
	 * Gibt das naechste Bauteil mit dem angegebenen Typ zurueck
	 * 
	 * @param t
	 *            Der Typ des Bauteils
	 * @return Das neachste Bauteil
	 */
	public Bauteil getBauteil(BauteilTyp t) {

		try {
			switch (t) {
			case AUGE:
				Bauteil auge = Bauteil.parseCSVString(this.augen.getLastLine().toString());
				this.augen.deleteLastLine();
				return auge;
			case ARM:
				Bauteil arm = Bauteil.parseCSVString(this.arme.getLastLine().toString());
				this.arme.deleteLastLine();
				return arm;
			case KETTENANTRIEB:
				Bauteil kettenantrieb = Bauteil.parseCSVString(this.antriebe.getLastLine().toString());
				this.antriebe.deleteLastLine();
				return kettenantrieb;
			case RUMPF:
				Bauteil rumpf = Bauteil.parseCSVString(this.ruempfe.getLastLine().toString());
				this.ruempfe.deleteLastLine();
				return rumpf;
			}
		} catch (IOException e) {

		}

		return null;
	}
	
	/**
	 * 
	 * Speicher einen Threadee
	 * 
	 * @param t Der Threadee der gepseichert werden soll
	 */
	public void threadeeAblegen(Threadee t) {
		try {
			this.auslieferung.writeRaw(t.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
