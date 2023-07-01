package assignment6_july1;

import java.util.HashMap;
import java.util.Map;

/*
💡 **Question 4**
Given a binary array nums, return *the maximum length of a contiguous subarray with an equal number 
of* 0 *and* 1.
**Example 1:**
**Input:** nums = [0,1]
**Output:** 2
**Explanation:**
[0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
*/
public class Q4 {
	public static void main(String[] args) {
		int[] nums = { 0, 1 };
		int maxLen = findMaxLength(nums);
		System.out.println(maxLen);
	}

	private static int findMaxLength(int[] nums) {
		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		// put default sum as 0 and index -1 in map
		int sum = 0;
		map.put(sum, -1);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				sum += -1; // treate 0 as -1
			else if (nums[i] == 1)
				sum += 1;

			//now we check if sum for current index is present in map or not
			if (map.containsKey(sum)) {
				int index = map.get(sum);

				max = Math.max(max, i - index);
			} else {
				map.put(sum, i);
			}

		}
		return max;
	}
}