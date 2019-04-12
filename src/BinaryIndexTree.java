/* 
 * Range Query - Sum Query
 */

public class BinaryIndexTree {

	public static void main(String args[]) {
		int input[] = { 1, 2, 3, 4, 5, 6, 7 };

		BinaryIndexTree binaryIndexTree = new BinaryIndexTree();

		int binaryIndexArray[] = new int[input.length + 1];

		binaryIndexTree.constructBinaryIndexTree(input, binaryIndexArray);

		System.out.println(binaryIndexTree.sumRangeQuery(binaryIndexArray, 0, 6) - binaryIndexTree.sumRangeQuery(binaryIndexArray, 0, 3));

	}

	private int sumRangeQuery(int[] binaryIndexArray, int i, int j) {
		int index = j + 1;

		int sum = 0;

		while (index != 0) {
			sum += binaryIndexArray[index];
			index = getParent(index);
		}

		return sum;
	}

	private void constructBinaryIndexTree(int[] input, int[] binaryIndexArray) {

		for (int i = 1; i <= input.length; i++) {
			updateData(binaryIndexArray, input[i - 1], i);
		}

	}
	
	/**
     * To get next
     * 1) 2's complement of get minus of index
     * 2) AND this with index
     * 3) Add it to index
     */

	private int getNext(int index) {
		return index + (index & -index);
	}

	 /**
     * To get parent
     * 1) 2's complement to get minus of index
     * 2) AND this with index
     * 3) Subtract that from index
     */
	
	private int getParent(int index) {
		return index - (index & -index);
	}

	private void updateData(int[] binaryIndexArray, int data, int index) {
		while (index < binaryIndexArray.length) {
			binaryIndexArray[index] += data;
			index = getNext(index);
		}

	}
}
