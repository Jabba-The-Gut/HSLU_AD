package ch.hslu.ad.sw02.D1.Aufg3;

import ch.hslu.ad.sw02.D1.Aufg3.StringStack.StackEmptyException;
import ch.hslu.ad.sw02.D1.Aufg3.StringStack.StackFullException;

public interface Stack {

	/**
	 * Check if the Stack is full
	 * 
	 * @return true if full, false if empty
	 */
	public boolean isFull();

	/**
	 * Check if the Stack is empty
	 * 
	 * @return true if empty, false if not
	 */
	public boolean isEmpty();

	/**
	 * Take the first element from the top of the Stack
	 * 
	 * @return top-Element of the Stack
	 */
	public String pop() throws StackEmptyException;

	/**
	 * Add an element on top of the existing elements
	 * 
	 * @param string
	 *            element to be added to the stack
	 */
	public void push(String string) throws StackFullException;

}
