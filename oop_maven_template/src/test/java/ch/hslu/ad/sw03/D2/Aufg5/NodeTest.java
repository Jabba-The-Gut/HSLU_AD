/**
 * 
 */
package ch.hslu.ad.sw03.D2.Aufg5;

import org.junit.Test;

import org.junit.Assert;

/**
 * @author Dave
 *
 */
public class NodeTest {

	/**
	 * Test method for
	 * {@link ch.hslu.ad.sw03.D2.Aufg5.Node#compareTo(ch.hslu.ad.sw03.D2.Aufg5.Node)}.
	 */
	@Test
	public void testCompareToEquals() throws Exception {
		Node node1 = new Node(3);
		Node node2 = new Node(3);
		Assert.assertTrue(node1.compareTo(node2) == 0);
	}
	
	/**
	 * Test method for
	 * {@link ch.hslu.ad.sw03.D2.Aufg5.Node#compareTo(ch.hslu.ad.sw03.D2.Aufg5.Node)}.
	 */
	@Test
	public void testCompareToSmaller() throws Exception {
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Assert.assertTrue(node1.compareTo(node2) == -1);
	}
	
	/**
	 * Test method for
	 * {@link ch.hslu.ad.sw03.D2.Aufg5.Node#compareTo(ch.hslu.ad.sw03.D2.Aufg5.Node)}.
	 */
	@Test
	public void testCompareToBigger() throws Exception {
		Node node1 = new Node(5);
		Node node2 = new Node(3);
		Assert.assertTrue(node1.compareTo(node2) == 1);
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw03.D2.Aufg5.Node#equals(java.lang.Object)}.
	 */
	@Test
	public void testEquals() throws Exception {
		Node node1 = new Node(3);
		Node node2 = new Node(3);
		Assert.assertTrue(node1.equals(node2));
	}

}
