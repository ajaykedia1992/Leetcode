
public class PermutationWithRepition {

	public static void main(String args[]) {
		char[] str = { 'a', 'b', 'c' };
		getAllPermutation(str, str.length, "");
	}

	private static void getAllPermutation(char[] str, int n, String start) {

		if (str == null || str.length == 0) {
			return;
		}

		if (start.length() == n) {
			System.out.println(start);
			return;
		}

		for (char c : str) {
			getAllPermutation(str, n, start + c);
		}

	}

}
