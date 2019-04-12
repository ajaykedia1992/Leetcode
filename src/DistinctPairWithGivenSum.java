import java.util.Arrays;

public class DistinctPairWithGivenSum {

	static int countPairsWithDiffK(int arr[], int n, int k) {
		int count = 0;
		Arrays.sort(arr); // Sort array elements

		int l = 0;
		int r = n - 1;
		while (l < r) {
			if (arr[r] + arr[l] == k) {
				count++;
				l++;
				r--;
			} else if (arr[r] + arr[l] > k)
				r--;
			else // arr[r] - arr[l] < sum
				l++;
		}
		return count;
	}

	// Driver program to test above function
	public static void main(String[] args) {
		int arr[] = {6,6,3,9,3,5,1};
		int n = arr.length;
		int k = 12;
		System.out.println("Count of pairs with given diff is " + countPairsWithDiffK(arr, n, k));
	}
}
