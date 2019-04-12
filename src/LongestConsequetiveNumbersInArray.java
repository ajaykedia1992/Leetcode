import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsequetiveNumbersInArray {

	public static void main(String args[]) {
		int[] num = { 4, 1, 2, 6, 5 , 3};

		System.out.println(findLongestConsequetiveNumbersInArray(num));
	}

	private static int findLongestConsequetiveNumbersInArray(int[] num) {
		Set<Integer> set = new HashSet<>(Arrays.stream(num).boxed().collect(Collectors.toList()));
		int count = 1;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<num.length; i++) {
		
			if(set.contains(num[i] - 1)) {
				continue;
			}
			int n = num[i];
			while(set.contains(++n)){
				count++;
			}
			max = Math.max(max, count);
			count = 1;
		}
		return max;
	}
}
