
public class PalindromInALinkedList {

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "" + data;
		}

	}

	Node head;

	public PalindromInALinkedList() {
		head = null;
	}

	public void insert(int d) {
		Node curr = head;
		if (curr == null) {
			curr = new Node(d);
			head = curr;
		} else {
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = new Node(d);
		}
	}

	public void printNode() {

		Node curr = head;

		while (curr.next != null) {
			System.out.print(curr + "->");
			curr = curr.next;
		}
		System.out.println(curr);
	}

	public static void main(String args[]) {
		int[] arr = { 1, 3, 8, 2, 3, 1 };
		PalindromInALinkedList p = new PalindromInALinkedList();
		for (int i : arr) {
			p.insert(i);
		}

		p.printNode();

		System.out.println(p.checkPalindrom());
	}

	private boolean checkPalindrom() {
		Node curr = head;

		Node slow, fast;
		slow = fast = curr;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// slow is quit in middle

		fast = slow.next;
		slow.next = null;

		Node a = reveseLinkedList(fast);

		slow = head;

		while (slow.next != null && a.next != null) {
			if (slow.data != a.data) {
				return false;
			}
			slow = slow.next;
			a = a.next;
		}
		return true;
	}

	private Node reveseLinkedList(Node fast) {
		Node prev = null;
		Node curr = fast;
		Node temp = curr.next;
		while (temp != null) {
			curr.next = prev;
			prev = curr;
			curr = temp;
			temp = temp.next;
		}

		curr.next = prev;

		return curr;
	}
}
