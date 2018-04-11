package ch.hslu.ad.sw06.N2.Aufg3;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		ArrayList<Consumer> consumers = new ArrayList<>(); //ArrayList for all consumers
		ArrayList<Producer> producers = new ArrayList<>(); //ArrayList for all producers
		ThreadGroup prodThreads = new ThreadGroup("Produzenten"); //ThreadGroup for all producer-Threads
		ThreadGroup consThreads = new ThreadGroup("Konsumenten"); //ThreadGroup for all consumer-Threads
		BoundedBuffer<Integer> buffer = new BoundedBuffer<>(5);
		final Logger LOG = LogManager.getLogger(Demo.class);
		int sumProducers = 0;
		int sumConsumers = 0;

		// Erstelle consumer-Threads und starte sie
		for (int i = 0; i < buffer.size(); i++) {
			consumers.add(new Consumer(buffer));
			new Thread(consThreads, consumers.get(i)).start();
		}
		// Erstelle producer-Threads und starte sie
		for (int i = 0; i < buffer.size(); i++) {
			producers.add(new Producer(buffer));
			new Thread(prodThreads, producers.get(i)).start();
		}
		// solange noch producer-Threads aktive sind, warte mit der Weiterfuehrung
		while(prodThreads.activeCount() > 0) {
			Thread.sleep(10);
		}
		// warte zur Sicherheit, damit auch wirklich alle producer-Threads tot sind
		Thread.sleep(1000);
		
		// toete alle consumer-Threads
		consThreads.interrupt();
		
		for (Consumer cons : consumers) {
			sumConsumers += cons.getSum();
		}
		
		for (Producer prod : producers) {
			sumProducers += prod.getSum();
		}
		
		LOG.info("Produziert: " + sumProducers + ", Konsumiert: " + sumConsumers);
		
		LOG.info("Produzenten(Lebendig): " + prodThreads.activeCount() + ", Konsumenten(Lebendig): " + consThreads.activeCount());
		
		LOG.info("Ist der Bounded-Buffer leer?: " + buffer.empty());

	}

}
