package ch.hslu.ad.sw10.Aufg2;

/**
 * Bibliotheks-Klasse, welche versch. Sorier-Funktionen zur Verfügung stellt
 * 
 * @author Dave
 *
 */
public class Sort {

	/**
	 * Methode, welche einfach 2 Plätze in Array vertauscht
	 * 
	 * @param element
	 * @param i
	 * @param j
	 */
	private static void swap(int[] element, int i, int j) {
		int temp = element[i];
		element[i] = element[j];
		element[j] = temp;
	}

	/**
	 * Methode, welche einfach 2 Plätze in Array vertauscht
	 * 
	 * @param element
	 * @param i
	 * @param j
	 */
	private static void swap(char[] element, int i, int j) {
		char temp = element[i];
		element[i] = element[j];
		element[j] = temp;
	}

	/**
	 * Sortiert das int‐Array aufsteigend, mit Insertion-Sort
	 * 
	 * @param a
	 *            Zu sortierendes Array.
	 */
	public static void insertionSort(final int[] a) {
		for (int i = 0; i < a.length; i++) {
			int current = i;
			if (current != a.length - 1) {
				while (a[current] > a[current + 1]) {
					Sort.swap(a, current, current + 1);
					if (current != 0) {
						current--;
					}
				}
			}
		}
	}

	/**
	 * Sortiert das int-Array aufsteigend, mit Selection-Sort
	 * 
	 * @param a
	 */
	public static void selectionSort(final int[] a) {
		for (int i = 0; i < a.length - 2; i++) {
			int lowestValue = i + 1;

			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[lowestValue]) {
					lowestValue = j;
				}
			}
			Sort.swap(a, i, lowestValue);
		}
	}

	/**
	 * Sortiert das int-Array aufsteigen, mit Bubble-Sort
	 * 
	 * @param a
	 */
	public static void bubbleSort(final int[] a) {
		for (int j = 0; j < a.length; j++) {
			for (int i = 0; i < a.length; i++) {
				if (i != a.length - 1) {
					if (a[i] > a[i + 1]) {
						Sort.swap(a, i, i + 1);
					}
				}
			}
		}
	}

	/**
	 * Sortiert ein char-Array aufsteigend, mit QuickSort
	 * @param a
	 * @param left
	 * @param right
	 */
	public static final void quickSort(final char[] a, final int left, final int right) {
		int up = left;
		int down = right - 1;
		char t = a[right];
		boolean allChecked = false;
		do {
			while (a[up] < t) {
				up++;
			}
			while ((a[down] >= t) && (down > up)) {
				down--;
			}
			if (down > up) {
				swap(a, up, down);
				up++;
				down--;
			} else {
				allChecked = true;
			}
		} while (!allChecked);
		swap(a, up, right);
		if (left < (up - 1))
			quickSort(a, left, (up - 1));
		if ((up + 1) < right)
			quickSort(a, (up + 1), right);
	}

}
