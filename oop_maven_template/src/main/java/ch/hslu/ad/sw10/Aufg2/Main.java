package ch.hslu.ad.sw10.Aufg2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private final static Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		int sizeOfArray = 200000;

		long start = System.currentTimeMillis();
		Sort.quickSort(Sort.randomChars(sizeOfArray));
		long finish = System.currentTimeMillis();

		LOG.info("Quicksort mit " + sizeOfArray + " Elementen: " + (finish - start) + " ms");
	}

}
