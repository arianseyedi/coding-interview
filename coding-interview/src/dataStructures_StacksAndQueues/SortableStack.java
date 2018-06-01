package dataStructures_StacksAndQueues;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * This class was made to support a method that sorts items on a stack using one
 * other stack as a temporary one.
 * 
 * @author Arian Seyedi
 *
 */
public class SortableStack<E extends Comparable<E>> extends Stack<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Stack<E> s;

	/**
	 * Constructor, initialize a stack and a queue.
	 */
	public SortableStack() {
		s = new Stack<>();
	}

	/**
	 * Instantiate an MyStack object with an already existing list. Easier for
	 * testing.
	 * 
	 * @param exp_ls
	 *            list to be added to MyStack upon instantiation.
	 */
	public SortableStack(List<E> ls) {
		s = new Stack<>();
		Iterator<E> it = ls.iterator();
		while (it.hasNext()) {
			this.push(it.next());
		}
	}

	/**
	 * Question from Chapter 3 of Laakmann McDowell, G. (2015). sort the stack part
	 * of the object using an additional temporary stack only. The smallest item
	 * will be at the top of the stack. For example:
	 * 
	 * <pre>
	 * (TOP) 10|1|12|9|14|0|1 returns 
	 * (TOP) 0|1|1|9|10|12|14
	 * </pre>
	 */
	public void sort() {
		if (s.isEmpty()) {
			return; // nothing to sort, return
		}
		Stack<E> temp = new Stack<>();
		temp.push(this.pop()); // safe. main stack size is at least 1.
		while (!s.isEmpty()) {
			E elem = s.pop();
			if (elem.compareTo(temp.peek()) < 0)
				while (!temp.isEmpty()) // empty temp, need to re-construct it
					this.push(temp.pop());
			temp.push(elem); // now the larger item is at the bottom of temp
		}
		while (!temp.isEmpty()) { // temp stack now goes from highest to lowest(bottom)
			s.push(temp.pop()); // reverse order by dumping temp back on main stack.
		}
	}

	/*
	 * push element onto the stack
	 * 
	 * @param element element to add onto the stack
	 * 
	 * @return element just added to the stack.
	 */
	@Override
	public E push(E element) {
		return s.push(element);
	}

	/*
	 * pop element onto the stack
	 * 
	 * @return element just popped from the stack.
	 */
	@Override
	public E pop() {
		return s.pop();
	}

	/*
	 * represent main stack where the left-most item is at the top and the
	 * right-most item is at the bottom of the stack
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Stack<E> temp = (Stack<E>) s.clone();
		sb.append("(TOP) ");
		while (!temp.isEmpty()) {
			sb.append(temp.pop());
			sb.append(" ");
		}
		sb.append("(Bottom)");
		return sb.toString();
	}

	public static void main(String arg[]) {// temporary, for quick testing

	}
}
