package ch.hslu.ad.sw01.E1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LaufzeitDemo {
	private static int nTask1 = 0;
	private static int nTask2 = 0;
	private static int nTask3 = 0;
	private static final Logger LOG = LogManager.getLogger(LaufzeitDemo.class);

	public static void main(String[] args) {
		task(10);
		task(20);
		task(40);
		task(80);
	}

	public static void task(final int n) {
		long start = System.currentTimeMillis();
		task1();
		task1();
		task1();
		task1();
		// T ~ 4
		for (int i = 0; i < n; i++) {
			// äussere Schleife: n‐mal
			task2();
			task2();
			task2();
			// T ~ n ∙ 3
			for (int j = 0; j < n; j++) {
				// innerer Schleife: n‐mal
				task3();
				task3();
				// T ~ n ∙ n∙ 2
			}
		}
		long end = System.currentTimeMillis();
		LOG.info("N: " + n + " | Task 1: " + nTask1 + " | Task 2: " + nTask2 + " | Task 3: " + nTask3
				+ " | Aufrufe Total: " + (nTask1 + nTask2 + nTask3) + " | Laufzeit (MilliS): " + (end-start));
	}

	private static void task3() {
		nTask3++;
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			LOG.error(e.getMessage());
		}
	}

	private static void task2() {
		nTask2++;
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			LOG.error(e.getMessage());
		}
	}

	private static void task1() {
		nTask1++;
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			LOG.error(e.getMessage());
		}
	}
}
