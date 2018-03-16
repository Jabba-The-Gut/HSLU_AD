/**
 * 
 */
package ch.hslu.ad.sw04.D3.Aufg3;

import org.junit.Assert;
import org.junit.Test;

import ch.hslu.ad.sw04.D3.Aufg3.Allocation;
import ch.hslu.ad.sw04.D3.Aufg3.CustomHashTable;

/**
 * @author Dave
 *
 */
public class CustomHashTableTest {

	/**
	 * Test method for
	 * {@link ch.hslu.ad.sw04.D3.Aufg3.CustomHashTable#CustomHashTable(int)}.
	 */
	@Test
	public void testCustomHashTable() {
		CustomHashTable hashTable = new CustomHashTable(10);
		Assert.assertTrue(hashTable != null);
	}

	@Test
	public void testAdd() {
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc1 = new Allocation(10, 4);
		hashTable.add(alloc1);
		Assert.assertTrue(hashTable.get(alloc1).equals(alloc1));
	}

	@Test
	public void testAddCollision() {
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc1 = new Allocation(10, 4);
		Allocation alloc2 = new Allocation(20, 4);
		hashTable.add(alloc1);
		hashTable.add(alloc2);
		Assert.assertTrue(hashTable.get(alloc2).equals(alloc2));
	}

	@Test
	public void testAddCollisionAtTheEnd() {
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc1 = new Allocation(19, 4);
		Allocation alloc2 = new Allocation(29, 4);
		hashTable.add(alloc1);
		Assert.assertTrue(hashTable.add(alloc2) && hashTable.get(alloc2).equals(alloc2));
	}

	@Test
	public void testGetEmpty() {
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc1 = new Allocation(13, 2);

		Assert.assertTrue(hashTable.get(alloc1) == null);
	}

	@Test
	public void testGetCollision() {
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc1 = new Allocation(13, 2);
		Allocation alloc2 = new Allocation(20, 2);
		Allocation alloc3 = new Allocation(10, 2);
		Allocation alloc4 = new Allocation(30, 2);

		hashTable.add(alloc1);
		hashTable.add(alloc2);
		hashTable.add(alloc3);
		hashTable.add(alloc4);

		Assert.assertTrue(hashTable.get(alloc3).equals(alloc3));
	}

	@Test
	public void testRemoveNormal() {
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc1 = new Allocation(13, 2);
		Allocation alloc2 = new Allocation(20, 2);
		Allocation alloc3 = new Allocation(10, 2);
		Allocation alloc4 = new Allocation(30, 2);

		hashTable.add(alloc1);
		hashTable.add(alloc2);
		hashTable.add(alloc3);
		hashTable.add(alloc4);

		hashTable.remove(alloc3);

		Assert.assertTrue(hashTable.get(alloc4).equals(alloc4));
	}

}
