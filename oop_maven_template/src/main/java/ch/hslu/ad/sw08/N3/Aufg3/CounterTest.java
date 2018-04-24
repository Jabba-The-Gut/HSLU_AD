package ch.hslu.ad.sw08.N3.Aufg3;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CounterTest {
	final static Logger LOG = LogManager.getFormatterLogger(CounterTest.class);

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// declare parameter for number of threads and number of Increments and number
		// of Decrements so
		// that these settings are configured in one place. Ideal number of threads is
		// number of processors plus 1
		int numberOfThreads = Runtime.getRuntime().availableProcessors() + 1;
		int numberOfIncAndDec = 1000000;

		// declare counters
		final AtomicCounter atomicCounter = new AtomicCounter();
		final SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

		// declare ExecutorService
		ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
		ArrayList<Future<Long>> resultsAtomic = new ArrayList<>();
		ArrayList<Future<Long>> resultsSynchronized = new ArrayList<>();

		// declare two variables to hold the elapsed time for the two counters
		long timeElapsedSynchronized = 0;
		long timeElapsedAtomic = 0;

		LOG.info("Simulation starting...");

		for (int i = 0; i < numberOfThreads; i++) {
			resultsAtomic.add(service.submit(new CountingTask(numberOfIncAndDec, numberOfIncAndDec, atomicCounter)));
		}

		// get time from all threads accessing the AtomicCounter (blocking)
		for (Future<Long> future : resultsAtomic) {
			timeElapsedAtomic += future.get();
		}

		for (int i = 0; i < numberOfThreads; i++) {
			resultsSynchronized
					.add(service.submit(new CountingTask(numberOfIncAndDec, numberOfIncAndDec, synchronizedCounter)));
		}

		// get time from all threads accessing the SynchronizedCounter (blocking)
		for (Future<Long> future : resultsSynchronized) {
			timeElapsedSynchronized += future.get();
		}

		// shut down the service now because it is sure that now tasks are active
		// anymore
		service.shutdown();

		// log elapsed time
		LOG.info("Zeit Atomic-Counter: " + timeElapsedAtomic);
		LOG.info("Zeit Synchronized-Counter: " + timeElapsedSynchronized);
		LOG.info("Simulation finished...");

	}

}
