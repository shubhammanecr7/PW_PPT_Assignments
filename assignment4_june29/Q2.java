package assignment4_june29;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
💡 **Question 2**
Given two **0-indexed** integer arrays nums1 and nums2, return *a list* answer *of size* 2 *where:*
- answer[0] *is a list of all **distinct** integers in* nums1 *which are **not** present in* nums2*.*
- answer[1] *is a list of all **distinct** integers in* nums2 *which are **not** present in* nums1.
**Note** that the integers in the lists may be returned in **any** order.
**Example 1:**
**Input:** nums1 = [1,2,3], nums2 = [2,4,6]
**Output:** [[1,3],[4,6]]
**Explanation:**
For nums1, nums1[1] = 2 is present at index 0 of nums2,
whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1,.
 whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
*/
public class Q2 {
	public static void main(String[] args) {
		int nums1[] = { 1, 2, 3 };
		int nums2[] = { 2, 4, 6 };

		List<List<Integer>> answer = findDistinct(nums1, nums2);
		System.out.println("Output : " + answer);
	}

	private static List<List<Integer>> findDistinct(int[] nums1, int[] nums2) {
		Set<Integer> s1 = new HashSet<>();
		Set<Integer> s2 = new HashSet<>();

		for (int n : nums1)
			s1.add(n);
		for (int n : nums2)
			s2.add(n);

		List<Integer> distinctList1 = new ArrayList<>();
		List<Integer> distinctList2 = new ArrayList<>();

		// finding distinct elements in set 1
		for (int n : s1)
			if (!s2.contains(n))
				distinctList1.add(n);

		// finding distinct elements in set 2
		for (int n : s2)
			if (!s1.contains(n))
				distinctList2.add(n);

		// adding distinct elements from set 1&2 at answer[0]&[1] position
		List<List<Integer>> answer = new ArrayList<>();
		answer.add(distinctList1);
		answer.add(distinctList2);

		return answer;
	}
}
