package algorithms_stringsArrays;

import java.util.List;

/**
 * This helper class creates a pair of Integers. Used as a wrapper to keep two
 * Integers with a certain property ex. co-prime, or sum up to X, etc.
 * 
 * @author Arian Seyedi
 *
 */
public class NumPair {
	private Integer pair1; // first of the pair
	private Integer pair2; // second of the pair

	/**
	 * Constructor creates an object wrapping two integers.
	 * 
	 * @param pair1
	 *            one Integer
	 * @param pair2
	 *            another Integer
	 */
	public NumPair(Integer pair1, Integer pair2) {
		this.pair1 = pair1;
		this.pair2 = pair2;
	}

	/**
	 * Returns a deep copy of pair1.
	 * 
	 * @return a deep copy of pair1.
	 */
	public Integer getPair1() {
		Integer copy = this.pair1.intValue();
		return copy;
	}

	/**
	 * Returns a deep copy of pair2.
	 * 
	 * @return a deep copy of pair2.
	 */
	public Integer getPair2() {
		Integer copy = this.pair2.intValue();
		return copy;
	}

	/**
	 * Deep copy the input number pair
	 * 
	 * @param toCopy
	 *            number pair to deep copy
	 * @return deep copy of input number pair
	 */
	public static NumPair deepCopy(NumPair toCopy) {
		return new NumPair(toCopy.getPair1(), toCopy.getPair2());
	}

	/**
	 * Calculates the sum of the two wrapped integers.
	 * 
	 * @return
	 */
	public Integer sum() {
		return this.pair1 + this.pair2;
	}

	/**
	 * This method compares this number pair with another. Returns true if both
	 * numbers in one pair exist in the other, thus the order does not matter.
	 * 
	 * @param numPair
	 *            the number pair to compare.
	 * @return true if both numbers in one pair also exist in the other one.
	 */
	@Override
	public boolean equals(Object numPair) { // order does not matter
		if (numPair.getClass() != NumPair.class) {
			throw new IllegalArgumentException("Object must be a number pair object!");
		}
		NumPair np = (NumPair) numPair;
		if ((this.getPair1() == np.getPair1() && this.getPair2() == np.getPair2())
				|| (this.getPair2() == np.getPair1() && this.getPair1() == np.getPair2())) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "(" + this.pair1 + ", " + this.pair2 + ")";
	}

	/**
	 * Searches for this pair in a given list.
	 * 
	 * @param npLs
	 * @return True if this pair exists in the given list.
	 */
	public boolean containsNumPair(List<NumPair> npLs) {
		for (int i = 0; i < npLs.size(); i++) {
			if (this.equals(npLs.get(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if all the unique number pairs in one list exist in the other.
	 * 
	 * @param npLs1
	 *            list of unique number pairs.
	 * @param npLs2
	 *            list of unique number pairs.
	 * @return True if all the unique number pairs in one list exist in the other.
	 */
	public static boolean containsAll(List<NumPair> npLs1, List<NumPair> npLs2) {
		int count = 0, enough = Math.min(npLs1.size(), npLs2.size());
		for (int i = 0; i < npLs1.size(); i++) {
			NumPair np1Now = npLs1.get(i);
			for (int j = 0; j < npLs1.size(); j++) {
				if (np1Now.equals(npLs2.get(j))) {
					count++;
					if (count == enough)
						break;
				}
			}
		}
		if (count == enough) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) { // quick check
		NumPair a = new NumPair(2, 19);
		NumPair b = new NumPair(2, 19);
		NumPair c = new NumPair(19, 2);
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));

	}
}
