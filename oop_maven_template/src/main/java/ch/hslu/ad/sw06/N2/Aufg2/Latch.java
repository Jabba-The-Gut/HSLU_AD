package ch.hslu.ad.sw06.N2.Aufg2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Ein Verzoegerungsmechanismus, welcher als Warte- bzw. Startsiganl fuer
 * Pferderennen gilt
 * 
 * @author jabbathegut
 *
 */
public class Latch implements Synch {
	private static final Logger LOG = LogManager.getLogger(Latch.class);
	private boolean latchAccessible;

	public Latch() {
		synchronized (this) {
			this.latchAccessible = false;
		}
	}

	@Override
	public void acquire() throws InterruptedException {
		synchronized (this) {
			while (!latchAccessible) {
				this.wait();
			}
		}
	}

	@Override
	public void release() {
		synchronized (this) {
			this.latchAccessible = true;
			this.notifyAll();
		}

	}

}
