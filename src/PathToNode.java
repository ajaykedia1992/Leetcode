import java.util.Stack;

public class PathToNode {

	public static void main(String args[]) {
		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);
		root.left.left = new Tree(4);
		root.left.left.left = new Tree(10);
		root.left.right = new Tree(5);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);
		Tree node = root.left.left.left;
		pathToNode(root, node);
	}

	private static void pathToNode(Tree root, Tree node) {

		if (root == null) {
			System.out.println("root is empty");
			return;
		}

		Stack<Integer> stack = findPath(root, node);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

	private static Stack<Integer> findPath(Tree root, Tree node) {

		if (root == null) {
			return null;
		}

		if (root.equals(node)) {
			Stack<Integer> result = new Stack<>();
			result.push(root.data);
			return result;
		}

		Stack<Integer> left = findPath(root.left, node);
		Stack<Integer> right = findPath(root.right, node);

		if (left != null) {
			left.push(root.data);
			return left;

		}

		if (right != null) {
			right.push(root.data);
			return right;
		}
		return null;
	}
}
