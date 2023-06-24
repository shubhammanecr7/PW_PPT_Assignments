package assignment2_june26;

import dsaStart17april.BinarySearch;

/*Question 6
Given an array of integers nums which is sorted in ascending order, and an integer target,
write a function to search target in nums. If target exists, then return its index. Otherwise,
return -1.
You must write an algorithm with O(log n) runtime complexity.
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4*/
public class Q6 {
	public static void main(String[] args) {

		int nums[] = { -1, 0, 3, 5, 9, 12 };
		int target = 9;
		int targetIndex = doBinarySearch(nums, target);
		System.out.println(targetIndex);
	}

	private static int doBinarySearch(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			else if (target < nums[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}
}