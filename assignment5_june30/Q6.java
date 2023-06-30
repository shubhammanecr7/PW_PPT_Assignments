package assignment5_june30;

import java.util.ArrayList;
import java.util.List;

/*
💡 **Question 6**
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and
 each integer appears **once** or **twice**, return *an array of all the integers that appears 
 **twice***.
You must write an algorithm that runs in O(n) time and uses only constant extra space.
**Example 1:**
**Input:** nums = [4,3,2,7,8,2,3,1]
**Output:**
[2,3]
*/
public class Q6 {
	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> duplicates = findDuplicates(nums);
		System.out.println("Duplicates: " + duplicates);
	}

	private static List<Integer> findDuplicates(int[] nums) {
		List<Integer> duplicates = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1; // Calculate the index based on the element value
			// Check if the value at the calculated index is negative
			// If it is negative, it means the element has appeared before (duplicate)
			// Add the absolute value of the element to the duplicates list
			// Otherwise, mark the value at the index as negative
			if (nums[index] < 0) {
				duplicates.add(Math.abs(nums[i]));
			} else {
				nums[index] = -nums[index];
			}
		}
		return duplicates;
	}
}
// if a integer value in negative Math.abs() function makes it positive.