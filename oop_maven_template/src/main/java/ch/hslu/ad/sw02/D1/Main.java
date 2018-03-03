package ch.hslu.ad.sw02.D1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
	private static final Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		LinkedList linkedL = new LinkedList();
		Allocation alloc1 = new Allocation(0, 16);
		Allocation alloc2 = new Allocation(16, 2);
		linkedL.add(alloc1);
		linkedL.add(alloc2);
		boolean hehe = alloc1.equals(linkedL.get(alloc1));
		LOG.info(linkedL.toString());
		LOG.info(hehe);

	}

}
