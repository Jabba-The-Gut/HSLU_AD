package ch.hslu.ad.sw11.Aufg1;

import java.util.concurrent.ForkJoinPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private final static Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		final int[] array = new int[200000000];
		final ForkJoinPool pool = new ForkJoinPool();
		// Array wird zufällig befüllt
		LOG.info("Array wird zufällig befüllt...");
		final RandomInitTask initTask = new RandomInitTask(array, 100);
		pool.invoke(initTask);

		// array wird sortiert
		final SortTask sortTask = new SortTask(array);
		LOG.info("Sortierung beginnt...");
		final long start = System.currentTimeMillis();
		pool.invoke(sortTask);
		final long finish = System.currentTimeMillis();
		LOG.info("Benötigte Zeit: " + (finish - start));
		
	}

}
