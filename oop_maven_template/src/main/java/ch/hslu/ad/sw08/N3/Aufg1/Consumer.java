package ch.hslu.ad.sw08.N3.Aufg1;

import java.util.Random;
import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Consumer implements Callable<Integer> {
	private int sum;
	private final BoundedBuffer<Integer> buffer;
	private final Random random;
	private final static Logger LOG = LogManager.getFormatterLogger(Consumer.class);

	public Consumer(final BoundedBuffer<Integer> buffer) {
		this.buffer = buffer;
		this.sum = 0;
		this.random = new Random();
	}

	public Integer getSum() {
		return this.sum;
	}

	@Override
	public Integer call() throws Exception {
		while (true) { // Konsumiere solange Elemente, bis der Thread interrupted wird
			try {
				final int fromBuffer = buffer.get();
				sum += fromBuffer;
			} catch (Exception e) {
				LOG.error(e);
				return getSum();
			}
		}
	}

}
