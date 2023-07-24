package searchingSortingAssignment;

import java.util.Arrays;

public class Q1 {
	/*
	 * Given a 1-indexed array of integers numbers that are already sorted in
	 * non-decreasing order, find two numbers such that they add up to a specific
	 * target number. Let these two numbers be numbers[index1] and numbers[index2]
	 * where 1 <= index1 < index2 < numbers.length. Return the indices of the two
	 * numbers, index1, and index2, added by one as an integer array [index1,
	 * index2] of length 2. The tests are generated such that there is exactly one
	 * solution. You may not use the same element twice. Your solution must use only
	 * constant extra space.
	 * 
	 * Input: numbers = [2,7,11,15], target = 9 Output: [1,2] Explanation: The sum
	 * of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
	 */

	public static void main(String[] args) {
		int nums[] = { 2, 7, 11, 15 };
		int target = 9;
		int[] result = twoSum(nums, target);
		System.out.println(Arrays.toString(result));
	}

	private static int[] twoSum(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int currentSum = nums[left] + nums[right];

			if (currentSum == target) {
				return new int[] { left + 1, right + 1 }; // Adding 1 to convert from 0-indexed to 1-indexed
			} else if (currentSum < target) {
				left++;
			} else {
				right--;
			}
		}

		// If the loop completes without finding a solution, it means there's no valid
		// pair.
		return new int[] {};
	}
}
