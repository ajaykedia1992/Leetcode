
public class RepeatedPermutation {

	public static void main(String args[]) {
		String str = "cd";

		getAllRepeatedPermutation(str, 0, str.length() - 1);
	}

	private static void getAllRepeatedPermutation(String str, int low, int high) {

		if (str == null || str.length() == 0) {
			return;
		}

		if (low == high) {
			System.out.println(str);
		}

		for (int i = 0; i < high; i++) {
			str = swap(str, low, i);
			getAllRepeatedPermutation(str, low + 1, high);
			str = swap(str, low, i);
		}

	}

	private static String swap(String str, int low, int high) {

		char[] arr = str.toCharArray();

		char temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;

		return String.copyValueOf(arr);
	}

}
