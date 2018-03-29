package ch.hslu.ad.sw06.N2.Aufg1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Demonstration eines Wait-Pools.
 */
public final class DemoWaitPool {
	private static final Object lock = new Object();
	private static final Logger LOG = LogManager.getLogger(DemoWaitPool.class);

	public static void main(final String args[]) throws InterruptedException {
		// wenn es funktionieren soll, dann darf nur notify im synchronized-block stehen
		synchronized (lock) {
			final MyTask waiter = new MyTask(lock);
			new Thread(waiter).start();
			Thread.sleep(1000);
			lock.notify();
			LOG.info("Notifiy fertig");
		}

	}
}