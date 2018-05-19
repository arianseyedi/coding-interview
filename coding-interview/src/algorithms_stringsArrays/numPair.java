package algorithms_stringsArrays;

/**
 * This class creates a pair of Integers. Used as a wrapper to keep two Integers
 * with a certain property ex. co-prime, or sum up to X, etc.
 * 
 * @author Arian Seyedi
 *
 */
public class numPair {
	private Integer pair1; // first of the pair
	private Integer pair2; // second of the pair

	public numPair(Integer pair1, Integer pair2) {
		this.pair1 = pair1;
		this.pair2 = pair2;
	}

	public Integer getPair1() {
		Integer copy = this.pair1;
		return copy;
	}

	public Integer getPair2() {
		Integer copy = this.pair2;
		return copy;
	}

	public Integer sum() {
		return this.pair1 + this.pair2;
	}

	@Override
	public String toString() {
		return "(" + this.pair1 + ", " + this.pair2 + ")";
	}

	public static void main(String[] args) { // quick check
		numPair a = new numPair(2, 19);
		Integer maybeCopy = a.getPair1();
		maybeCopy = 22;
		System.out.println(a);

	}
}
