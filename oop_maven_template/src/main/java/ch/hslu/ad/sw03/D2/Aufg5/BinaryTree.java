package ch.hslu.ad.sw03.D2.Aufg5;

public class BinaryTree implements Tree<Integer> {

	private Node root;
	private int size;

	public BinaryTree() {
		this.root = new Node(5);
		Node node2 = new Node(3);
		Node node3 = new Node(2);
		Node node4 = new Node(4);
		Node node5 = new Node(9);
		Node node6 = new Node(7);
		Node node7 = new Node(8);
		Node node8 = new Node(6);
		this.root.setLeft(node2);
		node2.setLeft(node3);
		node2.setRight(node4);
		this.root.setRight(node5);
		node5.setLeft(node6);
		node6.setRight(node7);
		node6.setLeft(node8);
		this.size = 8;
	}

	public int getSize() {
		return this.size;
	}

	public Node getRoot() {
		return this.root;
	}

	@Override
	public boolean insert(Integer o) {
		// TODO Code
		return false;
	}

	@Override
	public boolean remove(Integer o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Integer o) {
		if (this.root == null) {
			return false;
		}
		if (this.root.getValue() == o) {
			return true;
		} else {
			Node node = this.root.subNode(o);
			if (node == null) {
				return false;
			} 
			while(node != null) {
				if(node.getValue() == o) {
					return true;
				}
				node = node.subNode(o);
			} 
			return false;
		}
	}
}
