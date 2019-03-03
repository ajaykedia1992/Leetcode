import java.util.Stack;

public class NumberOfValidParentesis {

	public static void main(String args[]) {
		String str = "(()";
		System.out.println(longestValidParentheses(str));
	}

	private static int longestValidParentheses(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		int temp = 0;

		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			if (stack.isEmpty() && str.charAt(i) == ')') {
				continue;
			}
			if(!stack.isEmpty() && stack.peek() == '(' && str.charAt(i) == ')') {
				stack.pop();
				temp += 2;
			}
			else {
				stack.push(str.charAt(i));
			}
		}
		
		stack.clear();
		return temp;
	}
}
