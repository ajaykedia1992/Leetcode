import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CreateBigArray {

	public static void main(String args[]) {
		int[][] mainArray = { { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 },
				{ 1, 2, 3, 4, 5 } };
		System.out.println(Arrays.toString(createBigArray(mainArray)));
	}

	public static int[] createBigArray(int[][] mainArray) {
		int[] finalArray;
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int[] A : mainArray) {
			for (int b : A) {
				if (queue.size() > 1024) {
					queue.poll();
				}
				queue.add(b);
			}
		}

		finalArray = new int[queue.size()];
		int k = 0;
		while (!queue.isEmpty()) {
			finalArray[k++] = queue.poll();
		}
		return finalArray;
	}
}
