package ch.hslu.ad.sw05.N1.Aufg2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdditionTask implements Runnable {
	private volatile Thread runThread;
	private final int rangeBegin;
	private final int rangeEnd;
	private static final Logger LOG = LogManager.getLogger(AdditionTask.class);

	public AdditionTask(final int rangeBegin, final int rangeEnd) {
		this.rangeBegin = rangeBegin;
		this.rangeEnd = rangeEnd;
	}

	@Override
	public void run() {
		this.runThread = Thread.currentThread();
		// Initialisierungsphase
		long sum = 0;
		// Arbeitsphase
		try {
			while (runThread.isInterrupted() == false) {
				for (int i = this.rangeBegin; i <= this.rangeEnd; i++) {
					sum += i;

					Thread.sleep(15);
				}
			}

		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
			// Aufräumphase
			if (!isStopped()) {
				LOG.info(runThread.getName() + ": SUM  ->" + sum);
			} else {
				LOG.info(runThread.getName() + ": interrupted.");
			}
		}
	}

	private boolean isStopped() {
		return this.runThread.isInterrupted();
	}
}
