package june24Assignment;

import java.util.Arrays;

/*
💡 **Q7.** Given an integer array nums, move all 0's to the end of it while maintaining the relative
 order of the nonzero elements. Note that you must do this in-place without making a copy of the array.
**Example 1:**
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
*/
public class Q7 {
	public static void main(String[] args) {
		int nums[] = { 0, 1, 0, 3, 12 };
		moveZerosToEnd(nums);
		System.out.println(Arrays.toString(nums));
	}

	private static void moveZerosToEnd(int[] nums) {
		int pointer = 0;
		// using pointer we move all the non-zero elements to front side
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[pointer++] = nums[i];
			}
		}

		// fill remaining positions with zero
		for (int i = pointer; i < nums.length; i++)
			nums[i] = 0;
	}
}