package Facebook;

public class Tree {

	int val;
	Tree left;
	Tree right;

	Tree(int val) {
		this.val = val;
	}

	public void print(Tree root) {
		if (root != null) {
			print(root.left);
			System.out.print(root.val + " ");
			print(root.right);
		}
	}
}
