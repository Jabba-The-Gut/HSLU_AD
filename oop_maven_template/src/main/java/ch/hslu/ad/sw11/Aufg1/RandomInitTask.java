package ch.hslu.ad.sw11.Aufg1;

import java.util.Random;
import java.util.concurrent.RecursiveAction;

public class RandomInitTask extends RecursiveAction {
	final int[] array;
	private final int boundary;

	public RandomInitTask(final int[] array, final int boundary) {
		this.array = array;
		this.boundary = boundary;
	}

	@Override
	protected void compute() {
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(boundary);
		}
	}

}
