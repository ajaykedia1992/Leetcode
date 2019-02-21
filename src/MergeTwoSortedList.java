class ListNode {
	int val;
	ListNode next;

	ListNode() {

	}

	public ListNode(int x) {
		val = x;
	}
}

public class MergeTwoSortedList {

	public static ListNode createListNode(int[] arr) {
		ListNode root = null, temp = null;
		for (int i = 0; i < arr.length; i++) {
			if (root == null) {
				root = new ListNode(arr[i]);
				temp = root;
			} else {
				temp.next = new ListNode(arr[i]);
				temp = temp.next;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		int[] sort1 = { 2, 4, 5, 9, 10 };
		int[] sort2 = { 1, 4, 6, 8, 10, 12 };
		ListNode result = mergeTwoListRecursively(createListNode(sort1), createListNode(sort2));

		print(result);
	}

	private static void print(ListNode root) {
		while (root.next != null) {
			System.out.print(root.val + "->");
			root = root.next;
		}
		
		System.out.println(root.val);

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode prehead = new ListNode(-1);

		ListNode prev = prehead;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}

			prev = prev.next;

		}

		prev.next = l1 == null ? l2 : l1;
		return prehead.next;
	}
	
	public static ListNode mergeTwoListRecursively(ListNode l1, ListNode l2) {
		
		if(l1 == null) {
			return l2;
		}
		else if(l2 == null) {
			return l1;
		}
		
		else if(l1.val <= l2.val) {
			l1.next = mergeTwoListRecursively(l1.next, l2);
			return l1;
		}
		else {
			l2.next = mergeTwoListRecursively(l1, l2.next);
			return l2;
		}
	}
}