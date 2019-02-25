
public class LevelOrderTraversalDFS {

	public static void main(String args[]) {
		Tree root = new Tree(1);
		root.left = new Tree(3);
		root.left.left = new Tree(2);
		root.left.right = new Tree(1);
		root.left.right.left = new Tree(1);
		root.right = new Tree(-1);
		root.right.left = new Tree(4);
		root.right.left.left = new Tree(1);
		root.right.left.right = new Tree(2);
		root.right.right = new Tree(5);
		root.right.right.right = new Tree(2);

		findLevelOrderTraversal(root);

	}

	private static void findLevelOrderTraversal(Tree root) {
		if (root == null) {
			return;
		}

		int height = maxHeight(root);
		for (int i = 0; i < height; i++) {
			DFS(root, i);
		}

	}

	private static void DFS(Tree root, int level) {

		if (root == null) {
			return;
		}
		if (level == 0) {
			System.out.print(root.data + " ");
		}
		DFS(root.left, level - 1);
		DFS(root.right, level - 1);
	}

	private static int maxHeight(Tree root) {

		if (root == null) {
			return 0;
		}

		return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
	}
}
