package Facebook;

public class MakeALargeIsland {

	public static void main(String args[]) {
		int[][] grid = { { 1, 0 }, { 0, 1 } };
		System.out.println(new MakeALargeIsland().largestIsland(grid));
	}

	public int largestIsland(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		boolean hasZero = false;
		int maxArea = 0;

		int m = grid.length;
		int n = grid[0].length;

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == 0) {
					grid[row][col] = 1;
					maxArea = Math.max(maxArea, checkMaxAreaPossible(grid, row, col, new boolean[m][n]));
					if (maxArea == m * n) {
						return maxArea;
					}
					grid[row][col] = 0;
					hasZero = true;
				}
			}
		}
		return hasZero ? maxArea : m * n;
	}

	public int checkMaxAreaPossible(int[][] grid, int row, int col, boolean visited[][]) {

		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1
				|| visited[row][col]) {
			return 0;
		}

		visited[row][col] = true;

		return 1 + checkMaxAreaPossible(grid, row + 1, col, visited) + checkMaxAreaPossible(grid, row - 1, col, visited)
				+ checkMaxAreaPossible(grid, row, col + 1, visited) + checkMaxAreaPossible(grid, row, col - 1, visited);
	}
}
