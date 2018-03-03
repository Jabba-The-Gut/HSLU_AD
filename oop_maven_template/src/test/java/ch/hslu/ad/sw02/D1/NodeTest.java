/**
 * 
 */
package ch.hslu.ad.sw02.D1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author jabbathegut
 *
 */
public class NodeTest {

	@Test
	public void testNode(){
		Allocation alloc = new Allocation(0, 16);
		Node node1 = new Node(alloc);
		assertTrue(node1.getNextNode() == null);
	}

	@Test
	public void testSetNextNode(){
		Allocation alloc1 = new Allocation(0, 16);
		Allocation alloc2 = new Allocation(16, 2);
		Node node1 = new Node(alloc1);
		Node node2 = new Node(alloc2);
		node1.setNextNode(node2);
		assertTrue(node1.getNextNode().equals(node2) && node2.getNextNode() == null);
	}

	@Test
	public void testEqualsTrue(){
		Allocation alloc1 = new Allocation(0, 16);
		Node node1 = new Node(alloc1);
		Node node2 = node1;
		assertTrue(node1.equals(node2));
	}
}
