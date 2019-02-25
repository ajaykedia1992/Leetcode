import java.util.Stack;

public class BinaryTreeZigZagTraversal {

	public static void main(String args[]) {
		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);
		root.left.left = new Tree(4);
		root.left.right = new Tree(5);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);

		printZigZagTraversal(root);
	}

	private static void printZigZagTraversal(Tree root) {

		if (root == null) {
			return;
		}

		Stack<Tree> currentLevel = new Stack<Tree>();
		Stack<Tree> nextLevel = new Stack<Tree>();

		currentLevel.push(root);

		boolean hasReverse = true;

		while (!currentLevel.isEmpty()) {
			Tree temp = currentLevel.pop();
			System.out.print(temp.data + " ");
			if (hasReverse) {
				if (temp.left != null) {
					nextLevel.add(temp.left);
				}
				if (temp.right != null) {
					nextLevel.add(temp.right);
				}

			} else {
				if (temp.right != null) {
					nextLevel.add(temp.right);
				}
				if (temp.left != null) {
					nextLevel.add(temp.left);
				}
			}
			if (currentLevel.isEmpty()) {
				hasReverse = !hasReverse;
				Stack<Tree> swap = currentLevel;
				currentLevel = nextLevel;
				nextLevel = swap;
			}
		}

	}

}
