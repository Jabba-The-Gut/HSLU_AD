package ch.hslu.ad.sw08.N3.Aufg4;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.ad.sw08.N3.Aufg3.CounterTest;

public class Main {
	final static Logger LOG = LogManager.getFormatterLogger(CounterTest.class);

	public static void main(String[] args) throws InterruptedException {
		int nbrOfRequiredPrimes = 100;
		int nbrOfThreads = Runtime.getRuntime().availableProcessors() + 1;
		ExecutorService servicePrime = Executors.newFixedThreadPool(nbrOfThreads);
		PrimeCounter counter = new PrimeCounter(nbrOfRequiredPrimes);
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < nbrOfThreads; i++) {
			servicePrime.execute(new PrimeTesterTask(counter));
		}

		while(!counter.enoughPrimes()) {
			Thread.sleep(1);
		}
		long finished = System.currentTimeMillis();
		
		servicePrime.shutdownNow();
		
		Thread.sleep(1000);
		
		LOG.info("Needed " + (finished-start) + " milliseconds to find " +nbrOfRequiredPrimes+ " primes");
		
		

	}

}
