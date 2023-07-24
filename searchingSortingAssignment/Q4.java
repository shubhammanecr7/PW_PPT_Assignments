package searchingSortingAssignment;

public class Q4 {
	/*
	 * Given a sorted array of distinct integers and a target value, return the
	 * index if the target is found. If not, return the index where it would be if
	 * it were inserted in order. You must write an algorithm with O(log n) runtime
	 * complexity. Input: nums = [1,3,5,6], target = 5 Output: 2
	 * 
	 * Input: nums = [1,3,5,6], target = 7 Output: 4
	 */

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		int target = 5;

		int result = searchInsert(nums, target);

		System.out.println(result);
	}

	private static int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		// If the loop completes without finding the target, left points to the index
		// where the target should be inserted to maintain the sorted order.
		return left;
	}
}
