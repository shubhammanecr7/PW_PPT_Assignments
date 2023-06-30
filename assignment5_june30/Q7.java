package assignment5_june30;

/*
💡 **Question 7**
Suppose an array of length n sorted in ascending order is **rotated** between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
- [4,5,6,7,0,1,2] if it was rotated 4 times.
- [0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that **rotating** an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in
 the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
Given the sorted rotated array nums of **unique** elements,
 return *the minimum element of this array*.
You must write an algorithm that runs in O(log n) time.
**Example 1:**
**Input:** nums = [3,4,5,1,2]
**Output:** 1
**Explanation:**
The original array was [1,2,3,4,5] rotated 3 times.
*/
public class Q7 {
	public static void main(String[] args) {
		int nums[] = { 3, 4, 5, 1, 2 };
		int min = findMinimum(nums);
		System.out.println("Minimum element: " + min);
	}

	private static int findMinimum(int[] nums) {
		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;

			// Check if the middle element is less than the last element
			// If true, it means the minimum element is in the left part of the array
			if (nums[mid] < nums[high]) {
				high = mid;
			}
			// Check if the middle element is greater than the last element
			// If true, it means the minimum element is in the right part of the array
			else if (nums[mid] > nums[high]) {
				low = mid + 1;
			}
		}
		// At this point, low and high will point to the minimum element
		return nums[low];
	}
}