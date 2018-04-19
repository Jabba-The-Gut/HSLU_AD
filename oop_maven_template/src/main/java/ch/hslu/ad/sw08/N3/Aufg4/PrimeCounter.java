package ch.hslu.ad.sw08.N3.Aufg4;

import java.util.concurrent.atomic.AtomicInteger;

public class PrimeCounter {
	private int requiredPrimes;
	private AtomicInteger nbrOfPrimes;
	
	public PrimeCounter(final int requiredPrimes) {
		this.requiredPrimes = requiredPrimes;
		this.nbrOfPrimes = new AtomicInteger(0);
	}
	
	public void foundPrimeNumber() {
		nbrOfPrimes.incrementAndGet();
	}
	
	public boolean enoughPrimes() {
		return nbrOfPrimes.get() >= requiredPrimes ? true : false;
	}
	
	
}
