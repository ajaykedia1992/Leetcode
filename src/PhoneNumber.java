import java.util.LinkedList;
import java.util.Stack;

public class PhoneNumber {

	public static void main(String args[]) {
		String number[] = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		String input = "234787";
		LinkedList<String> ans = null;
		Stack<String> temp = new Stack<String>();
		temp.push("");
		for (int i = 0, j = 1; i < input.length(); j++, i++) {
			ans = new LinkedList<String>();
			char[] one = number[Character.getNumericValue(input.charAt(i))].toCharArray();
			while (!temp.isEmpty()) {
				String p = temp.pop();
				for (int m = 0; m < one.length; m++) {
					ans.add(p + "" + one[m]);
				}
			}
			for (String l : ans) {
				temp.push(l);
			}
		}
		for (String t : temp) {
			System.out.println(t);
		}
	}
}
