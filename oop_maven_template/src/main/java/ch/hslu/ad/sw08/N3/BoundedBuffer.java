package ch.hslu.ad.sw08.N3;

import java.util.ArrayDeque;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Eigene Implementation eines BoundedBuffers zum testen des
 * Konsumenten/Produzenten-Modells
 * 
 * @author jabbathegut
 *
 * @param <T>
 */
public class BoundedBuffer<T> {
	private final int size;
	private final Semaphore putSemaphore; // Semaphore fuer das Einfuegen von Elementen
	private final Semaphore takeSemaphore; // Semaphore fuer das Entfernen von Elementen
	private ArrayDeque<T> queue; // Datenstruktur fuer BoundedBuffer
	private final Logger LOG = LogManager.getLogger(BoundedBuffer.class);

	public BoundedBuffer(final int sizeOfBoundedBuffer) {
		this.size = sizeOfBoundedBuffer;
		this.queue = new ArrayDeque<>(sizeOfBoundedBuffer);
		this.putSemaphore = new Semaphore(sizeOfBoundedBuffer);
		this.takeSemaphore = new Semaphore(0);
	}

	/**
	 * Falls moeglich, fuege ein Element in den Buffer ein
	 * 
	 * @param element
	 *            Element dass eingefuegt werden soll
	 * @throws InterruptedException
	 */
	public void put(final T element) throws InterruptedException {
		putSemaphore.aquire();
		synchronized (queue) {
			queue.offerFirst(element);
			LOG.info("Put: " + element);
		}
		takeSemaphore.release();
	}

	/**
	 * Falls moeglich, probieren waehrend einer def. Zeit ein Element in den Buffer
	 * einzufuegen
	 * 
	 * @param element
	 *            Element, dass eingefuegt werden soll
	 * @param milisec
	 *            Timeout zum Einfuegen
	 * @throws InterruptedException
	 */
	public void put(final T element, final long milisec) throws InterruptedException {
		putSemaphore.aquire(milisec);
		synchronized (queue) {
			queue.offerFirst(element);
		}
		takeSemaphore.release();
	}

	/**
	 * Probiere, ein Element aus dem Buffer zu entnehmen
	 * 
	 * @return Entnommenes Element
	 * @throws InterruptedException
	 */
	public T get() throws InterruptedException {
		takeSemaphore.aquire();
		final T element;
		synchronized (queue) {
			element = queue.removeLast();
			LOG.info("Got: " + element);
		}
		putSemaphore.release();
		return element;
	}

	/**
	 * Probiere waehrend einer definierten Zeit, ein Element aus dem Buffer zu
	 * entnehmen
	 * 
	 * @param milisec
	 *            Zeit zum Versuch des Entnehmes eines Elements
	 * @return Entnommenes Element
	 * @throws InterruptedException
	 */
	public T get(long milisec) throws InterruptedException {
		takeSemaphore.aquire(milisec);
		final T element;
		synchronized (queue) {
			element = queue.removeLast();
		}
		putSemaphore.release();
		return element;
	}

	public boolean empty() {
		return this.queue.isEmpty() ? true : false;
	}

	public int size() {
		return this.size;
	}

	public boolean full() {
		return this.queue.size() == this.size ? true : false;
	}
}
