package assignment4_june29;

/*
💡 **Question 7**
You are given an m x n matrix M initialized with all 0's and an array of operations ops, 
where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.
Count and return *the number of maximum integers in the matrix after performing all the operations*
**Input:** m = 3, n = 3, ops = [[2,2],[3,3]]
**Output:** 4
**Explanation:** The maximum integer in M is 2, and there are four of it in M. So return 4.
*/
public class Q7 {
	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		int[][] ops = { { 2, 2 }, { 3, 3 } };

		int maxIntegers = maxCount(m, n, ops);

		System.out.println("Output : " + maxIntegers);
	}

	private static int maxCount(int m, int n, int[][] ops) {
		int minRow = m;
		int minCol = n;

		for (int[] op : ops) {
			minRow = Math.min(minRow, op[0]);
			minCol = Math.min(minCol, op[1]);
		}

		return minRow * minCol;
	}
}