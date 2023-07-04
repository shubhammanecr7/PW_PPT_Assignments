package assignment7_july3;

import java.util.HashMap;
import java.util.Map;

/*
💡 **Question 1**
Given two strings s and t, *determine if they are isomorphic*.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving 
the order of characters. No two characters may map to the same character, but a character 
may map to itself.
**Example 1:**
**Input:** s = "egg", t = "add"
**Output:** true
*/
public class Q1 {
	public static void main(String[] args) {
		String s = "egg";
		String t = "add";
		boolean isIsomorphic = isIsomorphic(s, t);
		System.out.println(isIsomorphic);
	}

	private static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false; // If the lengths of the strings are different, they cannot be isomorphic
		}

		Map<Character, Character> charMap = new HashMap<>(); 
		// Create a map to store character mappings

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			if (charMap.containsKey(c1)) {
				if (charMap.get(c1) != c2) {
					return false; 
					// If the character c1 is already mapped to a different character c2,
					//they are not isomorphic
				}
			} else {
				if (charMap.containsValue(c2)) {
					return false; 
					// If c2 is already mapped to a different character, c1 cannot be mapped to it
				}
				charMap.put(c1, c2); 
				// Add a new character mapping to the map
			}
		}

		return true; 
		// All characters in s and t are successfully mapped without violating the isomorphic condition

	}
}