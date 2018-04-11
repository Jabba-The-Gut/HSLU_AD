package ch.hslu.ad.sw06.N2.Aufg3;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Consumer implements Runnable {
	private int sum;
	private final BoundedBuffer<Integer> buffer;
	private final Random random;
	private final static Logger LOG = LogManager.getFormatterLogger(Consumer.class);

	public Consumer(final BoundedBuffer<Integer> buffer) {
		this.buffer = buffer;
		this.sum = 0;
		this.random = new Random();
	}

	@Override
	public void run() {
		while (true) { // Konsumiere solange Elemente, bis der Thread interrupted wird
			try {
				final int fromBuffer = buffer.get();
				sum += fromBuffer;
			} catch (Exception e) {
				LOG.error(e);
				return;
			}
		}
	}

	public Integer getSum() {
		return this.sum;
	}

}
