package assignment8_july4;

/*
💡 **Question 3**
Given two strings word1 and word2, return *the minimum number of **steps** required to 
make* word1 *and* word2 *the same*.
In one **step**, you can delete exactly one character in either string.
**Example 1:**
**Input:** word1 = "sea", word2 = "eat"
**Output:** 2
**Explanation:** You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
*/
public class Q3 {
	public static void main(String[] args) {
		String word1 = "sea";
		String word2 = "eat";
		int minSteps = minDistance(word1, word2);
		System.out.println(minSteps);
	}

	public static int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();

		int[][] memo = new int[m + 1][n + 1];
		return helper(word1, word2, 0, 0, memo);
	}

	private static int helper(String word1, String word2, int i, int j, int[][] memo) {
		// Base case: If either word1 or word2 is fully traversed,
		// return the remaining characters count as the minimum steps
		if (i == word1.length() || j == word2.length()) {
			return word1.length() - i + word2.length() - j;
		}

		// If the result for the current positions is already computed,
		// return it from the memoization table
		if (memo[i][j] > 0) {
			return memo[i][j];
		}

		int result;
		if (word1.charAt(i) == word2.charAt(j)) {
			// Characters at current positions are equal,
			// move to the next positions without incrementing step count
			result = helper(word1, word2, i + 1, j + 1, memo);
		} else {
			// Characters at current positions are not equal,
			// explore two options: delete from word1 or delete from word2
			int delete1 = helper(word1, word2, i + 1, j, memo) + 1;
			int delete2 = helper(word1, word2, i, j + 1, memo) + 1;
			result = Math.min(delete1, delete2);
		}

		// Store the result in the memoization table for future use
		memo[i][j] = result;
		return result;
	}
}
