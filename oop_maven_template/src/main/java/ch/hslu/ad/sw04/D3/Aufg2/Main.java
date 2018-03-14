package ch.hslu.ad.sw04.D3.Aufg2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static final Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc1 = new Allocation(13, 2, false);
		Allocation alloc2 = new Allocation(23, 2, false);
		Allocation alloc3 = new Allocation(33, 2, false);
		Allocation alloc4 = new Allocation(29, 2, false);

		hashTable.add(alloc1);
		hashTable.add(alloc2);
		hashTable.add(alloc3);
		hashTable.add(alloc4);
		hashTable.remove(alloc2);

		LOG.info(hashTable.toString());
		LOG.info(hashTable.get(alloc3));

	}

}
