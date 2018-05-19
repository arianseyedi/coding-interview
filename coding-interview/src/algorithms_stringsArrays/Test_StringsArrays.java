package algorithms_stringsArrays;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class Test_StringsArrays {

	/**
	 * Test if empty string causes crash.
	 */
	@Test
	void test_allMutations1() {
		try {
			StringsArrays.allMutations("");
		} catch (Exception e) {
			fail("Unexpected error for empty string input!" + e);
		}
	}

	/**
	 * This tester, tests whether all possible mutations of string 123 is found.
	 */
	@Test
	void test_allMutations2() {
		Set<String> expected = new HashSet<String>(
				Arrays.asList(new String[] { "123", "132", "321", "312", "231", "213" }));
		Set<String> actual = StringsArrays.allMutations("123");
		if (actual.size() != expected.size()) {
			fail("non matching set size!");
		}
		for (String s : actual) {
			if (!expected.contains(s)) {
				fail("string " + s + " not expected!");
			}
		}
	}

	/**
	 * Test replaceSpaceWith method for output on a string having spaces in multiple
	 * locations.
	 */
	@Test
	void test_replaceSpaceWith() {
		try {
			String expected = "%20A%20rian%20%20Seye%20di%20";
			String actual = StringsArrays.replaceSpaceWith(" A rian  Seye di ", "%20");
			if (!expected.equals(actual)) {
				fail("output not expected!");
			}
		} catch (Exception e) {
			fail("failed by unexpected error! " + e);
		}
	}

	/**
	 * Test stringCompressor for correctness and stability on boundary condition.
	 */
	@Test
	void test_stringCompressor() {
		String expected = "A3B1C1D2";
		String actual = StringsArrays.stringCompressor("AAABCDD");
		String expected2 = "A3"; // test repetition at both ends.
		String actual2 = StringsArrays.stringCompressor("AAA");
		String expected3 = "A3B1"; // test repetition at the beginning.
		String actual3 = StringsArrays.stringCompressor("AAAB");
		String expected4 = "B1A3"; // test repetition at the end.
		String actual4 = StringsArrays.stringCompressor("BAAA");
		String expected5 = "A1"; // test on char in string only.
		String actual5 = StringsArrays.stringCompressor("A");
		String expected6 = ".1"; // test special char '.'
		String actual6 = StringsArrays.stringCompressor(".");
		if (!expected.equals(actual) || !expected2.equals(actual2) || !expected3.equals(actual3)
				|| !expected4.equals(actual4) || !expected5.equals(actual5) || !expected6.equals(actual6)) {
			fail("unexpected output");
		}
		try {
			StringsArrays.stringCompressor("");
			fail("fail to throw error");
		} catch (IllegalArgumentException e) {
			// pass
		}
	}

	/**
	 * Tests method for finding pairs with specific sum for boundary conditions.
	 */
	@Test
	public void test_pairsSum_bcn() {
		try {
			StringsArrays.pairsSum(new Integer[] {}, 0);
			fail("Missed error check!");
		}catch (IllegalArgumentException e) {
			// pass
		}
		try {
			StringsArrays.pairsSum(new Integer[] {1}, 0);
			fail("Missed error check!");
		}catch (IllegalArgumentException e) {
			// pass
		}
		try {
			StringsArrays.pairsSum(new Integer[] {1, 2}, 0);
			// pass
		}catch (Exception e) {
			fail("Valid inputs caused unexpected error");
		}

	}
	
	/**
	 * Tests method for finding pairs with specific sum for accuracy.
	 */
	@Test
	public void test_pairsSum_accuracy() {
		Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		List<NumPair> expected = new ArrayList<NumPair>(); // for sum = 16
		expected.add(new NumPair(1, 15));
		expected.add(new NumPair(2, 14));
		expected.add(new NumPair(3, 13));
		expected.add(new NumPair(4, 12));
		expected.add(new NumPair(5, 11));
		expected.add(new NumPair(6, 10));
		expected.add(new NumPair(7, 9));
		try {
			List<NumPair> nmp = StringsArrays.pairsSum(a, 16);
			assertEquals(expected.size(), nmp.size(),"Number pair list length mismatch!");
			assertTrue(NumPair.containsAll(expected, nmp));
		}catch (Exception e) {
			fail("Valid inputs caused unexpected error");
		}

	}
	
	/**
	 * Tests method in charge of finding number of common elements in two arrays.
	 */
	@Test
	public void test_inCommon() {
		Integer[] a = { 1, 9, 12, 13, 15 };
		Integer[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15 };
		assertEquals(4, StringsArrays.inCommon(a, b), "Unexpected number of elements in common!");
		
		Integer[] c = {};
		Integer[] d = { 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15 };
		assertEquals(0, StringsArrays.inCommon(c, d), "Unexpected number of elements in common!");

		Integer[] e = {};
		Integer[] f = {};
		assertEquals(0, StringsArrays.inCommon(e, f), "Unexpected number of elements in common!");
		
		try {
			StringsArrays.inCommon(null, a);
			fail("Must have thrown null exception");
		}catch (NullPointerException ex) {
			// pass
		}
	}
}
