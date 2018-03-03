package ch.hslu.ad.sw02.D1.Aufg2;

/**
 * Class that implements the functionality of a LinkedList.
 * 
 * @author Dave
 *
 */
public class LinkedList {
	private int size = 0;
	private Node head;

	/**
	 * Create new LinkedList-Object
	 */
	public LinkedList() {
		this.head = new Node();
	}

	/**
	 * Add Allocation object to the LinkedList
	 * 
	 * @param alloc
	 *            Allocation to be added
	 */
	public void add(Allocation alloc) {
		// create new Node for alloation
		Node newNode = new Node(alloc);
		// if it's the first node, set nextNode to null (end)
		if (this.head.getNextNode() == null) {
			newNode.setNextNode(null);
		} else {
			// if it's not the first, set the nextNode to the previous Node referenced by
			// the head
			newNode.setNextNode(this.head.getNextNode());
		}
		// update head-Node to the newly inserted Node
		this.head.setNextNode(newNode);
		size++;
	}

	/**
	 * Remove the given Allocation object from the LinkedList
	 * 
	 * @param alloc
	 *            Allocation to be removed
	 * @return true if successfull, false if not
	 */
	public boolean remove(Allocation alloc) {
		Node node = this.head;
		for (int i = 0; i < this.size; i++) {
			if (node.getNextNode() != null) {
				if (node.getNextNode().getData().equals(alloc)) {
					if (node.getNextNode().getNextNode() != null) {
						node.setNextNode(node.getNextNode().getNextNode());
						node.getNextNode().setNextNode(null);
						size--;
						return true;
					} else {
						node.setNextNode(null);
						size--;
						return true;
					}

				} else {
					node = node.getNextNode();
				}
			}
		}
		return false;
	}

	/**
	 * Remove the first Element form the LinkedList
	 * 
	 * @return the first Element
	 */
	public Allocation removeFirst() {
		Allocation firstElem = this.head.getNextNode().getData();
		this.head.setNextNode(this.head.getNextNode().getNextNode());
		this.size--;
		return firstElem;
	}

	/**
	 * Checks if LinkedList contains Allocation
	 * 
	 * @param alloc
	 *            that should be checked
	 * @return true if alloc is contained, false if not
	 */
	public boolean contains(Allocation alloc) {
		Node node = this.head.getNextNode();
		for (int i = 0; i < this.size; i++) {
			if (node.getData().equals(alloc)) {
				return true;
			} else {
				node = node.getNextNode();
			}
		}
		return false;
	}

	/**
	 * Checks if LinkedList contains Allocation using an Iterator
	 * 
	 * @param alloc
	 *            that should be checked
	 * @return true if alloc is contained, false if not
	 */
	public boolean containsIterator(Allocation alloc) {
		LinkedListIterator it = this.iterator();
		while (it.hasNext()) {
			if (it.next().getData().equals(alloc)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the size of the LinkedList (Number of Elements)
	 * 
	 * @return size
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Returns an LinkedListIterator-Object
	 * 
	 * @return LinkedListIterator
	 */
	public LinkedListIterator iterator() {
		return new LinkedListIterator(this.head);
	}

	@Override
	public String toString() {
		return "LinkedList: Size:" + this.size + " | hashCode:" + this.hashCode();
	}

}
