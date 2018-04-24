package ch.hslu.ad.sw08.N3.Aufg4;

import java.math.BigInteger;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.ad.sw08.N3.Aufg3.CounterTest;

public class PrimeTesterTask implements Runnable {
	final static Logger LOG = LogManager.getFormatterLogger(CounterTest.class);
	private final PrimeCounter primeTask;

	public PrimeTesterTask(final PrimeCounter primeCounter) {
		this.primeTask = primeCounter;
	}

	@Override
	public void run() {
		while (!primeTask.enoughPrimes()) {
			// test BigIntegers for as long as one that is a prime is found, then finish
			if (new BigInteger(1024, new Random()).isProbablePrime(Integer.MAX_VALUE)) {
				primeTask.foundPrimeNumber();
				LOG.info("Found prime!");
			}
		}

	}

}
