package ch.hslu.ad.sw06.N2.Aufg1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Einfacher Task für die Demonstration eines Wait-Pools.
 */
public final class MyTask implements Runnable {
	private static final Logger LOG = LogManager.getLogger(MyTask.class);
	private final Object lock;

	public MyTask(final Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		LOG.info("warten...");
		synchronized (lock) {
			try {
				LOG.info("Monitor gehoert MyTask");
				lock.wait();
			} catch (InterruptedException ex) {
				return;
			}
		}
		LOG.info("...aufgewacht");
	}
}