/**
 * 
 */
package ch.hslu.ad.sw09.Aufg4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dave
 *
 */
public class SortTest {
	private final static Logger LOG = LogManager.getLogger(SortTest.class);

	/**
	 * Test method for {@link ch.hslu.ad.sw09.Aufg4.Sort#insertionSort(int[])}.
	 */
	@Test
	public void testInsertionSortNormal() throws Exception {
		int[] unsorted = { 5, 1, 12, 9, 6, 3 };
		Sort.insertionSort(unsorted);
		Assert.assertArrayEquals(new int[] { 1, 3, 5, 6, 9, 12 }, unsorted);
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw09.Aufg4.Sort#insertionSort(int[])}.
	 */
	@Test
	public void testInsertionSortDoubleValues() throws Exception {
		int[] unsorted = { 6, 5, 1, 12, 9, 6, 1, 3 };
		Sort.insertionSort(unsorted);
		Assert.assertArrayEquals(new int[] { 1, 1, 3, 5, 6, 6, 9, 12 }, unsorted);
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw09.Aufg4.Sort#insertionSort(int[])}.
	 */
	@Test
	public void testInsertionSortSorted() throws Exception {
		int[] sorted = new int[10000];
		for (int i = 0; i < 10000; i++) {
			sorted[i] = i;
		}
		int[] sorted2 = sorted;
		long start = System.currentTimeMillis();
		Sort.insertionSort(sorted);
		long finish = System.currentTimeMillis();
		LOG.info("InsertionSort: Sortiertes Array: " + (finish - start));
		Assert.assertArrayEquals(sorted2, sorted);
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw09.Aufg4.Sort#insertionSort(int[])}.
	 */
	@Test
	public void testInsertionSortReverseSorted() throws Exception {
		int[] sorted = new int[10000];
		int value = sorted.length - 1;
		for (int i = 0; i < 10000; i++) {
			sorted[i] = value;
			value--;
		}

		int[] sorted2 = new int[10000];
		for (int i = 0; i < 10000; i++) {
			sorted2[i] = i;
		}

		long start = System.currentTimeMillis();
		Sort.insertionSort(sorted);
		long finish = System.currentTimeMillis();
		LOG.info("Insretion-Sort: Verkehrt-Sortiertes Array: " + (finish - start));
		Assert.assertArrayEquals(sorted2, sorted);
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw09.Aufg4.Sort#selectionSort(int[])}.
	 */
	@Test
	public void testSelectionSortNormal() throws Exception {
		int[] unsorted = { 5, 1, 12, 9, 6, 3 };
		Sort.selectionSort(unsorted);
		Assert.assertArrayEquals(new int[] { 1, 3, 5, 6, 9, 12 }, unsorted);
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw09.Aufg4.Sort#selectionSort(int[])}.
	 */
	@Test
	public void testSelectionSortDouble() throws Exception {
		int[] unsorted = { 5, 1, 12, 12, 9, 6, 6, 3 };
		Sort.selectionSort(unsorted);
		Assert.assertArrayEquals(new int[] { 1, 3, 5, 6, 6, 9, 12, 12 }, unsorted);
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw09.Aufg4.Sort#selectionSort(int[])}.
	 */
	@Test
	public void testSelectionSortSorted() throws Exception {
		int[] sorted = new int[10000];
		for (int i = 0; i < 10000; i++) {
			sorted[i] = i;
		}
		int[] sorted2 = sorted;
		long start = System.currentTimeMillis();
		Sort.selectionSort(sorted);
		long finish = System.currentTimeMillis();
		LOG.info("Selection-Sort: Sortiertes Array: " + (finish - start));
		Assert.assertArrayEquals(sorted2, sorted);
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw09.Aufg4.Sort#selectionSort(int[])}.
	 */
	@Test
	public void testSelectionSortReverseSorted() throws Exception {
		int[] sorted = new int[10000];
		int value = sorted.length - 1;
		for (int i = 0; i < 10000; i++) {
			sorted[i] = value;
			value--;
			
		}

		int[] sorted2 = new int[10000];
		for (int i = 0; i < 10000; i++) {
			sorted2[i] = i;
		}

		long start = System.currentTimeMillis();
		Sort.selectionSort(sorted);
		long finish = System.currentTimeMillis();
		LOG.info("Selection-Sort: Verkehrt-Sortiertes Array: " + (finish - start));
		Assert.assertArrayEquals(sorted2, sorted);
	}
}
