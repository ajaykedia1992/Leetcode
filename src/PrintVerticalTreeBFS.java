import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

class INode {
    int index;
    Tree tnode;
    
    INode(Tree tnode, int index) {
        this.tnode = tnode; 
        this.index = index; 
    }
}


public class PrintVerticalTreeBFS {
	
	public static void main(String args[]) {
		Tree root = new Tree(3);
		root.left = new Tree(9);
		root.right = new Tree(20);
		root.right.left = new Tree(15);
		root.right.right = new Tree(7);

		List<List<Integer>> res = verticalOrder(root);

		for (List<Integer> r : res) {
			r.forEach(x -> System.out.print(x + " "));
			System.out.println();
		}

	}


	public static List<List<Integer>> verticalOrder(Tree root) {

		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		Queue<INode> q = new LinkedList<>();

		q.offer(new INode(root, 0));
		while (!q.isEmpty()) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				INode node = q.poll();
				if (node.tnode != null) {
					List<Integer> list = map.computeIfAbsent(node.index, l -> new ArrayList<>());
					list.add(node.tnode.data);
					if (node.tnode.left != null) {
						q.add(new INode(node.tnode.left, node.index - 1));
					}
					if (node.tnode.right != null) {
						q.add(new INode(node.tnode.right, node.index + 1));
					}
				}
			}
		}

		return new ArrayList(map.values());
	}
}
