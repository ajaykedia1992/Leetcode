/*
 * 1 1 1 1
 * 1 1 0 1
 * 0 1 0 1
 * 1 1 1 1
 */


public class FindAllUniquePath {

	public static void main(String args[]) {
		int maze[][] = { { 1, 1, 1, 1 }, { 1, 1, 0, 1 }, { 0, 1, 0, 1 }, { 1, 1, 1, 1 } };
		int m = maze.length;
		int n = maze[0].length;
		boolean visited[][] = new boolean[m][n];

		int count = 0;
		System.out.println(mazeFinder(maze, visited, 0, 0, count));
	}

	private static boolean checkBoundary(int[][] maze, int x, int y) {
		if ((x < 0 || y < 0 || x >= maze.length || y >= maze[0].length)) {
			return false;
		}
		else if(maze[x][y] == 0) {
			return false;
		}
		return true;
	}

	private static int mazeFinder(int[][] maze, boolean[][] visited, int x, int y, int count) {

		if (x == maze.length - 1 && y == maze[0].length - 1) {
			count++;
			return count;
		}

		visited[x][y] = true;

		if (checkBoundary(maze, x + 1, y) && !visited[x + 1][y]) {

			count = mazeFinder(maze, visited, x + 1, y, count);
		}
		
		if (checkBoundary(maze, x - 1, y) && !visited[x - 1][y]) {

			count = mazeFinder(maze, visited, x - 1, y, count);
		}
		
		if (checkBoundary(maze, x, y + 1) && !visited[x][y + 1]) {

			count = mazeFinder(maze, visited, x, y + 1, count);
		}
		
		if (checkBoundary(maze, x, y - 1) && !visited[x][y - 1]) {

			count = mazeFinder(maze, visited, x, y - 1, count);
		}
		
		visited[x][y] = false;
		return count;

	}

}
