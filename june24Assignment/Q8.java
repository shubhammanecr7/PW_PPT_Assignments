package june24Assignment;

import java.util.Arrays;
import java.util.HashSet;

/*<aside>
💡 **Q8.** You have a set of integers s, which originally contains all the numbers from 1 to n. 
Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
 which results in repetition of one number and loss of another number.You are given an integer array
  nums representing the data status of this set after the error. Find the number that occurs twice 
  and the number that is missing and return them in the form of an array.
**Example 1:**
Input: nums = [1,2,2,4]
Output: [2,3]
*/
public class Q8 {
	public static void main(String[] args) {
		int nums[] = { 1, 2, 2, 4 };
		int result[] = getRepeatingMissingNumber(nums);
		System.out.println(Arrays.toString(result));
		System.out.println("Duplicate : " + result[0]);
		System.out.println("Missing : " + result[1]);
	}

	private static int[] getRepeatingMissingNumber(int[] nums) {
		int n = nums.length;
		int duplicate = -1;
		int missing = -1;

		HashSet<Integer> set = new HashSet<>();
		// to find repeating number we use hash set
		for (int num : nums)
			if (set.contains(num))
				duplicate = num;
			else
				set.add(num);

		// to find missing number we use simple for loop 1-n
		// because it is given that array contains numbers from 1-n;
		for (int i = 1; i < n; i++)
			// if any element not present it is missing element
			if (!set.contains(i))
				missing = i;

		// we return missing and repeating element in the form of array
		return new int[] { duplicate, missing };
	}
}
