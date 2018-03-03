package ch.hslu.ad.sw02.D1.Aufg3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
	private static final Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		StringStack stack = new StringStack(3);
		try {
			stack.push("toll!");
			stack.push("sind");
			stack.push("Datenstrukturen");
			LOG.info("Stack-Inhalt: " + stack.pop() + " " + stack.pop() + " "+ stack.pop());
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

	}

}
