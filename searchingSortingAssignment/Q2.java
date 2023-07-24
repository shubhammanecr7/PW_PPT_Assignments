package searchingSortingAssignment;

import java.util.Arrays;

public class Q2 {
	/*
	 * Given an array of integer nums sorted in non-decreasing order, find the
	 * starting and ending position of a given target value. If the target is not
	 * found in the array, return [-1, -1]. You must write an algorithm with O(log
	 * n) runtime complexity Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4]
	 */

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		int[] result = searchRange(nums, target);
		System.out.println(Arrays.toString(result));
	}

	private static int[] searchRange(int[] nums, int target) {
		int firstOccurrence = findFirstOccurrence(nums, target);
		int lastOccurrence = findLastOccurrence(nums, target);

		return new int[] { firstOccurrence, lastOccurrence };
	}

	private static int findFirstOccurrence(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int result = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] >= target) {
				right = mid - 1;
				if (nums[mid] == target) {
					result = mid;
				}
			} else {
				left = mid + 1;
			}
		}

		return result;
	}

	private static int findLastOccurrence(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int result = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] <= target) {
				left = mid + 1;
				if (nums[mid] == target) {
					result = mid;
				}
			} else {
				right = mid - 1;
			}
		}

		return result;
	}
}
