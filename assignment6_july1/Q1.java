package assignment6_july1;

import java.util.Arrays;

/*
💡 **Question 1**
A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented 
as a string s of length n where:
- s[i] == 'I' if perm[i] < perm[i + 1], and
- s[i] == 'D' if perm[i] > perm[i + 1].
Given a string s, reconstruct the permutation perm and return it. If there are multiple valid
 permutations perm, return **any of them**.
**Example 1:**
**Input:** s = "IDID"
**Output:**
[0,4,1,3,2]
*/
public class Q1 {
	public static void main(String[] args) {
		String s = "IDID";
		int[] perm = findPermutations(s);
		System.out.println(Arrays.toString(perm));
	}

	private static int[] findPermutations(String s) {
		int n = s.length();

		// new result storing array using string length
		int[] perm = new int[n + 1];

		int start = 0;
		int end = n;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'I') {
				perm[i] = start++;
			} else {
				perm[i] = end--;
			}
		}
		
		//at last position we put the current value of start
		perm[n]= start; 

		return perm;
	}
}
