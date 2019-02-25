
public class MinimumDepth {

	public static void main(String args[]) {
		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);
		root.left.left = new Tree(4);
		root.left.right = new Tree(5);
		System.out.println(findMinimumDepth(root));
		System.out.println(minimumDepth(root, 0));
		System.out.println(minimumDepthTree(root));
	}

	private static int findMinimumDepth(Tree root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		if (root.left == null) {
			return findMinimumDepth(root.right) + 1;
		}
		if (root.right == null) {
			return findMinimumDepth(root.left) + 1;
		}

		return Math.min(findMinimumDepth(root.left), findMinimumDepth(root.right)) + 1;
	}

	public static int minimumDepth(Tree root, int level) {

		if (root == null)
			return level;
		level++;

		return Math.min(minimumDepth(root.left, level), minimumDepth(root.right, level));
	}

	public static int minimumDepthTree(Tree root) {

		if (root == null)
			return 0;

		int left = minimumDepthTree(root.left);
		int right = minimumDepthTree(root.right);

		return Math.min(left, right) + 1;
	}
}
