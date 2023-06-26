package assignment4_june29;

import java.util.Arrays;

/*
💡 **Question 8**
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
*Return the array in the form* [x1,y1,x2,y2,...,xn,yn].
**Example 1:**
**Input:** nums = [2,5,1,3,4,7], n = 3
**Output:** [2,3,5,4,1,7]
**Explanation:** Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
*/
public class Q8 {
	public static void main(String[] args) {
		int[] nums = { 2, 5, 1, 3, 4, 7 };
		int n = 3;

		int[] shuffledArray = shuffleArray(nums, n);

		System.out.println(Arrays.toString(shuffledArray));
	}

	private static int[] shuffleArray(int[] nums, int n) {

		int[] result = new int[2 * n];
		int index = 0; // for inserting alternate elements in result array
		int i = 0; // front pointer
		int j = n; // mid pointer

		// i handles 0,1,2 AND j handles 3,4,5 indexes
		while (i < n && j < 2 * n) {
			// add one element from front
			result[index++] = nums[i++];
			// add one element from middle
			result[index++] = nums[j++];
		}
		return result;
	}
}
