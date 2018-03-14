/**
 * 
 */
package ch.hslu.ad.sw04.D3.Aufg2;

import org.junit.Assert;
import org.junit.Test;

import ch.hslu.ad.sw04.D3.Aufg2.Allocation;
import ch.hslu.ad.sw04.D3.Aufg2.CustomHashTable;

/**
 * @author jabbathegut
 *
 */
public class CustomHashTableTest {

	@Test
	public void testIsFullTrue() {
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc1 = new Allocation(10, 4, false);
		Allocation alloc2 = new Allocation(12, 4, false);
		Allocation alloc3 = new Allocation(11, 4, false);
		Allocation alloc4 = new Allocation(14, 4, false);
		Allocation alloc5 = new Allocation(13, 4, false);
		Allocation alloc6 = new Allocation(15, 4, false);
		Allocation alloc7 = new Allocation(16, 4, false);
		Allocation alloc8 = new Allocation(17, 4, false);
		Allocation alloc9 = new Allocation(18, 4, false);
		Allocation alloc10 = new Allocation(19, 4, false);
		hashTable.add(alloc1);
		hashTable.add(alloc2);
		hashTable.add(alloc3);
		hashTable.add(alloc4);
		hashTable.add(alloc5);
		hashTable.add(alloc6);
		hashTable.add(alloc7);
		hashTable.add(alloc8);
		hashTable.add(alloc9);
		hashTable.add(alloc10);
		Assert.assertTrue(hashTable.isFull());
	}

	@Test
	public void testAdd() {
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc1 = new Allocation(10, 4, false);
		hashTable.add(alloc1);
		Assert.assertTrue(hashTable.get(alloc1) == alloc1);
	}

	@Test
	public void testAddCollision() {
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc1 = new Allocation(10, 4, false);
		Allocation alloc2 = new Allocation(20, 4, false);
		hashTable.add(alloc1);
		hashTable.add(alloc2);
		Assert.assertTrue(hashTable.get(alloc1) == alloc1);
	}

	@Test
	public void testAddCollisionAtTheEnd() {
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc1 = new Allocation(19, 4, false);
		Allocation alloc2 = new Allocation(29, 4, false);
		hashTable.add(alloc1);
		Assert.assertFalse(hashTable.add(alloc2));
	}

	@Test
	public void testGetCollision() {
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc1 = new Allocation(13, 2, false);
		Allocation alloc2 = new Allocation(20, 2, false);
		Allocation alloc3 = new Allocation(10, 2, false);
		Allocation alloc4 = new Allocation(30, 2, false);

		hashTable.add(alloc1);
		hashTable.add(alloc2);
		hashTable.add(alloc3);
		hashTable.add(alloc4);

		Assert.assertTrue(hashTable.get(alloc3).equals(alloc3));
	}

	@Test
	public void testRemoveNormal(){
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc1 = new Allocation(13, 2,false);
		Allocation alloc2 = new Allocation(20, 2,false);
		Allocation alloc3 = new Allocation(10, 2,false);
		Allocation alloc4 = new Allocation(30, 2,false);
		
		hashTable.add(alloc1);
		hashTable.add(alloc2);
		hashTable.add(alloc3);
		hashTable.add(alloc4);
		
		hashTable.remove(alloc3);
		
		Assert.assertTrue(hashTable.get(alloc4).equals(alloc4));
	}
	
	@Test
	public void testRemoveNormalAtTheEnd(){
		CustomHashTable hashTable = new CustomHashTable(10);
		Allocation alloc1 = new Allocation(13, 2,false);
		Allocation alloc2 = new Allocation(29, 2,false);
		Allocation alloc3 = new Allocation(19, 2,false);
		Allocation alloc4 = new Allocation(39, 2,false);
		
		hashTable.add(alloc1);
		hashTable.add(alloc2);
		hashTable.add(alloc3);
		hashTable.add(alloc4);
		
		hashTable.remove(alloc3);
		
		Assert.assertTrue(hashTable.get(alloc4) == null);
	}
	
	

}
