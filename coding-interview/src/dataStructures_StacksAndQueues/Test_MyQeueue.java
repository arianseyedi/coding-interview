package dataStructures_StacksAndQueues;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test_MyQeueue {

	Integer[] arr = { 1, 2, 3, 4, 5 };

	/**
	 * Test the three methods offered by MyQueue for robustness.
	 */
	@Test
	void testMyQ() {

		MyQueue<Integer> empty = new MyQueue<>();
		MyQueue<Integer> q = new MyQueue<>(arr);
		assertEquals((Integer) arr[0], q.peek()); // index 0 should be the front of the q
		assertEquals((Integer) arr[0], q.poll());
		assertEquals((Integer) arr[1], q.poll());
		assertEquals((Integer) arr[2], q.poll());
		assertEquals((Integer) arr[3], q.poll());
		assertEquals((Integer) arr[4], q.poll());
		assertEquals(null, q.poll()); // empty, must return null
		assertEquals(null, q.poll()); // empty, must return null again
		// now add a couple Integer values
		Integer toAdd = 6;
		q.offer((Integer) toAdd); // only item in queue
		assertEquals((Integer) toAdd, q.peek());
		Integer toAdd2 = 4; // next item in queue
		q.offer((Integer) toAdd2);
		assertEquals((Integer) toAdd, q.peek()); // first item added should be at front
		assertEquals((Integer) toAdd, q.poll());
		assertEquals((Integer) toAdd2, q.poll()); // then the last one
		// compare sizes
		assertEquals(null, empty.peek());
		assertEquals(empty.size(), q.size()); // both sizes zero
		// compare peek values
		assertEquals(null, empty.peek());
		assertEquals(empty.peek(), q.peek()); // both null
	}

}
