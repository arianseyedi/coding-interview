package dataStructures_LinkedIntLists;

/**
 * Utility methods for Linked List class.
 * 
 * @author Arian Seyedi
 *
 */
public class Utilities {

	/**
	 * Check if one instance of the target value already exists in the input array.
	 * Method assumes continuous array in which at no point in between two integer
	 * exists a null object.
	 * 
	 * @param arr
	 *            the array to search
	 * @param target
	 *            the value to search for the earliest instance off
	 * @return true immediately an instance of the target value is visited within
	 *         the array, false if target is unique.
	 */
	protected static boolean existsInArray(Integer[] arr, Integer target) {
		if (arr == null) {
			throw new NullPointerException("array is null");
		}
		if (arr.length == 0) {
			return false;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null)
				break;
			if (arr[i].intValue() == target)
				return true;
		}
		return false;
	}

	public static void main(String args[]) {
		Integer[] a = { 1, 2 };
		System.out.println(existsInArray(a, 99));
	}
}
