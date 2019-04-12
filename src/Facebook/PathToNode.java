

package Facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathToNode {

	public static void main(String args[]) {
		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);
		root.left.left = new Tree(4);
		root.right.left = new Tree(5);
		root.right.right = new Tree(6);

		System.out.println(pathToNode(root, root.right.right));
	}

	
	private static List<Integer> pathToNode(Tree root, Tree node) {
		Stack<Tree> stack = pathToNodeUtil(root, node);
		
		List<Integer> result = new ArrayList<>();
		
		while(!stack.isEmpty()) {
			int val = stack.pop().val;
			result.add(val);
		}
		
		return result;
	}


	/* 
	 * 
	 * 				1    root
	 *    		  /   \
	 *    		 2     3
	 *    		/     /  \
	 *    	   4     5    6   node
	 *    
	 *    pathToNode(1, 6) left = null right = [1, 3, 6]
	 *    			
	 */
	private static Stack<Tree> pathToNodeUtil(Tree root, Tree node) {

		if (root == null) {
			return null;
		}

		if (root == node) {
			Stack<Tree> temp = new Stack<>();
			temp.push(root);
			return temp;
		}

		Stack<Tree> left = pathToNodeUtil(root.left, node);
		Stack<Tree> right = pathToNodeUtil(root.right, node);

		if (left != null) {
			left.push(root);
			return left;
		}

		if (right != null) {
			right.push(root);
			return right;
		}
		return null;
	}
}
