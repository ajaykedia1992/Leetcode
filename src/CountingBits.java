import java.util.Arrays;

public class CountingBits {
	public int[] countBits(int num) {
		int[] result = new int[num + 1];
		int j = 0;
		for (int i = 0; i <= num; i++) {
			int n = i;
			int count = 0;
			while (n > 0) {
				if ((int) (n & 1) == 1) {
					count++;
					n >>= 1;
				} else {
					n >>= 1;
				}
			}
			result[j++] = count;
		}
		return result;
	}

	public static void main(String args[]) {
		CountingBits c = new CountingBits();
		int n = 5;
		System.out.println(Arrays.toString(c.countBits(n)));
	}
}
