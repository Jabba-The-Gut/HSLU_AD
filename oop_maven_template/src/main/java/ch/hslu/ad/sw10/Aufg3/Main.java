package ch.hslu.ad.sw10.Aufg3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private final static Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		int sizeOfArray = 200000;
		int TRESHOLD = 25;
		char[] a = Sort.randomChars(sizeOfArray);

		long start = System.currentTimeMillis();
		Sort.quickInsertionSort(a, TRESHOLD);
		long finish = System.currentTimeMillis();

		LOG.info("Quicksort mit " + sizeOfArray + " Elementen und Schwellenwert(" + TRESHOLD + ")" + ": "
				+ (finish - start) + " ms");

		char[] b = Sort.randomChars(sizeOfArray);
		long start2 = System.currentTimeMillis();
		Sort.quickSort(b);
		long finish2 = System.currentTimeMillis();

		LOG.info("Quicksort mit " + sizeOfArray + " Elementen: " + (finish2 - start2) + " ms");
	}

}
