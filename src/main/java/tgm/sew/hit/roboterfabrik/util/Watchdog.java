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
		startThreads();
		try {
			Thread.sleep(zeit);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stopThreads();
	}

	public void startThreads() {
		for (Mitarbeiter t : this.threads) {
			new Thread(t).start();
		}
	}
	
	public void stopThreads() {
		for (Mitarbeiter t : this.threads) {
			t.setGo(false);
		}
	}
	
	public int getZeit() {
		return this.zeit;
	}

	public Mitarbeiter[] getThreads() {
		return this.threads;
	}
}
