package assignment4_june29;

import java.util.Arrays;

/*
💡 **Question 3**
Given a 2D integer array matrix, return *the **transpose** of* matrix.
The **transpose** of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
**Example 1:**
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
*/
public class Q3 {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int transpose[][] = transposeMatrix(matrix);
		System.out.println(Arrays.deepToString(transpose));
	}

	private static int[][] transposeMatrix(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;

		int[][] transpose = new int[col][row];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				transpose[j][i] = matrix[i][j];
			}
		}
		return transpose;
	}
}