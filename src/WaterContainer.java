import java.util.Stack;

public class WaterContainer {

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5, 4, 3, 2, 1 };
		System.out.println(findMaxAreaOfWaterContainer(arr));
	}

	private static int findMaxAreaOfWaterContainer(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<>();
		int top, maxArea = 0;
		for (int i = 0; i < arr.length; i++) {
			if (stack.isEmpty()) {
				stack.push(i);
			}

			else {
				if (arr[i] <= arr[stack.peek()]) {
					stack.push(i);
				}

				else {
					while (true) {
						top = stack.pop();
						if (!stack.isEmpty() && arr[top] == arr[stack.peek()]) {
							stack.pop();
						} else {
							break;
						}
					}
					if (stack.isEmpty()) {
						stack.push(i);
						continue;
					}
					int stackTop = stack.peek();
					maxArea += (Math.min(arr[i], arr[stackTop]) - arr[top]) * (i - stackTop - 1);
					i -= 1;
				}
			}

		}

		return maxArea;
	}
}
