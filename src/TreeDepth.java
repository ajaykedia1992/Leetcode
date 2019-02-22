
public class TreeDepth {
	public static void main(String args[]) {
		Tree root1 = new Tree(29);
		root1.left = new Tree(13);
		root1.right = new Tree(1);
		root1.left.left = new Tree(7);
		root1.left.right = new Tree(87);
		root1.right.left = new Tree(8);
		root1.right.right = new Tree(12);
		System.out.println(depthOfTree(root1));
		System.out.println(heightOfTree(root1));
	}

	private static int depthOfTree(Tree root) {
		if (root == null) {
			return -1;
		}
		int left = depthOfTree(root.left);
		int right = depthOfTree(root.right);
		return Math.max(left, right) + 1;
	}

	private static int heightOfTree(Tree root) {
		if (root == null) {
			return -1;
		}
		int left = heightOfTree(root.left);
		int right = heightOfTree(root.right);
		return Math.max(left, right) + 1;
	}
}
