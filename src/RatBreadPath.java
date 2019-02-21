import java.util.Arrays;

public class RatBreadPath {

	public static void main(String args[]) {

		int[][] problem = { { 1, 0, 0, 0 }, { 0, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };

		int sol[][] = new int[problem.length][problem[0].length];

		boolean flag = solveMaze(problem, 0, 0, sol, problem.length);

		if (flag == false) {
			System.out.println("No path found");
		}

		else {
			for (int[] arr : sol) {
				System.out.println(Arrays.toString(arr));
			}
		}
	}

	private static boolean isSafe(int[][] problem, int x, int y, int N) {
		if (x >= 0 && x < N && y >= 0 && y < N && problem[x][y] == 1) {
			return true;
		}

		return false;
	}

	private static boolean solveMaze(int[][] problem, int x, int y, int[][] sol, int N) {

		if (x == N - 1 && y == N - 1 && isSafe(problem, x, y, N)) {	
			sol[x][y] = 1;
			return true;
		}
		
		if(isSafe(problem, x, y , N)) {
			sol[x][y] = 1;
			if(solveMaze(problem, x + 1, y, sol, N)) {
				return true;
			}
			if(solveMaze(problem, x, y + 1, sol, N)) {
				return true;
			}
			
			sol[x][y] = 0;
			return false;
			
		}

		return false;

	}
}
