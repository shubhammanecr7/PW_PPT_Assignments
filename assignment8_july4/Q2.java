package assignment8_july4;

import java.util.Stack;

/*
💡 **Question 2**
Given a string s containing only three types of characters: '(', ')' and '*', return true 
*if* s *is **valid***.
The following rules define a **valid** string:
- Any left parenthesis '(' must have a corresponding right parenthesis ')'.
- Any right parenthesis ')' must have a corresponding left parenthesis '('.
- Left parenthesis '(' must go before the corresponding right parenthesis ')'.
- '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or 
an empty string "".
**Example 1:**
**Input:** s = "()"
**Output:**
true
*/
public class Q2 {
	public static void main(String[] args) {
		String s = "()";
		boolean isValid = checkValidString(s);
		System.out.println(isValid);
	}

	private static boolean checkValidString(String s) {
		Stack<Integer> stack = new Stack<>();
		// Stack to store indices of opening parentheses and wildcards

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch == '(') {
				stack.push(i);
			} else if (ch == ')') {
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					return false; // Invalid: No corresponding opening parenthesis or wildcard
				}
			}
		}

		// Check remaining wildcards
		while (!stack.isEmpty()) {
			int wildcardIndex = stack.pop();
			if (wildcardIndex > s.length() - stack.size()) {
				return false;
				// Invalid: Wildcard is at the end, cannot be treated as an opening parenthesis
			}
		}

		return true; // Valid: All opening parentheses have corresponding closing parentheses
	}
}
