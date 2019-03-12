import java.util.HashMap;
import java.util.Map;

public class PreOrderAndInorderConstructBinaryTree {

	int preIndex = 0;

	public static void main(String args[]) {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };

		PreOrderAndInorderConstructBinaryTree p = new PreOrderAndInorderConstructBinaryTree();
		Tree root = p.buildTree(preorder, inorder);
		p.preorder(root);
	}

	private void preorder(Tree root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}

	}

	public Tree buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return constructUniqueBinaryTree(preorder, 0, inorder.length - 1, map);
	}

	private Tree constructUniqueBinaryTree(int[] preorder, int start, int end, Map<Integer, Integer> map) {

		if (start > end) {
			return null;
		}

		int data = preorder[preIndex++];

		Tree node = new Tree(data);

		if (start == end) {
			return node;
		}

		int index = map.get(data);

		node.left = constructUniqueBinaryTree(preorder, start, index - 1, map);
		node.right = constructUniqueBinaryTree(preorder, index + 1, end, map);

		return node;
	}
}
