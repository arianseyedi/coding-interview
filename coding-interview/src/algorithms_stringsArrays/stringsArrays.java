package algorithms_stringsArrays;

import java.util.*;

/**
 * This class will contain a few methods that perform on strings for a certain
 * purpose. They may seem a bit random, as they are, but will give insights as
 * to how certain things can be done.
 * 
 * @author Arian
 *
 */
public class stringsArrays {

	public stringsArrays() {
		// nothing
	}

	/**
	 * This class provides all possible mutations of a string, that is every
	 * character combination that make up the given string. Uses a private recursive
	 * helper method that runs in O(n^2). Thus method runs in O(n^2).
	 * 
	 * @param str
	 *            the input string whose list of possible mutations will be
	 *            returned.
	 * @return String array list with all possible mutations of input string.
	 */
	public static ArrayList<String> allMutations(String str) {
		ArrayList<String> mutations = new ArrayList<String>();
		allMutations_helper(mutations, "", str);
		return mutations;
	}

	/**
	 * A recursive method to help create all possible mutations of a string.
	 * 
	 * @param mutations
	 *            arrayList that will contain all mutations of fixed joined with
	 *            substr.
	 * @param fixed
	 *            fixed string which will not be included in finding its mutation.
	 * @param substr
	 *            will be explored for all possible mutations of this string.
	 */
	private static void allMutations_helper(ArrayList<String> mutations, String fixed, String substr) {
		if (substr.length() == 1) { // base case, finally join the two strings
			mutations.add(String.join("", fixed, substr));
		}
		for (int i = 0; i < substr.length(); i++) { // recursive call to explore possible mutations.
			String rest = String.join("", substr.substring(0, i), substr.substring(i + 1));
			allMutations_helper(mutations, String.join("", fixed, substr.substring(i, i + 1)), rest);
		}
	}

	/**
	 * Temporary for quick method checks.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		for (String i : allMutations("ABCD")) {
			System.out.println(i);
		} // this was a pass. 7.50 PM may 15.

	}

}
