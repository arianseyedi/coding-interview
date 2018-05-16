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
	 * replaced with a string which is not necessarily the same size. Input string
	 * must have enough room for the additional characters at the end of it. For
	 * example replaceSpaceWith("Arian Seyedi", "%20") will return "Arian%20Seyedi".
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
				strbf.append(str.charAt(i));
			} else {
				strbf.append(replacement);
			}
		}
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
		System.out.print(replaceSpaceWith(" A rian  Seye di ", "%20"));
	}

}
