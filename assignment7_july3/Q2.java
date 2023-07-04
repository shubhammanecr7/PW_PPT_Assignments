package assignment7_july3;

/*
💡 **Question 2**
Given a string num which represents an integer, return true *if* num *is a **strobogrammatic number***.
A **strobogrammatic number** is a number that looks the same when rotated 180 degrees 
(looked at upside down).
**Example 1:**
**Input:** num = "69"
**Output:**
true
*/
public class Q2 {
	public static void main(String[] args) {
		String num = "69";
		boolean isStrobogrammatic = isStrobogrammatic(num);
		System.out.println(isStrobogrammatic);
	}

	private static boolean isStrobogrammatic(String num) {

		int left = 0;
		int right = num.length() - 1;

		while (left <= right) {
			char c1 = num.charAt(left);
			char c2 = num.charAt(right);

			if (!isStrobogrammaticPair(c1, c2)) {
				return false; // If the pair of characters is not strobogrammatic, return false
			}

			left++;
			right--;
		}

		return true; // All characters in the number are strobogrammatic pairs

	}

	private static boolean isStrobogrammaticPair(char c1, char c2) {
		// Define the valid strobogrammatic pairs
		if ((c1 == '0' && c2 == '0') ||
			(c1 == '1' && c2 == '1') || 
			(c1 == '6' && c2 == '9') || 
			(c1 == '8' && c2 == '8') || 
			(c1 == '9' && c2 == '6')) {
				return true;
		}

		return false;
	}
}
