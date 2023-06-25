package assignment3_june28;

import java.util.ArrayList;
import java.util.List;

/*Question 7
You are given an inclusive range [lower, upper] and a sorted unique integer array
nums, where all elements are within the inclusive range.

A number x is considered missing if x is in the range [lower, upper] and x is not in
nums.

Return the shortest sorted list of ranges that exactly covers all the missing
numbers. That is, no element of nums is included in any of the ranges, and each
missing number is covered by one of the ranges.

Example 1:
Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: [[2,2],[4,49],[51,74],[76,99]]

Explanation: The ranges are:
[2,2]
[4,49]
[51,74]
[76,99]*/
public class Q7 {
	public static void main(String[] args) {
		int nums[] = { 0, 1, 3, 50, 75 };
		int lower = 0;
		int upper = 99;

		List<String> result = findMissingRanges(nums, lower, upper);
		System.out.println(result);
	}

	private static List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> ans = new ArrayList<>();

		for (int num : nums) {
			if (num > lower) {
				// if there is a gap between lower and num
				// add range from start to num-1
				ans.add(getRange(lower, num - 1));
			}
			lower = num + 1;
		}

		if (lower <= upper) {
			// if start is within range add range from lower to upper
			ans.add(getRange(lower, upper));
		}

		return ans;
	}

	private static String getRange(int start, int end) {
		if (start == end)
			return String.valueOf(start); // if start and end are same just return that number
		else
			return start + "->" + end;
	}
}