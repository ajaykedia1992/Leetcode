/*
 * 				 10
 * 			 5       15
 *         3   7  13    17
 *        2 4 6 9      16  19
 *        
 *        2 3 4 5 7 9 10 13 15 16 17 19
 */

public class FindKthMmaxElementBinarySearchTree {

	static int result = -1;
	static int count = 0;

	public static void main(String args[]) {
		Tree root = new Tree(10);
		root.left = new Tree(5);
		root.right = new Tree(15);
		root.left.left = new Tree(3);
		root.left.left.left = new Tree(2);
		root.left.left.right = new Tree(4);
		root.left.right = new Tree(7);
		root.right.left = new Tree(13);
		root.right.right = new Tree(17);
		root.right.right.left = new Tree(16);
		root.right.right.right = new Tree(19);

		int k = 5;
		inorder(root);
		System.out.println();
		System.out.println(kthSmallest(root, k));
		result = -1; count = 0;
		System.out.println(kthLargest(root, k));
	}

	private static void inorder(Tree root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public static int kthSmallest(Tree root, int k) {
		if (root == null) {
			return -1;
		}
		helperSmallest(root, k);
		return result;
	}
	
	public static int kthLargest(Tree root, int k) {
		if (root == null) {
			return -1;
		}
		helperLargest(root, k);
		return result;
	}

	public static void helperSmallest(Tree root, int k) {
		if (root != null) {
			helperSmallest(root.left, k);
			count++;
			if (count == k) {
				result = root.data;
			}
			helperSmallest(root.right, k);
		}
	}
	
	public static void helperLargest(Tree root, int k) {
		if (root != null) {
			helperLargest(root.right, k);
			count++;
			if (count == k) {
				result = root.data;
			}
			helperLargest(root.left, k);
		}
	}
}
