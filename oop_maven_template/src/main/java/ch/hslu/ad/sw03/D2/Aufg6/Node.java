package ch.hslu.ad.sw03.D2.Aufg6;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 * Stellt die Implementation der einzelnen Knoten im binären Suchbaum dar.
 * 
 * @author jabbathegut
 *
 */
public class Node implements Comparable<Node> {
	private static final Logger LOG = LogManager.getLogger(Node.class);

	private Allocation value;
	private int hash;
	private Node left;
	private Node right;

	public Node(Allocation alloc) {
		this.value = alloc;
		this.hash = this.hashCode();
	}

	public Node(Allocation alloc, Node left, Node right) {
		new Node(value);
		this.left = left;
		this.right = right;
	}

	public Integer getHash() {
		return this.hash;
	}

	public void setAlloc(Allocation alloc) {
		this.value = value;
	}

	public Allocation getValue() {
		return this.value;
	}

	/**
	 * Fuegt einen neuen Kind-Knoten ein. Falls der Wert (Speichergroesse) groesser
	 * ist, dann rechts, falls der Wert kleiner ist, dann links.
	 * 
	 * @param value
	 *            Speichergroesse Allocation
	 */
	public void addSubnode(Allocation alloc) {
		if (alloc.getSize() < this.value.getSize()) {
			this.setLeft(new Node(alloc));
		} else {
			this.setRight(new Node(alloc));
		}
	}

	private void setLeft(Node left) {
		this.left = left;
	}

	private void setRight(Node right) {
		this.right = right;
	}

	/**
	 * Methode, welche den Kind-Knoten des aktuellen Knotens zurueck gibt, den
	 * linken wenn der Wert kleiner ist und den rechten wenn er groesser ist. Wird
	 * bei der Suche gebraucht
	 * 
	 * @param value
	 *            Speichergroesse der Allokation
	 * @return Kind-Knoten
	 */
	public Node subNode(Allocation alloc) {
		if (alloc.getSize() < this.value.getSize()) {
			return this.left;
		} else {
			return this.right;
		}
	}

	public Node goLeft() {
		return this.left;
	}

	public Node goRight() {
		return this.right;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj instanceof Node) {
			Node node = (Node) obj;
			if (node.getValue().equals(obj)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Node node) {
		if (this.equals(node)) {
			return 0;
		} else if (this.getValue().getSize() > node.getValue().getSize()) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return "Knoten mit Wert: " + this.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.value);
	}

}
