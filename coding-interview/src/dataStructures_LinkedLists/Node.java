package dataStructures_LinkedLists;

/**
 * Nodes for a linked list of int values. A node stores an int value (called the
 * data of the node) and a reference to the next node in a linked sequence.
 * 
 * @author Arian Seyedi
 */
public class Node {

	private Node next;
	private int data;

	/**
	 * Initialize this node so that its data is 0 and its next node is null.
	 */
	public Node() {
		this(0, null);
	}

	/**
	 * Initialize this node so that its data and next node are equal to the
	 * specified data and next node.
	 * 
	 * @param data
	 *            an int value to store in this node
	 * @param next
	 *            the next node of this node. next can be equal to null.
	 */
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	/**
	 * Set the next node of this node to the specified node.
	 * 
	 * @param next
	 *            the next node of this node. next can be equal to null.
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * Sets the int value stored in this node to the specified value.
	 * 
	 * @param data
	 *            the int value to store in this node
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * Get the next node of this node.
	 * 
	 * @return the next node of this node. The returned value can be equal to null.
	 */
	public Node getNext() {
		return this.next;
	}

	/**
	 * Get the int value stored in this node.
	 * 
	 * @return the int value stored in this node
	 */
	public int getData() {
		return this.data;
	}
}
