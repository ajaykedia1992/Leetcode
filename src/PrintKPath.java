import java.util.ArrayList;
import java.util.List;

public class PrintKPath {

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
		printKPath(root, list, 5);
	}

	private static void printKPath(Tree root, List<Integer> list, int K) {
		if (root == null) {
			return;
		}
		list.add(root.data);
		printKPath(root.left, list, K);
		printKPath(root.right, list, K);

		int f = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			f += list.get(i);
			if (f == K) {
				print(list, i);
			}
		}
		// remove the current element from the list
		list.remove(list.size() - 1);
	}

	private static void print(List<Integer> list, int i) {
		for (int k = i; k < list.size(); k++) {
			System.out.print(list.get(k) + " ");
		}
		System.out.println();
	}
}
