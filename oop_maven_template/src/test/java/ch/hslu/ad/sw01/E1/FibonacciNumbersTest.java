/**
 * 
 */
package ch.hslu.ad.sw01.E1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Dave
 *
 */
public class FibonacciNumbersTest {

	/**
	 * Test method for {@link ch.hslu.ad.sw01.E1.FibonacciNumbers#fiboRec1(int)}.
	 */
	@Test
	public void testFiboRec1NormalThird() throws Exception {
		int expectedFib = 3;
		assertEquals(1, FibonacciNumbers.fiboRec1(expectedFib - 1));
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw01.E1.FibonacciNumbers#fiboRec1(int)}.
	 */
	@Test
	public void testFiboRec1NormalNinth() throws Exception {
		int expectedFib = 9;
		assertEquals(21, FibonacciNumbers.fiboRec1(expectedFib - 1));
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw01.E1.FibonacciNumbers#fiboRec1(int)}.
	 */
	@Test
	public void testFiboRec1NormalFifth() throws Exception {
		int expectedFib = 5;
		assertEquals(3, FibonacciNumbers.fiboRec1(expectedFib - 1));
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw01.E1.FibonacciNumbers#fiboIter(int)}.
	 */
	@Test
	public void testFiboIterNormalThird() throws Exception {
		assertEquals(1, FibonacciNumbers.fiboIter(3));
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw01.E1.FibonacciNumbers#fiboIter(int)}.
	 */
	@Test
	public void testFiboIterNormalNinth() throws Exception {
		assertEquals(21, FibonacciNumbers.fiboIter(9));
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw01.E1.FibonacciNumbers#fiboIter(int)}.
	 */
	@Test
	public void testFiboIterNormalFifth() throws Exception {
		assertEquals(3, FibonacciNumbers.fiboIter(5));
	}

}
