import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	class DLinkedList {
		int key;
		int value;
		DLinkedList pre;
		DLinkedList post;
	}

	public void addNode(DLinkedList node) {
		node.post = head.post;
		node.pre = head;
		this.head.post.pre = node;
		this.head.post = node;
	}

	public void removeNode(DLinkedList node) {
		DLinkedList a = node.pre;
		DLinkedList b = node.post;
		a.post = b;
		b.pre = a;
	}

	public void moveToFront(DLinkedList node) {
		removeNode(node);
		addNode(node);
	}

	public DLinkedList popTail() {
		DLinkedList node = tail.pre;
		removeNode(node);
		return node;
	}

	DLinkedList head, tail;

	int capacity, count;

	Map<Integer, DLinkedList> map = null;

	public LRUCache(int capacity) {
		count = 0;
		this.capacity = capacity;
		head = new DLinkedList();
		tail = new DLinkedList();
		head.post = tail;
		tail.pre = head;
		map = new HashMap<Integer, DLinkedList>();
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}

		DLinkedList node = map.get(key);
		moveToFront(node);
		return node.value;
	}

	public void put(int key, int value) {

		if (map.containsKey(key)) {
			DLinkedList node = map.get(key);
			node.value = value;
			moveToFront(node);
		} else {
			DLinkedList node = new DLinkedList();
			node.key = key;
			node.value = value;
			addNode(node);
			map.put(key, node);
			count++;
			while(count > capacity) {
				DLinkedList temp = popTail();
				map.remove(temp.key);
				count--;
			}
		}
	}

	public static void main(String[] args) {

		LRUCache cache = new LRUCache(2);
		System.out.println(cache.get(2));
		cache.put(2, 6);
		System.out.println(cache.get(1));
		cache.put(1, 5);
		cache.put(1, 2);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));

	}

}