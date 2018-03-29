package ch.hslu.ad.sw06.N2.Aufg2;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Eine Rennstrecke, auf der verschiedene Rennpferde (Threads) ein Rennen machen
 * @author jabbathegut
 *
 */
public final class Turf {
	private static final Logger LOG = LogManager.getLogger(Turf.class);
	private static List<Thread> threads;

	public static void main(final String[] args) throws InterruptedException {
		threads = new ArrayList<>();
		Synch starterBox = new Latch();
		for (int i = 0; i < 5; i++) {
			threads.add(new Thread(new RaceHorse(starterBox), "Horse " + (i + 1)));
		}
		for (int i = 0; i < 5; i++) {
			threads.get(i).start();
		}

		// Damit die run-Methode von jedem Thread sicher Zeit zum loggen hat
		Thread.sleep(100);

		// Rennen wird gestartet
		LOG.info("Start...");
		starterBox.release();

		// Auskommentieren, falls Rennen nicht abgebrochen werden soll. Falls es einige
		// Pferde ins Ziel schaffen sollen,
		// dann muss noch ein Thread.sleep() vorangefuegt werden.
		// chancelRace();
	}

	private static void chancelRace() {
		for (int i = 0; i < 5; i++) {
			threads.get(i).interrupt();
		}
	}
}
