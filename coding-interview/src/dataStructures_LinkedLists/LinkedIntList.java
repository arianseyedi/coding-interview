package dataStructures_LinkedLists;

import java.util.NoSuchElementException;

/**
 * This is a lab work from my Advance OOP course EECS2030 taught by Professor
 * <a href="http://eecs.lassonde.yorku.ca/faculty/matthew-kyan/"> Mathew Kyan
 * </a> All main methods have been implemented by me, @author Arian Seyedi. I
 * have also made small changes to the code to make it more efficient, secure,
 * concise etc.
 * 
 * <p>
 * This implementation keeps track of the first (head) and last (tail) node of
 * the linked list. All methods that add or remove nodes from the list may have
 * to update the fields this.head, this.tail, and this.size
 */
public class LinkedIntList {

	private int size; // size of the linked list to be maintained
	private Node head; // head of the list
	private Node tail; // tail of the list

	/**
	 * Initialize this linked list to an empty list.
	 */
	public LinkedIntList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	/**
	 * Return a reference to the first node of the list (the head node).
	 * 
	 * <p>
	 * NOTE: This method causes a privacy leak and would not normally be part of the
	 * public API; however, it is useful for testing purposes.
	 * 
	 * @return a reference to the first node of the list
	 */
	protected Node head() {
		return this.head;
	}

	/**
	 * Return a reference to the last node of the list (the tail node).
	 * 
	 * <p>
	 * NOTE: This method causes a privacy leak and would not normally be part of the
	 * public API; however, it is useful for testing purposes.
	 * 
	 * @return a reference to the last node of the list
	 */
	protected Node tail() {
		return this.tail;
	}

	/**
	 * Return a string representation of this list similar to the string returned by
	 * java.util.List.toString.
	 * 
	 * @return a string representation of this list
	 */
	public String toString() {
		StringBuilder b = new StringBuilder("[");
		if (this.size > 0) {
			Node n = this.head;
			b.append(n.getData());
			n = n.getNext();
			while (n != null) {
				b.append(", ");
				b.append(n.getData());
				n = n.getNext();
			}
		} else {
			b.append("empty");
		}
		b.append("]");
		return b.toString();
	}

	/**
	 * Return the number of elements in this list.
	 * 
	 * @return the number of elements in this list
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Return true if the size of this list is zero, and false otherwise.
	 * 
	 * @return true if the size of this list is zero, and false otherwise
	 */
	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		}
		return false;
	}

	/**
	 * Add an element to the end of this linked list.
	 * 
	 * @param elem
	 *            the element to add to the end of this linked list
	 * @return true (to be consistent with java.util.Collection)
	 */
	public boolean add(int elem) {
		Node endNode = new Node(elem, null);
		if (this.isEmpty() == true) {
			this.addFirst(elem);
			return true;
		}
		this.tail.setNext(endNode);
		this.tail = endNode; // tail is now the added node with next set as null
		this.size++; // maintain size
		return true;
	}

	/**
	 * Return the node at the given index.
	 * 
	 * <p>
	 * NOTE: This method is extremely useful for implementing many of the methods of
	 * this class, but students should try to use this method only once in each
	 * method.
	 * 
	 * @param index
	 *            the index of the node
	 * @return the node at the given index
	 * @throws IndexOutOfBoundsException
	 *             if index is less than 0 or greater than or equal the size of this
	 *             list
	 */
	protected Node getNode(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException(
					"index is " + "less than 0 or greater than or equal the size of this list");
		}
		if (index == 0) {
			return this.head;
		}
		Node n = this.head;
		for (int i = 0; i < index; i++) { // traverse list
			n = n.getNext();
		}
		return n;

	}

	/**
	 * Get the element stored at the given index in this linked list.
	 * 
	 * @param index
	 *            the index of the element to get
	 * @return the element stored at the given index in this linked list
	 * @throws IndexOutOfBoundsException
	 *             if (index &lt; 0) || (index &gt; size - 1)
	 */
	public int get(int index) {
		if (index < 0 || index > this.size - 1) {
			throw new IndexOutOfBoundsException("index < 0 or " + "index is larger than the length of list");
		}
		Node n = this.head;
		for (int i = 0; i < index; i++) { // traverse list
			n = n.getNext();
		}
		return n.getData();

	}

	/**
	 * Sets the element stored at the given index in this linked list. Returns the
	 * old element that was stored at the given index.
	 * 
	 * @param index
	 *            the index of the element to set
	 * @param elem
	 *            the element to store in this linked list
	 * @return the old element that was stored at the given index
	 * @throws IndexOutOfBoundsException
	 *             if (index &lt; 0) || (index &gt; size - 1)
	 */
	public int set(int index, int elem) {
		if (index < 0 || index > this.size - 1) {
			throw new IndexOutOfBoundsException("index < 0 or " + "index is larger than the length of list");
		}
		int oldElem = this.get(index);
		this.getNode(index).setData(elem);
		return oldElem;
	}

	/**
	 * Insert an element to the front of this list.
	 * 
	 * @param elem
	 *            the element to insert at the front of this list
	 */
	public void addFirst(int elem) {
		Node newElem = new Node(elem, this.head);
		if (this.isEmpty()) {
			this.head = newElem;
			this.tail = newElem;
		} else {
			this.head = newElem;
		}
		this.size++;

	}

	/**
	 * Inserts the specified element at the specified position in this list. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 * 
	 * <p>
	 * <code>t.add(0, elem)</code> is equivalent to <code>t.addFront(elem)</code>.
	 * 
	 * <p>
	 * <code>t.add(t.size(), elem)</code> is equivalent to <code>t.add(elem)</code>.
	 * 
	 * @param index
	 *            index at which the specified element is to be inserted
	 * @param elem
	 *            the element to be inserted
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index &lt; 0 || index &gt; size())
	 */
	public void add(int index, int elem) {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("index < 0 or " + "index is larger than the length of list");
		}
		
		if (index == 0) { // index is 0, add first
			this.addFirst(elem);
			return;
		}
		if (index == this.size) { // add to the end
			this.add(elem);
			return;
		} else { // add middle
			Node prev = this.getNode(index - 1);
			Node oldNext = prev.getNext();
			Node newNext = new Node(elem, oldNext);
			prev.setNext(newNext);
			this.size++;
		}
		return;

	}

	/**
	 * Removes and returns the first element from this list.
	 * 
	 * @return the first element from this list
	 * @throws NoSuchElementException
	 *             if this list is empty
	 */
	public int removeFirst() {
		if (this.isEmpty()) {
			throw new NoSuchElementException("No Such Element");
		}
		int headElem = this.head.getData();
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		}
		else {
			Node oldHead = this.head;
			this.head = this.head.getNext();
			oldHead.setNext(null); // remove the link to be safe
		}
		this.size--; // decrement size
		return headElem;

	}

	/**
	 * Removes and returns the last element from this list.
	 * 
	 * @return the last element from this list
	 * @throws NoSuchElementException
	 *             if this list is empty
	 */
	public int removeLast() {
		if (this.isEmpty() == true) {
			throw new NoSuchElementException("No Such Element");
		}
		int lastVal = this.getNode(this.size - 1).getData();
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		}
		else {
			Node secondLastTail = this.getNode(this.size - 2);
			secondLastTail.setNext(null);
			this.tail = secondLastTail;
		}
		this.size--; // decrement size
		return lastVal;
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices). Returns
	 * the element that was removed from the list.
	 * 
	 * <p>
	 * <code>t.remove(0)</code> is equivalent to <code>t.removeFirst()</code> except
	 * that a different exception might be thrown.
	 * 
	 * <p>
	 * <code>t.remove(t.size() - 1)</code> is equivalent to
	 * <code>t.removeLast()</code> except that a different exception might be
	 * thrown.
	 * 
	 * @param index
	 *            the index of the element to be removed
	 * @return the removed element
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index &lt; 0 || index &gt;= size())
	 */
	public int remove(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index is invalid" + " or out of bounds");
		}
		if (index == 0) {
			return this.removeFirst();
		}
		if (index == this.size - 1) {
			return this.removeLast();
		}
		Node prev = this.getNode(index - 1);
		Node toRemove = prev.getNext();
		prev.setNext(toRemove.getNext());
		toRemove.setNext(null); // remove reference to be safe
		this.size--; // decrement size
		return toRemove.getData();

	}

	/**
	 * Circularly shifts the elements of this list to the right by n positions
	 * causing the n elements at the end of the original list to appear at the front
	 * of the resulting list. For example, if <code>t</code> is the list:
	 * 
	 * <pre>
	 * [0, 1, 2, 3, 4, 5]
	 * </pre>
	 * 
	 * <p>
	 * then <code>t.shiftRight(2)</code> results in <code>t</code> being equal to:
	 * 
	 * <pre>
	 * [4, 5, 0, 1, 2, 3]
	 * </pre>
	 * 
	 * <p>
	 * <code>t.shiftRight(0)</code> and <code>t.shiftRight(t.size())</code> both
	 * leave <code>t</code> unchanged.
	 * 
	 * @param n
	 *            the number of positions to shift the elements
	 * @throws IllegalArgumentException
	 *             if n is out of range (n &lt; 0 || n &gt; size())
	 */
	public void shiftRight(int n) {
		if (n < 0 || n > this.size) {
			throw new IllegalArgumentException();
		}
		if (n == 0 || n == this.size) {
			return;
		}
		for (int i = 0; i < n; i++) {
			this.addFirst(this.removeLast());
		}
	}
}
