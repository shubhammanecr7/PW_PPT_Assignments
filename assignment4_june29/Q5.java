package assignment4_june29;

/*
💡 **Question 5**
You have n coins and you want to build a staircase with these coins. The staircase consists of k rows
where the ith row has exactly i coins. The last row of the staircase **may be** incomplete.
Given the integer n, return *the number of **complete rows** of the staircase you will build*.
**Example 1:**
**Input:** n = 5
**Output:** 2
**Explanation:** Because the 3rd row is incomplete, we return 2.
*/
public class Q5 {
	public static void main(String[] args) {
		int n = 5;
		int completeRows = arrangeCoins(n);
		System.out.println("Output : " + completeRows);
	}

	private static int arrangeCoins(int n) {
		int iRow = 1;

		while (n >= iRow) {
			n = n - iRow;
			iRow++;
		}
		return iRow - 1;
	}
}