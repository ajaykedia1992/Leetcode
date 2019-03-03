
public class RegularExpression {

	public static void main(String args[]) {
		String s = "abc";
		String p = "a*b*c";

		System.out.println(isMatch(s, p));
	}

	private static boolean isMatch(String s, String p) {

		if (s == null && p == null) {
			return false;
		}

		if (s.length() == 0 && p.length() == 0) {
			return true;
		}

		if (p.length() != 0 && p.charAt(0) == '*') {
			return false;
		}

		// Now we have both the strings which are non-empty

		boolean[][] status = new boolean[s.length() + 1][p.length() + 1];

		status[0][0] = true;

		char[] string = s.toCharArray();
		char[] pattern = p.toCharArray();

		for (int i = 1; i < status[0].length; i++) {
			if (pattern[i - 1] == '*') {
				status[0][i] = status[0][i - 2];
			}
		}

		for (int i = 1; i <= string.length; i++) { // pattern
			for (int j = 1; j <= pattern.length; j++) { // string
				if (string[i - 1] == pattern[j - 1] || pattern[j - 1] == '.') {
					status[i][j] = status[i - 1][j - 1];
				} else if (pattern[j - 1] == '*') {
					status[i][j] = status[i][j - 2];
					if (pattern[j - 2] == '.' || pattern[j - 2] == string[i - 1]) {
						status[i][j] = status[i][j] | status[i - 1][j];
					}
				} else {
					status[i][j] = false;
				}
			}
		}
		return status[string.length][pattern.length];
	}

}
