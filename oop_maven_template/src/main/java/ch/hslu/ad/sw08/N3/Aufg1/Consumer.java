package ch.hslu.ad.sw08.N3.Aufg1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Consumer implements Callable<Integer> {
	private int sum;
	private final ArrayBlockingQueue<Integer> buffer;
	private final static Logger LOG = LogManager.getFormatterLogger(Consumer.class);
	private volatile boolean run = true;

	public Consumer(final ArrayBlockingQueue<Integer> buffer) {
		this.buffer = buffer;
		this.sum = 0;
	}

	public Integer getSum() {
		return this.sum;
	}

	public void stop() {
		this.run = false;
	}

	@Override
	public Integer call() throws Exception {
		while (run) { // Konsumiere solange Elemente, bis run false ist (wird extern gesetzt)
			try {
				final int fromBuffer = buffer.take();
				sum += fromBuffer;
				LOG.info("Got: " + fromBuffer);
			} catch (Exception e) {
				LOG.error(e);
			}
		}
		return getSum();

	}

}
