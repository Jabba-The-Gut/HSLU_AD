package ch.hslu.ad.sw08.N3.Aufg3;

import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountingTask implements Callable<Boolean> {
	private static final Logger LOG = LogManager.getLogger(CountingTask.class);
	private final Count counter;
	final int limit;

	public CountingTask(final int limit, Count counter) {
		this.counter = counter;
		this.limit = limit;
	}

	@Override
	public Boolean call() throws Exception {
		try {
			while (counter.getCount() < limit) {
				counter.increment();
			}
			while (counter.getCount() != 0) {
				counter.decrement();
			}
			return true;

		} catch (Exception e) {
			LOG.error(e);
		} 
		return false;
	}

}
