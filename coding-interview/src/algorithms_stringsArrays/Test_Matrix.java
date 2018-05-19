package algorithms_stringsArrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tester unit for matrix class
 * 
 * @author Arian Seyedi
 *
 */
class Test_Matrix {
	/**
	 * Tests method in charge of replacing the associated row (x) and column (y) of
	 * any number at location (x, y) with the same value of that number.
	 */
	@Test
	void test_replaceRowCol() {
		// common error checks
		try {
			Integer[][] da = { { 1 }, { 2 } };
			new Matrix(da);
		} catch (IllegalArgumentException e) {
			fail("failed to initialize a 1 x 2 matrix. ");
		}
		try {
			Integer[][] da = { { 1 } };
			new Matrix(da);
			fail("failed to throw IAE for a 1 x 1 2-D array. ");
		} catch (IllegalArgumentException e) {
			// pass
		}
		try {
			Integer[][] da = { {} };
			new Matrix(da);
			fail("failed to throw IAE for an empty array. ");
		} catch (IllegalArgumentException e) {
			// pass
		}

		try {
			Integer[][] da = null;
			new Matrix(da);
			fail("failed to throw IAE for a null array.");
		} catch (IllegalArgumentException e) {
			// pass
		} 
		Integer[][] da = { { 1, 2, 3 }, { 1, 9, 8 }, { 1, 4, 1 }, { 4, 9, 0 } };
		Integer[][] exp = { { 1, 2, 8 }, { 8, 8, 8 }, { 1, 4, 8 }, { 4, 9, 8 } };
		Matrix expected = new Matrix(exp); // expected matrix
		Matrix actual = new Matrix(da);
		actual = actual.replace_rowCol_ofVal(8); // actual matrix. get a copy of mutated for comparison
		assertTrue(actual.equals(expected));

		Integer[][] exp2 = { { 1, 2, 3 }, { 1, 9, 8 }, { 1, 4, 1 }, { 4, 9, 0 } };
		expected = new Matrix(exp2); // expected matrix
		actual = new Matrix(da); // should not alter the state of the function.
		actual = actual.replace_rowCol_ofVal(128);// actual matrix. get a copy of mutated for comparison
		assertTrue(actual.equals(expected));
	}

}
