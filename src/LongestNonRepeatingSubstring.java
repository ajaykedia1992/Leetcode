import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSubstring {
	
	public static void main(String args[]) {
		String s = "au";
		int result = lengthOfLongestSubstring(s);
		System.out.println(result);
	}
	
	public static int lengthOfLongestSubstring(String s) {
		int result = 1;	
		for(int i = 0; i<s.length(); i++) {
			for(int j = s.length(); j>i ;j--) {
				String str = s.substring(i, j);
				if(result >= str.length()) {
					continue;
				}
				boolean check = checkString(str);
				if(check == false) {
					if(result < str.length()) {
						result = str.length();
					}
				}
			}
		}
		return result;
	}

	private static boolean checkString(String sub) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0;i<sub.length(); i++) {
			if(map.containsKey(sub.charAt(i))) {
				return true;
			}
			else {
				map.put(sub.charAt(i), 1);
			}
		}
		return false;
	}

	public int anotherSolution(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
	

