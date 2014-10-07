package tgm.sew.hit.roboterfabrik.bauteil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Bauteil Klasse. In dieser Klassen werden der Typ und ein int Array
 * gespeichert. Die Zahlen im int Array sind im Bereich von 0 - 999
 * 
 * @author Stefan Geyer
 * @version 1.0
 */
public class Bauteil {

	private BauteilTyp typ;
	private int[] data;

	public Bauteil(BauteilTyp typ, int[] data) {
		this.typ = typ;
		this.data = data;
	}

	public void sortData() {
		Arrays.sort(data);
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public int[] getData() {
		return this.data;
	}

	public BauteilTyp getTyp() {
		return typ;
	}

	public void setTyp(BauteilTyp typ) {
		this.typ = typ;
	}

	/**
	 * 
	 * Konvertiert einen String in in Bauteil. Als seperator wird , verwendet
	 * und das erste Element muss der BauteilTyp sein. Alle nachfolgenden Zahlen
	 * werden zum daten Array hinzugefuegt.
	 * 
	 * @param line
	 *            Die zu parsende Zeile
	 * @return Das verarbeitete Bauteil
	 */
	public static Bauteil parseCSVString(String line) {
		// return null wenn die line null ist
		if (line != null) {
			// Nach , aufspliten
			String[] items = line.split(",");
			// Stelle 0 ist der typ, alles danach sind die daten
			List<Integer> dataList = new ArrayList<Integer>();
			int[] data = null;

			for (int i = 0; i < items.length; i++) {
				try {
					dataList.add(Integer.parseInt(items[i]));
				} catch (NumberFormatException e) {
					continue;
				}
			}

			data = new int[dataList.size()];

			for (int i = 0; i < dataList.size(); i++) {
				data[i] = dataList.get(i);
			}

			// Bauteil vom String holen
			BauteilTyp b = null;
			
			try {
				b = BauteilTyp.valueOf(items[0].toUpperCase());
			} catch (IllegalArgumentException e) {
				//TODO Lager out of stock
			}
			
			if (b != null) {
				return new Bauteil(b, data);
			}
		}

		return null;
	}

	/**
	 * 
	 * Fuegt typ und die Daten mit , als seperator zusammen
	 * 
	 */
	public String toString() {
		String out = this.typ.getName() + ",";

		for (int i : data) {
			out += i + ",";
		}

		out = out.substring(0, out.lastIndexOf(','));

		return out;
	}

}
