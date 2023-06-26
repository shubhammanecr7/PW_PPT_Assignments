package assignment4_june29;

import java.util.ArrayList;
import java.util.HashSet;

/*
💡 **Question 1**
Given three integer arrays arr1, arr2 and arr3 **sorted** in **strictly increasing** order, 
return a sorted array of **only** the integers that appeared in **all** three arrays.
**Example 1:**
Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]
**Explanation:** Only 1 and 5 appeared in the three arrays.
*/
public class Q1 {
	public static void main(String[] args) {
		int[] a1 = { 1, 2, 3, 4, 5 };
		int[] a2 = { 1, 2, 5, 7, 9 };
		int[] a3 = { 1, 3, 4, 5, 8 };

		findMatching(a1, a2, a3);
	}

	private static void findMatching(int[] a1, int[] a2, int[] a3) {
		ArrayList<Integer> al = new ArrayList<>();
		HashSet<Integer> set1 = new HashSet<>(); // for storing a1 elements
		HashSet<Integer> set2 = new HashSet<>(); // for storing a2 elements

		for (int n : a1)
			set1.add(n);

		for (int n : a2)
			set2.add(n);

		// checking if elements in a3 are present in set 1&2
		for (int n : a3)
			if (set1.contains(n) && set2.contains(n))
				al.add(n);

		System.out.println(al);
	}
}
