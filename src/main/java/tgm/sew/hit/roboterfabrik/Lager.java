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
			File dir = new File(dataDir);
			File fAugen = new File(dataDir, "auge.csv");
			File fArme = new File(dataDir, "arm.csv");
			File fAntriebe = new File(dataDir, "kettenantrieb.csv");
			File fRuempfe = new File(dataDir, "rumpf.csv");
			File fAuslieferung = new File(dataDir, "auslieferung.csv");

			// Verzeichnise werden erstellt falls nicht vorhanden
			dir.mkdir();

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
	 * Ueberprueft ob ein oder mehrere (bis zu amount) Teile des Typs im Lager
	 * liegen.
	 * 
	 * @param t
	 *            Der Bauteiltyp
	 * @param amount
	 *            Wie oft
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
			return file.hasLine(amount);
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

		System.out.println("test");
		Bauteil b = null;
		try {
			switch (t) {
			case AUGE:
				String auge = this.augen.readAndDeleteLastLine().toString();
				System.out.println(auge);
				b = Bauteil.parseCSVString(auge);
			case ARM:
				String arme = this.arme.readAndDeleteLastLine().toString();
				System.out.println(arme);
				b = Bauteil.parseCSVString(arme);
			case KETTENANTRIEB:
				b = Bauteil.parseCSVString(this.antriebe.readAndDeleteLastLine().toString());
			case RUMPF:
				b = Bauteil.parseCSVString(this.ruempfe.readAndDeleteLastLine().toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return b;
	}

	/**
	 * 
	 * Speicher einen Threadee
	 * 
	 * @param t
	 *            Der Threadee der gepseichert werden soll
	 */
	public void threadeeAblegen(String t) {
		try {
			this.auslieferung.writeRaw(t);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
