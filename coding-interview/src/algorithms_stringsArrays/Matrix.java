package algorithms_stringsArrays;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

	public Integer[][] matrix; // double array representing the matrix.

	/**
	 * Initialize a matrix by making a double array of a given row x column and set
	 * each cell value to 0.
	 * 
	 * @param m
	 *            number of rows
	 * @param n
	 *            number of columns
	 */
	public Matrix(int m, int n) { // initialize a matrix size
		matrix = new Integer[m][n];
	}

	/**
	 * Initialize matrix of m(rows) x n(columns) by setting each cell equal to input
	 * value.
	 * 
	 * @param m
	 *            matrix rows
	 * @param n
	 *            matrix columns
	 * @param val
	 *            value placed in each cell of the m(rows) x n(columns) matrix.
	 */
	public Matrix(int m, int n, int val) { // initialize dimensions and set each cell to val
		matrix = new Integer[m][n];
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[0].length; j++) {
				matrix[i][j] = 0;
			}
		}
	}

	/**
	 * Initialize matrix given a valid n(row) x m(column) array
	 * 
	 * @param arr2D
	 */
	public Matrix(Integer[][] arr2D) {
		setMatrix(arr2D); // validate, and populate. O(n x m)
	}

	private void setMatrix(Integer[][] arr2D) {
		if (arr2D == null) // for null input
			throw new IllegalArgumentException("The 2-D array cannot be null/or empty!");
		if (arr2D.length == 0) // for 0 length array
			throw new IllegalArgumentException("Array cannot be empty!");
		if (arr2D[0] == null) // for null inner array
			throw new IllegalArgumentException("The 2-D array contains null as inner array!");
		if (arr2D[0].length == 0) // for 0 length inner array
			throw new IllegalArgumentException("The 2-D array contains inner array of length 0!");
		if (arr2D[0].length == 1 && arr2D.length == 1)
			throw new IllegalArgumentException("The 2-D array cannot be 1 x 1 in dimension. Not a valid Matrix!");
		int rows = arr2D.length, cols = arr2D[0].length, thisCol;
		this.matrix = new Integer[rows][cols]; // if input is to be a matrix, we will be safe.
		try {
			for (int i = 0; i < arr2D.length; i++) { // for every row
				thisCol = arr2D[i].length;
				if (thisCol != cols) {
					throw new IllegalArgumentException("Column length mismatch!");
				}
				for (int j = 0; j < thisCol; j++) {
					if (arr2D[i][j] == null) {
						throw new IllegalArgumentException(
								"The 2-D array contains null value(s). Cannot form valid matrix.");
					}
					this.matrix[i][j] = arr2D[i][j];
				}
			}
		} catch (IndexOutOfBoundsException e) { // index boundary error.
			throw new IllegalArgumentException("The 2-D array column size mismatch!");
		}
	}

	/**
	 * If an element in an MxN matrix is 0, its entire row and column are set to O.
	 * 
	 */
	public void zeroCell_toZeroCross() {
		int target = 0;
		List<NumPair> np = new ArrayList<NumPair>(); // (row, col) in this order.
		this.locateNums(np, 0); // ensure it is a matrix
		int i = 0;
		while (i < np.size()) {
			NumPair pair = np.get(i++);
			for (int j = pair.getPair1(); j < matrix.length; j++) { // for all rows
				matrix[j][pair.getPair2()] = 0; // at fixed column using getPair2
			}
			for (int k = pair.getPair2(); k < matrix[0].length; k++) { // for all columns
				matrix[pair.getPair1()][k] = 0; // at fixed row using getPair1
			}
		}

	}

	/**
	 * Locates elements of a given value.
	 * 
	 * @param np
	 *            list of number pairs to be populated.
	 * @param target
	 *            target value for the report. (row, column) of values equal to
	 *            target will be put in np list.
	 */
	private void locateNums(List<NumPair> np, int target) {
		int col = matrix[0].length; // column length
		int row = matrix.length; // row length
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (matrix[i][j] == target)
					np.add(new NumPair(i, j)); // (row, column)
	}

	/**
	 * Print matrix in the terminal.
	 */
	public void showMatrix() {
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[0].length; j++) {
				System.out.print(this.matrix[i][j]);
				if (j < this.matrix[0].length - 1)
					System.out.print(" , ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// test
		Integer[][] da = { { 1, 2, 3 }, { 0, 9, 8 }, { 1, 2, null }, { 4, 0, 0 } };
		Matrix ma = new Matrix(da);
		ma.showMatrix();
	}
}
