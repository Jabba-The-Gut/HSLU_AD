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
		BinaryTree tree = new BinaryTree();
		tree.insert(1);
		Assert.assertTrue(tree.getSize() == 1);
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw03.D2.Aufg5.BinaryTree#getRoot()}.
	 */
	@Test
	public void testGetRoot(){
		BinaryTree tree = new BinaryTree();
		tree.insert(3);
		Assert.assertTrue(tree.getRoot().getValue() == 3);
	}

}
