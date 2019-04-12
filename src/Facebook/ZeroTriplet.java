package Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ZeroTriplet {

	public static void main(String args[]) {
		int[] arr = { -1, 0, 1, 2, -1, -4 };
		List<int[]> result = findUniqueZeroTriplet(arr);

		for (int[] a : result) {
			System.out.println(Arrays.toString(a));
		}
	}

	private static List<int[]> findUniqueZeroTriplet(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}

		Arrays.sort(arr); // quick Sort O(nlogn)

		HashSet<int[]> result = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			int j = i;
			int k = arr.length - 1;
			while (j <= k) {
				long sum = (long) (arr[i] + arr[j] + arr[k]);
				if (sum == 0) {
					int[] temp = new int[] { arr[i], arr[j], arr[k] };
					result.add(temp);
					j++;
				} else if (sum > 0) {
					k--;
				} else {
					j++;
				}
			}
		}
		return new ArrayList<>(result);
	}
}
