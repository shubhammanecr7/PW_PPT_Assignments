package assignment3_june28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Question 2
Given an array nums of n integers, return an array of all the unique quadruplets
[nums[a], nums[b], nums[c], nums[d]] such that:
           ● 0 <= a, b, c, d < n
           ● a, b, c, and d are distinct.
           ● nums[a] + nums[b] + nums[c] + nums[d] == target

You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]*/
public class Q2 {
	public static void main(String[] args) {
		int nums[] = { 1, 0, -1, 0, -2, 2 };
		int target = 0;

		List<List<Integer>> result = findUniqueQudruplets(nums, target);
		System.out.println(result);
	}

	private static List<List<Integer>> findUniqueQudruplets(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) { // i-1st pointer
			if (i > 0 && nums[i] == nums[i - 1])
				continue; // skip duplicates
			for (int j = i + 1; j < nums.length - 2; j++) { // j-2nd pointer
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue; // skip duplicates

				int left = j + 1; // 3rd pointer
				int right = nums.length - 1; // 4th pointer

				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];

					if (sum == target) {
						ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

						while (left < right && nums[left] == nums[left + 1])
							continue; // skip duplicates
						while (left < right && nums[right] == nums[right - 1])
							continue; // skip duplicates

						left++;
						right--;
					} else if (sum < target)
						left++;
					else
						right--;
				}
			}
		}
		// return the answer list back
		return ans;
	}
}