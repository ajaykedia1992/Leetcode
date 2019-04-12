/* 
 * A balanced binary tree is atmost differ by 1.
 * 
 * 				1
 *    		  /   \
 *    		 2     3
 *    		/     /  \
 *    	   4     5    6
 */

package Facebook;


public class IsBalancedBinaryTree {

	public static void main(String args[]) {
		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);
		root.left.left = new Tree(4);
		root.right.left = new Tree(5);
		root.right.right = new Tree(6);
		System.out.println(isBalancedBinaryTree(root));
	}

	private static boolean isBalancedBinaryTree(Tree root) {
		if (balancedTree(root) > -1) {
			return true;
		}
		return false;
	}

	private static int balancedTree(Tree root) {
		if (root == null) {
			return 0;
		}

		int h1 = balancedTree(root.left);
		int h2 = balancedTree(root.right);

		if (h1 == -1 || h2 == -1) {
			return -1;
		}

		if (Math.abs(h1 - h2) > 1) {
			return -1;
		}

		return (h1 > h2 ? h1 : h2) + 1;
	}
}
