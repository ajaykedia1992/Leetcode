class ListNode1 {
	int val;
	ListNode1 next;

	public ListNode1(int x) {
		val = x;
	}
}

public class RemoveNthNodeFromLast {

	public static void main(String args[]) {

		ListNode1 l = new ListNode1(1);
		l.next = new ListNode1(2);
		l.next.next = new ListNode1(3);
		l.next.next.next = new ListNode1(4);
		l.next.next.next.next = new ListNode1(5);
		ListNode1 head = removeNthFromEnd(l, 2);
		print(head);

	}

	private static void print(ListNode1 head) {
		while (head.next != null) {
			System.out.println(head.val + " ");
			head = head.next;
		}

	}

	public static int findSize(ListNode1 l) {
		int n = 1;
		while (l.next != null) {
			n++;
			l = l.next;
		}
		return n;
	}

	public static ListNode1 removeNthFromEnd(ListNode1 head, int n) {

		if (head == null) {
			return null;
		}

		if (n == 0) {
			return head;
		}

		ListNode1 curr = head;

		int size = findSize(curr);

		System.out.println(size);

		int l = size - n;

		while (curr.next != null) {
			if (l == 1) {
				ListNode1 p = curr.next;
				if (p.next != null) {
					curr.next = p.next;
				} else {
					curr.next = null;
				}
				break;
			}
			curr = curr.next;
			l--;
		}
		
		return head;
	}
}
