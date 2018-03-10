/**
 * 
 */
package ch.hslu.ad.sw03.D2.Aufg5;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dave
 *
 */
public class BinaryTreeTest {

	/**
	 * Test method for {@link ch.hslu.ad.sw03.D2.Aufg5.BinaryTree#BinaryTree(ch.hslu.ad.sw03.D2.Aufg5.Node)}.
	 */
	@Test
	public void testBinaryTree(){

	}

	@Test
	public void testContainsTrue(){
		BinaryTree tree = new BinaryTree();
		boolean contains = tree.contains(9);
		Assert.assertTrue(contains);
	}
	
	@Test
	public void testContainsFalse(){
		BinaryTree tree = new BinaryTree();
		boolean contains = tree.contains(13);
		Assert.assertFalse(contains);
	}
}
