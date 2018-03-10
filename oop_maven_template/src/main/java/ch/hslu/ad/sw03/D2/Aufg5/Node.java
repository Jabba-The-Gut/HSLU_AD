package ch.hslu.ad.sw03.D2.Aufg5;

public class Node implements Comparable<Node> {

	private int value;
	private Node left;
	private Node right;
	
	public Node(int value) {
		this.value = value;
	}
	
	public Node(int value, Node left, Node right) {
		new Node(value);
		this.left = left;
		this.right = right;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return this.value;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	public Node goLeft() {
		return this.left;
	}
	
	public Node goRight() {
		return this.right;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		} else if (obj instanceof Node){
			Node node = (Node) obj;
			if(node.getValue() == this.value) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Node node) {
		if(this.equals(node)) {
			return 0;
		} else if(this.getValue() > node.getValue()) {
			return 1;
		} else {
			return -1;
		}
	}


	
}
