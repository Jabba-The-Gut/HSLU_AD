package ch.hslu.ad.sw08.N3.Aufg3;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Count {
	private final AtomicInteger counter;
	private long started;
	private long finished;
	
	public AtomicCounter() {
		this.counter = new AtomicInteger(0);
	}

	@Override
	public void increment() {
		if(this.getCount() == 0) {
		started = System.currentTimeMillis();
		}
		counter.incrementAndGet();
	}

	@Override
	public void decrement() {
		if(this.getCount() == 0) {
			finished = System.currentTimeMillis();
		}
		counter.decrementAndGet();
	}

	@Override
	public int getCount() {
		return counter.get();
	}

	@Override
	public long getTime() {
		return (finished - started);
	}

}
