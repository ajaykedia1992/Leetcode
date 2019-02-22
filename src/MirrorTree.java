
public class MirrorTree {

	public static void main(String args[]) {
		Tree root1 = new Tree(29);
		root1.left = new Tree(13);
		root1.right = new Tree(1);
		root1.left.left = new Tree(7);
		root1.left.right = new Tree(87);
		root1.right.left = new Tree(8);
		root1.right.right = new Tree(12);

		Tree root2 = new Tree(29);
		root2.left = new Tree(1);
		root2.right = new Tree(13);
		root2.left.left = new Tree(12);
		root2.left.right = new Tree(8);
		root2.right.left = new Tree(87);
		root2.right.right = new Tree(7);

		System.out.println(isMirror(root1, root2));
	}

	private static boolean isMirror(Tree root1, Tree root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}

		return (root1.data == root2.data && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left));
	}
}
