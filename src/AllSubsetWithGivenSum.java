import java.util.ArrayList;
import java.util.List;

public class AllSubsetWithGivenSum {

	static List<List<Integer>> result = new ArrayList<>();

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int sum = 10;
		findAllSubsetWithGivenSum(arr, arr.length, new ArrayList<Integer>(), sum);
	}

	private static void findAllSubsetWithGivenSum(int[] arr, int n, List<Integer> r, int sum) {

		if (sum == 0) {
			System.out.println(r);
			return;
		}

		if (n == 0) {
			return;
		}

		findAllSubsetWithGivenSum(arr, n - 1, r, sum);
		List<Integer> r1 = new ArrayList<>(r);
		r1.add(arr[n - 1]);
		findAllSubsetWithGivenSum(arr, n - 1, r1, sum - arr[n - 1]);
	}

}