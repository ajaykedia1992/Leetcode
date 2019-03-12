public class SingleLinkedList {
	class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "" + val;
		}

	}

	Node head;

	public SingleLinkedList() {
		head = null;
	}

	public void insert(int val) {
		Node current = head;
		if (current == null) {
			current = new Node(val);
			head = current;
		} else {
			while (current.next != null) {
				current = current.next;
			}
			Node temp = new Node(val);
			current.next = temp;
		}
	}

	public static void main(String args[]) {

		int[] data = { 1, 2, 3, 4, 5, 6 };

		SingleLinkedList s = new SingleLinkedList();
		for (int i = 0; i < data.length; i++) {
			s.insert(data[i]);
		}

		s.print(s.head);
		
		System.out.println("\n" + s.findKthNodeFromLast(s.head, 2));
	}

	private void print(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr + "->");
			curr = curr.next;
		}
		System.out.print(curr);
	}

	private Node findKthNodeFromLast(Node head, int k) {
		Node current = head;
		int count = size(current);
		if(k > count) {
			return null;
		}
		int low = 1;
		while(low < count - k) {
			current = current.next;
			low++;
		}
		return current;
	}

	private int size(Node head) {
		Node curr = head;
		int count = 0;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		return count;
	}
}
