package ch.hslu.ad.sw02.D1;

public class Node {
	private Allocation data;
	private Node next;
	
	public Node(Allocation alloc) {
		this.next = null;
		this.data = alloc;
	}
	
	public Node getNextNode() {
		return this.next;
	}
	
	public void setNextNode(Node n) {
		this.next = n;
	}
	
	public Allocation getData() {
		return this.data;
	}
	

}
