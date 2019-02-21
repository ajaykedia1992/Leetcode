import java.util.ArrayList;
import java.util.List;

public class SplitArrayToFibonacciSequence {

	public static void main(String args[]) {
		String str = "10100110";
		System.out.println(splitIntoFibonacci(str));
	}

	public static List<Integer> splitIntoFibonacci(String S) {

		int N = S.length();

		for (int i = 0; i < Math.min(10, N); i++) {
			if (S.charAt(0) == '0' && i > 0) {
				break;
			}
			long a = Long.parseLong(S.substring(0, i + 1));
			if (a >= Integer.MAX_VALUE) {
				break;
			}

			search: for (int j = i + 1; j < Math.min(i + 10, N); j++) {
				if (S.charAt(i + 1) == '0' && j > i + 1)
					break;
				long b = Long.parseLong(S.substring(i + 1, j + 1));
				if (b >= Integer.MAX_VALUE) {
					break;
				}

				List<Integer> fib = new ArrayList<Integer>();
				fib.add((int) a);
				fib.add((int) b);

				int k = j + 1;
				while (k < N) {
					int c = fib.get(fib.size() - 2) + fib.get(fib.size() - 1);
					String c_string = String.valueOf(c);
					if (c < Integer.MAX_VALUE && S.substring(k).startsWith(c_string)) {
						k += c_string.length();
						fib.add(c);
					}

					else
						continue search;

				}

				if (fib.size() >= 3) {
					return fib;
				}
			}

		}
		return new ArrayList<Integer>();
	}
}
