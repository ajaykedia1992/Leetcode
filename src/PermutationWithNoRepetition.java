public class PermutationWithNoRepetition {

	public static void main(String args[]) {
		String str = "ABC";
		PermutationWithNoRepetition sp = new PermutationWithNoRepetition();
		sp.calculatePermutation(str, 0, str.length() - 1);
		
		int arr[] = {1,2,3};
	}

	private void calculatePermutation(String str, int l, int r) {
		if (str != null || str.length() != 0) {
			if (l == r) {
				System.out.println(str);
			} else {
				for (int i = l; i <= r; i++) {
					str = swap(str, l, i);
					calculatePermutation(str, l + 1, r);
					str = swap(str, l, i);
				}
			}
		}

	}

	private String swap(String str, int i, int j) {
		char[] arr = str.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return String.valueOf(arr);
	}

}
