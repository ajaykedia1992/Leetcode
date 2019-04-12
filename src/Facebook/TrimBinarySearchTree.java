/* 
 * 
 * 				10    root1
 *    		  /   \
 *    		 7     15
 *    		/ \    /  \
 *    	   4   9  12   19  
 *    
 */

package Facebook;

public class TrimBinarySearchTree {
	public static void main(String args[]) {
		Tree root = new Tree(10);
		root.left = new Tree(7);
		root.right = new Tree(15);
		root.left.left = new Tree(4);
		root.left.right = new Tree(9);
		root.right.left = new Tree(12);
		root.right.right = new Tree(19);

		int L = 5;
		int R = 9;

		root.print(trimBST(root, L, R));

	}

	private static Tree trimBST(Tree root, int L, int R) {
		if (root == null) {
			return null;
		}

		if (root.val < L) {
			return trimBST(root.right, L, R);
		}

		if (root.val > R) {
			return trimBST(root.left, L, R);
		}
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);

		return root;
	}
}
