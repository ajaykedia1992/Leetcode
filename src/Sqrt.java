public class Sqrt {

	public static void main(String args[]) {
		System.out.println(findSqrt(2));
		System.out.println(findSqrtNewton(2));
	}

	private static int findSqrt(int d) {
		if (d < 0) {
			throw new IllegalArgumentException();
		}
		if (d == 0) {
			return 0;
		}
		int low = 1;
		int high = Integer.MAX_VALUE;

		while (true) {
			int mid = low + (high - low) / 2;
			if (mid > d / mid) {
				high = mid - 1;
			} else {
				if ((mid + 1) > d/(mid + 1)) {
					return mid;
				}
				low = mid + 1;
			}
		}

	}

	private static double findSqrtNewton(int d) {
		double r = d;
		while (r * r > d) {
			r = (r + d / r) / 2;
		}
		return r;
	}
}
