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
		// od Decrements so
		// that these settings are configured in one place
		int numberOfThreads = 100;
		int numberOfIncAndDec = 1000000;

		// declare counters
		final AtomicCounter atomicCounter = new AtomicCounter();
		final SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

		// declare ExecutorServices
		ExecutorService serviceSynchronized = Executors.newCachedThreadPool();
		ExecutorService serviceAtomic = Executors.newCachedThreadPool();
		ArrayList<Future<Long>> boolAtomic = new ArrayList<>();
		ArrayList<Future<Long>> boolSynchronized = new ArrayList<>();

		// declare two variables to hold the elapsed time for the two counters
		long timeElapsedSynchronized = 0;
		long timeElapsedAtomic = 0;

		LOG.info("Simulation starting...");

		for (int i = 0; i < numberOfThreads; i++) {
			boolAtomic.add(serviceAtomic.submit(new CountingTask(numberOfIncAndDec, numberOfIncAndDec, atomicCounter)));
		}
		for (int i = 0; i < numberOfThreads; i++) {
			boolSynchronized.add(serviceSynchronized
					.submit(new CountingTask(numberOfIncAndDec, numberOfIncAndDec, synchronizedCounter)));
		}

		// get time from alle threads accessing the AtomicCounter (blocking)
		for (Future<Long> future : boolAtomic) {
			timeElapsedAtomic += future.get();
		}

		// get time from all threads accessing the SynchronizedCounter (blocking)
		for (Future<Long> future : boolSynchronized) {
			timeElapsedSynchronized += future.get();
		}

		// shut down the two services now because it is sure that now tasks are active
		// anymore
		serviceAtomic.shutdown();
		serviceSynchronized.shutdown();

		// log elapsed time
		LOG.info("Zeit Atomic-Counter: " + timeElapsedAtomic);
		LOG.info("Anzahl Inc-/Dec-Aufrufe (muss 0 sein): " + atomicCounter.getcorrectCounterValue());
		LOG.info("Zeit Synchronized-Counter: " + timeElapsedSynchronized);
		LOG.info("Anzahl Inc-/Dec-Aufrufe (muss 0 sein): " + synchronizedCounter.getcorrectCounterValue());
		LOG.info("Simulation finished...");

	}

}
