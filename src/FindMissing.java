import java.util.HashMap;
import java.util.Map;

public class FindMissing {
	public static void main(String args[]) {
		int a[] = { Integer.MIN_VALUE, -2, -3, -4 };
		int b[] = { -2, -3, -4, -5, Integer.MIN_VALUE };

		System.out.println(getMissing(a, b));

		System.out.println(getMissingXOR(a, b));

		System.out.println(getMissingAddSubtractMethod(a, b));
	}

	private static int getMissing(int[] a, int[] b) {

		if (a.length > b.length) {
			return getMissing(b, a);
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < a.length; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
		}

		for (int i = 0; i < b.length; i++) {
			if (map.get(b[i]) == null || map.get(b[i]) == 0) {
				return b[i];
			} else {
				map.put(b[i], map.get(b[i]) - 1);
			}
		}
		return -1;
	}

	private static int getMissingXOR(int[] a, int[] b) {
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			temp ^= a[i];
		}

		for (int i = 0; i < b.length; i++) {
			temp ^= b[i];
		}
		return temp;
	}

	private static int getMissingAddSubtractMethod(int[] smaller, int[] bigger) {
		int sum = 0;
		int i = 0, j = 0;
		while (i < bigger.length && j < smaller.length) {
			if (sum < 0) {
				sum += bigger[i];
				i++;
			} else {
				sum -= smaller[j];
				j++;
			}
		}

		while (i < bigger.length) {
			sum += bigger[i];
			i++;
		}
		while (j < smaller.length) {
			sum -= smaller[j];
			j++;
		}

		return sum;
	}

}
