package Simple;

import java.util.ArrayList;
import java.util.List;

public class FibnoacciIndex {

	public static void main(String args[]) {
		int index = 4;
		System.out.println(getFibnoacciNumber(index));

		List<Integer> result = new ArrayList<Integer>();
		printFibnoacciNumber(result, index);
		result.stream().map(x -> x).forEach(x -> System.out.println(x));

	}

	private static int getFibnoacciNumber(int index) {
		if (index == 0) {
			return 0;
		}
		if (index == 1) {
			return 1;
		}
		return getFibnoacciNumber(index - 1) + getFibnoacciNumber(index - 2);
	}

	private static List<Integer> printFibnoacciNumber(List<Integer> list, int index) {
		if (index == 0) {
			list.add(0);
		}
		if (index == 1) {
			list.add(1);
		}
		list.add(printFibnoacciNumber(list, index - 1).get(index - 1)
				+ printFibnoacciNumber(list, index - 2).get(index - 2));
		return list;
	}
}
