package assignment6_july1;

/*
💡 **Question 2**
You are given an m x n integer matrix matrix with the following two properties:
- Each row is sorted in non-decreasing order.
- The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true *if* target *is in* matrix *or* false *otherwise*.
You must write a solution in O(log(m * n)) time complexity.
**Example 1:**
**Input:** matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
**Output:** true*/
public class Q2 {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int target = 3;

		boolean result = findTarget(matrix, target);
		System.out.println(result);
	}

	private static boolean findTarget(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;

		int low = 0;
		int high = m * n - 1;

		// declaration of required variables
		int midIndex, rowIndex, colIndex, midElement;

		while (low < high) {
			midIndex = low + (high - low) / 2;
			rowIndex = midIndex / n;
			colIndex = midIndex % n;
			// now we can get element at mid point using row&col index
			midElement = matrix[rowIndex][colIndex];

			if (midElement == target) {
				return true;
			} else if (target > midElement) {
				low = midIndex + 1;
			} else {
				high = midIndex + 1;
			}
		}

		return false;
	}
}