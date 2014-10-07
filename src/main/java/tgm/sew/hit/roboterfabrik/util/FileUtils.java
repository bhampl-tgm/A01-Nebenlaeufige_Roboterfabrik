package tgm.sew.hit.roboterfabrik.util;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

/**
 * @author Stefan Geyer
 * @version 1.0
 */
public class FileUtils {

	/**
	 * 
	 * Loescht alle Files in einem Verzeichnis und dessen subverzeichnisse.
	 * Ist ein Verezeichnis leer wird es geloescht.
	 * 
	 * @param path Der Pfad ab dem alle Files geloescht werden sollen
	 * @throws IOException
	 */
	public static void removeRecursive(File dir) throws IOException {
		File[] currList;
		Stack<File> stack = new Stack<File>();
		stack.push(dir);
		// Fuehre so lange durch bis alle Files geloescht sind
		while (!stack.isEmpty()) {
			// Falls es sich um ein Directory handelt wird es weiter untersucht, anderenfalls geloescht
			if (stack.lastElement().isDirectory()) {
				// Alle files aus dem dir zum Stack hinzufuegen
				currList = stack.lastElement().listFiles();
				// Wenn im dir files waren, werden sie zum stack hinzugefuegt.
				if (currList.length > 0) {
					for (File curr : currList) {
						stack.push(curr);
					}
				} else {
					stack.pop().delete();
				}
			} else {
				stack.pop().delete();
			}
		}
	}
}
