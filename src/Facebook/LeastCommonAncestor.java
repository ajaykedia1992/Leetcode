package Facebook;

public class LeastCommonAncestor {

	static boolean v1 = false, v2 = false;

	public static void main(String args[]) {
		Tree root = new Tree(10);
		root.left = new Tree(7);
		root.right = new Tree(15);
		root.left.left = new Tree(4);
		root.left.right = new Tree(9);
		root.right.left = new Tree(12);
		root.right.right = new Tree(19);
		Tree result = findLeastCommonAncestor(root, 10, 19);
		if(result == null) {
			System.out.println(""+null);
		}
		else {
			System.out.println(result.val);
		}
	}

	private static Tree findLeastCommonAncestor(Tree root, int i, int j) {

		Tree result = findLeastCommonAncestorUtil(root, i, j);

		if (v1 && v2) {
			return result;
		}

		return null;
	}

	private static Tree findLeastCommonAncestorUtil(Tree root, int n1, int n2) {
		if (root == null) {
			return null;
		}

		Tree temp = null;	
		if (root.val == n1) {
			temp = root;
			v1 = true;
		}
		
		if(root.val == n2) {
			temp = root;
			v2 = true;
		}

		Tree left = findLeastCommonAncestorUtil(root.left, n1, n2);
		Tree right = findLeastCommonAncestorUtil(root.right, n1, n2);

		if(temp != null) {
			return temp;
		}
		
		if (left != null && right != null) {
			return root;
		}

		return left != null ? left : right;
	}
}
