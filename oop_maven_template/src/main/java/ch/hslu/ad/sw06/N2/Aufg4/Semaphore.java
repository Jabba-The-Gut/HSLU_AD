package ch.hslu.ad.sw06.N2.Aufg4;

public final class Semaphore {
	private int sema; // Semaphor Zähler

	/**
	 * Erzeugt einen neuen Semaphore.
	 * 
	 * @param init
	 *            Anzahl gleichzeitig zulaessiger Zugaenge
	 * @param limit
	 *            Maximale Anzahl zulaessiger Zugaenge
	 */
	public Semaphore(final int init, final int limit) throws IllegalArgumentException{
		if(init > limit) {
			throw new IllegalArgumentException();
		} else {
			sema = init;
		}
	}

	public synchronized void acquire() throws InterruptedException {
		while (sema == 0) {
			this.wait();
		}
		sema--;
	}

	public synchronized void release() {
		this.notifyAll();
		sema++;
	}
	
	public synchronized void acquire(final int permits) throws InterruptedException {
		for(int i = 0; i < permits; i++) {
			acquire();
		}
	}

	public synchronized void release(final int permits) {
		for(int i = 0; i < permits; i++) {
			release();
		}
	}
}
