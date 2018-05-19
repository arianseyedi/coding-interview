package algorithms_stringsArrays;

/**
 * This class creates a pair of Integers. Used as a wrapper to keep two Integers
 * with a certain property ex. co-prime, or sum up to X, etc.
 * 
 * @author Arian Seyedi
 *
 */
public class NumPair {
	private Integer pair1; // first of the pair
	private Integer pair2; // second of the pair

	/**
	 * Constructor creates an object wrapping two integers.
	 * @param pair1 one Integer
	 * @param pair2 another Integer
	 */
	public NumPair(Integer pair1, Integer pair2) {
		this.pair1 = pair1;
		this.pair2 = pair2;
	}

	/**
	 * Returns a deep copy of pair1.
	 * @return a deep copy of pair1.
	 */
	public Integer getPair1() {
		Integer copy = this.pair1.intValue();
		return copy;
	}
	
	/**
	 * Returns a deep copy of pair2.
	 * @return a deep copy of pair2.
	 */
	public Integer getPair2() {
		Integer copy = this.pair2.intValue();
		return copy;
	}

	/**
	 * Calculates the sum of the two wrapped integers.
	 * @return
	 */
	public Integer sum() {
		return this.pair1 + this.pair2;
	}

	/**
	 * This method compares this number pair with another. Returns true if both
	 * numbers in one pair exist in the other, thus the order does not matter.
	 * 
	 * @param np
	 *            the number pair to compare.
	 * @return true if both numbers in one pair also exist in the other one.
	 */
	public boolean equals(NumPair np) { // order does not matter
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

	public static void main(String[] args) { // quick check
		NumPair a = new NumPair(2, 19);
		NumPair b = new NumPair(2, 19);
		NumPair c = new NumPair(19, 2);
		Integer maybeCopy = a.getPair1();
		maybeCopy = 22;
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));

	}
}
