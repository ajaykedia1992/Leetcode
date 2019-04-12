package Facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}

	ListNode() {

	}

	public ListNode insert(int[] data) {
		ListNode head = null;
		ListNode curr = head;
		for (int d : data) {
			if (head == null) {
				head = new ListNode(d);
				curr = head;
			} else {
				ListNode node = new ListNode(d);
				curr.next = node;
				curr = node;
			}
		}

		return head;
	}
}

public class MergeKListNode {

	public static void main(String args[]) {
		MergeKListNode m = new MergeKListNode();
		ListNode head = new ListNode();
		ListNode[] listNode = new ListNode[5];
		listNode[0] = head.insert(new int[] { 1, 2, 3, 4, 5 });
		listNode[1] = head.insert(new int[] { 5, 9, 11, 15, 20 });
		listNode[2] = head.insert(new int[] { 3, 5, 9, 12, 30 });
		listNode[3] = head.insert(new int[] { 5, 7, 9, 11, 13 });
		listNode[4] = head.insert(new int[] { 1, 4, 5, 6, 7 });
		head = m.mergeKLists(listNode);
		m.print(head);
	}

	private void print(ListNode head) {
		if (head == null) {
			System.out.println("Empty list");
			return;
		}
		ListNode curr = head;

		while (curr.next != null) {
			System.out.print(curr.val + " -> ");
			curr = curr.next;
		}
		System.out.print(curr.val);
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {

				Integer first = new Integer(o1.val);
				Integer second = new Integer(o2.val);
				return first.compareTo(second);
			}
		});

		for (ListNode l : lists) {
			if (l != null) {
				priorityQueue.add(l);
			}
		}

		ListNode head = null;
		ListNode curr = head;

		while (!priorityQueue.isEmpty()) {

			ListNode temp = priorityQueue.poll();

			if (head == null) {
				head = new ListNode(temp.val);
				curr = head;
			} else {
				curr.next = new ListNode(temp.val);
				curr = curr.next;
			}
			temp = temp.next;			
			if (temp != null) {
				priorityQueue.add(temp);
			}
		}

		return head;
	}

}
