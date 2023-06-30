package assignment5_june30;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
💡 **Question 4**
Given two **0-indexed** integer arrays nums1 and nums2, return *a list* answer *of size* 2 *where:*
- answer[0] *is a list of all **distinct** integers in* nums1 *which are **not** present in* nums2*.*
- answer[1] *is a list of all **distinct** integers in* nums2 *which are **not** present in* nums1.
**Note** that the integers in the lists may be returned in **any** order.
**Example 1:**
**Input:** nums1 = [1,2,3], nums2 = [2,4,6]
**Output:** [[1,3],[4,6]]
**Explanation:**
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
*/
public class Q4 {
	public static void main(String[] args) {
		int nums1[] = { 1, 2, 3 };
		int nums2[] = { 2, 4, 6 };

		List<List<Integer>> answer = findDistinct(nums1, nums2);
		System.out.println(answer);
	}

	private static List<List<Integer>> findDistinct(int[] nums1, int[] nums2) {
		HashSet<Integer> s1 = new HashSet<>();
		HashSet<Integer> s2 = new HashSet<>();

		// add nums1 elements to set1
		for (int n : nums1)
			s1.add(n);
		// add nums2 elements to set2
		for (int n : nums2)
			s2.add(n);

		List<Integer> distinctList1 = new ArrayList<>();
		List<Integer> distinctList2 = new ArrayList<>();

		// if elements present in set1 are not there in set2
		// we add them in disrinctlist1
		for (int n : s1)
			if (!s2.contains(n))
				distinctList1.add(n);

		// we do the same for set2 also
		for (int n : s2)
			if (!s1.contains(n))
				distinctList2.add(n);

		List<List<Integer>> answer = new ArrayList<>();
		answer.add(distinctList1);
		answer.add(distinctList2);

		return answer;
	}
}