
public class ValidateBinarySearchTree {

	public static void main(String args[]) {
		Tree root = new Tree(10);
		root.left = new Tree(7);
		root.right = new Tree(40);
		root.left.left = new Tree(5);
		root.left.right = new Tree(9);
		root.right.left = new Tree(30);
		root.right.right = new Tree(90);

		System.out.println(isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE)); // true

		inOrder(root);
	}

	private static void inOrder(Tree root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}

	}

	private static boolean isBinarySearchTree(Tree root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
		if (root.data <= maxValue && root.data >= minValue) {
			return (isBinarySearchTree(root.left, minValue, root.data)
					&& isBinarySearchTree(root.right, root.data, maxValue));
		}

		return false;
	}
}
