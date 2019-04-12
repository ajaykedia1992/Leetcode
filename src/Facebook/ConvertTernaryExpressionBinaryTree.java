package Facebook;

public class ConvertTernaryExpressionBinaryTree {

	class Tree {
		char data;
		Tree left;
		Tree right;

		Tree(char data) {
			this.data = data;
		}
	}

	public static void main(String args[]) {
		String str = "a?b?c:d:e";

		char[] c = str.toCharArray();
		Tree node = new ConvertTernaryExpressionBinaryTree().convertTernaryExpressionToBinaryTree(c, str.length());

		new ConvertTernaryExpressionBinaryTree().printInorder(node);
	}

	private void printInorder(Tree node) {
		if (node != null) {
			printInorder(node.left);
			System.out.print(node.data + " ");
			printInorder(node.right);
		}

	}

	static int index = 0;

	private Tree convertTernaryExpressionToBinaryTree(char[] c, int n) {

		if (index >= n) {
			return null;
		}

		Tree root = new Tree(c[index]);
		index++;

		if (index < n && c[index] == '?') {
			index++;
			root.left = convertTernaryExpressionToBinaryTree(c, n);
			if (index < n) {
				index++;
				root.right = convertTernaryExpressionToBinaryTree(c, n);
			}
		}

		if (index < n) {
			return root;
		}

		return root;
	}
}
