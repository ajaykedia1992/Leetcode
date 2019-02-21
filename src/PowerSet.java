import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class PowerSet {

	public static void main(String args[]) {
		String str = "abc";
		PowerSet(str).stream().map(x -> x).forEach(y -> System.out.println(y));
		powerSet(str).stream().map(x -> x).forEach(y -> System.out.println(y));
	}

	public static List<String> PowerSet(String inputStr) {
		Long a = System.nanoTime();
		char[] set = inputStr.toCharArray();
		int set_size = set.length;
		List<String> result = new ArrayList<>();
		long pow_set_size = (long) Math.pow(2, set_size);
		int counter, j;
		for (counter = 0; counter < pow_set_size; counter++) {
			StringBuffer str = new StringBuffer("");
			for (j = 0; j < set_size; j++) {
				if ((counter & (1 << j)) > 0)
					str.append(set[j]);
			}
			result.add(str.toString());
		}
		Collections.sort(result);
		System.out.println((long) System.nanoTime() - a);
		return result;
	}

	public static List<String> powerSet(String inputString) {
		Long a = System.nanoTime();
		if (inputString == null) {
			return null;
		}
		if (inputString.length() == 0) {
			return new ArrayList<String>();
		}

		Set<String> output = new HashSet<>();
		Stack<String> stack = new Stack<>();
		output.add("");
		for (int i = 0; i < inputString.length(); i++) {
			stack.add(inputString.substring(i, i + 1));
			for (int j = i + 1; j < inputString.length(); j++) {
				String[] temp = new String[stack.size() * 2];
				int k = temp.length - 1;
				while (!stack.isEmpty()) {
					temp[k - 1] = stack.pop();
					temp[k] = temp[k - 1] + inputString.substring(j, j + 1);
					k = k - 2;
				}

				for (int m = 0; m < temp.length; m++) {
					stack.push(temp[m]);
				}
			}

			while (!stack.isEmpty()) {
				output.add(stack.pop());
			}
		}

		List<String> result = output.stream().map(x -> x).collect(Collectors.toList());
		Collections.sort(result);
		System.out.println((long) System.nanoTime() - a);
		return result;
	}

}
