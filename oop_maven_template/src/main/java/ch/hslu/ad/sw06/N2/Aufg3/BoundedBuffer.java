package ch.hslu.ad.sw06.N2.Aufg3;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BoundedBuffer<T> {
	private static final Logger LOG = LogManager.getLogger(BoundedBuffer.class);
	private final ArrayDeque<T> data;
	private final int size;
	private final Semaphore putSemaphore;
	private final Semaphore takeSemaphore;

	public BoundedBuffer(int size) {
		this.data = new ArrayDeque<>(size);
		this.size = size;
		this.putSemaphore = new Semaphore(this.size, true);
		this.takeSemaphore = new Semaphore(0, true);
	}

	public void put(final T element) throws InterruptedException {
		putSemaphore.acquire();
		synchronized (data) {
			data.addFirst(element);
			LOG.info("Put: " + element);
		}
		takeSemaphore.release();
	}

	public T get() throws InterruptedException {
		takeSemaphore.acquire();
		T element;
		synchronized (data) {
			element = data.removeLast();
			LOG.info("Got: " + element);
		}
		putSemaphore.release();
		return element;
	}

	public boolean empty() {
		return data.isEmpty();
	}

	public boolean full() {
		return data.size() == this.size ? true : false;
	}

	public int size() {
		return data.size();
	}

}
