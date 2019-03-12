import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class NAryNode {
	public int val;
	public List<NAryNode> children;

	public NAryNode() {
	}

	public NAryNode(int _val, List<NAryNode> _children) {
		val = _val;
		children = _children;
	}
}

public class NAryTreePreOrderTraversal {
	List<Integer> l = new ArrayList<>();

	public List<Integer> preorder(NAryNode root) {
		if (root == null) {
			return l;
		}

		l.add(root.val);
		for (NAryNode c : root.children) {
			preorder(c);
		}
		return l;
	}

	public List<Integer> preorderStack(NAryNode root) {
		if (root == null) {
			return l;
		}

		Stack<NAryNode> stack = new Stack<NAryNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			NAryNode temp = stack.pop();
			l.add(temp.val);
			List<NAryNode> children = temp.children;
			if (children != null) {
				Collections.reverse(children);
				for (NAryNode c : children) {
					stack.push(c);
				}
			}
		}
		return l;
	}
}
