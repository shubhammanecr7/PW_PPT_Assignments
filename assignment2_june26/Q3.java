package assignment2_june26;

import java.util.HashMap;
import java.util.Map;

/*Question 3
We define a harmonious array as an array where the difference between its maximum value
and its minimum value is exactly 1.
Given an integer array nums, return the length of its longest harmonious subsequence
among all its possible subsequences.
A subsequence of an array is a sequence that can be derived from the array by deleting some or 
no elements without changing the order of the remaining elements.
Example 1:
Input: nums = [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].*/
public class Q3 {
	public static void main(String[] args) {
		int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };

		int count = findLHS(nums);
		System.out.println("LHS : " + count);
	}

	private static int findLHS(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		// we put all the numbers into map to get frequency of each element
		for (int num : nums)
			map.put(num, map.getOrDefault(num, 0) + 1);

		int count = 0; // to put total count of k and k+1 elements

		for (int key : map.keySet())
			if (map.containsKey(key + 1))
				count = Math.max(count, map.get(key) + map.get(key + 1));
		
		return count;
	}
}
