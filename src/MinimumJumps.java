import java.util.Arrays;

public class MinimumJumps {

	public static void main(String args[]) {
		int[] arr = { 2, 1, 1, 3, 1, 4, 2 };
		int N = arr.length;
		int result = findMinimumJump(arr, N);
		System.out.println("No. of jumps = " + result);
	}

	private static int findMinimumJump(int[] arr, int N) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		int[] countArray = new int[N];
		Arrays.fill(countArray, 1, N, Integer.MAX_VALUE);

		int[] indexArray = new int[N];
		for (int i = 0; i < N; i++) {
			indexArray[i] = i;
		}

		for (int j = 1; j < N; j++) {
			int i = 0;
			while (i < j) {
				if (i + arr[i] >= j) {
					if (countArray[j] > countArray[i] + 1) {
						indexArray[j] = i;
						countArray[j] = countArray[i] + 1;
					}
				}
				i++;
			}
		}

		findJumpingIndex(indexArray);

		return countArray[N - 1];
	}

	private static void findJumpingIndex(int[] indexArray) {
		System.out.println(Arrays.toString(indexArray));

		for (int i = indexArray.length - 1; i >= 0; i--) {

			if (i - 1 > 0) {
				if (indexArray[i] == indexArray[i - 1]) {
					continue;
				}
				System.out.println("index = " + indexArray[i]);
			}
		}

		System.out.println("index = " + indexArray[0]);
	}

}
