package assignment7_july3;

/*
💡 **Question 6**
Given two strings s and goal, return true *if and only if* s *can become* goal *after some number of **shifts** on* s.
A **shift** on s consists of moving the leftmost character of s to the rightmost position.
- For example, if s = "abcde", then it will be "bcdea" after one shift.
**Example 1:**
**Input:** s = "abcde", goal = "cdeab"
**Output:**
true
*/
public class Q6 {
	public static void main(String[] args) {
		String s = "abcde";
		String goal = "cdeab";
		boolean canShift = canShiftString(s, goal);
		System.out.println(canShift);
	}

	private static boolean canShiftString(String s, String goal) {
		if (s.length() != goal.length()) {
			return false; 
			// If the lengths are different, they cannot be equal after any number of shifts
		}

		String concatenated = s + s; 
		// Concatenate the original string with itself

		return concatenated.contains(goal); // Check if the target string is a substring of the concatenated string

	}
}
