import java.util.Arrays;

public class LongestPalindromicSubstring {

	public static void main(String args[]) {
		String str = "";
		String palindromicSubstring = getPalindromicSubstring(str);
		System.out.println(palindromicSubstring);
	}
	
	public static void printArray(boolean[][] table) {
		for(boolean row[] : table) {
			System.out.println(Arrays.toString(row));
		}
	}

	private static String getPalindromicSubstring(String str) {
		if(str == null || str.length() == 0) {
			return "";
		}
		
		int n =  str.length();
		
		boolean table[][] = new boolean[n][n];
		
		int maxLength = 1;
		// for a single letter
		for(int i = 0; i<n; i++) {
			table[i][i] = true;
		}
		
		
		//for 2 letters string
		int start = 0;
		for(int i = 0; i<n-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				table[i][i+1] = true;
				start = i;
				maxLength = 2;
 			}
		}
		
		// for 3 or more letters string
		
		for(int k = 3; k<=n; k++) {
			for(int i = 0; i<n-k+1; i++) {
				int j = i+k-1;
				if(table[i+1][j-1] && str.charAt(i) == str.charAt(j)) {
					table[i][j] = true;
					maxLength = k;
					start = i;
				}
			}
			
		}
		
		//System.out.println(maxLength);
		
		String result = str.substring(start, start+maxLength); 
		
		return result;

		//print table
		//printArray(table);
		
		
	}
}
