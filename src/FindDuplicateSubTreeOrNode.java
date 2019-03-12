import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 			1
 *        2    3
 *      4     2  4
 *          4    
 *         
 * Preorder: 10 1 5 2 3 2 3 5        
 * Ans: 2     5
 *     3
 */

public class FindDuplicateSubTreeOrNode {

	static Map<String, Integer> map = new HashMap<>();

	static List<Tree> list = new ArrayList<>();

	public static void main(String args[]) {

		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);
		root.left.left = new Tree(4);
		root.right.left = new Tree(2);
		root.right.left.left = new Tree(4);
		root.right.right = new Tree(4);
		preorder(root);
		System.out.println();
		findDuplicates(root);
		list.stream().forEach(x -> System.out.println(x.data));
	}

	private static String findDuplicates(Tree root) {
		if (root == null) {
			return "X";
		}
		String left = findDuplicates(root.left);
		String right = findDuplicates(root.right);

		String result = "" + root.data + left + right;

		map.put(result, map.getOrDefault(result, 0) + 1);
		if (map.get(result) == 2) {
			list.add(root);
		}

		return result;
	}

	private static void preorder(Tree root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
}

