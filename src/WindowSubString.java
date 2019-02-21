import java.util.HashMap;
import java.util.Map;

public class WindowSubString {
	
	public static void main(String args[]) {
		String s = "ADOBECODEBANC";
		String p = "ABC";
		WindowSubString a = new WindowSubString();
		String result = a.minWindow(s, p);
		System.out.println(result);
	}

	public Map<Character, Integer> fillMap(String p) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		return map;
	}

    
    public String minWindow(String s, String t) {
        if(s == null && t == null){
             return null;
        } 
        
        String result = new String();
        
        if(t.length() <= s.length()){
            Map<Character, Integer> map = fillMap(t);
            for(int i = 0; i<s.length() - t.length() + 1; i++){
            	StringBuffer temp = new StringBuffer("");
                for(int j = i; j<s.length(); j++){
                    char c = s.charAt(j);
                    if(map.containsKey(c)){
                        map.put(c, map.get(c) - 1);
                        temp.append(c);
                        if(map.get(c) == 0){
                            map.remove(c);
                        }
                        if(map.size() == 0){
                            if(result.length() == 0 || result.length() > temp.length()){
                                result = temp.toString();
                            }
                            break;
                        }
                    }
                    else {
                    	temp.append(c);
                    	if(result.length() != 0 && temp.length() > result.length()) {
                    		break;
                    	}
                    }
                }
                map = fillMap(t);
            }
            return result;
        }
        return "";
        
    }
}
