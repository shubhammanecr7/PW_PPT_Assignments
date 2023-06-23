package june24Assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
💡 **Q1.** Given an array of integers nums and an integer target, return indices of the two numbers 
such that they add up to target. You may assume that each input would have exactly one solution, and
 you may not use the same element twice.You can return the answer in any order.
**Example:**
Input: nums = [2,7,11,15], target = 9
Output0 [0,1]
**Explanation:** Because nums[0] + nums[1] == 9, we return [0, 1]
*/
public class Q1 {
	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;

		int[] result = findTargetSumIndex1(nums, target);
		System.out.println(Arrays.toString(result));
	}

	// brute force approach
	private static int[] findTargetSumIndex(int[] nums, int target) {
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums[i] + nums[j] == target)
					return new int[] { i, j };
			}
		}
		// if none of elements matching the target sum
		return null;
	}

	// optimized
	private static int[] findTargetSumIndex1(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int remaining = target - nums[i];
			if (map.containsKey(remaining)) {
				return new int[] { map.get(remaining), i };
			}
			map.put(nums[i], i);
		}
		return null;
	}
}
