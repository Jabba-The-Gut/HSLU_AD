package ch.hslu.ad.sw02.D1.Aufg3;

public class StringStack implements Stack {
	private String[] stack;

	public class StackFullException extends Exception {

		// Constructor that accepts a message
		public StackFullException(String message) {
			super(message);
		}
	}

	public class StackEmptyException extends Exception {

		// Constructor that accepts a message
		public StackEmptyException(String message) {
			super(message);
		}
	}

	public StringStack(int size) {
		this.stack = new String[size];
	}

	@Override
	public boolean isFull() {
		int indexesUsed = 0;
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] != null) {
				indexesUsed++;
			}
		}
		if (indexesUsed == stack.length) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isEmpty() {
		int indexesUsed = 0;
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] == null) {
				indexesUsed++;
			}
		}
		if (indexesUsed == stack.length) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String pop() throws StackEmptyException {
		for (int i = 0; i < stack.length; i++) {
			if (!isEmpty()) {
				if (stack.length == 1) {
					String element = stack[i];
					stack[i] = null;
					return element;

				} else if (stack[i] == null) {
					String element = stack[i - 1];
					stack[i - 1] = null;
					return element;
				} else if ((i + 1) == stack.length) {
					String element = stack[i];
					stack[i] = null;
					return element;
				}
			} else {
				throw new StackEmptyException("Stack is empty");
			}
		}
		throw new StackEmptyException("Stack is empty");
	}

	@Override
	public void push(String string) throws StackFullException {
		if (!isFull()) {
			for (int i = 0; i < stack.length; i++) {
				if (stack[i] == null) {
					stack[i] = string;
					break;
				}
			}
		} else {
			throw new StackFullException("Stack is full");
		}
	}
}
