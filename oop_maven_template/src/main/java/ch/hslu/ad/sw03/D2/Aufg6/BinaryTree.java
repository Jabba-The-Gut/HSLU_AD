package ch.hslu.ad.sw03.D2.Aufg6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Eigene Implementation eines Binären Suchbaumes.
 * 
 * @author jabbathegut
 *
 */
public class BinaryTree implements Tree<Allocation> {

	private static final Logger LOG = LogManager.getLogger(BinaryTree.class);

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
	public boolean insert(Allocation o) {
		if (!this.contains(o)) {
			// Wenn der Baum leer ist, dann wird die Wurzel gesetzt
			if (this.root == null) {
				this.root = new Node(o);
				this.size++;
				return true;
			}
			// Wenn es nur den Wurzel-Knoten gibt, dann wird der neue Knoten entweder links
			// oder rechts darunter gesetzt
			if (this.root.subNode(o) == null) {
				this.root.addSubnode(o);
				this.size++;
				return true;
			} else {
				// Wenn es mehr als den Wurzelknoten gibt, dann gehe solang tiefer in der
				// Baumstruktur, bis ein Knoten keine Knder mehr hat und dann kann der neue
				// Knoten darunter eingefügt werden
				Node node = this.root.subNode(o);
				Node subnode = node.subNode(o);
				while (node != null && subnode != null) {
					node = node.subNode(o);
					subnode = subnode.subNode(o);
				}
				node.addSubnode(o);
				this.size++;
				return true;
			}
		}
		return false;
	}

	/**
	 * Diese Methode entfernt einfach immer den Wurzel-Knoten des Baumes. Sie setzt
	 * ihn zurueck. Funktioniert also nicht wirklich --> so gewollt.
	 */
	@Override
	public boolean remove(Allocation o) {
		this.root = null;
		this.size = 0;
		return true;
	}

	@Override
	public boolean contains(Allocation o) {
		// Leerer Baum enthaeelt nichts
		if (this.size == 0) {
			return false;
		}
		// Ist der Wurzel-Knoten bereits der gesuchte Knoten, dann ist fertig
		if (this.root.getValue() == o) {
			return true;
		} else {
			// Nimm den Kind-Knoten vom Wurzel-Knoten und schaue, ob er der gesuchte Knoten
			// ist
			Node node = this.root.subNode(o);
			if (node == null) {
				return false;
			}
			while (node != null) {
				if (node.getValue() == o) {
					return true;
				}
				// Falls der Kind-Knoten nicht der gesuchte Knoten ist, nimm den Kindknoten vom
				// Kindknoten
				node = node.subNode(o);
			}
			return false;
		}
	}

	/**
	 * Traversiert die Knoten nach inOrder-Reihenfolge und loggt deren Wert
	 * 
	 * @param root
	 *            Wurzelknoten des Baumes
	 */
	public void inOrderRek(Node root) {
		if (root == null) {// Rekursionsbasis
			return;
		}
		inOrderRek(root.goLeft());
		LOG.info(root.toString());
		inOrderRek(root.goRight());
	}

	/**
	 * Traversiert die Knoten nach postOrder-Reihenfolge und loggt deren Wert
	 * 
	 * @param root
	 *            Wurzelknoten des Baumes
	 */
	public void postOrderRek(Node root) {
		if (root == null) {// Rekursionsbasis
			return;
		}
		postOrderRek(root.goLeft());
		postOrderRek(root.goRight());
		LOG.info(root.toString());
	}

	/**
	 * Traversiert die Knoten nach preOrder-Reihenfolge und loggt deren Wert
	 * 
	 * @param root
	 *            Wurzelknoten des Baumes
	 */
	public void preOrderRek(Node root) {
		if (root == null) {// Rekursionsbasis
			return;
		}
		LOG.info(root.toString());
		preOrderRek(root.goLeft());
		preOrderRek(root.goRight());

	}

}
