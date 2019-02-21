
public class CountAndSay {

	public static void main(String args[]) {
		int n = 4;
		System.out.println(countAndSay(n));
	}

	public static String countAndSay(int n) {
		if (n == 1)
			return "1";
		StringBuilder build = new StringBuilder("1");

		for (int i = 1; i < n; i++) {
			String word = build.toString();
			build.setLength(0);

			char curChar = ' ';
			int count = 0;
			for (int x = 0; x < word.length(); x++) {
				if (curChar == word.charAt(x)) {
					count++;
				} else {
					if (count != 0) {
						build.append(count).append(curChar);
					}
					curChar = word.charAt(x);
					count = 1;
				}
			}
			build.append(count).append(curChar);
		}
		return build.toString();

	}
}
