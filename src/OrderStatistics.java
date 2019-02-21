import java.util.Collections;
import java.util.PriorityQueue;

public class OrderStatistics {
	public static void main(String args[]) {
		int arr[] = {1,6,3,9,8,5,3,1,6,5};
		System.out.println(findKthSmallest(arr, 4));
		System.out.println(findKthLargest(arr, 4));
	}

	private static int findKthLargest(int[] arr, int k) {
		// min-heap
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int i = 0; i<arr.length; i++) {
			minHeap.add(arr[i]);
			if(minHeap.size()>k) {
				minHeap.poll();
			}
		}
		return minHeap.peek();
	}

	private static int findKthSmallest(int[] arr, int k) {
		//max-heap
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
		for(int i = 0; i<arr.length; i++) {
			maxHeap.add(arr[i]);
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		
		return maxHeap.peek();
	}
}

