package ch.hslu.ad.sw11.Aufg2;

import java.util.Random;
import java.util.concurrent.RecursiveAction;

public class RandomInitTask extends RecursiveAction {
	private final char[] abc;

	public RandomInitTask(final char[] abc) {
		this.abc = abc;
	}

	@Override
	protected void compute() {
		for (int i = 0; i < abc.length; i++) {
			Random r = new Random();
			abc[i] = (char) (r.nextInt(26) + 'a');
		}

	}

}
