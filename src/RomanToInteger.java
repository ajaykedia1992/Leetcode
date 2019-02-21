import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class RomanToInteger {
    public int romanToInt(String s) {
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        char[] rn = s.toCharArray();
        System.out.println(Arrays.toString(rn));
        int count = 0;
        for(int i = 0; i<rn.length - 1; ){
            int l;
            if(rn[i] == 'I' && (rn[i+1] == 'V' || rn[i+1] == 'X')){
                l = map.get(rn[i+1]) - map.get(rn[i]);
                i = i+2;
                count += 2;
            }
            else if(rn[i] == 'X' && (rn[i+1] == 'L' || rn[i+1] == 'C')){
                l = map.get(rn[i+1]) - map.get(rn[i]);
                i = i+2;
                count += 2;
            }
            
            else if(rn[i] == 'C' && (rn[i+1] == 'D' || rn[i+1] == 'M')){
                l = map.get(rn[i+1]) - map.get(rn[i]);
                i = i+2;
                count += 2;
            }
            else{
                l = map.get(rn[i]);
                i += 1;
                count += 1;
            }
            result += l;
            
        }
        if(count != rn.length){
            result += map.get(rn[rn.length -1]);
        }
        return result;
    }
}
