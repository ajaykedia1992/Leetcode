import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VerticalSumBinaryTree {

	public static void main(String args[]) {
		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);
		root.left.left = new Tree(4);
		root.left.right = new Tree(5);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);

		Map<Integer, Integer> map = findVeticalSum(root);

		if (map == null) {
			throw new IllegalArgumentException();
		}
		Set<Integer> keys = map.keySet();
		List<Integer> list = new ArrayList<>(keys);
		Collections.sort(list);
		list.stream().map(x -> x).forEach(x -> System.out.print(map.get(x) + " "));
	}

	private static Map<Integer, Integer> findVeticalSum(Tree root) {
		if (root == null) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		helper(map, root, 0);
		return map;
	}

	private static void helper(Map<Integer, Integer> map, Tree root, int c) {
		if (root.left != null) {
			helper(map, root.left, c - 1);
		}
		if (root.right != null) {
			helper(map, root.right, c + 1);
		}
		int data = 0;
		if (map.containsKey(c)) {
			data = map.get(c);
		}

		map.put(c, root.data  + data);
	}
}
