
public class KDivisionMinimiseLargestSum {

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int k = 3;
		System.out.println(findTheMinimisedLargestSum(arr, k));
	}

	public static int findTheMinimisedLargestSum(int[] arr, int k) {

		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			max = Math.max(max, arr[i]);
		}

		long l = max, r = sum;

		while (l < r) {
			long mid = (l + r) / 2;
			if (valid(mid, arr, k)) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return (int) l;

	}

	private static boolean valid(long mid, int[] arr, int k) {
		int count = 1;
		int total = 0; 
		
		for(int  i = 0; i<arr.length; i++) {
			total += arr[i];
			if(total > mid) {
				total = arr[i];
				count++;
				if(count > k) {
					return false;
				}
			}
		}
		return true;
	}
}
