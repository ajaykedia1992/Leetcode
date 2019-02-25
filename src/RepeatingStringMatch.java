/*
 * https://leetcode.com/problems/repeated-string-match/
 * 
 */

public class RepeatingStringMatch {

	public static void main(String args[]) {
		String a = "abcabcabcabc";
		String b = "abac";

		int result = repeatedStringMatch(a, b);
		System.out.println(result);
	}

	private static int repeatedStringMatch(String A, String B) {

		int q = 1;
        StringBuilder S = new StringBuilder(A);
        for (; S.length() < B.length(); q++) S.append(A);
        if (S.indexOf(B) >= 0) return q;
        if (S.append(A).indexOf(B) >= 0) return q+1;
        return -1;
	}
}
