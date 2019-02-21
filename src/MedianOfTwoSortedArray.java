
public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		int a[] = { 1, 4, 7, 9 };

		int b[] = { 2, 4, 6, 7 };

		System.out.println(findMedianSortedArrays(a, b));

	}

	public static double findMedianSortedArrays(int[] A, int[] B) {
		if (A.length > B.length) {
			return findMedianSortedArrays(B, A);
		}
		int small = A.length;
		int big = B.length;

		int low = 0;
		int high = small;

		while (low <= high) {
			int partitionX = (low + high) / 2;
			int partitionY = (small + big + 1) / 2 - partitionX;

			int minX = (partitionX == 0) ? Integer.MIN_VALUE : A[partitionX - 1];
			int maxX = (partitionX == small) ? Integer.MAX_VALUE : A[partitionX];
			int minY = (partitionY == 0) ? Integer.MIN_VALUE : B[partitionY - 1];
			int maxY = (partitionY == big) ? Integer.MAX_VALUE : B[partitionY];

			if (minX <= maxY && minY <= maxX) {
				if ((small + big) % 2 == 0) {
					return (double) (Math.max(minX, minY) + Math.min(maxX, maxY)) / 2;
				} else {
					return (double) Math.max(minX, minY);
				}
			}
			if (minX > maxY) {
				high = partitionX - 1;
			} else {
				low = partitionX + 1;
			}

		}
		return 0.0;
	}

}
