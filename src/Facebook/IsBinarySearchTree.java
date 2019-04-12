/* 
 * 
 * 				10
 *    		  /   \
 *    		 8     15
 *    		/     /  \
 *    	   4     12    16
 */

package Facebook;


public class IsBinarySearchTree {

	public static void main(String args[]) {
		Tree root = new Tree(10);
		root.left = new Tree(8);
		root.right = new Tree(15);
		root.left.left = new Tree(4);
		root.right.left = new Tree(12);
		root.right.right = new Tree(1);
		System.out.println(isBST(root));
	}

	private static boolean isBST(Tree root) {

		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBST(Tree root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}

		if (root.val < minValue || root.val > maxValue) {
			return false;
		}

		return isBST(root.left, minValue, root.val) && isBST(root.right, root.val + 1, maxValue);
	}
}
