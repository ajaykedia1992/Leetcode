
public class UnivaluePath {

	public static void main(String args[]) {
		Tree root = new Tree(1);
		root.left = new Tree(4);
		root.right = new Tree(5);
		root.left.left = new Tree(4);
		root.left.right = new Tree(4);
		root.right.right = new Tree(5);

		int result = getUnivaluePath(root);
		System.out.println(result);
	}

	private static int getUnivaluePath(Tree root) {
		if (root != null) {
			int res[] = new int[1];
			DFS(root, res);
			return res[0];
		}
		return -1;
	}

	private static int DFS(Tree root, int[] count) {
		int left = root.left != null ? DFS(root.left, count) : 0;
		int right = root.right != null ? DFS(root.right, count) : 0;

		int resLeft = root.left != null && root.left.data == root.data ? left + 1 : 0;

		int resRight = root.right != null && root.right.data == root.data ? right + 1 : 0;

		count[0] = Math.max(count[0], resLeft + resRight);

		return Math.max(resLeft, resRight);
	}
}
