package ch.hslu.ad.sw08.N3.Aufg1;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int sizeBuffer = 5;
		ArrayList<Consumer> consumers = new ArrayList<>(); // ArrayList fuer alle Konsumenten
		ArrayList<Producer> producers = new ArrayList<>(); // ArrayList fuer alle Produzenten
		ArrayList<Future<Integer>> sumCons = new ArrayList<>(); // ArrayList mit Futures fuer Summen der Konsumenten
		ArrayList<Future<Integer>> sumProd = new ArrayList<>(); // ArrayList mit Futures fuer Summen der Produzenten
		ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(sizeBuffer);
		final ExecutorService serviceProd = Executors.newFixedThreadPool(sizeBuffer);// Executor-Service fuer Produzenten
		final ExecutorService serviceCons = Executors.newFixedThreadPool(sizeBuffer); // Executor-Service fuer Konsumenten
		final Logger LOG = LogManager.getLogger(Demo.class);
		int sumConsumers = 0;
		int sumProducers = 0;

		// Erstelle Konsumenten und uebergebe sie dem Executor-Service
		for (int i = 0; i < sizeBuffer; i++) {
			consumers.add(new Consumer(buffer));
			sumCons.add(serviceCons.submit(consumers.get(i)));
		}
		// Erstelle Produzenten und uebergebe sie dem Executor-Service
		for (int i = 0; i < sizeBuffer; i++) {
			producers.add(new Producer(buffer));
			sumProd.add(serviceProd.submit(producers.get(i)));
		}

		// Frage die Summen von allen Produzenten ab. Ist blockierend, bis alle
		// Produzenten fertig sind
		for (Future<Integer> future : sumProd) {
			sumProducers += future.get();
		}

		// Setze run-Boolean der Konsumenten auf false, denn alle Produzenten sind
		// fertig
		for (Consumer cons : consumers) {
			cons.stop();
		}

		// Der Konsumenten-Service kann nun heruntergefahren werden, der
		// Produzenten-Service sowieso
		serviceCons.shutdownNow();
		serviceProd.shutdownNow();

		for (Future<Integer> future : sumCons) {
			sumConsumers += future.get();
		}

		LOG.info("Produziert: " + sumProducers + ", Konsumiert: " + sumConsumers);

		LOG.info("Ist der Bounded-Buffer leer?: " + buffer.isEmpty());

	}

}
