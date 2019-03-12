import java.util.PriorityQueue;

public class MinimumCostFile {

	public static void main(String args[]) {
		int[] files = { 8, 4, 6, 10 };
		System.out.println(getFindMinimumCostFile(files));
	}

	private static int getFindMinimumCostFile(int[] files) {
		if (files == null || files.length == 0) {
			return 0;
		}

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

		for (int i : files) {
			queue.add(i);
		}

		int result = 0;

		if (queue.size() == 1) {
			return queue.poll();
		} else {
			while (!queue.isEmpty() && queue.size() >= 2) {
				int first = queue.poll();
				int second = queue.poll();
				result += first + second;
				queue.add(first + second);
			}
		}

		return result;
	}
}
