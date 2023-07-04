package assignment7_july3;

import java.util.Stack;

/*
💡 **Question 7**
Given two strings s and t, return true *if they are equal when both are typed into empty text editors*. '#' means a backspace character.
Note that after backspacing an empty text, the text will continue empty.
**Example 1:**
**Input:** s = "ab#c", t = "ad#c"
**Output:** true
**Explanation:**
Both s and t become "ac".
*/
public class Q7 {
	public static void main(String[] args) {
		String s = "ab#c";
		String t = "ad#c";
		boolean isEqual = backspaceCompare(s, t);
		System.out.println(isEqual);
	}

	private static boolean backspaceCompare(String s, String t) {
		return buildString(s).equals(buildString(t));
	}

	private static String buildString(String str) {
		Stack<Character> stack = new Stack<>(); // Stack to store characters

		for (char ch : str.toCharArray()) {
			if (ch != '#') {
				stack.push(ch);
				// If the current character is not a backspace, push it onto the stack
			} else if (!stack.isEmpty()) {
				stack.pop();
				// If the current character is a backspace and the stack is not empty, pop an
				// element from the stack
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop()); // Build the final string by appending characters from the stack
		}

		return sb.toString(); // Return the built string
	}
}
