package assignment8_july4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
💡 **Question 6**
Given two strings s and p, return *an array of all the start indices of* p*'s anagrams in* s. 
You may return the answer in **any order**.
An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase,
 typically using all the original letters exactly once.
**Example 1:**
**Input:** s = "cbaebabacd", p = "abc"
**Output:** [0,6]
**Explanation:**
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
*/
public class Q6 {
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> indices = findAnagrams(s, p);
		System.out.println(indices);
	}

	private static List<Integer> findAnagrams(String s, String p) {
		List<Integer> indices = new ArrayList<>();
		if (s.length() < p.length()) {
			return indices;
		}

		int[] targetFreq = new int[26]; // Frequency map for characters in p
		int[] windowFreq = new int[26]; // Frequency map for characters in the sliding window

		// Calculate the frequency of characters in p
		for (char ch : p.toCharArray()) {
			targetFreq[ch - 'a']++;
		}

		int windowSize = p.length();
		int left = 0;
		int right = 0;

		// Process each window in s
		while (right < s.length()) {
			// Expand the window by adding the character at the right pointer
			char rightChar = s.charAt(right);
			windowFreq[rightChar - 'a']++;

			// Shrink the window if it exceeds the desired size
			if (right - left + 1 > windowSize) {
				char leftChar = s.charAt(left);
				windowFreq[leftChar - 'a']--;
				left++;
			}
			// Compare the frequency maps of the window and target
			if (right - left + 1 == windowSize) {
				if (Arrays.equals(targetFreq, windowFreq)) {
					indices.add(left);
				}
			}
			right++;
		}

		return indices;
	}
}