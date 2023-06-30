package assignment5_june30;

import java.util.HashMap;
import java.util.Map;

/*
💡 **Question 8**
An integer array original is transformed into a **doubled** array changed by appending **twice 
the value** of every element in original, and then randomly **shuffling** the resulting array.
Given an array changed, return original *if* changed *is a **doubled** array. If* changed *is 
not a **doubled** array, return an empty array. The elements in* original *may be returned in 
**any** order*.
**Example 1:**
**Input:** changed = [1,3,4,2,6,8]
**Output:** [1,3,4]
**Explanation:** One possible original array could be [1,3,4]:
- Twice the value of 1 is 1 * 2 = 2.
- Twice the value of 3 is 3 * 2 = 6.
- Twice the value of 4 is 4 * 2 = 8.
Other original arrays could be [4,3,1] or [3,1,4].
*/
public class Q8 {
	public static void main(String[] args) {
		int[] changed = { 1, 3, 4, 2, 6, 8 };

		int[] originalArray = findOriginalArray(changed);
		System.out.println(originalArray);
	}

	public static int[] findOriginalArray(int[] changed) {
		// Check if the length of the changed array is odd
		if (changed.length % 2 != 0) {
			return new int[0]; // If it is odd, return an empty array
		}

		// Map to keep track of the count of each number in the changed array
		Map<Integer, Integer> countMap = new HashMap<>();

		// Count the occurrences of each number in the changed array
		for (int num : changed) {
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		}

		// Create an array to store the original array
		int[] original = new int[changed.length / 2];
		int index = 0; // Index to track the position in the original array

		// Iterate over the changed array
		for (int num : changed) {
			// Check if the count of the current number is zero
			if (countMap.getOrDefault(num, 0) == 0) {
				continue; // If count is zero, skip to the next iteration
			}

			// Calculate the doubled value of the current number
			int doubledNum = num * 2;

			// Check if the doubled value is present and its count is zero
			if (countMap.getOrDefault(doubledNum, 0) == 0) {
				return new int[0]; // If doubled value is not present or count is zero, return an empty array
			}

			// Add the current number to the original array
			original[index++] = num;

			// Decrease the count of the current number and its doubled value in the
			// countMap
			countMap.put(num, countMap.get(num) - 1);
			countMap.put(doubledNum, countMap.get(doubledNum) - 1);
		}

		return original; // Return the original array
	}
}