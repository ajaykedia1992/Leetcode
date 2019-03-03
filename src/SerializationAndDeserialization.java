import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializationAndDeserialization {

	final static String END = "X";
	final static String SPLITTER = ",";

	public static void main(String args[]) {
		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);
		root.right.left = new Tree(4);
		root.right.right = new Tree(5);
		preOrder(root);
		System.out.println();
		StringBuffer str = new StringBuffer("");
		serialize(root, str);
		deserialize(str);
	}

	private static void deserialize(StringBuffer str) {
		Queue<String> queue = new LinkedList<String>();
		queue.addAll(Arrays.asList(str.toString().split(SPLITTER)));
		Tree root = deserializeUtil(queue);
		preOrder(root);

	}

	private static void preOrder(Tree root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}

	}

	private static Tree deserializeUtil(Queue<String> queue) {

		if (queue.peek().equals(END)) {
			queue.remove();
			return null;
		}

		String data = queue.remove();

		Tree head = new Tree(Integer.parseInt(data));
		head.left = deserializeUtil(queue);
		head.right = deserializeUtil(queue);
		return head;
	}

	private static void serialize(Tree root, StringBuffer str) {
		serializeUtil(root, str);
		str.delete(str.length() - 1, str.length());
	}

	private static void serializeUtil(Tree root, StringBuffer str) {

		if (root == null) {
			str.append(END);
			str.append(SPLITTER);
			return;
		}

		str.append(root.data).append(SPLITTER);
		serializeUtil(root.left, str);
		serializeUtil(root.right, str);

	}
}
