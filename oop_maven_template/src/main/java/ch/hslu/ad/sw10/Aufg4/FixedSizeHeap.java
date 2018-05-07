package ch.hslu.ad.sw10.Aufg4;

public class FixedSizeHeap {
	private int[] array;

	private final class Node {
		private Node parent;
		private Node leftChild;
		private Node rightChild;

		public Node(final Node parent, final Node leftChild, final Node rightChild) {
			this.parent = parent;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		private Node getLeftChild() {
			return this.leftChild;
		}

		private Node getRightChild() {
			return this.rightChild;
		}

		private Node getParent() {
			return this.parent;
		}

		private void setLeftChild(final Node leftChild) {
			this.leftChild = leftChild;
		}

		private void setRightChild(final Node rightChild) {
			this.rightChild = rightChild;
		}

		private void setParent(final Node parent) {
			this.parent = parent;
		}
	}

	public FixedSizeHeap(final int[] array) {
	
	}
}
