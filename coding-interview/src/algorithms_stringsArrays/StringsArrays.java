package algorithms_stringsArrays;

import java.util.*;

/**
 * This class will contain a few methods that perform on strings for a certain
 * purpose. They may seem a bit random, as they are, but will give insights as
 * to how certain things can be done.
 * 
 * @author Arian Seyedi
 *
 */
public class StringsArrays {
	static int count = 0; // for debugging

	public StringsArrays() {
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
	 * Method returns all pairs in a list whose sum is equal to a certain amount
	 * determined by the user. A pair is a wrapper object consisting of two
	 * Integers. Runtime complexity is Omega(n^2) guaranteed. Method mutates input
	 * array through heap-sorting.
	 * 
	 * @param a
	 *            an array of Integers.
	 * @param sum
	 *            target sum for which the pairs will be looked for.
	 * @return
	 * @throws IllegalArgumentException
	 *             if array has less than 2 numbers in it.
	 */
	public static List<NumPair> pairsSum(Integer[] a, Integer sum) {
		if (a.length < 2) { // error check
			throw new IllegalArgumentException("Array must at least contain 2 numbers.");
		}
		Sorting.heapSort(a); // mutator method to sort integer array. O(n log(n))
		List<NumPair> result = new ArrayList<NumPair>();
		if ((a[a.length - 1] + a[a.length - 2] < sum) || (a[0] + a[1] > sum)) {
			// no chance of a non void answer
			return result;
		}
		NumPair bounds = pickSumBoundary(a, sum); // O(n)
		int f_index = bounds.getPair1(); // fixed index
		int m_index = f_index + 1; // moving index
		int end_index = bounds.getPair2(); // end index
		pSum_helper(a, sum, f_index, m_index, end_index, result); // omega(n^2)
		return result;
	}

	/**
	 * Finds the inclusive beginning and end indices within which numbers at most
	 * sum to a certain input sum in a sorted list of Integers.
	 * 
	 * @param a
	 *            array of Integers.
	 * @param sum
	 *            the target sum.
	 * @return an pair of beginning and end indices within which numbers in the
	 *         input array sum to at most the given input sum.
	 */
	public static NumPair pickSumBoundary(Integer[] a, int sum) {
		int beg = 0, end = a.length - 1;
		while (a[end] >= sum) {
			end--; // decrement end while equal or larger than sum
		}
		while (a[beg] + a[end] < sum) {
			beg++; // increment beginning while sum of either ends smaller than sum.
		}
		return new NumPair(beg, end);
	}

	/**
	 * Helper method recursively finds all pairs whose sum are equal to the input
	 * sum.
	 * 
	 * @param arr
	 *            array of Integers to pick pairs from. Accessor-only method.
	 * @param sum
	 *            input target sum to pair numbers.
	 * @param f_ix
	 *            the fixed index whose other pair member will be picked from the
	 *            next available indices.
	 * @param m_ix
	 *            moving index used to iterate the array to search for pair sums.
	 * @param end_ix
	 *            TODO
	 * @param pairsLs
	 *            list of number pairs to be populated.
	 * @return list of number pairs whose sum is equal to input sum.
	 * @throws IllegalArgumentException
	 *             if index is not available in the array, or array length less than
	 *             2.
	 */
	private static void pSum_helper(Integer[] arr, Integer sum, int f_ix, int m_ix, int end_ix, List<NumPair> pairsLs) {
		if (f_ix <= end_ix - 1) {
			if (m_ix <= end_ix) {
				if (sum - arr[f_ix] == arr[m_ix]) { // if sum equality true, add.
					pairsLs.add(new NumPair(arr[f_ix], arr[m_ix]));
					pSum_helper(arr, sum, f_ix, m_ix + 1, end_ix, pairsLs);
				} else if (sum - arr[f_ix] - arr[m_ix] > 0) { // keep fixed one fixed, move the moving.
					pSum_helper(arr, sum, f_ix, m_ix + 1, end_ix, pairsLs); // increment m_index
				} else if (sum - arr[f_ix] - arr[f_ix + 1] > 0) {
					// at this fixed position, no further moving index can equal sum, so move fixed
					// index.
					pSum_helper(arr, sum, f_ix + 1, f_ix + 2, end_ix, pairsLs); // increment m_index
				}
			} else { // reached end of array with the moving index, move the fixed index.
				pSum_helper(arr, sum, f_ix + 1, f_ix + 2, end_ix, pairsLs);// increment m_index
			}
		}
	}

	/**
	 * Temporary for quick method checks.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// test pairsSum
		Integer[] b  = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		List<NumPair> np = pairsSum(b, 16);
		for (NumPair i : np) {
			System.out.println(i);
		}
	}

}