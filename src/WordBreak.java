import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

	public static void main(String args[]) {
		List<String> wordDict = new ArrayList<String>();
		String str = "acccbc";
		wordDict.add("cc");
		wordDict.add("bc");
		wordDict.add("ac");
		wordDict.add("ca");
		boolean status = wordBreak(str, wordDict);
		System.out.println(status);
	}

	private static boolean wordBreak(String str, List<String> wordDict) {
		int n = str.length();
		boolean[][] dp = new boolean[n][n];
		// single letter
		for (int i = 0; i < n; i++) {
			dp[i][i] = wordDict.contains("" + str.charAt(i));
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < n - i + 1; j++) {
				String sub = str.substring(j, j+i);
				if (wordDict.contains(sub)) {
					dp[j][j + i - 1] = true;
				}
				else {
					for(int k = 0; k < sub.length() - 1; k++) {
						if(dp[j][j+k] && dp[j+k+1][j + sub.length()-1]) {
							dp[j][j + i - 1] = true;
						}
					}
				}
			}
			//print(dp);
			//System.out.println("---------------------------");
		}

		
		if(dp[0][n-1]) {
			return true;
		}
		
		return false;
	}

	private static void print(boolean[][] dp) {
		for (boolean[] t : dp) {
			System.out.println(Arrays.toString(t));
		}

	}

}
