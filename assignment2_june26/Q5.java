package assignment2_june26;

/*Question 5
Given an integer array nums, find three numbers whose product is maximum and
return the maximum product.
Example 1:
Input: nums = [1,2,3]
Output: 6*/
public class Q5 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };

		int maxProduct = findMaxProduct(nums);
		System.out.println("Maximum product sum : ");
		System.out.println(maxProduct);
	}

	private static int findMaxProduct(int[] nums) {
		int max1 = Integer.MIN_VALUE;
		int max2 = max1;
		int max3 = max2;

		for (int num : nums) {
			if (num > max1) {
				max3 = max2;
				max2 = max1;
				max1 = num;
			} else if (num > max2) {
				max3 = max2;
				max2 = num;
			} else {
				max3 = num;
			}
		}
		return max1*max2*max3;
	}
}
