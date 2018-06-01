package dataStructures_StacksAndQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * This class holds a dynamic number of stacks, and keeps on adding more if the
 * current stack size goes beyond a set thresh. The advantage is access to the
 * top of every stack in O(1) while keeping the same data structure. Pop, push
 * and peek work just as if this is a single stack. But if desired, these
 * operations can also be done on a specific stack. The consequences of pushing
 * on a different stack is that the item already on the top of that stack will
 * be replaced and put on the most recent stack instead. Popping will cause
 * leave that stack with an available spot which could be used if an item needs
 * be pushed on that stack later. This question appears in Laakmann McDowell, G.
 * (2015) chapter 3 question 3 + FOLOW UP.
 * 
 * @author Arian Seyedi
 * @see Laakmann McDowell, G. (2015) Chapter 3, Question 3.
 */
public class PlateStack<E extends Comparable<E>> extends Stack<E> {

	private static final long serialVersionUID = 1L;
	private Map<Integer, Stack<E>> stock; // dynamic stack holder
	private static int thresh = 100; // max size of any stack in the stock, default set here
	private Integer stackIndex; // starting at index 0
	private Stack<E> current_st; // current stack
	private static final int MAX_ESHOLD = 500;
	private static final int MIN_ESHOLD = 3;

	/**
	 * No argument results in default initialization.
	 * 
	 * @throws MaxStackSizeExceededException
	 */
	public PlateStack() throws MaxStackSizeExceededException {
		this(thresh); // chaining
	}

	/**
	 * Validate thresh input and initialize stock, ID and thresh.
	 * 
	 * @param thresh
	 * @throws MaxStackSizeExceededException
	 */
	public PlateStack(Integer threshold) throws MaxStackSizeExceededException {
		if (threshold > MAX_ESHOLD) { // check upper bound
			throw new MaxStackSizeExceededException("Maximum allowed stack threshold size is " + MAX_ESHOLD);
		}
		if (threshold < 3) { // check lower bound
			throw new MaxStackSizeExceededException("Minimum allowed stack threshold size is " + MIN_ESHOLD);
		}
		thresh = threshold;
		this.stackIndex = 0;
		this.stock = new HashMap<Integer, Stack<E>>();
		current_st = new Stack<E>();
		this.stock.put(this.stackIndex, current_st);
	}

	/**
	 * Get size of the PlateStack summing all the stacks sizes.
	 * 
	 * @return
	 */
	@Override
	public int size() { // add up all stack sizes
		int size = 0;
		Set<Integer> kset = stock.keySet();
		for (Integer i : kset) {
			size += this.getStack(i).size();
		}
		return size;
	}

	/**
	 * Return size of the stock, corresponding to the number of stacks existing.
	 */
	public int stockSize() {
		return stock.size();
	}

	/**
	 * Get stack at key index
	 * 
	 * @return stack at key
	 */
	private final Stack<E> getStack(Integer id) {
		if (!stock.containsKey(id)) {
			throw new IllegalArgumentException("Stack does not exist");
		}
		return stock.get(id);
	}

	/**
	 * Put stack in map at given key index
	 * 
	 * @param st
	 *            the stack to put
	 * @param key
	 *            key index
	 */
	private final void put(Integer key, Stack<E> st) {
		this.stock.put(key, st);
	}

	/*
	 * Push new element on the Plate Stack. New stack will be generated if current
	 * stack is full.
	 * 
	 * @param element element to be pushed on stack.
	 * 
	 * @return element added onto the stack.
	 * 
	 * @see java.util.Stack#push()
	 */
	@Override
	public synchronized E push(E element) {
		if (this.current_st.size() == thresh) { // is the current stack
			current_st = new Stack<E>();
			put(++stackIndex, current_st);
		}
		current_st.push(element);
		return element;
	}

	/**
	 * Push element on a specific stack in stock. If that stack is full, the top
	 * item will be popped and added to the current stack, so that the input element
	 * can be pushed on the desired stack.
	 * 
	 * @param element
	 *            element to be added to stack of a certain index in the stock.
	 * @param stack_index
	 *            stack index. Size of the stock indicates available stacks. Index
	 *            is 0 based.
	 * @return element added to the given stack index.
	 */
	public synchronized E push(E element, Integer stack_index) {
		if (stack_index == stackIndex) { // is the current stack
			this.push(element);
			return element;
		}
		Stack<E> st = this.getStack(stack_index);
		if (st.size() == thresh) {
			E addRecent = st.pop();
			this.push(addRecent);
		}
		return st.push(element);
	}

	/*
	 * Pop an element off the top of the stack.
	 * 
	 * @return element popped from the stack. Null if plateStack empty.
	 * 
	 * @see java.util.Stack#pop()
	 */
	@Override
	public synchronized E pop() {
		if (this.empty()) // plateStack entirely empty
			return null;
		if (current_st.size() == 0) { // back to previous stack
			this.stock.remove(stackIndex--); // remove empty stack from stock and decrement index
			current_st = this.getStack(stackIndex);
			this.resetKeys();
		}
		return current_st.pop();
	}

	/**
	 * pop from a given stack
	 * 
	 * @param stack_index
	 *            stack index. Stock size indicates the number of stacks available.
	 *            Index is 0-based. If inner stack becomes empty, the Plate Stacks
	 *            will be re-indexed to ensure no discrepancy.
	 * @return popped item from the given stack, null if stack is empty.
	 */
	public synchronized E pop(Integer stack_index) {
		if (stack_index == stackIndex) { // is the current stack
			return this.pop();
		}
		Stack<E> st = this.getStack(stack_index);
		if (st.size() <= 1) {
			if (st.empty())
				return null;

			E elem = st.pop();
			stock.remove(stack_index);
			this.resetKeys();
			return elem;
		}
		return st.pop();
	}

	/*
	 * peek current stack.
	 * 
	 * @see java.util.Stack#peek()
	 */
	@Override
	public synchronized E peek() {
		return current_st.peek();
	}

	/**
	 * peek a specific stack.
	 * 
	 * @param stack_index
	 *            stack index. Stock size indicates the number of stacks available.
	 *            Index is 0-based.
	 * @return peeked element from the desired stack.
	 */
	public synchronized E peek(Integer stack_index) {
		if (stack_index == stackIndex) { // is the current stack
			return this.peek();
		}
		return this.getStack(stack_index).peek();
	}

	/*
	 * if plateStack empty totally.
	 * 
	 * @see java.util.Stack#empty()
	 */
	@Override
	public boolean empty() {
		if (this.stockSize() == 1)
			return this.current_st.empty();
		return false;
	}

	/**
	 * Restes the keys so that they begin at 0 and end at the size - 1.
	 */
	private void resetKeys() {
		Map<Integer, Stack<E>> newStock = new HashMap<Integer, Stack<E>>();
		Set<Integer> kset = stock.keySet();
		int j = 0; // new index
		for (Integer i : kset) {
			newStock.put(j++, stock.get(i));
		}
		stock = newStock; // point old stock to new stock.
		stackIndex = stock.size() - 1; // very important.
	}

	/**
	 * String representation of the PlateStack where each row represents a stack and
	 * the left-most item is at the top and the right-most item is at the bottom of
	 * the stack.
	 * 
	 * @return the String representation of PlateStack. Each row is one stack (top
	 *         row is the first stack, bottom is the most recent one) the left-most
	 *         item is at the top and the right-most item is at the bottom of the
	 *         stack.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Set<Integer> kset = stock.keySet();
		for (Integer i : kset) {
			Stack<E> s = stock.get((Integer) i);

			Stack<E> temp = (Stack<E>) s.clone();
			sb.append("Stack# " + i + " of size " + temp.size() + "/" + thresh + " (TOP) ");
			while (!temp.isEmpty()) {
				sb.append(temp.pop());
				sb.append(" ");
			}
			sb.append("(Bottom)\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) throws MaxStackSizeExceededException {

	}

}
