package ch.hslu.ad.sw08.N3.Aufg3;

public class SynchronizedCounter implements Count {
	private int counter;
	private long started;
	private long finished;

	public SynchronizedCounter() {
		this.counter = 0;
	}

	@Override
	public void increment() {
		synchronized (this) {
			if (this.getCount() == 0) {
				started = System.currentTimeMillis();
			}
			counter++;
		}

	}

	@Override
	public void decrement() {
		synchronized (this) {
			if (this.getCount() == 0) {
				finished = System.currentTimeMillis();
			}
			counter--;
		}

	}

	@Override
	public int getCount() {
		synchronized (this) {
			return counter;
		}
	}

	@Override
	public long getTime() {
		return (finished - started);
	}

}