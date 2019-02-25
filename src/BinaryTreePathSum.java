
public class BinaryTreePathSum {
	public static void main(String args[]) {
		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);
		root.left.left = new Tree(4);
		root.left.left.left = new Tree(10);
		root.left.right = new Tree(5);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);

		int sum = 11;

		boolean status = hasPathSum(root, sum);
		System.out.println(status);
	}

	private static boolean hasPathSum(Tree root, int sum) {
		if (root == null) {
			if (sum == 0) {
				return true;
			}
			return false;
		}

		/*
		 * if (root.left == null && root.right == null && root.data == sum) { return
		 * true; }
		 */
		return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
	}
}
