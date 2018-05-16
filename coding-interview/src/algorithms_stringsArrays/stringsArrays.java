package algorithms_stringsArrays;

import java.nio.charset.Charset;
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
	 * replaced with a string which is not necessarily the same size. Input string
	 * must have enough room for the additional characters at the end of it. For
	 * example replaceSpaceWith("Arian Seyedi'space''space'", "%20", 12) will return
	 * "Arian%20Seyedi" where 12 is the number of all characters minus the trailing
	 * white space at the end to accommodate for the extra 2 characters. The term
	 * 'space' is simply a place holder for space character for the sake of clarity
	 * in the example.
	 * 
	 * @param str
	 *            will have spaces repaced with the replacement. Input str must have
	 *            enough room to account for extra characters if any.
	 * @param replacement
	 *            the replacement for all spaces in str.
	 * @return str with spaces replaced with the replacement.
	 */
	public static String replaceSpaceWith(String str, String replacement, int trueLength) {
		double numReplacements = str.length() / trueLength;
		if (Math.floor(numReplacements) != (int) numReplacements) {
			throw new IllegalArgumentException("Either wrong trueLength or string does not have right capacity.");
		}
		List<String> allChars = new ArrayList<String>();
		int consecSpaces = 0;
		for (int i = 0; i < str.length() - trueLength - 1; i++) {
			if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
				allChars.add(replacement);
			} else {
				allChars.add(str.substring(i - 1, i)); 
			}
		}
		return str;
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

	}

}
