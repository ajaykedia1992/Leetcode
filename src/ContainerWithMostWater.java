/*
 * https://leetcode.com/problems/container-with-most-water/
 * 
 */
public class ContainerWithMostWater {

	public static void main(String args[]) {
		int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(arr));
	}

	private static int maxArea(int[] arr) {
		int max = 0;

		int l = 0, r = arr.length - 1;

		while (l < r) {
			max = Math.max(max, Math.min(arr[l], arr[r]) * (r - l));
			if (arr[l] > arr[r]) {
				r--;
			} else {
				l++;
			}
		}
		return max;
	}

}
