import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of integers where each value 1 <= x <= len
 */
public class FindAllDuplicates {

	public static void main(String args[]) {

		int arr[] = { 2, 1, 2, 1, 3, 5, 4, 2, 3, 1, 4 };

		System.out.println(findDuplicates(arr));
	}

	private static Set<Integer> findDuplicates(int[] arr) {
		Set<Integer> resultSet = new HashSet<>();

		if (arr == null || arr.length == 0) {
			return resultSet;
		}

		for (int i = 0; i < arr.length; i++) {
			int number = Math.abs(arr[i]);
			if (arr[number - 1] < 0 && !resultSet.contains(arr[i])) {
				resultSet.add(arr[i]);
			} else {
				arr[number - 1] *= -1;
			}
		}
		return resultSet;
	}
}
