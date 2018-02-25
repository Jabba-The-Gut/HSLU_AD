package ch.hslu.ad.sw01.E1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FibonacciNumbers {
	private static final Logger LOG = LogManager.getLogger(FibonacciNumbers.class);
	private static int[] fibonacciNumbers = new int[] {};

	public static void main(String[] args) {

		int n = 6;
		// Berechnung der n-ten Fibonacci Zahl (0 wird als erste Fibonacci-Ziffer
		// gezählt)
		LOG.info(n + "te Fibonacci-Zahl (Rekursiv) = " + String.valueOf(fiboRec1(n - 1)));
		LOG.info(n + "te Fibonacci-Zahl (Iterativ) = " + String.valueOf(fiboIter(n)));
	}

	/**
	 * Rekursive Berechnung der n-ten Fibonacci-Zahl
	 * 
	 * @param n
	 *            Gewünschte Zahl der Fiboncci-Folge - 1
	 * @return Zahl der Fiboncci-Folge
	 */
	public static int fiboRec1(final int n) {
		if (n == 0) { // Rekursionsbasis
			return 0;
		} else if (n == 1) {
			return 1; // Rekursionsbasis
		} else {
			return (fiboRec1(n - 2) + fiboRec1(n - 1)); // Rekursionsvorschrift
		}
	}

	/**
	 * Iterative Berechnung der n-ten Fibonacci-Zahl
	 * 
	 * @param n
	 *            Gewünschte Zahl der Fibonacci-Folge
	 * @return Zahl der Fibonacci-Folge
	 */
	public static int fiboIter(final int n) {
		int[] result = new int[n];
		result[0] = 0;
		result[1] = 1;
		for (int i = 2; i < n; i++) {
			result[i] = result[i - 2] + result[i - 1];
		}
		return result[n - 1];
	}

}
