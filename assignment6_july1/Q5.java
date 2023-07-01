package assignment6_july1;

import java.util.Arrays;

/*
💡 **Question 5**
The **product sum** of two equal-length arrays a and b is equal to the sum of a[i] * b[i] 
for all 0 <= i < a.length (**0-indexed**).
- For example, if a = [1,2,3,4] and b = [5,2,3,1], the **product sum** would be
 1*5 + 2*2 + 3*3 + 4*1 = 22.
Given two arrays nums1 and nums2 of length n, return *the **minimum product sum** 
if you are allowed to **rearrange** the **order** of the elements in* nums1.

**Example 1:**
**Input:** nums1 = [5,3,4,2], nums2 = [4,2,2,5]
**Output:** 40
**Explanation:**
We can rearrange nums1 to become [3,5,4,2]. The product sum of [3,5,4,2] and [4,2,2,5] is
 3*4 + 5*2 + 4*2 + 2*5 = 40.
*/
public class Q5 {
	public static void main(String[] args) {
		int[] nums1 = { 5, 3, 4, 2 };
		int[] nums2 = { 4, 2, 2, 5 };
		int minProductSum = findMinProductSum(nums1, nums2);
		System.out.println(minProductSum);
	}

	private static int findMinProductSum(int[] nums1, int[] nums2) {
		//we sort the both arrays
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int minSum = 0;
		for (int i = 0; i < nums1.length; i++) {
			minSum += nums1[i] * nums2[nums2.length - 1 - i];
		}
		return minSum;
	}
}
