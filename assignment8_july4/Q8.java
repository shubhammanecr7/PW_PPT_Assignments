package assignment8_july4;

/*
💡 **Question 8**
Given two strings s and goal, return true *if you can swap two letters in* s *so the result is equal
 to* goal*, otherwise, return* false*.*
Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping
 the characters at s[i] and s[j].
- For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
**Example 1:**
**Input:** s = "ab", goal = "ba"
**Output:** true
**Explanation:** You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
*/
public class Q8 {
	public static void main(String[] args) {
		String s = "ab";
		String goal = "ba";
		boolean result = areAlmostEqual(s, goal);
		System.out.println(result);
	}

	private static boolean areAlmostEqual(String s, String goal) {
		int n = s.length();
		int diffCount = 0;
		int[] diffIndices = new int[2];

		// Iterate through each character in s and goal
		for (int i = 0; i < n; i++) {
			char ch1 = s.charAt(i);
			char ch2 = goal.charAt(i);

			// If the characters are different, track the indices and count the differences
			if (ch1 != ch2) {
				if (diffCount == 2) {
					// If there are already two differences, return false
					return false;
				}
				diffIndices[diffCount] = i;
				diffCount++;
			}
		}

		// Check if the differences can be swapped to make s equal to goal
		if (diffCount == 0) {
			// If there are no differences, s and goal are already equal
			return true;
		} else if (diffCount == 2) {
			// If there are exactly two differences, check if swapping them results in s =
			// goal
			char ch1 = s.charAt(diffIndices[0]);
			char ch2 = s.charAt(diffIndices[1]);
			char ch3 = goal.charAt(diffIndices[0]);
			char ch4 = goal.charAt(diffIndices[1]);
			return ch1 == ch4 && ch2 == ch3;
		} else {
			// If there are more than two differences, swapping won't make s equal to goal
			return false;
		}
	}
}
