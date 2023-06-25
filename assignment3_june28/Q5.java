package assignment3_june28;

import java.util.Arrays;

/*
💡 **Question 5**
You are given a large integer represented as an integer array digits, where each
digits[i] is the ith digit of the integer. The digits are ordered from most significant
to least significant in left-to-right order. The large integer does not contain any
leading 0's.

Increment the large integer by one and return the resulting array of digits.

**Example 1:**
Input: digits = [1,2,3]
Output: [1,2,4]

**Explanation:** The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
*/
public class Q5 {
	public static void main(String[] args) {
		int nums[] = { 1,2,3 };
		nums = incrementByOne(nums);
		System.out.println("output=" + Arrays.toString(nums));
	}

	private static int[] incrementByOne(int[] nums) {
		int carry = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			nums[i] += 1;
			if (nums[i] > 9) {
				carry = nums[i] / 10; // to store carry if occures
				nums[i] = 0;
			} else {
				break;
			}
		}
		// to handle carry - create new array with new size to fit extra element
		if (carry > 0) {
			int result[] = new int[nums.length + 1];
			result[0] = 1;
			nums = result;
		}
		return nums; // return the modified array
	}
}
