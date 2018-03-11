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
		tree.insert(5);
		tree.insert(3);
		tree.insert(6);
		tree.insert(10);
		tree.insert(2);
		tree.insert(4);
		tree.insert(9);
		Assert.assertTrue(tree.getSize() == 7);
	}

	@Test
	public void testContainsTrue(){
		BinaryTree tree = new BinaryTree();
		tree.insert(5);
		tree.insert(3);
		tree.insert(6);
		tree.insert(10);
		tree.insert(2);
		tree.insert(4);
		tree.insert(9);
		Assert.assertTrue(tree.contains(6));
	}
	
	@Test
	public void testContainsFalse(){
		BinaryTree tree = new BinaryTree();
		tree.insert(5);
		tree.insert(3);
		tree.insert(6);
		tree.insert(10);
		tree.insert(2);
		tree.insert(4);
		tree.insert(9);
		Assert.assertTrue(!tree.contains(1));
	}
	
	@Test
	public void testContainsRoot(){
		BinaryTree tree = new BinaryTree();
		tree.insert(5);
		Assert.assertTrue(tree.contains(5));
	}


	
	
}
