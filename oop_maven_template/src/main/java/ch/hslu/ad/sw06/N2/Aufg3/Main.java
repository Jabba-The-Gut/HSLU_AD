package ch.hslu.ad.sw06.N2.Aufg3;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static List<Thread> consumerThreads;
	private static List<Thread> producerThreads;
	private final static BoundedBuffer<Integer> buffer = new BoundedBuffer<>(5);

	public static void main(String[] args) {
		consumerThreads = new ArrayList<>();
		producerThreads = new ArrayList<>();

		// Arbeiter- bzw. Produzenten-Threads erstellen
		for (int i = 0; i < 2; i++) {
			producerThreads.add(new Thread(new WorkerThread(buffer)));
		}

		// Konsumenten-Threads erstellen
		for (int i = 0; i < 3; i++) {
			consumerThreads.add(new Thread(new ConsumerThread(buffer)));
		}

		// Starte Konsumenten- und Produzenten-Threads
		for (Thread thread : producerThreads) {
			thread.start();
		}

		for (Thread thread : consumerThreads) {
			thread.start();
		}
	}

}
