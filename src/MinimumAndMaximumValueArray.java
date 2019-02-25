class Pair {
	int min;
	int max;

	public Pair(int min, int max) {
		this.max = max;
		this.min = min;
	}

	public Pair() {

	}

	@Override
	public String toString() {
		return "Pair [min=" + min + ", max=" + max + "]";
	}

}

public class MinimumAndMaximumValueArray {

	public static void main(String args[]) {
		int[] arr = { 1, 60, -10, 70, -80, 85 };
		int n = arr.length;
		findMinimum(arr, n);
		Pair pair = findMinimum1(arr, 0, n - 1);
		System.out.println(pair);
	}

	private static void findMinimum(int[] arr, int n) {
		int minimum = Integer.MAX_VALUE, maximum = Integer.MIN_VALUE;

		if (arr.length == 1) {
			minimum = arr[0];
			maximum = arr[1];
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < minimum) {
				minimum = arr[i];
			}
			if (arr[i] > maximum) {
				maximum = arr[i];
			}
		}

		System.out.println("minimum = " + minimum + " , maximum = " + maximum);

	}

	private static Pair findMinimum1(int[] arr, int low, int high) {

		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException();
		}

		Pair pair = new Pair();
		Pair leftPair, rightPair;
		if (low == high) {
			pair.min = arr[low];
			pair.max = arr[low];
			return pair;
		}

		if (low + 1 == high) {
			if (arr[low] > arr[high]) {
				pair.min = arr[high];
				pair.max = arr[low];
			} else {
				pair.max = arr[high];
				pair.min = arr[low];
			}
			return pair;
		}

		int mid = (low + high) / 2;
		leftPair = findMinimum1(arr, low, mid);
		rightPair = findMinimum1(arr, mid + 1, high);

		if (leftPair.min > rightPair.min) {
			pair.min = rightPair.min;
		} else {
			pair.min = leftPair.min;
		}

		if (leftPair.max > rightPair.max) {
			pair.max = leftPair.max;
		} else {
			pair.max = rightPair.max;
		}

		return pair;

	}
}
