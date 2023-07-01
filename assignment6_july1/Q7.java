package assignment6_july1;

import java.util.Arrays;

/*
💡 **Question 7**
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
**Example 1:**
**Input:** n = 3
**Output:** [[1,2,3],[8,9,4],[7,6,5]]*/
public class Q7 {
	public static void main(String[] args) {
		int n = 3;
		int[][] spiral = generateSpiral(n);
		for (int[] row : spiral) {
			System.out.println(Arrays.toString(row) + "\n");
		}
	}

	private static int[][] generateSpiral(int n) {
		int r1 = 0, r2 = n - 1;
		int c1 = 0, c2 = n - 1;

		int[][] a = new int[n][n];
		int val = 1;

		while (r1 <= r2 && c1 <= c2) {

			// moving from left to right
			for (int c = c1; c <= c2; c++)
				a[r1][c] = val++;

			// move down
			for (int r = r1 + 1; r <= r2; r++)
				a[r][c2] = val++;

			// now we check again if r1 and c1 are within range or not
			if (r1 < r2 && c1 < c2) {
				// move from right to left
				for (int c = c2 - 1; c > c1; c--)
					a[r2][c] = val++;

				// move up
				for (int r = r2; r > r1; r--)
					a[r][c1] = val++;
			}
			r1++;
			c1++;
			r2--;
			c2--;
		}
		return a;
	}
}