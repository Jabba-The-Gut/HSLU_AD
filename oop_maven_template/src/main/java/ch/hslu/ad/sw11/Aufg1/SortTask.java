package ch.hslu.ad.sw11.Aufg1;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/*
 * Paralleller Merge-Sort mittels dem Fork-Join-Verfahren
 */
public class SortTask extends RecursiveAction {
	private final int[] array;
	private final int min;
	private final int max;
	private final int THRESHOLD = 25000000;

	/**
	 * Konstruktor, welche für die Initialisierung des ersten Objekts gebraucht
	 * wird.
	 * 
	 * @param array
	 */
	public SortTask(final int[] array) {
		this.array = array;
		this.min = 0;
		this.max = (array.length - 1);
	}

	/**
	 * Konstruktor, welcher intern für die Aufteilung der Aufgabe benötigt wird.
	 * 
	 * @param array
	 * @param max
	 * @param min
	 */
	private SortTask(final int[] array, final int min, final int max) {
		this.array = array;
		this.min = min;
		this.max = max;
	}

	@Override
	protected void compute() {
		if (max - min < THRESHOLD) {
			sortSequentially(min, max);
		} else {
			final int mid = min + (max - min) / 2;
			invokeAll(new SortTask(array, min, mid), new SortTask(array, mid, max));
			merge(min, mid, max);
		}
	}

	private void sortSequentially(final int min, final int max) {
		Arrays.sort(this.array, min, max);
	}

	private void merge(final int min, int mid, int max) {
		int[] buf = Arrays.copyOfRange(this.array, min, mid);
		int i = 0;
		int j = min;
		int k = mid;
		while (i < buf.length) {
			if (k == max || buf[i] < this.array[k]) {
				this.array[j] = buf[i];
				i++;
			} else {
				this.array[j] = this.array[k];
				k++;
			}
			j++;
		}
	}

}
