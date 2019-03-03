/*
 * Given a sorted array of n elements containing elements in range from 1 to n-1 i.e. one element occurs twice, the task is to find the repeating element in an array.

Examples :

Input :  arr[] = { 1, 2 , 3 , 4 , 4}
Output :  4

Input :  arr[] = { 1 , 1 , 2 , 3 , 4}
Output :  1

https://www.geeksforgeeks.org/find-repeating-element-sorted-array-size-n/
 */

public class FindRepeatingElement {

	public static void main(String args[]) {
		int arr[] = { 1, 1, 2, 3, 4 };
		System.out.println(arr[findRepeatingone(arr, 0, arr.length - 1)]);
	}

	private static int findRepeatingone(int[] arr, int i, int j) {

		if (arr == null) {
			return -1;
		}

		int mid = (i + j) / 2;

		if (mid >= 0 && arr[mid] != mid + 1) {
			if (arr[mid] == arr[mid - 1]) {
				return mid;
			}
			return findRepeatingone(arr, i, mid - 1);
		}
		return findRepeatingone(arr, mid + 1, j);
	}
}
