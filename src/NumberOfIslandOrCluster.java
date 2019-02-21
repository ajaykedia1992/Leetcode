/*
 * 1 0 1 0 1
 * 1 1 0 0 0
 * 0 1 0 1 1
 * 
 */

public class NumberOfIslandOrCluster {

	public static void main(String args[]) {
		char[][] island = { { '1', '0', '1', '0', '1' }, { '1', '1', '0', '0', '0' }, { '0', '1', '0', '1', '1' } };

		System.out.println(findAllIsland(island, island.length, island[0].length));
	}

	private static int findAllIsland(char[][] island, int row, int col) {

		if (island == null) {
			return 0;
		}

		int noOfIslands = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// if island[i][j] == '1', increase island count
				if (island[i][j] == '1') {
					noOfIslands++;
					// check its neighbor
					helper(island, i, j);
				}

			}
		}

		return noOfIslands;
	}

	private static void helper(char[][] island, int i, int j) {
		// check boundary cases
		// check if the current position if having char 0
		if (i < 0 || i >= island.length || j < 0 || j >= island[0].length || island[i][j] == '0') {
			return;
		}
		
		island[i][j] = '0';

		helper(island, i + 1, j); // down
		helper(island, i - 1, j); // up
		helper(island, i, j + 1); // right
		helper(island, i, j - 1); // left
	}
}
