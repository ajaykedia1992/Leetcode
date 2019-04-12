package Facebook;

public class SwapPair {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	ListNode head;

	SwapPair() {
		head = null;
	}

	public ListNode swapPairs() {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode first = head;
		ListNode next = first.next;
		ListNode prev = new ListNode(0);
		ListNode dummies = prev;
		while (next != null) {

			first.next = next.next;
			next.next = first;
			prev.next = next;
			prev = first;
			if (first.next == null) {
				break;
			}

			first = first.next;
			next = first.next;
		}

		return dummies.next;
	}

	public static void main(String args[]) {

		SwapPair s = new SwapPair();
		s.head = s.new ListNode(1);
		s.head.next = s.new ListNode(2);
		s.head.next.next = s.new ListNode(3);
		s.head.next.next.next = s.new ListNode(4);

		s.head = s.swapPairs();

		s.printListNode(s.head);

	}

	private void printListNode(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}
}
