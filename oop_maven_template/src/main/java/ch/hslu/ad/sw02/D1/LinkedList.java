package ch.hslu.ad.sw02.D1;

public class LinkedList {
	private static int size = 0;
	private Node head;

	public LinkedList() {
		this.head = new Node();
	}

	public void add(Allocation alloc) {
		Node newNode = new Node(alloc);
		newNode.setNextNode(null);
		if (this.head.getNextNode() == null) {
			this.head.setNextNode(newNode);
		}
		size++;
	}

	public void remove(Allocation alloc) {

	}

	public Allocation get(Allocation alloc) {
		//Nur falls es eine Node gibt, falls mehrere muss noch implementiert werden
		Node node = this.head.getNextNode();
		if (node.equals(this.head.getNextNode())) {
			return node.getData();
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		return "LinkedList |Size:" + this.size + " hashCode:" + this.hashCode();
	}

}
