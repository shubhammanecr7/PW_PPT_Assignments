package assignment6_july1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
💡 **Question 6**
An integer array original is transformed into a **doubled** array changed by appending **twice the
 value** of every element in original, and then randomly **shuffling** the resulting array.
Given an array changed, return original *if* changed *is a **doubled** array. If* changed *is not
 a **doubled** array, return an empty array. The elements in* original *may be returned in **any**
  order*.
**Example 1:**
**Input:** changed = [1,3,4,2,6,8]
**Output:** [1,3,4]
**Explanation:** One possible original array could be [1,3,4]:
- Twice the value of 1 is 1 * 2 = 2.
- Twice the value of 3 is 3 * 2 = 6.
- Twice the value of 4 is 4 * 2 = 8.
Other original arrays could be [4,3,1] or [3,1,4].
*/
public class Q6 {
	public static void main(String[] args) {
		int[] changed = { 1,3,4,2,6,8};

		int[] original = findOriginal(changed);
		System.out.println(Arrays.toString(original));
	}

	private static int[] findOriginal(int[] changed) {
		Arrays.sort(changed);
		int n = changed.length;
		if (n % 2 != 0)
			return new int[0];

		// creation of map for storing count
		Map<Integer, Integer> map = new HashMap<>();

		// count the occurance of each element in changed array
		for (int num : changed)
			map.put(num, map.getOrDefault(num, 0) + 1);
		
		int[] original = new int[n / 2];
		int index = 0;
		
		for (int num : changed) {
			// step1. we check if current num and its double is present in map
			if (map.containsKey(num) && map.containsKey(num * 2))
				// step2. check if count/frequency of current num and it double is > 0
				if (map.get(num) > 0 && map.get(num * 2) > 0) {
					original[index++] = num; // add current num to original array
					map.put(num, map.get(num) - 1); // reduce count of current num by 1
					map.put(num * 2, map.get(num * 2) - 1); // reduce current num double count by 1
				}
		}

		// check if all elements are found
		if (index == n / 2)
			return original;
		else
			return new int[0];
	}
}