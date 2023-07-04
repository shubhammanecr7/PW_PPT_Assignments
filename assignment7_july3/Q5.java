package assignment7_july3;

/*
💡 **Question 5**
Given a string s and an integer k, reverse the first k characters for every 2k characters counting
 from the start of the string.
If there are fewer than k characters left, reverse all of them. If there are less than 2k but 
greater than or equal to k characters, then reverse the first k characters and leave the other 
as original.
**Example 1:**
**Input:** s = "abcdefg", k = 2
**Output:**
"bacdfeg"
*/
public class Q5 {
	public static void main(String[] args) {
		String s = "abcdefg";
		int k = 2;
		String reversed = reverseStringChunk(s, k);
		System.out.println(reversed);
	}

	private static String reverseStringChunk(String s, int k) {
		char[] charArray = s.toCharArray();
		int n = charArray.length;

		for (int i = 0; i < n; i += 2 * k) {
			int left = i;
			int right = Math.min(i + k - 1, n - 1);

			while (left < right) {
				char temp = charArray[left];
				charArray[left] = charArray[right];
				charArray[right] = temp;

				left++;
				right--;
			}
		}

		return String.valueOf(charArray);
	}
}
