import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class PrintVerticalTreeDFS {

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
		List<List<Integer>> res = new ArrayList<>();

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		map.put(0, new ArrayList<>());
		getVerticalOrder(root, 0, map);

		TreeSet<Integer> set = new TreeSet<>();
		set.addAll(map.keySet());
		for (int i : set) {
			res.add(map.get(i));
		}

		return res;
	}

	private static void getVerticalOrder(Tree root, int i, Map<Integer, List<Integer>> map) {

		if (root == null) {
			return;
		}

		if (map.containsKey(i)) {
			List<Integer> l = map.get(i);
			l.add(root.data);
			map.put(i, l);
		} else {
			List<Integer> l = new ArrayList<>();
			l.add(root.data);
			map.put(i, l);
		}

		if (root.left != null) {
			getVerticalOrder(root.left, i - 1, map);
		}
		if (root.right != null) {
			getVerticalOrder(root.right, i + 1, map);
		}

	}

}
