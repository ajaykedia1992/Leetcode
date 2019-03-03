import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/swim-in-rising-water/
 * 
 * https://www.youtube.com/watch?v=dmP65LPl9wQ
 * 
 * 0->  1 -> 2 -> 3 ->  4
 *                      |
   24   23   22   21    5
                        |
   12 <-13 <-14 <-15 <- 16 
   |   					
   11   17   18   19    20
   |
   10 -> 9 -> 8 -> 7 ->  6
   
 */

class GridPair implements Comparable<GridPair> {
	int elevation;
	int x;
	int y;

	public GridPair(int elevation, int x, int y) {
		this.elevation = elevation;
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(GridPair o) {
		return this.elevation - o.elevation;
	}

}

public class SwimInRisingWater {

	public static void main(String args[]) {
		int grid[][] = { { 0, 1, 2, 3, 4 }, { 24, 23, 22, 21, 5 }, { 12, 13, 14, 15, 16 }, { 11, 17, 18, 19, 20 },
				{ 10, 9, 8, 7, 6 } };

		int m = grid.length;
		int n = grid[0].length;
		System.out.println(findTheLeastTimeToReachBottom(grid, m, n));

	}

	private static int findTheLeastTimeToReachBottom(int[][] grid, int m, int n) {

		if (grid == null || m == 0) {
			return -1;
		}

		PriorityQueue<GridPair> queue = new PriorityQueue<GridPair>();

		boolean[][] visited = new boolean[m][n];

		int min = Integer.MIN_VALUE;

		queue.add(new GridPair(grid[0][0], 0, 0));

		while (!queue.isEmpty()) {
			GridPair temp = queue.poll();
			int x = temp.x;
			int y = temp.y;
			visited[x][y] = true;
			min = Math.max(min, temp.elevation);
			getAdjacent(grid, visited, x, y, queue);
			if(x == m - 1 && y == n - 1) {
				break;
			}
		}

		return min;
	}

	private static boolean valid(int[][] grid, int x, int y) {
		if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
			return true;
		}
		return false;
	}

	private static void getAdjacent(int[][] grid, boolean[][] visited, int x, int y, PriorityQueue<GridPair> queue) {

		if (valid(grid, x + 1, y) && !visited[x + 1][y]) {
			queue.add(new GridPair(grid[x + 1][y], x + 1, y));
		}

		if (valid(grid, x - 1, y) && !visited[x - 1][y]) {
			queue.add(new GridPair(grid[x - 1][y], x - 1, y));
		}

		if (valid(grid, x, y + 1) && !visited[x][y + 1]) {
			queue.add(new GridPair(grid[x][y + 1], x, y + 1));
		}

		if (valid(grid, x, y - 1) && !visited[x][y - 1]) {
			queue.add(new GridPair(grid[x][y - 1], x, y - 1));
		}

	}
}
