package DivideAndConquer;

public class Search2DMatrixII {

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		return divideAndConquer(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
	}

	private static boolean divideAndConquer(int[][] matrix, int target, int rowStart, int colStart, int rowEnd, int colEnd) {
		// Base case: Search space is exhausted
		if (rowStart > rowEnd || colStart > colEnd) {
			return false;
		}

		// Calculate middle indices to find the center element
		int midRow = (rowStart + rowEnd) / 2;
		int midCol = (colStart + colEnd) / 2;
		int midElement = matrix[midRow][midCol];

		if (midElement == target) {
			return true;
		}

		if (midElement > target) {
			/*
			 * Case A: midElement is too large. The target CANNOT be in the Bottom-Right
			 * quadrant. We must search: 1. Top-Left quadrant 2. Top-Right quadrant 3.
			 * Bottom-Left quadrant (excluding the Bottom-Right part)
			 */
			return divideAndConquer(matrix, target, rowStart, colStart, midRow - 1, colEnd) || // Top Half
					divideAndConquer(matrix, target, midRow, colStart, rowEnd, midCol - 1); // Bottom Left
		} else {
			/*
			 * Case B: midElement is too small. The target CANNOT be in the Top-Left
			 * quadrant. We must search: 1. Bottom-Right quadrant 2. Top-Right quadrant 3.
			 * Bottom-Left quadrant (excluding the Top-Left part)
			 */
			return divideAndConquer(matrix, target, midRow + 1, colStart, rowEnd, colEnd) || // Bottom Half
					divideAndConquer(matrix, target, rowStart, midCol + 1, midRow, colEnd); // Top Right
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 4, 7, 11, 15 }, 
				{ 2, 5, 8, 12, 19 }, 
				{ 3, 6, 9, 16, 22 }, 
				{ 10, 13, 14, 17, 24 } };
		
		System.out.println(searchMatrix(matrix, 5));

	}
}