package ch.hslu.ad.sw08.N3.Aufg3;

/**
 * Counter class that uses the synchronization machanism
 * 
 * @author Dave
 *
 */
public class SynchronizedCounter implements Count {
	private int counter;

	public SynchronizedCounter() {
		this.counter = 0;
	}

	@Override
	public void increment() {
		synchronized (this) {
			counter++;
		}

	}

	@Override
	public void decrement() {
		synchronized (this) {
			counter--;
		}

	}

	@Override
	public int getCount() {
		synchronized (this) {
			return counter;
		}
	}

}