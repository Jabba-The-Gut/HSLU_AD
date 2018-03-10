package ch.hslu.ad.sw03.D2.Aufg5;

public class BinaryTree implements Tree<Integer> {

	private Node root;
	private int size;

	public BinaryTree() {
		this.root = null;
		this.size = 0;
	}

	public int getSize() {
		return this.size;
	}
	
	public Node getRoot() {
		return this.root;
	}

	@Override
	public boolean insert(Integer o) {
		if(this.size ==0) {
			this.root = new Node(o);
			size++;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean remove(Integer o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Integer o) {
		// TODO Auto-generated method stub
		return false;
	}

}
