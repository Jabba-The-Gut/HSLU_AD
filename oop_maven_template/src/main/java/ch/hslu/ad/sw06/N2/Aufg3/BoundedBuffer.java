package ch.hslu.ad.sw06.N2.Aufg3;

import java.util.ArrayDeque;

public class BoundedBuffer<T> {
	private final ArrayDeque<T> data;
	private final int size;

	public BoundedBuffer(int size) {
		this.data = new ArrayDeque<>();
		this.size = size;
	}

	public synchronized void put(T element) throws InterruptedException {
		if (data.size() == this.size) {
			this.wait();
		}

		data.addFirst(element);
		if (data.size() == 1) {
			this.notifyAll();
		}
	}

	public synchronized boolean put(T element, long millisec) throws InterruptedException {
		if (data.size() == this.size) {
			this.wait(millisec);
			if (data.size() == this.size) {
				return false;
			}
		}

		data.addFirst(element);
		if (data.size() == 1) {
			this.notifyAll();
		}
		return true;
	}

	public synchronized T get() throws InterruptedException {
		if (data.isEmpty()) {
			this.wait();
		}

		if (data.size() == (this.size - 1)) {
			this.notifyAll();
		}
		return data.removeLast();
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
