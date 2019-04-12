
public class EditDistance {

	public static void main(String args[]) {

		String query = "board";
		String[] words = { "bord", "doard", "blond", "board", "blord" };

		for (int i = 0; i < words.length; i++) {
			if (isValidWord(query, words[i])) {
				System.out.println(words[i]);
			}
		}
	}

	private static boolean isValidWord(String query, String string) {
		int m = query.length();
		int n = string.length();
		int i = 0, j = 0;
		int count = 0;
		while (i < m && j < n) {
			if (query.charAt(i) != string.charAt(j)) {
				if (count == 1) {
					return false;
				}
				if (m < n) {
					j++;
				} else if (m > n) {
					i++;
				} else {
					i++;
					j++;
				}
				count++;
			} else {
				i++;
				j++;
			}
		}

		if (i < m || j < n) {
			count++;
		}
		return count <= 1;
	}
}
