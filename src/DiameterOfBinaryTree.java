
public class DiameterOfBinaryTree {

	static int ans;
	public static void main(String args[]) {
		Tree root = new Tree(10);
		root.left = new Tree(1);
		root.right = new Tree(4);
		root.right.left = new Tree(9);
		root.right.right = new Tree(3);
		root.right.left.left = new Tree(11);
		root.left.left = new Tree(5);
		root.left.right = new Tree(7);
		root.left.right.left = new Tree(6);
		root.left.right.right = new Tree(3);
		root.left.right.right.left = new Tree(2);

		// inorder(root);
		int d = depthofBinaryTree(root);
		System.out.println(d);
	}

	public static int depthofBinaryTree(Tree root) {
		ans = 1;
		diameterOfBinaryTree(root);
		return ans - 1;
	}
	
	private static int diameterOfBinaryTree(Tree root) {

		if (root == null) {
			return 0;
		}
		int left = diameterOfBinaryTree(root.left);
		int right = diameterOfBinaryTree(root.right);

		ans = Math.max(ans, left + right + 1);
		return Math.max(left, right) + 1;
	}

}
