package ch.hslu.ad.sw08.N3.Aufg1;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Producer implements Callable<Integer> {
	private int sum;
	private final ArrayBlockingQueue<Integer> buffer;
	private final Random random;
	private final static Logger LOG = LogManager.getFormatterLogger(Consumer.class);

	public Producer(final ArrayBlockingQueue<Integer> buffer) {
		this.buffer = buffer;
		this.sum = 0;
		this.random = new Random();
	}

	public Integer getSum() {
		return this.sum;
	}

	@Override
	public Integer call() throws Exception {
		for (int i = 0; i < this.random.nextInt(5); i++) { // Fuege eine zufaellige Anzahl an Threads in den Buffer ein
			try {
				final int randomInt = this.random.nextInt(100);
				buffer.offer(randomInt);
				sum += randomInt;
				LOG.info("Put: " + randomInt);
			} catch (Exception e) {
				LOG.error(e);
			}
		}
		return getSum();
	}
}
