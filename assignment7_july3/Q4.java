package assignment7_july3;

/*
💡 **Question 4**
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
**Example 1:**
**Input:** s = "Let's take LeetCode contest"
**Output:** "s'teL ekat edoCteeL tsetnoc"
*/
public class Q4 {
	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		String reversed = reverseWords(s);
		System.out.println(reversed);
	}

	private static String reverseWords(String s) {
		String[] words = s.split(" "); // Split the sentence into individual words
		StringBuilder result = new StringBuilder();

		for (String word : words) {
			StringBuilder reversedWord = new StringBuilder(word);
			reversedWord.reverse(); // Reverse each word

			result.append(reversedWord).append(" "); // Append the reversed word with a whitespace
		}

		result.setLength(result.length() - 1); // Remove the trailing whitespace

		return result.toString();
	}

}
