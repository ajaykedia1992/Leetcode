package Facebook;

import java.util.Arrays;

public class FindPathGrid {

	public static void main(String args[]) {

		int[][] grid = new int[][] { { 1, 0, 0, 1 }, { 1, 1, 0, 1 }, { 0, 1, 1, 1 }, { 0, 0, 0, 1 } };

		int M = grid.length;
		int N = grid[0].length;

		int[][] visited = new int[M][N];
		boolean findPath = new FindPathGrid().findPath(grid, visited, M, N);
		System.out.println(findPath);

		if (findPath) {
			for (int[] v : visited) {
				System.out.println(Arrays.toString(v));
			}
		}
	}

	private boolean findPath(int[][] grid, int[][] visited, int M, int N) {

		if (grid == null || grid.length == 0) {
			return true;
		}

		boolean findPath = DFS(grid, 0, 0, M, N, visited);
		
		return findPath;

	}

	public boolean valid(int[][] grid, int i, int j, int visited[][]) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j] != 0) {
			return false;
		}
		return true;
	}

	private boolean DFS(int[][] grid, int i, int j, int m, int n, int[][] visited) {
		
		visited[i][j] = 1;
		
		if(i == m - 1 && j == n - 1) {
			return true;
		}

		if (valid(grid, i + 1, j, visited)) {
			return DFS(grid, i + 1, j, m, n, visited);
		}

		if (valid(grid, i - 1, j, visited)) {
			return DFS(grid, i - 1, j, m, n, visited);
		}

		if (valid(grid, i, j + 1, visited)) {
			return DFS(grid, i, j + 1, m, n, visited);
		}

		if (valid(grid, i, j - 1, visited)) {
			return DFS(grid, i, j - 1, m, n, visited);
		}

		visited[i][j] = 0;
		
		return false;
	}
}
