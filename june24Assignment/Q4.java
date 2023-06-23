package june24Assignment;

import java.util.Arrays;

/*
💡 You are given a large integer represented as an integer array digits, where each digits[i] is the 
ith digit of the integer. The digits are ordered from most significant to least significant 
in left-to-right order. The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.
**Example 1:**
Input: digits = [1,2,3]
Output: [1,2,4]
**Explanation:** The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
*/
public class Q4 {
	public static void main(String[] args) {
		int nums[] = { 1, 2, 9 };

		int result[] = incrementByOne(nums);
		System.out.println(Arrays.toString(result));
	}

	private static int[] incrementByOne(int[] nums) {
		int n = nums.length - 1;
		for (int i = n; i >= 0; i--) {
			// increment last digit by 1
			nums[i] += 1;

			// if digit becomes 10 make it zero and go for next iteration
			if (nums[i] == 10)
				nums[i] = 0;
			else
				return nums;
		}

		// if all the digits becomes zero then we create new array with new increased
		// size, for example if nums is 9 9 9, if we add 1 , it becomes 1 0 0 0
		int result[] = new int[n + 1];
		result[0] = 1;
		return result;
	}
}