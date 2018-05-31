package dataStructures_StacksAndQueues;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

class Test_ExtremaStack {

	ExtremaStack<Integer> mx;

	/**
	 * Testing MaxStack for Boundary conditions
	 */
	@Test
	void testBCN() {
		try { // if maximum throws error on empty stack pass
			mx = new ExtremaStack<>();
			mx.max();
			fail("max method should have thrown error on empty extremaStack, but did not!");
		} catch (EmptyStackException e) {
			// pass
		}

		try { // if minimum throws error on empty stack pass
			mx = new ExtremaStack<>();
			mx.min();
			fail("min method should have thrown error on empty extremaStack, but did not!");
		} catch (EmptyStackException e) {
			// pass
		}

		try { // if minimum throws error on empty stack pass
			mx = new ExtremaStack<>();
			mx.pop();
			fail("pop method should have thrown error on empty extremaStack, but did not!");
		} catch (EmptyStackException e) {
			// pass
		}

		try { // Ensure smooth operations on a list with only 1 item.
			Integer[] a = { 1 };
			mx = new ExtremaStack<Integer>(Arrays.asList(a));
			assertEquals((Integer) 1, mx.max()); // make sure expected is correct.
			assertEquals((Integer) 1, mx.min()); // make sure expected is correct.
			mx.min(); // an extra call to ensure min uses peek as opposed to pop to return value
			mx.max(); // an extra call to ensure max uses peek as opposed to pop to return value
			mx.pop(); // now stack must be empty
		} catch (Exception e) {
			fail("Operations should NOT have thrown any error, but there is at least one errorous operation in the try block!");
		}
	}

	/**
	 * Testing MaxStack for robustness
	 */
	@Test
	void testR() {
		Integer[] a = { 1, 2, 4, 9, 191, 23, 0, -99, 12, 1 };
		mx = new ExtremaStack<Integer>(Arrays.asList(a));
		assertEquals((Integer) 191, mx.max()); // make sure expected is correct.
		assertEquals((Integer) (-99), mx.min()); // make sure expected is correct.
	}

}
