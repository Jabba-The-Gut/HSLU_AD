package ch.hslu.ad.sw02.D1.Aufg2;

import java.util.Objects;

/**
 * Class that represents a node inside a LinkedList. Each Node has a "data"
 * attribute (Allocation object) and a "next" attribute (next Node in LinkedList)
 * 
 * @author Dave
 *
 */

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

	/**
	 * Returns next Node
	 * 
	 * @return Node
	 */
	public Node getNextNode() {
		return this.next;
	}

	/**
	 * Sets next attribute of current Node
	 * @param n
	 */
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
		return "HashCode:" + this.hashCode() + " | Data: " + data.toString();
	}

}
