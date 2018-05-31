package dataStructures_StacksAndQueues;

import java.util.*;

/**
 * This is a useful implementation of an Extrema Stack where the minimum and the
 * maximum item on a non empty stack is found at O(1) runtime implemented using
 * stacks.
 * 
 * @author Arian Seyedi
 */
public class ExtremaStack<E extends Comparable<E>> extends Stack<E> {

	private static final long serialVersionUID = 1L; // not really useful since no serialization/de-serialization
	private Stack<E> minStack = new Stack<>(); // min-stack
	private Stack<E> maxStack = new Stack<>(); // max-stack
	private Stack<E> origStack = new Stack<>(); // original stack

	public ExtremaStack() {
		// do nothing
	}

	/**
	 * Instantiate an Extrema Stack with an already existing list.
	 * 
	 * @param ls
	 *            list to be added to the Extrema Stack upon instantiation.
	 */
	public ExtremaStack(List<E> ls) {
		Iterator<E> it = ls.iterator();
		while (it.hasNext()) {
			this.push(it.next());
		}
	}

	/**
	 * Push element onto the main stack and maintain the extrema stacks.
	 * 
	 * @param element
	 *            the element to add on the main stack.
	 */
	public E push(E element) {
		origStack.push(element);
		maxStack_maintainPush(element); // maintain max-stack
		minStack_maintainPush(element); // maintain min-stack
		return element;
	}

	/**
	 * Maintains max stack upon addition of a new element to the main stack.
	 * 
	 * @param element
	 *            the element to be pushed on the main stack which should be
	 *            examined in order to maintain the integrity of the maxStack
	 */
	private void maxStack_maintainPush(E element) {
		if (maxStack.isEmpty()) {
			maxStack.push(element);
		}
		if (element.compareTo(maxStack.peek()) > 0) {
			maxStack.push(element);
		} else { // if peek continues to be the maximum, push again to keep lengths consistent.
			maxStack.push(maxStack.peek());
		}
	}

	/**
	 * Maintains min stack upon addition of a new element to the main stack.
	 * 
	 * @param element
	 *            the element to be pushed on the main stack which should be
	 *            examined in order to maintain the integrity of the minStack
	 */
	private void minStack_maintainPush(E element) {
		if (minStack.isEmpty()) {
			minStack.push(element);
		}
		if (element.compareTo(minStack.peek()) < 0) {
			minStack.push(element);
		} else { // if peek continues to be the minimum, push again to keep lengths consistent.
			minStack.push(minStack.peek());
		}
	}

	/**
	 * Pop the top item from the stack.
	 * 
	 * @throws ExtremaStack
	 *             if stack is empty.
	 */
	public synchronized E pop() {
		if (this.origStack.isEmpty()) {
			throw new EmptyStackException();
		}
		maxStack.pop(); // just pop, no maintenance required.
		minStack.pop(); // just pop, no maintenance required.
		return origStack.pop();
	}

	/**
	 * Returns the maximum value currently on the stack. Runs in O(1) time.
	 * 
	 * @return maximum item on the stack.
	 * @throws EmptyStackException
	 *             if this stack is empty.
	 */
	public synchronized E max() {
		if (this.origStack.isEmpty()) {
			throw new EmptyStackException();
		}
		return maxStack.peek();
	}

	/**
	 * Returns the minimum value currently on the stack. Runs in O(1) time.
	 * 
	 * @return minimum item on the stack.
	 * @throws EmptyStackException
	 *             if this stack is empty.
	 */
	public synchronized E min() {
		if (this.origStack.isEmpty()) {
			throw new EmptyStackException();
		}
		return minStack.peek();
	}
}
