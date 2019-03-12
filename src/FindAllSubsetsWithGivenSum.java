import java.util.ArrayList;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/recursive-program-to-print-all-subsets-with-given-sum/
 */
public class FindAllSubsetsWithGivenSum {

	public static void main(String args[]) {
		int arr[] = { 2, 5, 8, 4, 6, 11 };
		int sum = 13; // output : {5, 8}, {2,11}, {2,5,6}

		findAllSubsetsWithGivenSum(arr, sum);
	}

	private static void findAllSubsetsWithGivenSum(int[] arr, int sum) {

		findAllSubsetsWithGivenSum(arr, sum, new ArrayList<Integer>(), arr.length - 1);
	}

	private static void findAllSubsetsWithGivenSum(int[] arr, int sum, List<Integer> arrayList, int index) {

		if (arr == null || arr.length == 0) {
			return;
		}

		if (sum == 0) {
			System.out.println(arrayList);
			return;
		}

		if (index < 0) {
			return;
		}

		findAllSubsetsWithGivenSum(arr, sum, arrayList, index - 1);

		List<Integer> list = new ArrayList<>(arrayList);

		list.add(arr[index]);

		findAllSubsetsWithGivenSum(arr, sum - arr[index], list, index - 1);
	}
}
