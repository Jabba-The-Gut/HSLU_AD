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
		final AtomicCounter atomicCounter = new AtomicCounter();
		final SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
		ExecutorService serviceSynchronized = Executors.newFixedThreadPool(10);
		ExecutorService serviceAtomic = Executors.newFixedThreadPool(10);
		ArrayList<Future<Boolean>> boolAtomic = new ArrayList<>();
		ArrayList<Future<Boolean>> boolSynchronized = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			boolAtomic.add(serviceAtomic.submit(new CountingTask(100, atomicCounter)));
		}
		for (int i = 0; i < 10; i++) {
			boolSynchronized.add(serviceSynchronized.submit(new CountingTask(100, synchronizedCounter)));
		}

		for (Future<Boolean> future : boolAtomic) {
			future.get();
		}

		for (Future<Boolean> future : boolSynchronized) {
			future.get();
		}

		serviceAtomic.shutdown();
		serviceSynchronized.shutdownNow();

		LOG.info("Zeit Atomic-Counter" + atomicCounter.getTime());
		LOG.info("Zeit Synchronized-Counter" + atomicCounter.getTime());

	}

}
