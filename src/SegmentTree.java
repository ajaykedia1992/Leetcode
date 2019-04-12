import java.util.Arrays;

/* 
 * range Query - > Min Max
 */
public class SegmentTree {

	public static void main(String args[]) {
		int input[] = { -1, 2, 4, 3, 1 };

		SegmentTree s = new SegmentTree();
		int[] segment = new int[s.isPowerOfTwo(input.length) ? input.length * 2 - 1
				: s.getNextPowerOfTwo(input.length) * 2 - 1];
		Arrays.fill(segment, Integer.MAX_VALUE);
		s.constructSegmentTree(input, segment, 0, input.length - 1, 0);
		System.out.println(Arrays.toString(segment));
		System.out.println(rangeQueryMin(segment, 1, 4, 0, input.length - 1, 0));

	}

	private static int rangeQueryMin(int[] segment, int qLow, int qHigh, int low, int high, int pos) {

		if (qLow <= low && qHigh >= high) {
			return segment[pos];
		} else if (qHigh < low || qLow > high) {
			return Integer.MAX_VALUE;
		} else {
			int mid = (low + high) / 2;
			return Math.min(rangeQueryMin(segment, qLow, qHigh, low, mid, 2 * pos + 1),
					rangeQueryMin(segment, qLow, qHigh, mid + 1, high, 2 * pos + 2));
		}
	}

	private void constructSegmentTree(int[] input, int[] segment, int low, int high, int pos) {
		if (low == high) {
			segment[pos] = input[low];
			return;
		}
		int mid = (low + high) / 2;
		constructSegmentTree(input, segment, low, mid, 2 * pos + 1);
		constructSegmentTree(input, segment, mid + 1, high, 2 * pos + 2);
		segment[pos] = Math.min(segment[2 * pos + 1], segment[2 * pos + 2]);
	}

	private int getNextPowerOfTwo(int length) {
		int count = 1;
		while (count < length) {
			count *= 2;
		}
		return count;
	}

	private boolean isPowerOfTwo(int length) {
		int count = 1;
		while (count < length) {
			count *= 2;
		}
		if (count == length) {
			return true;
		} else {
			return false;
		}

	}

}
