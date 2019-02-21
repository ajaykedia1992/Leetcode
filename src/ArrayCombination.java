import java.util.Arrays;

class Node {
	String dataString;
	Node left;
	Node right;

	public Node(String dataString) {
		this.dataString = dataString;
	}

	public String getDataString() {
		return dataString;
	}

}

public class ArrayCombination {

	public static void main(String args[]) {
		int[] arr = { 1, 2, 1 };
		findCombination(arr);
	}

	private static void findCombination(int[] arr) {
		Node root = createTree(0, "", arr);
		printLeafNode(root);
	}

	private static void printLeafNode(Node root) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			System.out.print(root.dataString + " ");
		}
		printLeafNode(root.left);
		printLeafNode(root.right);
	}

	private static Node createTree(int data, String str, int[] arr) {

		if (data > 26) {
			return null;
		}

		String dataString = str + getAlphabets(data);

		Node root = new Node(dataString);

		if (arr.length != 0) {

			data = arr[0];

			int[] newArray = Arrays.copyOfRange(arr, 1, arr.length);

			root.left = createTree(data, dataString, newArray);

			if (arr.length > 1) {
				
				data = arr[0] * 10 + arr[1];

				newArray = Arrays.copyOfRange(arr, 2, arr.length);

				root.right = createTree(data, dataString, newArray);
			}

		}
		return root;
	}

	private static String getAlphabets(int i) {
		String[] alphabets = { "", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
				"r", "s", "t", "u", "v", "w", "x", "y", "z" };
		return alphabets[i];
	}
}
