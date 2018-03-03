package ch.hslu.ad.sw02.D1.Aufg2;

import java.util.Iterator;

/**
 * Iterator-Class for the LinkedList
 * @author Dave
 *
 */
public class LinkedListIterator implements Iterator<Node> {
	private Node current;

	public LinkedListIterator(Node current) {
		this.current = current;
	}

	@Override
	public boolean hasNext() {
		return current.getNextNode() == null ? false : true;
	}

	@Override
	public Node next() {
			Node actual = current.getNextNode();
			this.current = current.getNextNode();
			return actual;
	}

}
