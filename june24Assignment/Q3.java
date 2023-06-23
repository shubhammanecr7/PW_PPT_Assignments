package june24Assignment;

/*
💡 **Q3.** Given a sorted array of distinct integers and a target value, return the index 
if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
**Example 1:**
Input: nums = [1,3,5,6], target = 5
Output: 2
*/
public class Q3 {
	public static void main(String[] args) {
		int nums[] = { 1, 3, 5, 6 };
		int target = 5;

		int index = findTargetIndex(nums, target);
		System.out.println(index);
	}

	// using binary search approach
	private static int findTargetIndex(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target)
				return mid; // if we found element at correct position
			else if (target > nums[mid])
				left = mid + 1;
			else
				right = mid - 1;
		}
		
		//if target is not found we return the left index, 
		//which represents the position where the target value should be inserted.
		return left;
	}
}