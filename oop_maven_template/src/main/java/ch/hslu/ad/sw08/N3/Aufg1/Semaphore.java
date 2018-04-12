package ch.hslu.ad.sw08.N3.Aufg1;

/**
 * Einfache Implementation eines Semaphores.
 * 
 * @author jabbathegut
 *
 */
public class Semaphore {
	private int count; // Anzahl Permits

	public Semaphore(final int size) {
		this.count = size;
	}

	/**
	 * Falls ein Permit verfuegbar ist, erlange Zugang zu geschuetzem Bereich
	 * 
	 * @throws InterruptedException
	 */
	public synchronized void aquire() throws InterruptedException {
		while (this.count == 0) {
			this.wait();
		}
		count--;
	}

	/**
	 * Falls ein Permit verfuegbar ist, erlange Zugang zu geschuetzem Bereich. Falls
	 * auf ein Permit gewartet werden muss, warte solange, wie im TimeOut angegeben
	 * 
	 * @throws InterruptedException
	 */
	public synchronized void aquire(final long milisec) throws InterruptedException {
		while (this.count == 0) {
			this.wait(milisec);
		}
		count--;
	}

	/**
	 * Gib Zugang zu geschuetyztem Bereich frei und wecke allenfalls auf ein Permit
	 * wartende Threads auf
	 * 
	 * @throws InterruptedException
	 */
	public synchronized void release() throws InterruptedException {
		if (this.count == 0) {
			this.notifyAll();
		}
		count++;
	}

}
