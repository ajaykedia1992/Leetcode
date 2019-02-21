
public class CheckAnagram {

	public static void main(String args[]) {
		String str = "maoiam";
		System.out.println(checkAnagram(str));
	}

	private static boolean checkAnagram(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		str = str.toLowerCase();
		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
