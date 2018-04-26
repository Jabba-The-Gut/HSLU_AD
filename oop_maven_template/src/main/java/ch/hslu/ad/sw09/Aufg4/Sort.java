package ch.hslu.ad.sw09.Aufg4;

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

}
