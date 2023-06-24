package assignment2_june26;

import java.util.Arrays;

/*
💡 **Question 1**
Given an integer array nums of 2n integers, group these integers into n pairs 
(a1, b1), (a2, b2),..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. 
Return the maximized sum.
**Example 1:**
Input: nums = [1,4,3,2]
Output: 4
**Explanation:** All possible pairings (ignoring the ordering of elements) are:
1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
So the maximum possible sum is 4.
*/
public class Q1 {
	public static void main(String[] args) {
		int nums[] = { 1, 4, 3, 2 };
		int maxSum = findMaxSum(nums);
		System.out.println(maxSum);
	}

	private static int findMaxSum(int[] nums) {
		int maxSum = 0;
		Arrays.sort(nums);
		// here we use simple for loop and increment its value by 2
		for (int i = 0; i < nums.length; i += 2) {
			maxSum += Math.min(nums[i], nums[i + 1]);
		}
		return maxSum;
	}
}