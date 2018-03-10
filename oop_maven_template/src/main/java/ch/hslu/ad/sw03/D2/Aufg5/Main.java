package ch.hslu.ad.sw03.D2.Aufg5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static final Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		Node node2 = new Node(3);
		Node node3 = new Node(2);
		Node node4 = new Node(1);
		Node node5 = new Node(4);
		Node node6 = new Node(9);
		Node node7 = new Node(7);
		Node node8 = new Node(6);
		Node node9 = new Node(10);
		Node node10 = new Node(12);
		BinaryTree tree = new BinaryTree();
		tree.insert(5);

	}

}
