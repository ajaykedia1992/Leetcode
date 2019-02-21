/*
 * 0 1 0 0 0
 * 1 1 1 0 0
 * 1 1 1 0 0
 * 0 1 0 0 0
 */

public class IslandPerimiter {

	public static void main(String args[]) {
		int[][] island = { { 0, 1, 0, 0, 0}, { 1, 1, 1, 0, 0 }, { 1, 1, 1, 0, 0 }, { 0, 1, 0, 0, 0 } };
		System.out.println(findPerimeterOfIsland(island));
	}

	private static int findPerimeterOfIsland(int[][] island) {
		if (island == null || island.length == 0) {
			return 0;
		}

		int perimeter = 0;

		for (int i = 0; i < island.length; i++) {
			for (int j = 0; j < island[0].length; j++) {
				// check island current position == 1
				if (island[i][j] == 1) {
					//perimeter++;
					// check its surround is 1 or 0 or boundary condition
					perimeter += helper(island, i, j);
				}
			}
		}
		return perimeter;
	}

	private static int helper(int[][] island, int i, int j) {
		if(i < 0 || i >= island.length || j < 0 || j >= island[0].length || island[i][j] == 0) {
			return 0;
		}
		int count = 0;
		if(i + 1 >= island.length || island[i+1][j] == 0) { // down
			count++;
		}
		if(i - 1 < 0 || island[i-1][j] == 0) { // up
			count++;
		}
		if(j - 1 < 0 || island[i][j - 1] == 0) { // left
			count++;
		}
		if(j + 1 >= island[0].length || island[i][j+1] == 0) {  // right
			count++;
		}
		return count;
	}

}
