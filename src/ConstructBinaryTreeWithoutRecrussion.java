import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ConstructBinaryTreeWithoutRecrussion {
	static Set<Tree> set = new HashSet<>();
	static Stack<Tree> stack = new Stack<>();

	// Function to build tree using given traversal
	public Tree buildTree(int[] preorder, int[] inorder) {

		Tree root = null;
		for (int pre = 0, in = 0; pre < preorder.length;) {

			Tree node = null;
			do {
				node = new Tree(preorder[pre]);
				if (root == null) {
					root = node;
				}
				if (!stack.isEmpty()) {
					if (set.contains(stack.peek())) {
						set.remove(stack.peek());
						stack.pop().right = node;
					} else {
						stack.peek().left = node;
					}
				}
				stack.push(node);
			} while (preorder[pre++] != inorder[in] && pre < preorder.length);

			node = null;
			while (!stack.isEmpty() && in < inorder.length && stack.peek().data == inorder[in]) {
				node = stack.pop();
				in++;
			}

			if (node != null) {
				set.add(node);
				stack.push(node);
			}
		}

		return root;
	}

	// Function to print tree in Inorder
	void printInorder(Tree node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.data + " ");

		/* now recur on right child */
		printInorder(node.right);
	}

	// driver program to test above functions
	public static void main(String args[]) {
		ConstructBinaryTreeWithoutRecrussion tree = new ConstructBinaryTreeWithoutRecrussion();

		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		int len = inorder.length;

		Tree root = tree.buildTree(preorder, inorder);

		tree.printInorder(root);
	}
}
