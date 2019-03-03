
public class CorrectFloorAndCeiling {

	public static void main(String args[]) {

		int[] arr = { -11, -5, 2, 8, 10, 10, 12, 19 };
		int k = 19;
		int ceilingIndex = getCeiling(arr, k);

		if (ceilingIndex == -1) {
			throw new IllegalArgumentException();
		}

		else if (ceilingIndex == arr.length) {
			System.out.println("There is no ceiling and floor = " + arr[ceilingIndex - 1]);
		}

		else if (ceilingIndex == -2) {
			System.out.println("There is no floor and ceiling = " + arr[0]);
		} else if (k == arr[ceilingIndex]) {
			System.out.println("Floor and ceiling are same = " + arr[ceilingIndex]);
		} else {
			System.out.println("Floor = " + arr[ceilingIndex - 1] + ", ceil = " + arr[ceilingIndex]);
		}

	}

	private static int getCeiling(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		if (k < arr[0]) {
			return -2;
		}

		if (k > arr[arr.length - 1]) {
			return arr.length;
		}

		int low = 0;
		int high = arr.length - 1;

		return searchForCeiling(arr, k, low, high);
	}

	private static int searchForCeiling(int[] arr, int k, int low, int high) {

		int mid = (low + high) / 2;

		if (k == arr[mid]) {
			return mid;
		}

		else if (arr[mid] < k) {
			if (mid + 1 <= high && k <= arr[mid + 1]) {
				return mid + 1;
			} else {
				return searchForCeiling(arr, k, mid + 1, high);
			}
		} else {
			if (mid - 1 >= low && k > arr[mid - 1]) {
				return mid;
			} else {
				return searchForCeiling(arr, k, low, mid - 1);
			}
		}
	}
}
