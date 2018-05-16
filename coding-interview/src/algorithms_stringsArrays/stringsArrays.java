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
	 * helper method that runs in O(xn!). Thus method runs in O(xn!).
	 * 
	 * @param str
	 *            the input string whose list of possible mutations will be
	 *            returned.
	 * @return String set with all possible mutations of input string.
	 */
	public static Set<String> allMutations(String str) {
		Set<String> mutations = new HashSet<String>();
		allMutations_helper(mutations, "", str);
		return mutations;
	}

	/**
	 * A recursive method to help create all possible mutations of a string.
	 * 
	 * @param mutations
	 *            hashSet that will contain all mutations of fixed joined with
	 *            substr.
	 * @param fixed
	 *            fixed string which will not be included in finding its mutation.
	 * @param substr
	 *            will be explored for all possible mutations of this string.
	 */
	private static void allMutations_helper(Set<String> mutations, String fixed, String substr) {
		if (substr.length() == 1) { // base case, finally join the two strings
			mutations.add(String.join("", fixed, substr));
		}
		for (int i = 0; i < substr.length(); i++) { // recursive call to explore possible mutations.
			String rest = String.join("", substr.substring(0, i), substr.substring(i + 1));
			allMutations_helper(mutations, String.join("", fixed, substr.substring(i, i + 1)), rest);
		}
	}

	/**
	 * This method particularly works if spaces between words in a string need be
	 * replaced with a string which is not necessarily the same size. For example
	 * replaceSpaceWith("Arian Seyedi", "%20") will return "Arian%20Seyedi".
	 * 
	 * @param str
	 *            will have spaces repaced with the replacement in a new string.
	 * @param replacement
	 *            the replacement for all spaces in str.
	 * @return str with spaces replaced with the replacement in a new string.
	 */
	public static String replaceSpaceWith(String str, String replacement) {
		StringBuffer strbf = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				strbf.append(str.charAt(i)); // append just like a copy.
			} else {
				strbf.append(replacement); // for every space, append replacement to buffer instead.

			}
		}
		return strbf.toString(); // buffer to string and return.
	}

	/**
	 * This method compresses strings by showing every character and the number of
	 * consecutive repetition of them such that the repetition follows the character
	 * being repeated that many times. For instance, input string "AAACVVD" will
	 * return "A3C1V2D1".
	 * 
	 * @param str
	 *            the string input containing any character.
	 * @return a string containing every character followed by respective number of
	 *         consecutive repetition.
	 * @throws IllegalArgumentException
	 *             if string is empty.
	 */
	public static String stringCompressor(String str) throws IllegalArgumentException {
		if (str.length() == 0) {
			throw new IllegalArgumentException("string cannot be empty!");
		}
		StringBuffer strbf = new StringBuffer(); // strin buffer for characters
		// head start with zeroth char.
		char c = str.charAt(0);
		strbf.append(c);
		int repetition = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				repetition++; // nothing more to do here than to remember the repetition
			} else {
				strbf.append(repetition); // done with last char, append score already.
				repetition = 1; // reset repetition to 1.
				c = str.charAt(i); // update character
				strbf.append(c); // add current char to buffer
			}
		}
		strbf.append(repetition); // last char is missing its score, append score already.
		return strbf.toString();
	}

	/**
	 * Temporary for quick method checks.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		for (String i : allMutations("011")) {
			System.out.println(i);
		} // this was a pass. 7.50 PM may 15.
		System.out.println(replaceSpaceWith(" A rian  Seye di ", "%20")); // pass
		System.out.println(stringCompressor("DDDABBCDDD")); // pass
	}

}
