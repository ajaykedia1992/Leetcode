package Facebook;

public class ValidWordAbbrevation {

	public static void main(String args[]) {
		String s = "internationalization";
		String abbr = "i12iz4n";

		System.out.println(validWordAbbrevation(s, abbr));

		s = "apple";
		abbr = "a2e";

		System.out.println(validWordAbbrevation(s, abbr));
	}

	private static boolean validWordAbbrevation(String s, String abbr) {

		if (abbr.length() > s.length()) {
			return false;
		}

		int wp = 0;
		int ap = 0;

		while (ap < abbr.length()) {
			if (Character.isDigit(abbr.charAt(ap))) {
				if (abbr.charAt(ap) == '0') {
					return false;
				}
				int[] nextAlphabet = findNextAlpha(abbr, ap);
				wp += nextAlphabet[0];
				ap = nextAlphabet[1];
			} else {
				if (wp >= s.length() || ap >= abbr.length() || s.charAt(wp) != abbr.charAt(ap)) {
					return false;
				}
				wp++;
				ap++;
			}
		}

		if (wp != s.length()) {
			return false;
		}

		return true;
	}

	private static int[] findNextAlpha(String abbr, int ap) {
		int num = 0;
		int result[] = new int[2];
		while (ap < abbr.length() && Character.isDigit(abbr.charAt(ap))) {
			num = num * 10 + abbr.charAt(ap) - '0';
			ap++;
		}

		result[0] = num;
		result[1] = ap--;
		return result;
	}
}
