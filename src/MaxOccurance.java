import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Occurance implements Comparable<Occurance> {
	int num;
	int occurance;

	Occurance(int num, int occurance) {
		this.num = num;
		this.occurance = occurance;
	}


	@Override
	public int compareTo(Occurance o) {
		int compareResult = Integer.compare(this.occurance, o.occurance);
		return compareResult == 0 ? Integer.compare(this.num, o.num) : compareResult;
	}
}

public class MaxOccurance {

	public static void main(String args[]) {
		int nums[] = { 3, 1, 1, 4, 4, 5, 7, 4, 2, 6, 1 };

		MaxOccurance m = new MaxOccurance();
		List<Integer> result = m.getMaxOccurance(nums, 4);
		result.forEach(nb -> System.out.print(nb + " "));
	}

	private List<Integer> getMaxOccurance(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}

		// creating min-heap

		PriorityQueue<Occurance> priorityQueue = new PriorityQueue<Occurance>();

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Occurance o = new Occurance(entry.getKey(), entry.getValue());
			priorityQueue.offer(o);
			if (priorityQueue.size() > k) {
				priorityQueue.poll();
			}
		}

		List<Integer> result = new ArrayList<Integer>();
		while (priorityQueue.size() > 0) {
			result.add(priorityQueue.poll().num);
		}
		Collections.reverse(result);

		return result;

	}
}
