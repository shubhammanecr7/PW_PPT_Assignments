package june24Assignment;

import java.util.HashSet;

//💡 **Q6.** Given an integer array nums, return true if any value appears at least twice in the array,
// and return false if every element is distinct.
// **Example 1:**
// Input: nums = [1,2,3,1]
// Output: true

public class Q6 {
	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 1 };

		boolean result = checkOccurance(nums);
		System.out.println(result);
	}

	private static boolean checkOccurance(int[] nums) {
		HashSet<Integer> set = new HashSet<>();

		for (int value : nums) {
			if (set.contains(value))
				return true;
			else
				set.add(value);
		}
		return false;
	}
}