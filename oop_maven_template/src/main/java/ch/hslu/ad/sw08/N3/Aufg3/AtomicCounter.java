package ch.hslu.ad.sw08.N3.Aufg3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Counter that uses the Atomic mechanism
 * @author Dave
 *
 */
public class AtomicCounter implements Count {
	private final AtomicInteger counter;
	private  AtomicInteger increments;
	private  AtomicInteger decrements;

	
	public AtomicCounter() {
		this.counter = new AtomicInteger(0);
		this.increments = new AtomicInteger(0);
		this.decrements = new AtomicInteger(0);
	}

	@Override
	public void increment() {
		counter.incrementAndGet();
		increments.incrementAndGet();
	}

	@Override
	public void decrement() {
		counter.decrementAndGet();
		decrements.incrementAndGet();
	}

	@Override
	public int getCount() {
		return counter.get();
	}
	
	@Override
	public int getcorrectCounterValue() {
		return (increments.get()-decrements.get());
	}

}
