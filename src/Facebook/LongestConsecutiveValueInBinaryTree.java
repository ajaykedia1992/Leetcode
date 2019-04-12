/* 
 * 				1
 *    		  /   \
 *    		 2     3
 *    		/     /  \
 *    	   3     5    6
 */

package Facebook;

public class LongestConsecutiveValueInBinaryTree {

	public static void main(String args[]) {
		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);
		root.left.left = new Tree(3);
		root.right.left = new Tree(4);
		root.right.right = new Tree(6);
		root.right.left.left = new Tree(5);
		root.right.left.left.left = new Tree(6);
		root.right.left.left.left.left = new Tree(9);
		System.out.println(new LongestConsecutiveValueInBinaryTree().longestConsecutiveValue(root));
	}

	private int longestConsecutiveValue(Tree root) {
		if (root == null) {
			return 0;
		}

		return Math.max(longestConsecutiveValue(root.left, root.val, 1),
				longestConsecutiveValue(root.right, root.val, 1));
	}

	private int longestConsecutiveValue(Tree root, int prev, int length) {
		if(root == null) {
			return length;
		}
		
		if(root.val == prev + 1) {
			int left = longestConsecutiveValue(root.left, root.val, length + 1);
			int right = longestConsecutiveValue(root.right, root.val, length + 1);
			return Math.max(left, right);
		}else {
			int left = longestConsecutiveValue(root.left, root.val, length);
			int right = longestConsecutiveValue(root.right, root.val, length);
			return Math.max(left, right);
			
		}
	}

}
