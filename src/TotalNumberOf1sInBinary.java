
public class TotalNumberOf1sInBinary {
	public static void main(String args[]) {
		int n = 5;
		System.out.println(numberOfBinary(n));
	}

	private static int numberOfBinary(int n) {

		if (n < 0) {
			n = -n;
		}
		int sum = 0;
		while (n > 0) {
			sum += n ^ 1;
			n >>= 1;
		}
		return sum;
	}

}
