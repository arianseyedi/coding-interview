package algorithms_stringsArrays;

import java.util.PriorityQueue;

/**
 * A class containing two comparison sorting algorithms heap and merge sort.
 * 
 * @author Arian Seyedi
 *
 */
public class sorting {

	/**
	 * Sorts the input array of Integers a using HeapSort. Result is returned in a.
	 * Makes use of java.util.PriorityQueue. Sorting is NOT in place - PriorityQueue
	 * allocates a separate heap-based priority queue. Not a stable sort, in
	 * general. Throws a null pointer exception if the input array is null.
	 * 
	 * @param a
	 *            array of interegs to be sorted
	 * @throws NullPointerException
	 *             if null input.
	 */
	public static void heapSort(Integer[] a) throws NullPointerException {
		if (a.length == 0) { // check for null
			throw new NullPointerException("Array empty!");
		}
		// sorting
		PriorityQueue<Integer> priorityQ = new PriorityQueue<Integer>();
		for (int i = 0; i < a.length; i++) {
			priorityQ.add(a[i]);
		}
		for (int j = 0; j < a.length; j++) {
			a[j] = priorityQ.remove();
		}
	}

	/**
	 * Sorts the input array of Integers a using mergeSort and returns result.
	 * Sorting is stable. Throws a null pointer exception if the input array is
	 * null.
	 * 
	 * @param a
	 *            array of integers.
	 * @return the input array with its elements sorted.
	 * @throws NullPointerException
	 *             if array is empty.
	 */
	public static Integer[] mergeSort(Integer[] a) throws NullPointerException {
		if (a.length == 0) { // check for null
			throw new NullPointerException("Array empty!");
		}
		return (mergeSort(a, 0, a.length - 1));
	}

	/**
	 * Sorts the input subarray of Integers a[p...q] using MergeSort and returns
	 * result. Sorting is stable.
	 * 
	 * @param a
	 *            array of integers to sort
	 * @param p
	 *            used for breaking up the array from index p.
	 * @param q
	 *            used for breaking up the array to index q.
	 */
	private static Integer[] mergeSort(Integer[] a, int p, int q) {
		if (q > p) {// check if breakable
			Integer[] l1 = mergeSort(a, p, (p + q) / 2); // merge sort left half
			Integer[] l2 = mergeSort(a, ((p + q) / 2) + 1, q); // merge sort right half
			Integer[] result = merge(l1, l2); // merge the result
			return result;
		}
		Integer[] result = { a[p] };
		return result;
	}

	/**
	 * Merges two sorted arrays of Integers into a single sorted array. Given two
	 * equal elements, one in a and one in b, the element in a precedes the element
	 * in b.
	 * 
	 * @param a
	 *            array of Integers to be sorted.
	 * @param b
	 *            array of Integers to be sorted.
	 */
	private static Integer[] merge(Integer[] a, Integer[] b) {
		int i = 0, j = 0, k = 0;
		Integer[] result = new Integer[a.length + b.length];
		while (i != a.length && j != b.length) { // exits as soon as one of the two conditions breached.
			if (a[i] <= b[j]) {
				result[k++] = a[i++];
			} else {
				result[k++] = b[j++];
			}
		}

		// we must include all the untouched values from either one array.
		if (a.length == i && j < b.length) {// no more a members, all b members are inserted.
			for (; j < b.length; j++) {
				result[k++] = b[j];
			}
		} else if (b.length == j && i < a.length) {// no more b members, all a members are inserted.
			for (; i < a.length; i++) {
				result[k++] = a[i];
			}
		}
		return result;
	}

	// public static void main(String[] args) { // quick check
	// Integer[] a = { 1, 91, 23, 2, 19, 2, 4, 289, 194, 133, 15 };
	// heapSort(a);
	// for (int i = 0; i < a.length; i++) {
	// System.out.println("i is " + a[i]);
	// }
	//
	// Integer[] A = { 1, 3, 17, 25 };
	// Integer[] B = { 0, 2, 117, 225 };
	// Integer[] C = { 1, 91, 23, 2, 19, 2, 4, 289, 194, 133, 15 };
	// Integer[] D = mergeSort(C);
	// System.out.print("[ ");
	// for (Integer j : D) {
	// System.out.print(j + ", ");
	// }
	// System.out.println(" ]");
	// }
}
