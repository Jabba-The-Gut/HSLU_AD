package ch.hslu.ad.sw04.D3.Aufg4;

/**
 * Eigene Implementation eines HashTables. So implementiert, dass er bei
 * Kollisionen von Indexes aufgrund der Hash-Implementierung mittels
 * Buckets(Nodes einer Linked-List) arbeitet!
 * 
 * @author jabbathegut
 *
 */

public class CustomHashTable implements HashDataStructure<Allocation> {
	private Node[] store;

	public CustomHashTable(int size) {
		store = new Node[size];
	}

	@Override
	public boolean add(Allocation element) {
		final int hash = this.generateIndexFromHash(element);
		if (store[hash] == null) {
			store[hash] = new Node(element);
			return true;
		} else {
			Node node = store[hash];
			if (node.getData().equals(element)) {
				return false;
			}
			while (node.getNextNode() != null) {
				if (node.getNextNode().getData().equals(element)) {
					return false;
				}
				node = node.getNextNode();
			}
			node.setNextNode(new Node(element));
			return true;
		}
	}

	@Override
	public Allocation get(Allocation element) {
		final int hash = this.generateIndexFromHash(element);
		if (store[hash] == null) {
			return null;
		} else {
			Node node = store[hash];
			if (node.getData().equals(element)) {
				return node.getData();
			}
			while (node.getNextNode() != null) {
				if (node.getNextNode().getData().equals(element)) {
					return node.getNextNode().getData();
				}
				node = node.getNextNode();
			}
			return null;
		}
	}

	/**
	 * Berechnet den Index fuer das einzufuegende Element, in dem der Hash des
	 * Elements verteilt an die Groesse der Datenstruktur gerechnet wird -->
	 * eindeutiger Index wenn nicht zweimal ein Element mit gleichem Hash eingefuegt
	 * wird
	 * 
	 * @param alloc
	 *            Objekt dass eingefuegt werden soll
	 * @return Index des alloc-Objekts basierend auf dem Hash
	 */
	private int generateIndexFromHash(Allocation alloc) {
		return (alloc.hashCode() % store.length);
	}

	@Override
	public boolean remove(Allocation element) {
		final int hash = this.generateIndexFromHash(element);
		if (this.get(element) == null) {
			return false;
		} else {
			Node node = store[hash];
			if (node.getData().equals(element)) {
				store[hash] = node.getNextNode();
				node.setNextNode(null);
				return true;
			}
			while (node.getNextNode() != null) {
				if (node.getNextNode().getData().equals(element)) {
					node.setNextNode(node.getNextNode().getNextNode());
					node.getNextNode().setNextNode(null);
					return true;
				}
			}
			return false;
		}
	}

}
