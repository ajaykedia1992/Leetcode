class Tree {
	int data;
	Tree left;
	Tree right;

	public Tree(int data) {
		this.data = data;
	}

}

public class InorderSuccessor {

	public static void main(String args[]) {
		Tree root = new Tree(10);
		root.left = new Tree(7);
		root.right = new Tree(35);
		root.left.left = new Tree(5);
		root.left.right = new Tree(9);
		root.right.left = new Tree(30);
		root.right.right = new Tree(45);

		int target = 10;
		Tree result = findInorderSuccessor(root, target);
		if (result == null) {
			System.out.println("No Inorder successor");
		} else {
			System.out.println(findInorderSuccessor(root, target).data);
		}
	}

	private static Tree findInorderSuccessor(Tree root, int target) {
		if (root == null) {
			return null;
		}
		Tree temp = null;
		while (root != null) {
			if (root.data == target) {
				if (root.right != null) {
					temp = root.right;
					while (temp.left != null) {
						temp = temp.left;
					}
				}
				root = null;
			} else if (target < root.data) {
				temp = root;
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return temp;
	}
}
