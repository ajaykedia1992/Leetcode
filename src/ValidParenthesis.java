import java.util.Stack;

public class ValidParenthesis {

	public static void main(String args[]) {
		String str = "((()))";
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (!stack.isEmpty() && ((stack.peek() == '(' && str.charAt(i) == ')')
					|| (stack.peek() == '{' && str.charAt(i) == '}') || (stack.peek() == '[' && str.charAt(i) == ']'))) {
				stack.pop();
			} else {
				stack.push(str.charAt(i));
			}

		}

		if (stack.isEmpty()) {
			System.out.println("valid parenthesis");
		} else {
			System.out.println("Not valid");
		}
	}
}
