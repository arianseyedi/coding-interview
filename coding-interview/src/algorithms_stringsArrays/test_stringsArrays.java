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

}
