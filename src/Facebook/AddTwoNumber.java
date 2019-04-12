package Facebook;

public class AddTwoNumber {

	public static void main(String args[]) {
		int[] a = { 1 };
		ListNode l = new ListNode();
		ListNode l1 = l.insert(a);
		int[] b = { 9, 9, 9, 9 };
		ListNode l2 = l.insert(b);
		AddTwoNumber add = new AddTwoNumber();
		ListNode head = add.addTwoNumbers(l1, l2);
		add.print(head);

	}

	public void print(ListNode head) {
		while (head.next != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.print(head.val);
		System.out.println();
	}

	public ListNode reverseLinkedList(ListNode head) {
		ListNode first = head;
		ListNode prev = null;
		while (first.next != null) {
			ListNode second = first.next;
			first.next = prev;
			prev = first;
			first = second;
		}
		if (first != null) {
			first.next = prev;
		}
		return first;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}

		l1 = reverseLinkedList(l1);
		l2 = reverseLinkedList(l2);

		print(l1);
		print(l2);

		ListNode result = null;

		int carry = 0;
		ListNode temp = null;
		while (l1 != null && l2 != null) {
			int val = l1.val + l2.val + carry;
			if (result == null) {
				result = new ListNode(val >= 10 ? val % 10 : val);
				temp = result;
			} else {
				temp.next = new ListNode(val >= 10 ? val % 10 : val);
				temp = temp.next;
			}
			l1 = l1.next;
			l2 = l2.next;
			carry = val / 10;
		}

		if (l1 != null) {
			temp.next = l1;
			do {
				temp = temp.next;
				int val = temp.val + carry;
				temp.val = val % 10;
				carry = val / 10;
			}while(carry != 0 && temp.next != null);
		}

		else if (l2 != null) {
			temp.next = l2;
			do {
				temp = temp.next;
				int val = temp.val + carry;
				temp.val = val % 10;
				carry = val / 10;
				
			}while(carry != 0 && temp.next != null);
		}
		if (carry != 0) {
			temp.next = new ListNode(carry);
		}

		return reverseLinkedList(result);
	}
}
