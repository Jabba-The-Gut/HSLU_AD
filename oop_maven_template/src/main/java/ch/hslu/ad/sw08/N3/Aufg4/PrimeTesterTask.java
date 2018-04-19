package ch.hslu.ad.sw08.N3.Aufg4;

import java.math.BigInteger;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.ad.sw08.N3.Aufg3.CounterTest;

public class PrimeTesterTask implements Runnable {
	final static Logger LOG = LogManager.getFormatterLogger(CounterTest.class);
	private final BigInteger bigInt;
	private final PrimeCounter primeTask;

	public PrimeTesterTask(final BigInteger bigInt, final PrimeCounter primeCounter) {
		this.bigInt = bigInt;
		this.primeTask = primeCounter;
	}

	@Override
	public void run() {
		while (!primeTask.enoughPrimes()) {
			if (new BigInteger(1024, new Random()).isProbablePrime(Integer.MAX_VALUE)) {
				primeTask.foundPrimeNumber();
				LOG.info("Found prime!");
			}
		}

	}

}
