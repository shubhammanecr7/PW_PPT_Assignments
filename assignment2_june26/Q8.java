package assignment2_june26;

/*Question 8
You are given an integer array nums and an integer k.
In one operation, you can choose any index i where 0 <= i < nums.length 
and change nums[i] to nums[i] + x where x is an integer from the range [-k, k]. 
You can apply this operation at most once for each index i.
The score of nums is the difference between the maximum and minimum elements in nums. Return the 
minimum score of nums after applying the mentioned operation at most once for each index init.
Example 1:
Input: nums = [1], k = 0
Output: 0
Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.*/
public class Q8 {
	public static void main(String[] args) {
		int nums[] = { 1 };
		int k = 0;

		int minScore = findMinimumScore(nums, k);
		System.out.println(minScore);
	}

	private static int findMinimumScore(int[] nums, int k) {
		int minNum = nums[0];
		int maxNum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < minNum)
				minNum = nums[i];
			if (nums[i] > maxNum)
				maxNum = nums[i];
		}

		int initialScore = maxNum - minNum;

		if (k >= initialScore)
			return 0;

		int newMinNum = minNum + k;
		int newMaxNum = maxNum - k;

		int newScore = newMaxNum - newMinNum;
		return newScore;
	}
}