package assignment8_july4;

import java.util.Stack;

/*
💡 **Question 7**
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is 
being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square 
brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain 
any digits and that digits are only for those repeat numbers, k. For example, there will not be 
input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 105.
**Example 1:**
**Input:** s = "3[a]2[bc]"
**Output:** "aaabcbc"
*/
public class Q7 {
	public static void main(String[] args) {
		String s = "3[a]2[bc]";
		String decodedString = decodeString(s);
		System.out.println(decodedString);
	}

	private static String decodeString(String s) {
		// Stack to store the repetition counts
		Stack<Integer> countStack = new Stack<>();
		// Stack to store the intermediate decoded strings
		Stack<StringBuilder> stringStack = new Stack<>();
		// Current decoded string
		StringBuilder currentString = new StringBuilder();
		// Current repetition count
		int currentCount = 0;

		// Iterate through each character in the input string
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				// If the character is a digit, update the current repetition count
				currentCount = currentCount * 10 + (ch - '0');
			} else if (ch == '[') {
				// If an opening bracket is encountered, push the current repetition count
				// and the current decoded string onto their respective stacks
				countStack.push(currentCount);
				stringStack.push(currentString);
				// Reset the repetition count and the current decoded string
				currentCount = 0;
				currentString = new StringBuilder();
			} else if (ch == ']') {
				// If a closing bracket is encountered, pop the previous repetition count
				// and decoded string from the stacks
				StringBuilder decodedString = stringStack.pop();
				int repeatCount = countStack.pop();
				// Append the current decoded string to the popped decoded string for the
				// specified number of repetitions
				for (int i = 0; i < repeatCount; i++) {
					decodedString.append(currentString);
				}
				// Update the current decoded string
				currentString = decodedString;
			} else {
				// If the character is not a digit or bracket, append it to the current decoded
				// string
				currentString.append(ch);
			}
		}

		// Return the final decoded string
		return currentString.toString();
	}
}
