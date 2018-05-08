package ch.hslu.ad.sw11.Aufg3;

import java.util.concurrent.RecursiveTask;

public class ParallelFibonacciTask extends RecursiveTask<Integer> {
	private final int n;

	public ParallelFibonacciTask(final int n) {
		this.n = n;
	}

	@Override
	protected Integer compute() {
		final int result;
		if (n == 0) { // Rekursionsbasis
			return 0;
		} else if (n == 1) {
			return 1; // Rekursionsbasis
		} else {
			ParallelFibonacciTask task1 = new ParallelFibonacciTask(n - 2);
			ParallelFibonacciTask task2 = new ParallelFibonacciTask(n - 1);
			task1.fork();
			result = task2.invoke() + task1.join();
		}
		return result;
	}

}
