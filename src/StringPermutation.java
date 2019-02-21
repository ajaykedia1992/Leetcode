public class StringPermutation {

	public static void main(String args[]) {
		String str = "ABC";
		StringPermutation sp = new StringPermutation();
		sp.calculatePermutation(str, 0, str.length() - 1);
	}

	private void calculatePermutation(String str, int l, int r) {
		if (str != null || str.length() != 0) {
			if (l == r) {
				System.out.println(str);
			} else {
				for (int i = l; i <= r; i++) {
					if (l != i) {
						str = swap(str, l, i);
					}
					calculatePermutation(str, l + 1, r);
					if (l != i) {
						str = swap(str, l, i);
					}
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
