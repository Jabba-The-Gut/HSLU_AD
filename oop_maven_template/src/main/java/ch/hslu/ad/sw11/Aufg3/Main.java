package ch.hslu.ad.sw11.Aufg3;

import java.util.concurrent.ForkJoinPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.ad.sw01.E1.FibonacciNumbers;

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

		// Rekursive Berechnung
		LOG.info("Rekursive Fibonacci-Berechnung beginnt...");
		long start2 = System.currentTimeMillis();
		int resultRecursive = FibonacciNumbers.fiboRec1(20);
		long finish2 = System.currentTimeMillis();
		LOG.info("Rekursive Fibonacci-Berechnung: " + (finish2 - start2) + "ms, Zahl: " + resultRecursive);

		// Iterative Berechnung
		LOG.info("Iterative Fibonacci-Berechnung beginnt...");
		long start3 = System.currentTimeMillis();
		int resultIterative = FibonacciNumbers.fiboIter(21);
		long finish3 = System.currentTimeMillis();
		LOG.info("Iterative Fibonacci-Berechnung: " + (finish3 - start3) + "ms, Zahl: " + resultIterative);
	}

}
