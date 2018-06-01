package dataStructures_StacksAndQueues;

import java.util.Stack;

/**
 * This is an implementation of a Queue using a pair of stacks. This class
 * offers only 3 methods (returning a special value) offered by Java's own Queue
 * interface:
 * 
 * <style> table { border: 1px solid black; table-layout: auto; } th,td {
 * border: 1px solid black; } </style>
 * 
 * <h4>Summary of Queue methods</h4>
 * <table>
 * <tr >
 * <th></th>
 * <th>Throws exception</th>
 * <th>Returns special value</th>
 * </tr>
 * <tr>
 * <td>Insert</td>
 * <td>add(e)</td>
 * <td>offer(e)</td>
 * </tr>
 * <tr>
 * <td>Remove</td>
 * <td>remove()</td>
 * <td>poll()</td>
 * </tr>
 * <tr>
 * <td>Examine</td>
 * <td>element()</td>
 * <td>peek()</td>
 * </tr>
 * </table>
 * 
 * @author Arian Seyedi
 * @see Laakmann McDowell, G. (2015) Chapter 3 Excercise 4.
 */
public class MyQueue<E extends Comparable<E>> {

	Stack<E> st, tempSt; // only data structures used

	/**
	 * Constructor initializing the two stacks
	 */
	public MyQueue() {
		st = new Stack<E>();
		tempSt = new Stack<E>();
	}

	/**
	 * Constructor initializing the two stacks by adding all elements of the input
	 * array. Easier for testing.
	 */
	public MyQueue(E[] l) {
		this();
		this.addAll(l);
	}

	/**
	 * Enqueue an element on the queue.
	 * 
	 * @param elem
	 *            element to be enqueued
	 * @return the element just enqueued
	 */
	public E offer(E elem) {
		st.push(elem);
		return elem;
	}

	/**
	 * Dequeue the next element from the queue and return it.
	 * 
	 * @return element dequeued from the queue. Null if queue is empty.
	 */
	public E poll() {
		if (st.isEmpty())
			return null;
		while (st.size() > 1) { // save last item, pop rest onto temp
			tempSt.push(st.pop());
		}
		E toReturn = st.pop(); // pop last element, keep
		while (!tempSt.isEmpty()) {
			st.push(tempSt.pop());
		}
		return toReturn;
	}

	/**
	 * Show the front element on the queue (would be dequeued next) without changing
	 * the state of the queue.
	 * 
	 * @return element at the front of the queue. Null if empty.
	 */
	public E peek() {
		if (st.isEmpty())
			return null;
		while (st.size() > 1) { // save last item, pop rest onto temp
			tempSt.push(st.pop());
		}
		E toReturn = st.peek(); // pop last element, keep
		while (!tempSt.isEmpty()) {
			st.push(tempSt.pop());
		}
		return toReturn;
	}

	/**
	 * Add all array elements of given buffer(array) to the queue starting from
	 * index 0.
	 * 
	 * @param arr
	 *            array of elements to enqueue starting from index 0.
	 * @return true if the state of the queue changed as the result.
	 */
	public boolean addAll(E[] arr) {
		for (int i = 0; i < arr.length; i++) {
			this.offer(arr[i]);
		}
		return true;
	}

	/**
	 * Return size of the queue.
	 * 
	 * @return size of the queue. 0 if empty.
	 */
	public int size() {
		return st.size();
	}

	/**
	 * represent main stack where the right-most item is at the (F)ront and the
	 * left-most item is at the (E)nd of the queue.
	 * 
	 * @return string representation of the queue where the left-most item is the
	 *         last item in the queue denoted by E (for End) and the right-most item
	 *         is the front of the queue, denoted by (F).
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Stack<E> temp = (Stack<E>) st.clone();
		sb.append("(E) ");
		while (!temp.isEmpty()) {
			sb.append(temp.pop());
			sb.append(" ");
		}
		sb.append("(F)");
		return sb.toString();
	}

	public static void main(String args[]) { // for quick checks

	}

}
