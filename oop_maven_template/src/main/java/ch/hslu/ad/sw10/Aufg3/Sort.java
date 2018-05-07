package ch.hslu.ad.sw10.Aufg3;

import java.util.Random;

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
	private static final void swap(int[] element, int i, int j) {
		int temp = element[i];
		element[i] = element[j];
		element[j] = temp;
	}

	/**
	 * Vertauscht zwei bestimmte Zeichen im Array.
	 *
	 * @param a
	 *            Zeichen‐Array
	 * @param firstIndex
	 *            Index des ersten Zeichens
	 * @param secondIndex
	 *            Index des zweiten Zeichens
	 */
	private static final void exchange(final char[] a, final int firstIndex, final int secondIndex) {
		char tmp;
		tmp = a[firstIndex];
		a[firstIndex] = a[secondIndex];
		a[secondIndex] = tmp;
	}

	public static char[] randomChars(final int lenght) {
		final char[] a = new char[lenght];
		for (int i = 0; i < lenght; i++) {
			Random r = new Random();
			a[i] = (char) (r.nextInt(26) + 'a');
		}
		return a;
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
	 * Sortiert das char‐Array aufsteigend, mit Insertion-Sort
	 * 
	 * @param a
	 *            Zu sortierendes Array.
	 */
	public static void insertionSort(final char[] a) {
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
	 * Sortier das char-Array aufsteigend
	 * 
	 * @param a
	 *            char array
	 * @param left
	 *            index des ersten Elements
	 * @param right
	 *            index des letzten Elements
	 */
	public static final void quickSort(final char[] a, final int left, final int right) {
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
		exchange(a, up, right); // Trennelement an endgültige Position (a[up])
		if (left < (up - 1))
			quickSort(a, left, (up - 1)); // linke Hälfte
		if ((up + 1) < right)
			quickSort(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
	}

	/**
	 * Sortier das char-Array aufsteigend
	 * 
	 * @param a
	 *            char array
	 * @param left
	 *            index des ersten Elements
	 * @param right
	 *            index des letzten Elements
	 */
	public static final void quickSort(final char[] a) {
		final int left = 0;
		final int right = a.length - 1;
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
		exchange(a, up, right); // Trennelement an endgültige Position (a[up])
		if (left < (up - 1))
			quickSort(a, left, (up - 1)); // linke Hälfte
		if ((up + 1) < right)
			quickSort(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
	}

	/**
	 * Sortier das char-Array aufsteigend, wenn eine Teilfolge von M Elementen zu
	 * sortieren ist, verwende InsertionSort
	 * 
	 * @param a
	 * @param TRESHOLD
	 *            Schwellenwert der Teilfolgengroesse
	 */
	public static final void quickInsertionSort(final char[] a, final int TRESHOLD) {
		final int left = 0;
		final int right = a.length - 1;
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
		exchange(a, up, right); // Trennelement an endgültige Position (a[up])

		// Hier ist noch ein Fehler drin. Ich sollte in der Else-condition wieder
		// QuickInsertionSort aufrufen!!
		if ((left - (up - 1)) == TRESHOLD) {
			Sort.insertionSort(a);
		} else {
			quickSort(a, left, (up - 1)); // linke Hälfte
		}
		if (((up + 1) - right) == TRESHOLD) {
			Sort.insertionSort(a);
		} else {
			if ((up + 1) < right)
				quickSort(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.}
		}
	}
}
