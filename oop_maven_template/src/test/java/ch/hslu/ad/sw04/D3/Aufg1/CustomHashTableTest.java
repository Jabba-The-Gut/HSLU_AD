/**
 * 
 */
package ch.hslu.ad.sw04.D3.Aufg1;

import org.junit.Test;

import ch.hslu.ad.sw04.D3.Aufg1.Allocation;
import ch.hslu.ad.sw04.D3.Aufg1.CustomHashTable;

import org.junit.Assert;

/**
 * @author jabbathegut
 *
 */
public class CustomHashTableTest {

	@Test
	public void testCustomHashTable() {
		CustomHashTable hashTable = new CustomHashTable(10);
		Assert.assertTrue(hashTable != null);
		;
	}

	@Test
	public void testAdd() {
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc = new Allocation(12, 4);
		hashTable.add(alloc);
		Assert.assertTrue(hashTable.get(alloc) == alloc);
	}

	@Test
	public void testAddCollision() {
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc = new Allocation(12, 4);
		Allocation alloc2 = new Allocation(22, 4);
		hashTable.add(alloc);
		hashTable.add(alloc2);
		Assert.assertTrue(!hashTable.get(alloc).equals(alloc));
	}

	@Test
	public void testRemove() {
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc = new Allocation(12, 4);
		hashTable.remove(alloc);
		Assert.assertTrue(hashTable.get(alloc) == null);
	}

}
