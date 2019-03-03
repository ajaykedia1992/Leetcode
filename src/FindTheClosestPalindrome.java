/*
 * https://leetcode.com/problems/find-the-closest-palindrome/
 * 
 * three different cases:
 * 10987 ->  if my middle is 9 then we will 
 */

public class FindTheClosestPalindrome {

	public static void main(String args[]) {
		String s = "10";
		System.out.println(new FindTheClosestPalindrome().nearestPalindromic(s));
	}

	public String mirroring(String s) {
		String str = s.substring(0, s.length() / 2);
		return str + (s.length() % 2 == 1 ? s.charAt(s.length() / 2) : "") + new StringBuffer(str).reverse().toString();
	}

	public String nearestPalindromic(String n) {
		if (n.equals("1")) {
			return "0";
		}

		StringBuilder s = new StringBuilder(n);

		long diff1 = Long.MAX_VALUE, diff2 = Long.MAX_VALUE, diff3 = Long.MAX_VALUE;

		String a = mirroring(s.toString());

		diff1 = Math.abs(Long.parseLong(a) - Long.parseLong(n));

		if (diff1 == 0) {
			diff1 = Long.MAX_VALUE;
		}

		s = new StringBuilder(n);

		int i = (s.length() - 1) / 2;
		while (i >= 0 && s.charAt(i) == '9') {
			s.replace(i, i + 1, "0");
			i--;
		}

		if (i < 0) {
			s.insert(0, "1");
		} else {
			s.replace(i, i + 1, "" + (char) (s.charAt(i) + 1));
		}

		String b = mirroring(s.toString());

		diff2 = Math.abs(Long.parseLong(n) - Long.parseLong(b));

		s = new StringBuilder(n);

		i = (s.length() - 1) / 2;

		while (i >= 0 && s.charAt(i) == '0') {
			s.replace(i, i + 1, "9");
			i--;
		}
		
		// consider the case of 10
		if (i == 0 && s.charAt(i) == '1') {
			s.delete(0, 1);
			int mid = (s.length() - 1) / 2;
			s.replace(mid, mid + 1, "9"); 
		} else {
			s.replace(i, i + 1, "" + (char) (s.charAt(i) - 1));
		}

		String c = mirroring(s.toString());

		diff3 = Math.abs(Long.parseLong(c) - Long.parseLong(n));

		if (diff3 <= diff1 && diff3 <= diff2) {
			return c;
		}
		if (diff1 <= diff2 && diff1 <= diff3) {
			return a;
		} else {
			return b;
		}
	}
}
