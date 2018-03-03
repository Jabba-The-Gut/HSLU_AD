package ch.hslu.ad.sw02.D1;

import java.util.Objects;

public class Node {
	private Allocation data;
	private Node next;

	public Node() {
		this.next = null;
		this.data = null;
	}

	public Node(Allocation alloc) {
		new Node();
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

	@Override
	public int hashCode() {
		return Objects.hash(this.next, this.data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "HashCode:" + this.hashCode();
	}

}
