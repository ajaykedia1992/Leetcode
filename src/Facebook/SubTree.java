/* 
 * 
 * 				1    root1
 *    		  /   \
 *    		 2     3
 *    		/ \    /  \
 *    	   4   4  5    6   
 *    
 *    			2   root2
 *    		   / \
 *    		  4	  7 
 *    			
 */

package Facebook;

public class SubTree {

	public static void main(String args[]) {
		Tree root1 = new Tree(1);
		root1.left = new Tree(2);
		root1.right = new Tree(3);
		root1.left.left = new Tree(4);
		root1.left.right = new Tree(4);
		root1.right.left = new Tree(5);
		root1.right.right = new Tree(6);

		Tree root2 = new Tree(2);
		root2.left = new Tree(4);
		root2.right = new Tree(4);

		System.out.println(isSubTree(root1, root2));

	}

	
	
	private static boolean isSubTree(Tree root1, Tree root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null && root2 != null) {
			return false;
		}

		if (root1 != null && root2 == null) {
			return true;
		}

		if (isSubTreeUtil(root1, root2)) {
			return true;
		}

		return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
	}
	
	/* 
	 * 
	 * 				1    root1
	 *    		  /   \
	 *    		 2     3
	 *    		/ \    /  \
	 *    	   4   4  5    6   
	 *    
	 *    			2   root2
	 *    		   / \
	 *    		  4	  7 
	 *    			
	 *   isSubTree(1,2)
	 *   
	 */

	private static boolean isSubTreeUtil(Tree root1, Tree root2) {
		
		if(root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null && root2 != null) {
			return false;
		}

		if (root1 != null && root2 == null) {
			return true;
		}
		
		return (root1.val == root2.val) && isSubTreeUtil(root1.left, root2.left)
				&& isSubTreeUtil(root1.right, root2.right);
	}
}
