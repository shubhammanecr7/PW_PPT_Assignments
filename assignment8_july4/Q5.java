package assignment8_july4;

/*
💡 **Question 5**
Given an array of characters chars, compress it using the following algorithm:
Begin with an empty string s. For each group of **consecutive repeating characters** in chars:
- If the group's length is 1, append the character to s.
- Otherwise, append the character followed by the group's length.
The compressed string s **should not be returned separately**, but instead, be stored **in the input character array chars**. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
After you are done **modifying the input array,** return *the new length of the array*.
You must write an algorithm that uses only constant extra space.
**Example 1:**
**Input:** chars = ["a","a","b","b","c","c","c"]
**Output:** Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
**Explanation:**
The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
*/
public class Q5 {
	public static void main(String[] args) {
		char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		int newLength = compress(chars);

		System.out.print("New Length: " + newLength + ", Compressed Array: [");
		for (int i = 0; i < newLength; i++) {
			System.out.print("\"" + chars[i] + "\"");
			if (i < newLength - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

	private static int compress(char[] chars) {
		int n = chars.length; // Length of the original array
		int compressedIndex = 0; // Index for updating the compressed array
		int count = 1; // Count of consecutive repeating characters

		for (int i = 1; i <= n; i++) {
			// Check if the current character is the same as the previous one
			if (i < n && chars[i] == chars[i - 1]) {
				count++;
			} else {
				// Update the compressed array with the character and its count
				chars[compressedIndex++] = chars[i - 1];

				if (count > 1) {
					// If the count is greater than 1, convert it to a string and update the
					// compressed array
					String countStr = String.valueOf(count);
					for (char c : countStr.toCharArray()) {
						chars[compressedIndex++] = c;
					}
				}

				count = 1; // Reset the count for the next group
			}
		}

		return compressedIndex; // Return the new length of the compressed array
	}
}
