/*
 * This program will take binary data in stream and will check that a number is divisible by passed number
 */

public class BinaryStreamCheckDivisibility {

	static int num = 0;

	public static void main(String args[]) {
		int arr[] = { 1, 0, 1, 0, 1 };

		for (int i : arr) {
			checkDivisibility(i, 3);
		}
	}

	private static void checkDivisibility(int i, int n) {

		if (i > 1 || i < 0) {
			return;
		}
		if (i == 1) {
			num = (num * 2 + 1) % n; // it will help in overflow of integer value
		} else if (i == 0) {
			num = (num * 2) % n;
		}

		if (num % n == 0) {
			System.out.println(num + " is divisible by " + n);
		} else {
			System.out.println(num + " is not divisible by " + n);
		}
	}
}
