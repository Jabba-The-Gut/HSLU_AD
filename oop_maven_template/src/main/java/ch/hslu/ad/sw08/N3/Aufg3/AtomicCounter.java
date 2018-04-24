package ch.hslu.ad.sw08.N3.Aufg3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Counter that uses the Atomic mechanism
 * 
 * @author Dave
 *
 */
public class AtomicCounter implements Count {
	private final AtomicInteger counter;

	public AtomicCounter() {
		this.counter = new AtomicInteger(0);
	}

	@Override
	public void increment() {
		counter.incrementAndGet();
	}

	@Override
	public void decrement() {
		counter.decrementAndGet();
	}

	@Override
	public int getCount() {
		return counter.get();
	}

}
