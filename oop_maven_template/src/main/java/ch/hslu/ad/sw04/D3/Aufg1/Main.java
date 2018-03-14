package ch.hslu.ad.sw04.D3.Aufg1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static final Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc1 = new Allocation(13, 2);
		Allocation alloc2 = new Allocation(11, 2);
		Allocation alloc3 = new Allocation(10, 2);
		Allocation alloc4 = new Allocation(18, 2);
		
		hashTable.add(alloc1);
		hashTable.add(alloc2);
		hashTable.add(alloc3);
		hashTable.add(alloc4);
		
		LOG.info(hashTable.toString());
		
		hashTable.remove(alloc1);
		
		LOG.info(hashTable.toString());

	}

}
