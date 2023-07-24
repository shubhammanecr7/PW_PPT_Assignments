package searchingSortingAssignment;

public class Q6 {
	/*
	 * You are a product manager and currently leading a team to develop a new
	 * product. Unfortunately, the latest version of your product fails the quality
	 * check. Since each version is developed based on the previous version, all the
	 * versions after a bad version are also bad. Suppose you have n versions [1, 2,
	 * ..., n] and you want to find out the first bad one, which causes all the
	 * following ones to be bad. You are given an API bool isBadVersion(version)
	 * which returns whether the version is bad. Implement a function to find the
	 * first bad version. You should minimize the number of calls to the API. Input:
	 * n = 5, bad = 4 Output: 4 Explanation: call isBadVersion(3) -> false call
	 * isBadVersion(5) -> true call isBadVersion(4) -> true Then 4 is the first bad
	 * version.
	 */

	public static void main(String[] args) {
		int n = 5;
		int firstBadVersion = firstBadVersion(n);
		System.out.println(firstBadVersion);
	}

	private static int firstBadVersion(int n) {
		int left = 1;
		int right = n;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (isBadVersion(mid)) {
				right = mid; // The current version is bad, continue searching in the left half
			} else {
				left = mid + 1; // The current version is good, continue searching in the right half
			}
		}

		return left; // The left pointer will eventually point to the first bad version.

	}

	private static boolean isBadVersion(int version) {
		return false; 
	}

}
