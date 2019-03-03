import java.util.ArrayList;
import java.util.List;

public class PrintAllPath {
	public static void main(String args[]) {
		Tree root = new Tree(1);
		root.left = new Tree(3);
		root.left.left = new Tree(2);
		root.left.right = new Tree(1);
		root.left.right.left = new Tree(1);
		root.right = new Tree(-1);
		root.right.left = new Tree(4);
		root.right.left.left = new Tree(1);
		root.right.left.right = new Tree(2);
		root.right.right = new Tree(5);
		root.right.right.right = new Tree(2);

		List<Integer> list = new ArrayList<Integer>();
		printAllPath(root, list);

	}

	private static void printAllPath(Tree root, List<Integer> list) {
		if (root == null) {
			return;
		}

		list.add(root.data);
		if (root.left == null && root.right == null) {
			printList(list);
		} else {
			printAllPath(root.left, list);
			printAllPath(root.right, list);
		}
		list.remove(list.size() - 1);
	}

	private static void printList(List<Integer> list) {
		System.out.println(list);
	}
}
