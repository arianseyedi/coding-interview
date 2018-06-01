package dataStructures_StacksAndQueues;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class Test_SortableStack {

	SortableStack<Integer> actual;
	SortableStack<Integer> expected;

	/**
	 * Test instantiation Test sort method for a stack for robustness.
	 */
	@Test
	void test() {

		try {
			Integer[] intArr = { 1, 9, 12, 2, 99, -12, 4 };
			Integer[] intArr_exp = { 99, 12, 4, 2, 1, -12 };
			actual = new SortableStack<Integer>(Arrays.asList(intArr));
			expected = new SortableStack<Integer>(Arrays.asList(intArr_exp));
			actual.sort();
			assertEquals(expected, actual);
		} catch (Exception e) {
			fail("Operation should not have raised an exception");
		}

		try {
			Integer[] intArr = {};
			actual = new SortableStack<Integer>(Arrays.asList(intArr));
			expected = new SortableStack<Integer>(); // instantiates an empty stack
			actual.sort();
			assertEquals(expected, actual);
		} catch (Exception e) {
			fail("Operation should not have raised an exception");
		}

		try {
			Integer[] intArr = { 1, 1, 2 };
			Integer[] intArr_exp = { 2, 1, 1 };
			actual = new SortableStack<Integer>(Arrays.asList(intArr));
			expected = new SortableStack<Integer>(Arrays.asList(intArr_exp));
			actual.sort();
			assertEquals(expected, actual);
		} catch (Exception e) {
			fail("Operation should not have raised an exception");
		}
	}

}
