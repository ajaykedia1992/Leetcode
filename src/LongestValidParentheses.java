import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String args[]) {
		String str = "(()())";

		System.out.println(longestValidParentheses(str));
	}

	private static int longestValidParentheses(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		int longest = 0;

		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push(i);
			}
			else {
				stack.pop();
				if(stack.isEmpty()) {
					stack.push(i);
				}
				else {
					longest = Math.max(longest, i - stack.peek());
				}
			}
		}
		return longest;
	}
}
