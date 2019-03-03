import java.util.ArrayList;
import java.util.List;

public class SubsetPowerSet {

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3 };
		List<List<Integer>> res = getSubset(arr);
		for (List<Integer> r : res) {
			System.out.println(r);
		}
	}

	private static List<List<Integer>> getSubset(int[] arr) {

		if (arr == null) {
			throw new IllegalArgumentException();
		}
		int poweSetSize = (int) Math.pow(2, arr.length);
		int setSize = arr.length;
		List<List<Integer>> result = new ArrayList<>();
		for (int counter = 0; counter < poweSetSize; counter++) {
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < setSize; i++) {
				if ((counter & (1 << i)) > 0) {
					temp.add(arr[i]);
				}
			}
			result.add(temp);
		}
		return result;
	}

}
