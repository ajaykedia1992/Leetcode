
public class NumberOfOneInBinary {

	public static void main(String args[]) {
		int n = 5;
		System.out.println(numberOfBinary(n));
	}

	private static int numberOfBinary(int n) {

		if (n < 0) {
			n = -n;
		}
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n >>= 1;
		}

		return count;
	}
}
