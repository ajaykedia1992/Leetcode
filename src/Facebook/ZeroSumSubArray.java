package Facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubArray {

	public static void main(String args[]) {
		int arr[] = { -1, 2, -1, -1, 2, -1 };
		System.out.println(Arrays.toString(findZeroSumSubArray(arr)));
	}

	private static int[] findZeroSumSubArray(int[] arr) {

		if (arr == null || arr.length == 0) {
			return null;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int sum = 0;

		for (int i = 0; i <= arr.length; i++) {
			Integer oldIndex = map.get(sum);
			if (oldIndex == null && i == arr.length) {
				return null;
			}
			if (oldIndex == null) {
				map.put(sum, i);
				sum += arr[i];
			} else {
				return Arrays.copyOfRange(arr, oldIndex, i);
			}
		}

		return null;
	}
}
