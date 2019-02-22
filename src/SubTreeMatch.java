class BinaryTree {
	int data;
	BinaryTree left;
	BinaryTree right;

	public BinaryTree(int data) {
		this.data = data;
	}
}

public class SubTreeMatch {

	public static void main(String args[]) {
		/*
		 * 4 3 5 2 1 4 6 1 3
		 * 
		 */

		BinaryTree root = new BinaryTree(4);
		root.left = new BinaryTree(3);
		root.right = new BinaryTree(5);
		root.left.left = new BinaryTree(2);
		root.left.right = new BinaryTree(1);
		root.right.left = new BinaryTree(4);
		root.right.right = new BinaryTree(6);
		root.left.left.left = new BinaryTree(1);
		root.left.left.right = new BinaryTree(3);

		/*
		 * 2 1 3
		 */

		BinaryTree sub = new BinaryTree(2);
		sub.left = new BinaryTree(1);
		sub.right = new BinaryTree(3);

		boolean result = findSubtree(root, sub);
		System.out.println(result);
	}

	private static boolean findSubtree(BinaryTree root, BinaryTree sub) {

		if (root == null && sub == null) {
			return true;
		}

		if (root == null && sub != null) {
			return false;
		}

		if (root != null && sub == null) {
			return true;
		}

		boolean hasMatch = helper(root, sub);

		return hasMatch || findSubtree(root.left, sub) || findSubtree(root.right, sub);
	}

	private static boolean helper(BinaryTree root, BinaryTree sub) {
		if (root == null && sub == null) {
			return true;
		}

		if (root == null && sub != null) {
			return false;
		}

		if (root != null && sub == null) {
			return true;
		}

		return root.data == sub.data && helper(root.left, sub.left) && helper(root.right, sub.right);
	}

}
