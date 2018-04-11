package ch.hslu.ad.sw08.N3;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Producer implements Runnable {
	private int sum;
	private final BoundedBuffer<Integer> buffer;
	private final Random random;
	private final static Logger LOG = LogManager.getFormatterLogger(Consumer.class);

	public Producer(final BoundedBuffer<Integer> buffer) {
		this.buffer = buffer;
		this.sum = 0;
		this.random = new Random();
	}

	@Override
	public void run() {
		for (int i = 0; i < this.random.nextInt(5); i++) { // Fuege eine zufaellige Anzahl an Threads in den Buffer ein
			try {
				final int randomInt = this.random.nextInt(100);
				buffer.put(randomInt);
				sum += randomInt;

			} catch (Exception e) {
				LOG.error(e);
			}
		}
	}

	public Integer getSum() {
		return this.sum;
	}
}
