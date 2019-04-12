import java.util.Arrays;

/*
 * {'B', 'B', 'C','0','0'},
 * {'0','0','0','B','B'},
 * {'0','B','C','0','B'},
 * {'0','0','0','B','B'}
 * 
 * Input:
 * 
 * BBC00
 * 000BB
 * 0BC0B
 * 000BB
 * 
 * output:
 * 
 * BBC12
 * 321BB
 * 4BC1B
 * 321BB
 * 
 */
public class BuildingCarStreetProblem {

	public static void main(String args[]) {
		char[][] city = { { 'B', 'B', 'C', '0', '0' }, { '0', '0', '0', 'B', 'B' }, { '0', 'B', 'C', '0', 'B' },
				{ '0', '0', '0', 'B', 'B' } };

		findMinimumDistanceBetweenCars(city);

		for (char[] c : city) {
			System.out.println(Arrays.toString(c));
		}
	}

	private static void findMinimumDistanceBetweenCars(char[][] c) {
		int m = c.length;
		int n = c[0].length;
		int[][] city = new int[m][n];
		preprocessing(c, city, m, n);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (city[i][j] == 0) {
					fill2DArray(city, i, j, 0);
					//dfs(i, j, city, 0);
				}
			}
		}

		reversePreprocessing(city, c);

	}

	private static void reversePreprocessing(int[][] city, char[][] c) {
		for (int i = 0; i < city.length; i++) {
			for (int j = 0; j < city[0].length; j++) {
				if (city[i][j] != -1 && city[i][j] != 0 && city[i][j] != Integer.MAX_VALUE) {
					c[i][j] = (char) (city[i][j] + '0');
				}
			}
		}

	}

	/*
	 * B-> -1 C-> 0 0-> Integer.MIN_VALUE;
	 */
	private static void preprocessing(char[][] c, int[][] city, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (c[i][j] == 'B') {
					city[i][j] = -1;
				} else if (c[i][j] == 'C') {
					city[i][j] = 0;
				} else {
					city[i][j] = Integer.MAX_VALUE;
				}
			}
		}
	}

	static void dfs(int row, int col, int[][] rooms, int dist) {
		if (row < 0 || col < 0 || row >= rooms.length || col >= rooms[row].length || rooms[row][col] == -1
				|| rooms[row][col] < dist)
			return;

		rooms[row][col] = dist;

		dfs(row + 1, col, rooms, dist + 1);
		dfs(row - 1, col, rooms, dist + 1);
		dfs(row, col + 1, rooms, dist + 1);
		dfs(row, col - 1, rooms, dist + 1);
	}
	
	private static void fill2DArray(int[][] city, int i, int j, int start) {
		if (i < 0 || i >= city.length || j < 0 || j >= city[0].length || city[i][j] == -1 || city[i][j] < start) {
			return;
		}
		city[i][j] = start;
		fill2DArray(city, i + 1, j, start + 1);
		fill2DArray(city, i, j + 1, start + 1);
		fill2DArray(city, i - 1, j, start + 1);
		fill2DArray(city, i, j - 1, start + 1);

	}

}
