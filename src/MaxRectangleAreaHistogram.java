import java.util.Stack;

public class MaxRectangleAreaHistogram {

	public static void main(String args[]) {
		int[] arr = { 1, 0, 0, 0, 1 };
		System.out.println(calculateMaxRectangleArea(arr, arr.length));
	}

	private static int calculateMaxRectangleArea(int[] arr, int length) {

		if (arr == null || arr.length == 0 || arr.length != length) {
			return -1;
		}

		Stack<Integer> stack = new Stack<>();

		int top, maxArea = -1, area = 0;

		for (int k = 0; k <= length; k++) {
			if (stack.isEmpty()) {
				stack.push(k);
			} else if (k < length && arr[k] >= arr[stack.peek()]) {
				stack.push(k);
			} else {
				top = stack.pop();
				if (stack.isEmpty()) {
					area = arr[top] * k;
				} else {
					area = arr[top] * (k - stack.peek() - 1);
				}

				if (maxArea < area) {
					maxArea = area;
				}
				k -= 1;
			}
		}
		return maxArea;
	}
}
