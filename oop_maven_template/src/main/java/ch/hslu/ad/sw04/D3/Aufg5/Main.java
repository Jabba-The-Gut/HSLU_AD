package ch.hslu.ad.sw04.D3.Aufg5;

import java.util.ArrayDeque;
import java.util.Stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.ad.sw02.D1.Aufg3.StringStack;
import ch.hslu.ad.sw02.D1.Aufg3.StringStack.StackFullException;

public class Main {
	private static final Logger LOG = LogManager.getLogger(Main.class);
	private static final int SIZE = 100000;

	public static void main(String[] args) throws StackFullException {
		// Messung der Zeit für Datenerstellung
		long start1 = System.currentTimeMillis();

		String[] data = DataGenerator.testData(SIZE);

		long end1 = System.currentTimeMillis();

		LOG.info("Dauer in Millisekunden: " + (end1 - start1));

		// Messung der Zeit für Abfüllung der Daten in java.util.Stack
		long start2 = System.currentTimeMillis();

		Stack<String> stack1 = new Stack<>();
		for (int i = 0; i < data.length; i++) {
			stack1.push(data[i]);
		}

		long end2 = System.currentTimeMillis();

		LOG.info("Dauer in Millisekunden (java.util.Stack): " + (end2 - start2));

		// Messung der Zeit für Abfüllung der Daten in StringStack
		long start3 = System.currentTimeMillis();

		StringStack stack2 = new StringStack(SIZE);
		for (int i = 0; i < data.length; i++) {
			stack2.push(data[i]);
		}

		long end3 = System.currentTimeMillis();

		LOG.info("Dauer in Millisekunden (StringStack): " + (end3 - start3));

		// Messung der Zeit für Abfüllung der Daten in ArrayDeque
		long start4 = System.currentTimeMillis();

		ArrayDeque<String> arrayDeque = new ArrayDeque<>();
		for (int i = 0; i < data.length; i++) {
			arrayDeque.add(data[i]);
		}

		long end4 = System.currentTimeMillis();

		LOG.info("Dauer in Millisekunden (ArrayDeque): " + (end4 - start4));

	}

}
