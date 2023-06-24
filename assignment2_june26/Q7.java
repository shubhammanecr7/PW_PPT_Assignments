package assignment2_june26;

/*Question 7 : 
An array is monotonic if it is either monotone increasing or monotone decreasing.
An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is
monotone decreasing if for all i <= j, nums[i] >= nums[j].
Given an integer array nums, return true if the given array is monotonic, or false otherwise.
Example 1:
Input: nums = [1,2,2,3]
Output: true*/
public class Q7 {
	public static void main(String[] args) {
		int nums[] = { 1, 2, 2, 3 };

		System.out.println(checkMonotonic(nums));
	}

	private static boolean checkMonotonic(int[] nums) {
		boolean isIncreasing = true;
		boolean isDecreasing = true;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] > nums[i])
				isDecreasing = false;
			else if (nums[i - 1] < nums[i])
				isIncreasing = false;

			if (!isIncreasing && !isDecreasing)
				break;
		}
		return isIncreasing || isDecreasing;
	}
}