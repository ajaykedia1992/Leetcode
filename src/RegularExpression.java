
public class RegularExpression {

	public static void main(String args[]) {
		String s = "abc";
		String p = ".*c";

		System.out.println(isMatch(s, p));
	}

	private static boolean isMatch(String s, String p) {

		if (s == null && p == null) {
			return false;
		}

		if (s.length() == 0 && p.length() == 0) {
			return true;
		}

		if ((s.length() != 0 && p.length() == 0) || (s.length() == 0 && p.length() != 0)) {
			return false;
		}

		// Now we have both the strings which are non-empty

		boolean[][] status = new boolean[p.length() + 1][s.length() + 1];

		status[0][0] = true;

		char[] string = s.toCharArray();
		char[] pattern = p.toCharArray();

		for (int i = 1; i <= pattern.length; i++) { // pattern
			for (int j = 1; j <= string.length; j++) { // string
				if (pattern[i - 1] == string[j - 1]) {
					status[i][j] = true;
				} else {
					if (pattern[i - 1] == '.') {
						if (status[i - 1][j - 1]) {
							status[i][j] = true;
						}
					} else if (pattern[i - 1] == '*') {
						if (status[i - 1][j] || status[i][j - 1]) {
							status[i][j] = true;
						}
					} else {
						status[i][j] = false;
					}
				}
			}
		}
		return status[pattern.length][string.length];
	}
}
