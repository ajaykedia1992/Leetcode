class Position {
	int row;
	int col;

	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public String toString() {
		return "Position [row=" + row + ", col=" + col + "]";
	}
}

public class QueenProblem {

	public static void main(String args[]) {

		Position[] positions = solveQueenProblem(4);

		if (positions == null) {
			System.out.println("No position available");
		}

		else {
			for (int i = 0; i < positions.length; i++) {
				System.out.println(positions[i]);
			}
		}
	}

	private static Position[] solveQueenProblem(int number) {
		Position[] positions = new Position[number];

		boolean hasSolvedTheProblem = helper(number, 0, positions);
		if (hasSolvedTheProblem) {
			return positions;
		} else {
			return new Position[0];
		}
	}

	private static boolean helper(int number, int row, Position[] positions) {

		if (number == row) {
			return true;
		}

		for (int col = 0; col < number; col++) {
			boolean isFoundSafe = true;

			for (int queen = 0; queen < row; queen++) {
				if (positions[queen].col == col || positions[queen].row + positions[queen].col == row + col
						|| positions[queen].row - positions[queen].col == row - col) {
					isFoundSafe = false;
					break;
				}
			}
			if (isFoundSafe) {
				positions[row] = new Position(row, col);
				if (helper(number, row + 1, positions)) {
					return true;
				}
			}
		}

		return false;
	}

}
