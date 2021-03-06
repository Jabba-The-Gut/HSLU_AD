package ch.hslu.ad.sw03.D2.Aufg5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Main {
	private static final Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.insert(5);
		tree.insert(3);
		tree.insert(6);
		tree.insert(10);
		tree.insert(2);
		tree.insert(4);
		tree.insert(9);

		tree.inOrderRek(tree.getRoot());
		LOG.info("---");
		tree.postOrderRek(tree.getRoot());
		LOG.info("---");
		tree.preOrderRek(tree.getRoot());
	}

}
