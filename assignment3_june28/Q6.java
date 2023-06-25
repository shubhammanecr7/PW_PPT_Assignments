package assignment3_june28;

/*Question 6
Given a non-empty array of integers nums, every element appears twice except
for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only
constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1*/
public class Q6 {
	public static void main(String[] args) {
		int nums[] = { 2, 2, 1 };
		int result = findSingleOccurance(nums);
		System.out.println("Output=" + result);
	}

	// here we can use xor operation bcoz if an element xored with itself gives 0
	// so this way we can get single occuring element
	private static int findSingleOccurance(int[] nums) {
		int result = 0;
		for (int num : nums)
			result ^= num;

		return result;
	}
}