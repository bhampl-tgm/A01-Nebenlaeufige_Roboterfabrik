package tgm.sew.hit.roboterfabrik.util;

import java.util.List;

import tgm.sew.hit.roboterfabrik.mitarbeiter.Mitarbeiter;

/**
 * 
 * Watchdog der nach der Runtime alle Threads beendet.
 * 
 * @author pmalik
 * @version 1.1
 */
public class Watchdog implements Runnable {

	private int zeit;
	private Mitarbeiter[] threads;

	public Watchdog(int zeit, List<Mitarbeiter> threads) {
		this.zeit = zeit;
		this.threads = threads.toArray(new Mitarbeiter[0]);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(zeit);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].setGo(false);
		}
	}

	public int getZeit() {
		return this.zeit;
	}

	public Mitarbeiter[] getThreads() {
		return this.threads;
	}
}
