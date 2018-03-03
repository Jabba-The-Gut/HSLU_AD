/**
 * 
 */
package ch.hslu.ad.sw02.D1.Aufg2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import ch.hslu.ad.sw02.D1.Aufg2.Allocation;
import ch.hslu.ad.sw02.D1.Aufg2.LinkedList;
import ch.hslu.ad.sw02.D1.Aufg2.LinkedListIterator;

/**
 * @author Dave
 *
 */
public class LinkedListTest {

	/**
	 * Test method for
	 * {@link ch.hslu.ad.sw02.D1.Aufg2.LinkedList#add(ch.hslu.ad.sw02.D1.Aufg2.Allocation)}.
	 */
	@Test
	public void testAddOne() {
		LinkedList linkedList = new LinkedList();
		Allocation alloc1 = new Allocation(0, 16);
		linkedList.add(alloc1);
		assertTrue(linkedList.getSize() == 1);
	}

	/**
	 * Test method for
	 * {@link ch.hslu.ad.sw02.D1.Aufg2.LinkedList#add(ch.hslu.ad.sw02.D1.Aufg2.Allocation)}.
	 */
	@Test
	public void testAddMultiple() {
		LinkedList linkedList = new LinkedList();
		Allocation alloc1 = new Allocation(0, 16);
		Allocation alloc2 = new Allocation(16, 10);
		Allocation alloc3 = new Allocation(26, 2);
		linkedList.add(alloc1);
		linkedList.add(alloc2);
		linkedList.add(alloc3);
		assertTrue(linkedList.getSize() == 3);
	}

	/**
	 * Test method for
	 * {@link ch.hslu.ad.sw02.D1.Aufg2.LinkedList#occurs(ch.hslu.ad.sw02.D1.Aufg2.Allocation)}.
	 */
	@Test
	public void testContains() {
		LinkedList linkedList = new LinkedList();
		Allocation alloc1 = new Allocation(0, 16);
		Allocation alloc2 = new Allocation(16, 10);
		Allocation alloc3 = new Allocation(26, 2);
		linkedList.add(alloc1);
		linkedList.add(alloc2);
		linkedList.add(alloc3);
		assertTrue(linkedList.contains(alloc1));
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw02.D1.Aufg2.LinkedList#removeFirst()}.
	 */
	@Test
	public void testRemoveFirst() {
		LinkedList linkedList = new LinkedList();
		Allocation alloc1 = new Allocation(0, 16);
		Allocation alloc2 = new Allocation(16, 10);
		Allocation alloc3 = new Allocation(26, 2);
		linkedList.add(alloc1);
		linkedList.add(alloc2);
		linkedList.add(alloc3);
		Allocation alloc4 = linkedList.removeFirst();
		assertTrue(alloc4.equals(alloc3) && linkedList.getSize() == 2);
	}

	/**
	 * Test method for
	 * {@link ch.hslu.ad.sw02.D1.Aufg2.LinkedList#remove(ch.hslu.ad.sw02.D1.Aufg2.Allocation)}.
	 */
	@Test
	public void testRemoveIsFirst() {
		LinkedList linkedList = new LinkedList();
		Allocation alloc1 = new Allocation(0, 16);
		Allocation alloc2 = new Allocation(16, 10);
		linkedList.add(alloc1);
		linkedList.add(alloc2);
		boolean remov = linkedList.remove(alloc2);
		assertTrue(remov && !linkedList.contains(alloc2) && linkedList.getSize() == 1);
	}

	/**
	 * Test method for
	 * {@link ch.hslu.ad.sw02.D1.Aufg2.LinkedList#remove(ch.hslu.ad.sw02.D1.Aufg2.Allocation)}.
	 */
	@Test
	public void testRemoveNormal() {
		LinkedList linkedList = new LinkedList();
		Allocation alloc1 = new Allocation(0, 16);
		Allocation alloc2 = new Allocation(16, 10);
		Allocation alloc3 = new Allocation(26, 10);
		linkedList.add(alloc1);
		linkedList.add(alloc2);
		linkedList.add(alloc3);
		boolean remov = linkedList.remove(alloc2);
		assertTrue(remov && !linkedList.contains(alloc2) && linkedList.getSize() == 2);
	}

	/**
	 * Test method for
	 * {@link ch.hslu.ad.sw02.D1.Aufg2.LinkedList#remove(ch.hslu.ad.sw02.D1.Aufg2.Allocation)}.
	 */
	@Test
	public void testRemoveIsLast() {
		LinkedList linkedList = new LinkedList();
		Allocation alloc1 = new Allocation(0, 16);
		Allocation alloc2 = new Allocation(16, 10);
		Allocation alloc3 = new Allocation(26, 10);
		linkedList.add(alloc1);
		linkedList.add(alloc2);
		linkedList.add(alloc3);
		boolean remov = linkedList.remove(alloc1);
		assertTrue(remov && !linkedList.contains(alloc1) && linkedList.getSize() == 2);
	}

	/**
	 * Test method for
	 * {@link ch.hslu.ad.sw02.D1.Aufg2.LinkedList#remove(ch.hslu.ad.sw02.D1.Aufg2.Allocation)}.
	 */
	@Test
	public void testRemoveEmptyList() {
		LinkedList linkedList = new LinkedList();
		Allocation alloc1 = new Allocation(0, 16);
		boolean remov = linkedList.remove(alloc1);
		assertTrue(!remov);
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw02.D1.Aufg2.LinkedList#iterator()}.
	 */
	@Test
	public void testIterator() {
		ArrayList<Integer> addresses = new ArrayList<>();
		LinkedList linkedList = new LinkedList();
		Allocation alloc1 = new Allocation(0, 16);
		Allocation alloc2 = new Allocation(16, 10);
		Allocation alloc3 = new Allocation(26, 10);
		linkedList.add(alloc1);
		linkedList.add(alloc2);
		linkedList.add(alloc3);
		LinkedListIterator it = linkedList.iterator();
		while (it.hasNext()) {
			addresses.add(it.next().getData().getAddress());
		}

		assertArrayEquals(new ArrayList<Integer>() {
			{
				add(26);
				add(16);
				add(0);
			}
		}.toArray(), addresses.toArray());
	}

	/**
	 * Test method for
	 * {@link ch.hslu.ad.sw02.D1.Aufg2.LinkedList#containsIterator(ch.hslu.ad.sw02.D1.Aufg2.Allocation)}.
	 */
	@Test
	public void testContainsIterator() {
		LinkedList linkedList = new LinkedList();
		Allocation alloc1 = new Allocation(0, 16);
		Allocation alloc2 = new Allocation(16, 10);
		Allocation alloc3 = new Allocation(26, 2);
		linkedList.add(alloc1);
		linkedList.add(alloc2);
		linkedList.add(alloc3);
		assertTrue(linkedList.containsIterator(alloc1));
	}

}
