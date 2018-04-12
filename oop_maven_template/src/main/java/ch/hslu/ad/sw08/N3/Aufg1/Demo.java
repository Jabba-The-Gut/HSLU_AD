package ch.hslu.ad.sw08.N3.Aufg1;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ArrayList<Consumer> consumers = new ArrayList<>(); // ArrayList for all consumers
		ArrayList<Producer> producers = new ArrayList<>(); // ArrayList for all producers
		ArrayList<Future<Integer>> sumCons = new ArrayList<>();
		ArrayList<Future<Integer>> sumProd = new ArrayList<>();
		BoundedBuffer<Integer> buffer = new BoundedBuffer<>(5);
		final ExecutorService serviceProd = Executors.newFixedThreadPool(buffer.size());
		final ExecutorService serviceCons = Executors.newFixedThreadPool(buffer.size());
		final Logger LOG = LogManager.getLogger(Demo.class);
		int sumConsumers = 0;
		int sumProducers = 0;

		// Erstelle consumer-Threads und starte sie
		for (int i = 0; i < buffer.size(); i++) {
			consumers.add(new Consumer(buffer));
			sumCons.add(serviceCons.submit(consumers.get(i)));
		}
		// Erstelle producer-Threads und starte sie
		for (int i = 0; i < buffer.size(); i++) {
			producers.add(new Producer(buffer));
			sumProd.add(serviceProd.submit(producers.get(i)));
		}
		// solange noch producer-Threads aktive sind, warte mit der Weiterfuehrung
		while (!serviceProd.isShutdown()) {
			Thread.sleep(10);
		}
		// warte zur Sicherheit, damit auch wirklich alle producer-Threads tot sind
		Thread.sleep(1000);

		serviceCons.shutdown();

		for (Future<Integer> future : sumCons) {
			sumConsumers += future.get();
		}

		for (Future<Integer> future : sumProd) {
			sumProducers += future.get();
		}

		LOG.info("Produziert: " + sumProducers + ", Konsumiert: " + sumConsumers);

		LOG.info("Ist der Bounded-Buffer leer?: " + buffer.empty());

	}

}
