package ch.hslu.ad.sw10.Aufg3;

import org.junit.Assert;
import org.junit.Test;

import ch.hslu.ad.sw10.Aufg3.Sort;

public class SortTest {

	@Test
	public void testInsertionSortCharArray() throws Exception {
		char[] unsorted = new char[] { 'a', 'c', 'd', 'z', 'b', 'x' };
		Sort.insertionSort(unsorted);
		Assert.assertArrayEquals(new char[] { 'a', 'b', 'c', 'd', 'x', 'z' }, unsorted);
	}

	@Test
		public void testQuickInsertionSort() throws Exception {
			char[] unsorted = new char[] { 'a', 'c', 'd', 'z', 'b', 'x', 'g', 'y', 'f', 'k', 'h', 'i' };
			Sort.quickInsertionSort(unsorted, 4);
			Assert.assertArrayEquals(new char[] { 'a', 'b', 'c', 'd', 'f', 'g', 'h', 'i', 'k', 'x', 'y', 'z' }, unsorted);
		}

}
