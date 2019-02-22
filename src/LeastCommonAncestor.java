
public class LeastCommonAncestor {

	public static void main(String args[]) {

		Tree root = new Tree(29);
		root.left = new Tree(13);
		root.right = new Tree(1);
		root.left.left = new Tree(7);
		root.left.right = new Tree(87);
		root.right.left = new Tree(8);
		root.right.right = new Tree(12);

		int a = 1, b = 8;

		if ((find(root, a) == false || find(root, b) == false)) {
			System.out.println("" + null);
		} else {
			Tree result = findLeastCommonAncestor(root, a, b);
			if (result == null) {
				System.out.println(result);
			} else {

				System.out.println(result.data);
			}
		}
	}

	public static boolean find(Tree root, int id) {
		if (root == null) {
			return false;
		}
		if (root.data == id) {
			return true;
		}

		return find(root.left, id) || find(root.right, id);
	}

	public static Tree findLeastCommonAncestor(Tree root, int id1, int id2) {

		if (root == null) {
			return null;
		}
		if (root.data == id1 || root.data == id2) {
			return root;
		}

		Tree leftTree = findLeastCommonAncestor(root.left, id1, id2);

		Tree rightTree = findLeastCommonAncestor(root.right, id1, id2);

		if (leftTree != null && rightTree != null) {
			return root;
		}

		if (leftTree == null && rightTree == null) {
			return null;
		}

		return (leftTree != null) ? leftTree : rightTree;

	}

}
