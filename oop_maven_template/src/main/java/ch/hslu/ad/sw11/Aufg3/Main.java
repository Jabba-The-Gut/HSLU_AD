package ch.hslu.ad.sw11.Aufg3;

import java.util.concurrent.ForkJoinPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();

		// Parallele Fibonacci Berechnung mit Fork-Join
		LOG.info("Parallele Fibonacci-Berechnung Fork-Join beginnt...");
		ParallelFibonacciTask task = new ParallelFibonacciTask(20);
		long start1 = System.currentTimeMillis();
		int resultParallelForkJoin = pool.invoke(task);
		long finish1 = System.currentTimeMillis();
		LOG.info("Parallele Fibonacci-Berechnung Fork-Join: " + (finish1 - start1) + "ms, Zahl: "
				+ resultParallelForkJoin);
		
		// TODO weiter vergleichen mit dem Rest

	}

}
