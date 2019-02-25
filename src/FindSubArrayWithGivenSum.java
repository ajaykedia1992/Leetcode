import java.util.HashMap;
import java.util.Map;

public class FindSubArrayWithGivenSum {

	public static void main(String args[]) {
		int[] arr = { 10, 2, -2, -20, 10 };
		int sum = -20;

		// output => 0 to 3

		findSubArrayWithGivenSum(arr, sum);
	}

	private static void findSubArrayWithGivenSum(int[] arr, int sum) {

		if (arr == null || arr.length == 0) {
			return;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int curr_sum = 0, start = 0, end = -1;

		for (int i = 0; i < arr.length; i++) {
			curr_sum += arr[i];
			if (curr_sum - sum == 0) {
				start = 0;
				end = i;
				break;
			}

			// This condition apply when we are having extra sum which we have to remove to
			// get the require sum
			if (map.containsKey(curr_sum - sum)) {
				start = map.get(curr_sum - sum) + 1;
				end = i;
				break;
			}
			map.put(curr_sum, i);
		}

		if (end == -1) {
			System.out.println("No range is available for the given sum ");
		} else {
			System.out.println("curr sum found at start: " + start + " end: " + end);
		}
	}
}
