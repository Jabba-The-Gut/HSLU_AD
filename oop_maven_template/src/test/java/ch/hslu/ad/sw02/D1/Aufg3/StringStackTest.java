/**
 * 
 */
package ch.hslu.ad.sw02.D1.Aufg3;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ch.hslu.ad.sw02.D1.Aufg3.StringStack.StackEmptyException;
import ch.hslu.ad.sw02.D1.Aufg3.StringStack.StackFullException;

/**
 * @author Dave
 *
 */
public class StringStackTest {

	/**
	 * Test method for {@link ch.hslu.ad.sw02.D1.Aufg3.StringStack#StringStack()}.
	 */
	@Test
	public void testStringStackEmpty() {
		StringStack stack = new StringStack(2);
		assertTrue(stack.isEmpty());
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw02.D1.Aufg3.StringStack#StringStack()}.
	 * 
	 * @throws StackFullException
	 */
	@Test
	public void testStringStackEmptyAfterInsertion() throws StackFullException {
		StringStack stack = new StringStack(1);
		stack.push("ABC");
		assertTrue(!stack.isEmpty());
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw02.D1.Aufg3.StringStack#StringStack()}.
	 * 
	 * @throws StackFullException
	 */
	@Test
	public void testStringStackFullAfterInsertion() throws StackFullException {
		StringStack stack = new StringStack(1);
		stack.push("ABC");
		assertTrue(stack.isFull());
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw02.D1.Aufg3.StringStack#StringStack()}.
	 * 
	 * @throws StackFullException
	 * @throws StackEmptyException
	 */
	@Test
	public void testStringStackSimple() throws StackFullException, StackEmptyException {
		StringStack stack = new StringStack(1);
		stack.push("ABC");
		assertTrue(stack.pop().equals("ABC")&&stack.isEmpty());
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw02.D1.Aufg3.StringStack#StringStack()}.
	 * 
	 * @throws StackFullException
	 * @throws StackEmptyException
	 */
	@Test
	public void testStringStackMultiple() throws StackFullException, StackEmptyException {
		StringStack stack = new StringStack(3);
		stack.push("ABC");
		stack.push("DEF");
		stack.push("GHI");
		assertTrue(stack.pop().equals("GHI"));
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw02.D1.Aufg3.StringStack#StringStack()}.
	 * 
	 * @throws StackFullException
	 * @throws StackEmptyException
	 */
	@Test
	public void testStringStackMultipleComplicated() throws StackFullException, StackEmptyException {
		StringStack stack = new StringStack(3);
		stack.push("ABC");
		stack.pop();
		stack.push("DEF");
		assertTrue(stack.pop().equals("DEF")&&stack.isEmpty());
	}

	/**
	 * Test method for {@link ch.hslu.ad.sw02.D1.Aufg3.StringStack#StringStack()}.
	 * 
	 * @throws StackFullException
	 * @throws StackEmptyException
	 */
	@Rule 
	public ExpectedException e =  ExpectedException.none();
	@Test
	public void testStringStackEmptyAndPop() throws StackFullException, StackEmptyException {
		e.expect(StackEmptyException.class);
		e.expectMessage("Stack is empty");
		StringStack stack = new StringStack(1);
		stack.push("ABC");
		stack.pop();
		stack.pop();
	}
	
	/**
	 * Test method for {@link ch.hslu.ad.sw02.D1.Aufg3.StringStack#StringStack()}.
	 * 
	 * @throws StackFullException
	 * @throws StackEmptyException
	 */

	@Test
	public void testStringStackFullAndPush() throws StackFullException, StackEmptyException {
		e.expect(StackFullException.class);
		e.expectMessage("Stack is full");
		StringStack stack = new StringStack(1);
		stack.push("ABC");
		stack.push("ZZZ");
	}
}
