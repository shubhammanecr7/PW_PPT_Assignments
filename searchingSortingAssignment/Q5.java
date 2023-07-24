package searchingSortingAssignment;

public class Q5 {
	/*
	 * Find the majority element in the array. A majority element in an array A[] of
	 * size n is an element that appears more than n/2 times (and hence there is at
	 * most one such element). Input: A[]={3, 3, 4, 2, 4, 4, 2, 4, 4} Output: 4
	 * Explanation: The frequency of 4 is 5 which is greater than half of the size
	 * of the array size.
	 */

	public static void main(String[] args) {
		int[] nums = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
		int majorityElement = findMajorityElement(nums);
		System.out.println(majorityElement);
	}

	private static int findMajorityElement(int[] nums) {
		int majorityElement = nums[0]; // Assume the first element as the potential majority element
		int count = 1; // Initialize the count of potential majority element to 1

		// Iterate through the array from the second element onwards
		for (int i = 1; i < nums.length; i++) {
			// If the current element is the same as the potential majority element,
			// increment the count
			if (nums[i] == majorityElement) {
				count++;
			} else {
				// If the current element is different, decrement the count
				count--;

				// If the count becomes 0, update the potential majority element to the current
				// element
				if (count == 0) {
					majorityElement = nums[i];
					count = 1;
				}
			}
		}

		return majorityElement;
	}
}
