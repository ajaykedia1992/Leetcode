/*
 * https://leetcode.com/explore/interview/card/facebook/53/recursion-3/324/
 * https://www.youtube.com/watch?v=Q-k3Ucoy6qk
 */

import java.util.ArrayList;
import java.util.List;

public class RemoveParantheses {

	public static void main(String args[]) {
		String str = "()())()";
		List<String> result = new RemoveParantheses().removeInvalidParentheses(str);

		System.out.println(result);
	}

	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<String>();
		if (s == null) {
			return result;
		}

		removeInvalidParenthesesUtil(s, 0, 0, result, new char[] { '(', ')' });

		return result;

	}

	public void removeInvalidParenthesesUtil(String s, int start, int lastModified, List<String> result, char[] pair) {

		for (int stack = 0, i = start; i < s.length(); i++) {
			if (s.charAt(i) == pair[0]) {
				stack++;
			} else if (s.charAt(i) == pair[1]) {
				stack--;
			}
			if (stack >= 0) {
				continue;
			}
			for (int j = lastModified; j <= i; j++) {
				if (s.charAt(j) == pair[1] && (j == lastModified || s.charAt(j - 1) != pair[1])) {
					removeInvalidParenthesesUtil(s.substring(0, j) + s.substring(j + 1), i, j, result, pair);
				}
			}
			return;
		}

		s = new StringBuilder(s).reverse().toString();

		if (pair[0] == '(') {
			removeInvalidParenthesesUtil(s, 0, 0, result, new char[] { ')', '(' });
		} else {
			result.add(s);
		}
	}
}
