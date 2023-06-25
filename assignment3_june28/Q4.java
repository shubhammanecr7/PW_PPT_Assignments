package assignment3_june28;

/*Question 4
Given a sorted array of distinct integers and a target value, return the index if the
target is found. If not, return the index where it would be if it were inserted in
order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2*/
public class Q4 {
	public static void main(String[] args) {
		int nums[] = { 1, 3, 5, 6 };
		int target = 5;

		int targetIndex = doBinarySearch(nums, target);
		System.out.println(targetIndex);
	}

	private static int doBinarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (target == nums[mid])
				return mid;
			else if (target < nums[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return left;
	}
}
