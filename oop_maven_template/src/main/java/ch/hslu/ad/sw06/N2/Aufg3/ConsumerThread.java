package ch.hslu.ad.sw06.N2.Aufg3;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsumerThread implements Runnable {
	private static final Logger LOG = LogManager.getLogger(ConsumerThread.class);
	private final Random random;
	private final BoundedBuffer<Integer> buffer;

	public ConsumerThread(final BoundedBuffer<Integer> buffer) {
		this.buffer = buffer;
		this.random = new Random();
	}

	@Override
	public void run() {
		while (true) {
			try {
				int value = buffer.get();
			} catch (InterruptedException e) {
				LOG.error(e);
			}
		}

	}

}
