package ch.hslu.ad.sw08.N3.Aufg3;

/**
 * Counter class that uses the synchronization machanism
 * @author Dave
 *
 */
public class SynchronizedCounter implements Count {
	private int counter;
	private int increments;
	private int decrements;

	public SynchronizedCounter() {
		this.counter = 0;
		this.increments = 0;
		this.decrements = 0;
	}

	@Override
	public void increment() {
		synchronized (this) {
			counter++;
			increments++;
		}
		

	}

	@Override
	public void decrement() {
		synchronized (this) {
			counter--;
			decrements++;
		}
		
	}

	@Override
	public int getCount() {
		synchronized (this) {
			return counter;
		}
	}
	
	@Override
	public int getcorrectCounterValue() {
		return (increments-decrements);
	}
}