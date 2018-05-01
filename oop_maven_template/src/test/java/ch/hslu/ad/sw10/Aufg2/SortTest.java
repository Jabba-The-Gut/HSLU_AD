/**
 * 
 */
package ch.hslu.ad.sw10.Aufg2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

;

/**
 * @author jabbathegut
 *
 */
public class SortTest {
	private static final Logger LOG = LogManager.getFormatterLogger(SortTest.class);

	@Test
	public void testQuickSort() throws Exception {
		char[] unsorted = new char[] { 'a', 'c', 'd', 'z', 'b', 'x' };
		Sort.quickSort(unsorted, 0, unsorted.length - 1);
		Assert.assertArrayEquals(new char[] { 'a', 'b', 'c', 'd', 'x', 'z' }, unsorted);
	}

	@Test
	public void testQuickSortCharArray() throws Exception {
		char[] unsorted = new char[] { 'a', 'c', 'd', 'z', 'b', 'x' };
		Sort.quickSort(unsorted);
		Assert.assertArrayEquals(new char[] { 'a', 'b', 'c', 'd', 'x', 'z' }, unsorted);
	}

	@Test
	public void testrandomChars() throws Exception {
		char[] test = Sort.randomChars(200);
		Assert.assertTrue(test.length == 200);
	}
}
