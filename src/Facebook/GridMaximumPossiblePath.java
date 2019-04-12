package Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridMaximumPossiblePath {

	public static void main(String args[]) {

		/*int[][] grid = new int[][] { { 1, 2, 3, 4, 5 }, { 16, 17, 18, 19, 6 }, { 15, 24, 25, 20, 7 },
				{ 14, 23, 22, 21, 8 }, { 13, 12, 11, 10, 9 }

		};
*/
		
		int[][] grid = new int[][] { { 1, 1, 1, 1, 1}, { 1, 1, 1, 1, 1 }

	};
		GridMaximumPossiblePath g = new GridMaximumPossiblePath();
		int M = grid.length;
		int N = grid[0].length;
		System.out.println(g.findMaximumPossiblePath(grid, M, N));

	}

	private int findMaximumPossiblePath(int[][] grid, int M, int N) {

		if (grid == null || grid.length == 0) {
			return 0;
		}

		int maxValue = 0;

		int[][] memoTable = new int[M][N];

		for (int i = 0; i < M; i++) {
			Arrays.fill(memoTable[i], -1);
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				maxValue = Math.max(DFS(grid, i, j, M, N, 0, memoTable), maxValue);
			}
		}

		return maxValue;
	}

	private int DFS(int[][] grid, int i, int j, int M, int N, int fun, int[][] memoTable) {

		if (memoTable[i][j] != -1) {
			return memoTable[i][j] + fun;
		}

		List<int[]> toVisit = new ArrayList<>();

		if (i + 1 < M && grid[i + 1][j] < grid[i][j]) {
			toVisit.add(new int[] { i + 1, j });
		}

		if (i - 1 >= 0 && grid[i - 1][j] < grid[i][j]) {
			toVisit.add(new int[] { i - 1, j });
		}

		if (j + 1 < N && grid[i][j + 1] < grid[i][j]) {
			toVisit.add(new int[] { i, j + 1 });
		}

		if (j - 1 >= 0 && grid[i][j - 1] < grid[i][j]) {
			toVisit.add(new int[] { i, j - 1 });
		}

		int max = fun;

		for (int k = 0; k < toVisit.size(); k++) {
			max = Math.max(max, DFS(grid, toVisit.get(k)[0], toVisit.get(k)[1], M, N, fun + 1, memoTable));
		}

		memoTable[i][j] = max;

		return max;
	}

}
