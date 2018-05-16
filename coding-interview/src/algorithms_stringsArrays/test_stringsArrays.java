package algorithms_stringsArrays;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.Set;

import org.junit.jupiter.api.Test;

class test_stringsArrays {

	/**
	 * Test if empty string causes crash.
	 */
	@Test
	void test_allMutations1() {
		try {
			stringsArrays.allMutations("");
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
		Set<String> actual = stringsArrays.allMutations("123");
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
			String actual = stringsArrays.replaceSpaceWith(" A rian  Seye di ", "%20");
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
		String actual = stringsArrays.stringCompressor("AAABCDD");
		String expected2 = "A3"; // test repetition at both ends.
		String actual2 = stringsArrays.stringCompressor("AAA");
		String expected3 = "A3B1"; // test repetition at the beginning.
		String actual3 = stringsArrays.stringCompressor("AAAB");
		String expected4 = "B1A3"; // test repetition at the end.
		String actual4 = stringsArrays.stringCompressor("BAAA");
		String expected5 = "A1"; // test on char in string only.
		String actual5 = stringsArrays.stringCompressor("A");
		String expected6 = ".1"; // test special char '.'
		String actual6 = stringsArrays.stringCompressor(".");
		if (!expected.equals(actual) || !expected2.equals(actual2) || !expected3.equals(actual3)
				|| !expected4.equals(actual4) || !expected5.equals(actual5) || !expected6.equals(actual6)) {
			fail("unexpected output");
		}
		try {
			stringsArrays.stringCompressor("");
			fail("fail to throw error");
		} catch (IllegalArgumentException e) {
			// pass
		}

	}
}
