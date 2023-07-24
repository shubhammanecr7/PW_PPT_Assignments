package searchingSortingAssignment;

public class Q7 {
	/*
	 * Given an array of integers, find the inversion of an array. Formally, two
	 * elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j. N=5, arr[]
	 * = {2, 4, 1, 3, 5} Output: 3 Explanation: (2,1) (4,1) and (4,3) forms an
	 * inversion in an array
	 */

	public static void main(String[] args) {
		int[] arr = { 2, 4, 1, 3, 5 };
		int inversions = countInversions(arr);
		System.out.println(inversions);
	}

	public static int countInversions(int[] arr) {
		return mergeSortAndCount(arr, 0, arr.length - 1);
	}

	private static int mergeSortAndCount(int[] arr, int left, int right) {
		int invCount = 0;

		if (left < right) {
			int mid = left + (right - left) / 2;

			invCount += mergeSortAndCount(arr, left, mid);
			invCount += mergeSortAndCount(arr, mid + 1, right);
			invCount += mergeAndCount(arr, left, mid, right);
		}

		return invCount;
	}

	private static int mergeAndCount(int[] arr, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		int invCount = 0;

		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				invCount += (mid - i + 1); // Count inversions
			}
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= right) {
			temp[k++] = arr[j++];
		}

		System.arraycopy(temp, 0, arr, left, temp.length);

		return invCount;
	}
}
