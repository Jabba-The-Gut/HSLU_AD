package ch.hslu.ad.sw04.D3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static final Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		Allocation alloc = new Allocation(25, 3);
		int hash = alloc.hashCode() % 10;
		LOG.info(hash);

	}

}
