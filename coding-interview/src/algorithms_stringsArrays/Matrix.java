package algorithms_stringsArrays;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is generously built to assist with a few algorithms for a specific
 * application. Find references in methods documentation below.
 * 
 * @see Laakmann McDowell, 2015 Chapter1 for original question.
 * @author Arian Seyedi
 *
 */
public class Matrix {

	private Integer[][] matrix; // double array representing the matrix.

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

	/**
	 * Sets matrix object cell values according to the input 2-D array. The 2-D
	 * array must have solid dimensions and contain numbers as values only.
	 * 
	 * @param arr2D
	 *            2-D array to be copied if solid and contains all numbers.
	 * @throws IllegalArgumentException
	 *             if 2-D array contains null values or is not solid.
	 */
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
	 * If an element in an MxN matrix is equal to the input, its entire row and
	 * column will be set to that value.
	 * 
	 * @see Laakmann McDowell, 2015 Chapter1 for original question.
	 * @author Arian Seyedi
	 * @param target
	 *            target value to be used to replace the intercepting row and
	 *            column.
	 */
	public Matrix replace_rowCol_ofVal(int target) {
		List<NumPair> np = new ArrayList<NumPair>(); // (row, col) in this order.
		Matrix res_m = new Matrix(this.matrix); // mutable copy of matrix.

		this.locateNums(np, target); // locate all matrix cells locations (row, col)pair equal to input.
		int i = 0;
		while (i < np.size()) {
			NumPair pair = np.get(i++);
			System.out.println(pair);
			for (int j = 0; j < matrix.length; j++) { // for all rows
				res_m.matrix[j][pair.getPair2()] = target; // at fixed column using getPair2
			}
			for (int k = 0; k < matrix[0].length; k++) { // for all columns
				res_m.matrix[pair.getPair1()][k] = target; // at fixed row using getPair1
			}
		}
		return res_m;
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
	 * Compare two matrices. True if matrices of same dimension and all cells at the
	 * same location are identical.
	 */
	@Override
	public boolean equals(Object matrix2) {
		if (matrix2.getClass() != Matrix.class) { // check class
			return false;
		}
		Matrix m = (Matrix) matrix2; // safely cast
		if (!this.getSize().equals(m.getSize())) {
			return false;
		}
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[0].length; j++) {
				if (this.matrix[i][j] != m.matrix[i][j])
					return false;
			}
		}
		return true;
	}

	/**
	 * Get size of original matrix as a number pair ordered as in (#of rows, #of
	 * column).
	 * 
	 * @return the original matrix size as a number pair of format: (#of rows, #of
	 *         columns)
	 */
	public NumPair getSize() {
		return new NumPair(matrix.length, matrix[0].length);
	}

	/**
	 * Rotate a NxN matrix (where N is odd) 90 degrees clockwise. Method uses an
	 * in-place algorithm to accomplish this task.
	 * 
	 * @see Laakmann McDowell, 2015 Chapter1 for original question.
	 * @author Arian Seyedi
	 * @param m
	 *            matrix to be rotated.
	 */
	public static Matrix rotate90_CW(Matrix m) {
		if (m.getSize().getPair1() != m.getSize().getPair2()) {
			throw new IllegalArgumentException("Not a square Matrix! Matrix must be of size N x N");
		}
		int row = m.getSize().getPair1(), col = m.getSize().getPair2();
		Integer[][] rotated = new Integer[row][col];
		if (m.getSize().getPair1() % 2 != 0) {
			
		}
		return m;
	}

	/**
	 * Find 90degree CW position with respect to Cartesian coordinates centred at
	 * the matrix. Position is a number pair. Method assumes properly sized valid
	 * matrix and an available position as argument.
	 * 
	 * @param pos
	 *            number pair representing position in format: (row, column). The
	 *            total size of matrix must be given to find respective location of
	 *            cell.
	 * @return shifted position, a number pair of format (row, column);
	 */
	private static NumPair get_90rotatedPos(NumPair pos, NumPair size) {
		int center = (int) Math.floor(size.getPair1() / 2); // not ceil: positions are 0-based!
		int x = pos.getPair1(), y = pos.getPair2(); // y -> row, x -> column
		if (x == center && y == center) // at center, no rotation applies
			return NumPair.deepCopy(pos);
		if (y == center) // along x axis
			return new NumPair(pos.getPair2(), pos.getPair1());
		// any other situation below applies
		return new NumPair(pos.getPair2(), center * 2 - pos.getPair1());
	}

	/**
	 * Swaps values at two locations i and j
	 * 
	 * @param i
	 *            a number pair stating the location of the first number in matrix
	 * @param j
	 *            a number pair stating the location of the second number in matrix.
	 */
	public static void swapVal(Matrix m, NumPair i, NumPair j) {
		int row1 = i.getPair1(), col1 = i.getPair2();
		int row2 = j.getPair1(), col2 = j.getPair2();
		Integer temp = m.matrix[row1][col1].intValue(); // deep copy
		m.matrix[row1][col1] = m.matrix[row2][col2];
		m.matrix[row2][col2] = temp;
	}

	/**
	 * Shows a matrix in the terminal.
	 * 
	 * @param matrix
	 *            input matrix to show.
	 */
	public static void show(Matrix m) {
		System.out.println("\n");
		for (int i = 0; i < m.matrix.length; i++) {
			for (int j = 0; j < m.matrix[0].length; j++) {
				System.out.print(m.matrix[i][j]);
				if (j < m.matrix[0].length - 1)
					System.out.print(" , ");
			}
			System.out.println();
		}

	}

	/**
	 * Show the available position within a Matrix object.
	 */
	public void showPositions() {
		System.out.println("\n");
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[0].length; j++) {
				System.out.print("(" + i + " , " + j + ")");
				if (j < this.matrix[0].length - 1)
					System.out.print(" ");
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		// quick test
		Integer[][] da = { { 5, 8, 3, 2, 0, 1},  { 5, 8, 3, 2, 0, 1},  { 5, 8, 3, 2, 0, 1},  { 5, 8, 3, 2, 0, 1},
				 { 5, 8, 3, 2, 0, 1},  { 5, 8, 3, 2, 0, 1}};
		Integer[][] da2 = { { 5, 8, 3, 2, 0},  { 5, 8, 3, 2,1},  { 5, 8, 3, 0, 1},  { 8, 3, 2, 0, 1},
				 { 5, 3, 2, 0, 1}};
		Matrix ma = new Matrix(da);
		Matrix ma2 = new Matrix(da2);
//		show(ma2);
		ma.showPositions();
		ma2.showPositions();

	}
}
