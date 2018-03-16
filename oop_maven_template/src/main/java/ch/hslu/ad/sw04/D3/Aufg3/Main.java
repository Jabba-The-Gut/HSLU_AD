package ch.hslu.ad.sw04.D3.Aufg3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static final Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc1 = new Allocation(13, 2);
		Allocation alloc2 = new Allocation(23, 2);
		Allocation alloc3 = new Allocation(33, 2);
		Allocation alloc4 = new Allocation(29, 2);

		hashTable.add(alloc1);
		hashTable.add(alloc2);
		hashTable.add(alloc3);
		hashTable.add(alloc4);
		hashTable.remove(alloc2);

		LOG.info(hashTable.toString());

	}

}
