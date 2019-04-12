package Facebook;

public class DivideTwoInteger {

	public static void main(String args[]) {
		int dividend = Integer.MIN_VALUE;
		int divisor = 1;
		DivideTwoInteger d = new DivideTwoInteger();
		int result = d.divide(dividend, divisor);
		System.out.println(result);
	}

	private int divide(int dividend, int divisor) {

		if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}

		int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;

		long dvd = Math.abs((long)dividend);
		long dvs = Math.abs((long)divisor);

		int res = 0;
		while (dvd >= dvs) {
			int multiple = 1; long temp = dvs;
			while (dvd >= (temp << 1)) {
				temp <<= 1;
				multiple <<= 1;
			}

            dvd -= temp;
			res += multiple;

		}

		return sign * res;
	}
}
