package ch.hslu.ad.sw04.D3.Aufg3;

import java.util.Objects;

/**
 * Class that represents a node inside a LinkedList. Each Node has a "data"
 * attribute (Allocation object) and a "next" attribute (next Node in
 * LinkedList)
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
	 * 
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
		return Objects.hashCode(this.data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Node) {
			final Node node = (Node) obj;
			if (this.getData() == node.getData()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "HashCode:" + this.hashCode() + " | Data: " + data.toString();
	}

}
