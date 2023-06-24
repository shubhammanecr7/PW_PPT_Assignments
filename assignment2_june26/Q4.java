package assignment2_june26;

/*Question 4
You have a long flowerbed in which some of the plots are planted, and some are not.
However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
 and an integer n, return true if n new flowers can be planted in the flowerbed without violating 
 the no-adjacent-flowers rule and false otherwise.
Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true*/
public class Q4 {
	public static void main(String[] args) {
		int flowerbed[] = { 1, 0, 0, 0, 1 };
		int n = 1;

		boolean result = canPlace(flowerbed, n);
		System.out.println(result);
	}

	private static boolean canPlace(int[] flowerbed, int n) {
		int count = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 0) {
				if (i == 0 || flowerbed[i - 1] == 0) {
					if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
						flowerbed[i]=1;
						count++;
						if (count>=n) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
