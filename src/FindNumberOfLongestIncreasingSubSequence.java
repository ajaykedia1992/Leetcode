
public class FindNumberOfLongestIncreasingSubSequence {

	public static void main(String args[]) {
		int arr[] = { 1, 3, 5, 4, 7 };

		System.out.println(findNumberOfLongestIncreasingSubSequence(arr));
	}

	private static int findNumberOfLongestIncreasingSubSequence(int[] arr) {

		if (arr == null || arr.length == 0) {
			return 0;
		}

		int maxLen = 0;
		int n = arr.length;
		int len[] = new int[n];
		int cnt[] = new int[n];
		int res = 0;

		for (int i = 0; i < n; i++) {
			len[i] = cnt[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					if (len[i] == len[j] + 1) {
						cnt[i] += cnt[j];
					}
					if (len[i] < len[j] + 1) {
						len[i] = len[j] + 1;
						cnt[i] = cnt[j];
					}
				}
			}
			if (maxLen == len[i]) {
				res += cnt[i];
			}
			if (maxLen < len[i]) {
				maxLen = len[i];
				res = cnt[i];
			}
		}

		return res;
	}
}
