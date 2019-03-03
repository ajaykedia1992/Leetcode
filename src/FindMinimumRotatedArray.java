/*
 * this is just an experiment
 */
public class FindMinimumRotatedArray {

	public static void main(String args[]) {
		int[] arr = { 4,4,4,4, 5, 1,1, 2, 3 };
		System.out.println(new FindMinimumRotatedArray().findMin(arr, 0, arr.length - 1));
	}

	int findMin(int arr[], int start, int end) {
		if (start == end) {
			return arr[start];
		}
		int mid = (start + end) / 2;
		if (arr[start] > arr[mid]) {
			// min element lies in left subarray
			return findMin(arr, start, mid);
		} else if (arr[mid] > arr[end]) {
			// min element lies in right subarray
			return findMin(arr, mid + 1, end);
		} else {
			// array is sorted but not rotated
			return arr[start];
		}
	}
}
