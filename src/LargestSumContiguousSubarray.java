import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestSumContiguousSubarray {
	public static void main(String args[]) {
		int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int result = findSumContiguousSubarray(arr);
		System.out.println(result);

	}

	private static int findSumContiguousSubarray(int[] arr) {

		int[] sumArray = Arrays.copyOf(arr, arr.length);
		int[] index = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			index[i] = i;
		}

		for (int i = 0, j = 1; i < arr.length - 1; i++, j++) {
			if (sumArray[i] + arr[j] > sumArray[j]) {
				sumArray[j] = sumArray[i] + arr[j];
				index[j] = i;
			}
		}

		// System.out.println(Arrays.toString(sumArray));
		System.out.println(Arrays.toString(index));

		int max = Integer.MIN_VALUE;
		int ind = -1;
		for (int i = 0; i < sumArray.length; i++) {
			if (sumArray[i] > max) {
				max = sumArray[i];
				ind = i;
			}
		}

		List<Integer> result = new ArrayList<Integer>();

		result.add(arr[ind]);

		while ((ind - 1 >= 0) && (index[ind] != index[ind - 1])) {
			result.add(arr[index[ind]]);
			ind--;
		}
		result.add(arr[ind - 1]);
		result.stream().map(x -> x).forEach(x -> System.out.print(x + " "));
		System.out.println();
		return max;
	}
}
