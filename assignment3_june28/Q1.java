package assignment3_june28;

import java.util.Arrays;

/*Question 1
Given an integer array nums of length n and an integer target, find three integers
in nums such that the sum is closest to the target.
Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2

Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/
public class Q1 {
	public static void main(String[] args) {
		int nums[] = { -1, 2, 1, -4 };
		int target = 1;

		int result = findClosestSum(nums, target);
		System.out.println("Closest sum : " + result);
	}

	private static int findClosestSum(int[] nums, int target) {
		Arrays.sort(nums);
		int closestSum = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (Math.abs(sum - target) < Math.abs(closestSum - target))
					closestSum = sum;
				else if (target > sum)
					left++;
				else
					right--;
			}
		}
		return closestSum;
	}
}
