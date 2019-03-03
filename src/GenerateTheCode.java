
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
 * 0 0 0 0
 * - 0 0 0 1
 * - - 0 0 1 0
 * - - - 0 1 0 1
 * - - - - 1 0 1 0
 * - - - - - 0 1 0 0
 */

public class GenerateTheCode {

    public static String generateFourDigitString(String digits, int K){

        final String firstDigit = Character.toString(digits.charAt(0));

        // Generate Starting number 0 0 0 0
        LinkedList<String> fourDigitCombinations = new LinkedList<>(
                Arrays.asList(Stream.generate(() -> firstDigit).
                        limit(K).collect(Collectors.joining())));

        // Generate all the combination of the four digits
        for(int i = 0; i<Math.pow(digits.length(), K); i++){
            for(int j = digits.length() - 1; j >=0; j--){
                String permute = fourDigitCombinations.getLast().substring(1) + digits.charAt(j); // adding digit from the back side
                if (fourDigitCombinations.stream().noneMatch(a -> a.equals(permute))) { //  checking if the digit is already present, if not then we add in the list.
                    fourDigitCombinations.add(permute);
                    break;
                }
            }
        }

        // reversing all the collection to print  lexicographically
        Collections.reverse(fourDigitCombinations);

        // Adding each digit from the back of the 4 digit
        Optional<String> reduce = fourDigitCombinations.stream().map(a -> String.valueOf(a.charAt(a.length() - 1))).reduce((c1, c2) -> String.valueOf(c1) + String.valueOf(c2));
        String str = reduce.get();

        StringBuffer output =  new StringBuffer(str.substring(0,str.length() - 1));
        return "0" + output.toString();

    }

    public static void main(String args[]) {

        String digits = "0123456789";
        int K = 4;
        String result = generateFourDigitString(digits, K);
        System.out.println(result);
    }

}

// Size of String = 10000 (No Repetition) -> Checked
// Time Complexity O(N ^ 2)
// space Complexity O(N * K)