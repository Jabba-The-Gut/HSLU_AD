package ch.hslu.ad.sw03.D2.Aufg6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Main {
	private static final Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.insert(new Allocation(2, 5));
		tree.insert(new Allocation(7, 3));
		tree.insert(new Allocation(10, 6));
		tree.insert(new Allocation(16,10));
		tree.insert(new Allocation(18,2));
		tree.insert(new Allocation(22,4));

		tree.inOrderRek(tree.getRoot());
		LOG.info("---");
		tree.postOrderRek(tree.getRoot());
		LOG.info("---");
		tree.preOrderRek(tree.getRoot());
	}

}
