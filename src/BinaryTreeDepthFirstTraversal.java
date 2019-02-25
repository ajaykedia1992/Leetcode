import java.util.Stack;

public class BinaryTreeDepthFirstTraversal {

	public static void main(String args[]) {
		Tree root = new Tree(10);
		root.left = new Tree(7);
		root.right = new Tree(35);
		root.left.left = new Tree(5);
		root.left.right = new Tree(9);
		root.right.left = new Tree(30);
		root.right.right = new Tree(45);
		findDepthFirstTraversal(root);
	}

	private static void findDepthFirstTraversal(Tree root) {

		if (root == null) {
			return;
		}

		Stack<Tree> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Tree temp = stack.pop();
			System.out.println(temp.data);

			if (temp.right != null) {
				stack.push(temp.right);
			}
			if (temp.left != null) {
				stack.push(temp.left);
			}
		}
	}

}
