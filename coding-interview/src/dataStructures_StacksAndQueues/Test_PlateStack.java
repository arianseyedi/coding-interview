package dataStructures_StacksAndQueues;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test_PlateStack {

	List<Integer> exp_ls;
	PlateStack<Integer> act;
	int thresh = (int) (Math.random() * 10) + 3;
	int toAdd = (thresh * 3 - thresh / 2);

	/**
	 * prep expected list
	 * 
	 * @throws MaxStackSizeExceededException
	 */
	@BeforeEach
	void prep() throws MaxStackSizeExceededException {
		act = new PlateStack<>(thresh);
		exp_ls = new ArrayList<Integer>();
		int elem;
		for (int i = 1; i <= toAdd; i++) {
			elem = i * 10;
			exp_ls.add(elem);
			act.push(elem);
		}
	}

	/**
	 * Test PlateStack for robustness and BCN
	 * 
	 * @throws MaxStackSizeExceededException
	 */
	@Test
	void test_01() throws MaxStackSizeExceededException {
		int exp_init_size = (toAdd / thresh) + 1;
		int thresh_cpy = thresh;
		int exp_l_size = exp_ls.size();

		assertEquals(exp_ls.size(), act.size()); // check total size,
		assertEquals(exp_ls.get(exp_ls.size() - 1), act.peek()); // peek inner stack
		assertEquals(exp_init_size, act.stockSize()); // check stock size

		// pop inner stack first
		for (int i = 0; i < thresh; i++) {
			assertEquals(exp_ls.get(--thresh_cpy), act.pop(0));
		}
		
		// check actual stock size, must have now been reduced by 1.
		assertEquals(exp_init_size - 1, act.stockSize());

		// pop the rest
		for (int i = act.size(); i > 0; i--) {
			assertEquals(exp_ls.get(--exp_l_size), act.pop());
		}
		assertEquals(1, act.stockSize()); // check stock size
		assertEquals(0, act.size()); // check total size

	}

}
