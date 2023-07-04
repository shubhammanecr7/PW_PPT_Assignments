package assignment7_july3;

/*
💡 **Question 8**
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate
 of a point. Check if these points make a straight line in the XY plane.
**Example 1:**
**Input:** coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
**Output:** true*/
public class Q8 {
	public static void main(String[] args) {
		int[][] coordinates = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } };
		boolean isStraightLine = checkStraightLine(coordinates);
		System.out.println(isStraightLine);
	}

	private static boolean checkStraightLine(int[][] coordinates) {
		int x0 = coordinates[0][0];
		int y0 = coordinates[0][1];
		int x1 = coordinates[1][0];
		int y1 = coordinates[1][1];

		int deltaX = x1 - x0;
		int deltaY = y1 - y0;

		// Check the slope between the first two points
		for (int i = 2; i < coordinates.length; i++) {
			int x = coordinates[i][0];
			int y = coordinates[i][1];

			// Calculate the slope between the current point and the first point
			if (deltaX * (y - y0) != deltaY * (x - x0)) {
				return false; // If the slopes are not equal, points do not lie on a straight line
			}
		}
		return true; // All points lie on a straight line
	}
}
