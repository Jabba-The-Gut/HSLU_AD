package ch.hslu.ad.sw11.Aufg2;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.ad.sw10.Aufg3.Sort;

public class Main {
	private final static Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		final ForkJoinPool pool = new ForkJoinPool();

		// Parallelisierter QuickSort
		final char[] abc = new char[200000];

		LOG.info("Array wird zufällig befüllt...");
		RandomInitTask task1 = new RandomInitTask(abc);
		pool.invoke(task1);
		ParallelQuickSortTask parallelQuickSort = new ParallelQuickSortTask(abc);
		LOG.info("ParallelQuickSort beginnt...");
		final long start1 = System.currentTimeMillis();
		pool.invoke(parallelQuickSort);
		final long finish1 = System.currentTimeMillis();
		LOG.info("ParallelQuickSort fertig, Dauer: " + (finish1 - start1));

		// Normaler QuickInsertionSort
		final char[] cde = new char[200000];

		LOG.info("Array wird zufällig befüllt...");
		RandomInitTask task2 = new RandomInitTask(cde);
		pool.invoke(task2);
		LOG.info("QuickInsertionSort beginnt...");
		final long start2 = System.currentTimeMillis();
		Sort.quickInsertionSort(abc, 25000);
		final long finish2 = System.currentTimeMillis();
		LOG.info("QuickInsertionSort fertig, Dauer: " + (finish2 - start2));

		// Arrays.sort()-Methode
		final char[] efg = new char[200000];

		LOG.info("Array wird zufällig befüllt...");
		RandomInitTask task3 = new RandomInitTask(efg);
		pool.invoke(task3);
		LOG.info("Arrays.sort() beginnt...");
		final long start3 = System.currentTimeMillis();
		Arrays.sort(efg);
		final long finish3 = System.currentTimeMillis();
		LOG.info("Arrays.sort() fertig, Dauer: " + (finish3 - start3));

	}

}
