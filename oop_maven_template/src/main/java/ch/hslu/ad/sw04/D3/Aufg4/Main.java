package ch.hslu.ad.sw04.D3.Aufg4;

import java.util.HashSet;

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

		long start1 = System.currentTimeMillis();
		hashTable.add(alloc1);
		long end1 = System.currentTimeMillis();
		hashTable.add(alloc2);
		hashTable.add(alloc3);
		hashTable.add(alloc4);
		long start2 = System.currentTimeMillis();
		hashTable.remove(alloc2);
		long end2 = System.currentTimeMillis();
		long start3 = System.currentTimeMillis();
		hashTable.get(alloc3);
		long end3 = System.currentTimeMillis();
		
		LOG.info("Eigene Hash-Table Implementation:");
		LOG.info("Dauer add()-Methode: " + (end1 - start1));
		LOG.info("Dauer remove()-Methode: " + (end2 - start2));
		LOG.info("Dauer get()-Methode: " + (end3 - start3));
		
		
		HashSet<Allocation> hashSet = new HashSet<>(10);
		long start10 = System.currentTimeMillis();
		hashSet.add(alloc1);
		long end10 = System.currentTimeMillis();
		hashSet.add(alloc2);
		hashSet.add(alloc3);
		hashSet.add(alloc4);
		long start20 = System.currentTimeMillis();
		hashSet.remove(alloc2);
		long end20 = System.currentTimeMillis();
		long start30 = System.currentTimeMillis();
		hashSet.contains(alloc3);
		long end30 = System.currentTimeMillis();
		
		LOG.info("java.util.HashSet:");
		LOG.info("Dauer add()-Methode: " + (end10 - start10));
		LOG.info("Dauer remove()-Methode: " + (end20 - start20));
		LOG.info("Dauer get()-Methode: " + (end30 - start30));

	}

}
