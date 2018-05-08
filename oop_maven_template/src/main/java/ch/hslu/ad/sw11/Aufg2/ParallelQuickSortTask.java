package ch.hslu.ad.sw11.Aufg2;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

import ch.hslu.ad.sw10.Aufg3.Sort;

public class ParallelQuickSortTask extends RecursiveAction {
	final char[] a;
	final int left;
	final int right;

	public ParallelQuickSortTask(final char[] a) {
		this.a = a;
		this.left = 0;
		this.right = (a.length - 1);
	}

	private ParallelQuickSortTask(final char[] a, final int left, final int right) {
		this.a = a;
		this.left = left;
		this.right = right;
	}

	@Override
	protected void compute() {
		int up = left; // linke Grenze
		int down = right - 1; // rechte Grenze (ohne Trennelement)
		char t = a[right]; // rechtes Element als Trennelement
		boolean allChecked = false;
		do {
			while (a[up] < t) {
				up++; // suche grösseres (>=) Element von links an
			}
			while ((a[down] >= t) && (down > up)) {
				down--; // suche echt kleineres(<) Element von rechts an
			}
			if (down > up) { // solange keine Überschneidung
				exchange(a, up, down);
				up++;
				down--; // linke und rechte Grenze verschieben
			} else {
				allChecked = true; // Austauschen beendet
			}
		} while (!allChecked);
		exchange(a, up, right); // Trennelement an endgültige Position (a[up])
		if ((left - (up - 1)) < 25000) {
			Arrays.sort(a);
		} else {
			new ParallelQuickSortTask(a, left, (up - 1)).fork(); // linke Hälfte
		}
		if (((up + 1) - right) < 25000) {
			Arrays.sort(a);
		} else {
			if ((up + 1) < right)
				new ParallelQuickSortTask(a, left, (up - 1)).fork(); // linke Hälfte
		}

	}

	private final void exchange(final char[] a, final int firstIndex, final int secondIndex) {
		char tmp;
		tmp = a[firstIndex];
		a[firstIndex] = a[secondIndex];
		a[secondIndex] = tmp;
	}

}
