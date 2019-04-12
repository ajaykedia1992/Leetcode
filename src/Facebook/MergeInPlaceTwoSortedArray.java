/*
 *  		  aIndex	mergeIndex
 *  A = 1, 3, 5, 0, 0, 0
 *  B = 2, 4, 6
 *  		  bIndex 
 */

package Facebook;

import java.util.Arrays;

public class MergeInPlaceTwoSortedArray {

	public static void main(String args[]) {
		int[] A = { 1, 3, 5, 0, 0, 0 };
		int[] B = { 2, 4, 6 };
		mergeTwoSortedArray(A, B, 3, 3);
		System.out.println(Arrays.toString(A));
	}

	private static void mergeTwoSortedArray(int[] a, int[] b, int aLength, int bLength) {

		int aIndex = aLength - 1;
		int bIndex = bLength - 1;

		int mergeIndex = aLength + bLength - 1;

		while (aIndex >= 0 && bIndex >= 0) {
			if (a[aIndex] >= b[bIndex]) {
				a[mergeIndex] = a[aIndex];
				aIndex--;
			} else {
				a[mergeIndex] = b[bIndex];
				bIndex--;
			}

			mergeIndex--;
		}

		while (bIndex >= 0) {
			a[mergeIndex] = b[bIndex];
			bIndex--;
			mergeIndex--;
		}

	}
}
