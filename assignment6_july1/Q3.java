package assignment6_july1;

/*
💡 **Question 3**
Given an array of integers arr, return *true if and only if it is a valid mountain array*.
Recall that arr is a mountain array if and only if:
- arr.length >= 3
- There exists some i with 0 < i < arr.length - 1 such that:
    - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
    - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
**Example 1:**
**Input:** arr = [2,1]
**Output:**
false*/
public class Q3 {
	public static void main(String[] args) {
		int arr[] = { 2, 1 };
		boolean result = isValidMountainArray(arr);
		System.out.println(result);
	}

	private static boolean isValidMountainArray(int[] a) {
		if (a.length < 3)
			return false;

		int l = 0, r = a.length - 1;
		// check for increasing
		while (a[l] < a[l + 1] && l + 1 < a.length - 1)
			l++;
		// check for decreasing
		while (a[r] < a[r - 1] && r - 1 > 0)
			r--;
		// if it is valid mountain array both l&r pointer stop at same index
		return l == r;
	}
}
