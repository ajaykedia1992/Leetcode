import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * This program is to learn about streaming in Java. Following are the operation we are going to learn
 * 1. Intermediate Operations -> a. map
 *  				          -> b. filter
 * 						      -> c. sorted
 * 2. Terminal Operations -> a. foreach
 * 			  			  -> b. reduce
 * 			        	  -> c. collect
 */

public class JavaStream {

	public static void main(String args[]) {

		int[] a = { 1, 3, 4, 5, 6 };

		List<Integer> li = Arrays.stream(a).boxed().collect(Collectors.toList());
		System.out.println(li);

		List<Integer> list = Arrays.asList(2, 3, 1, 4, 5, 2, 3);
		List<Integer> result = list.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(result);

		result = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		System.out.println(result);

		result = list.stream().sorted().collect(Collectors.toList());

		System.out.println(result);

		Set<Integer> result1 = list.stream().sorted().collect(Collectors.toSet());

		System.out.println(result1);

		result1.stream().map(x -> x * x).forEach(y -> System.out.println(y));

		int output = list.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);
		System.out.println(output);

		@SuppressWarnings("serial")
		Map<String, String> map = new HashMap<String, String>() {
			{
				put("a", "abc");
				put("b", "cde");
				put("c", "def");
			}
		};

/*		for (Map.Entry<String, String> e : map.entrySet()) {
			String key = e.getKey();
			String value = e.getValue();

		}*/

		map.forEach((key, value) -> System.out.println(key + "->" + value));

		for (String e : map.keySet()) {
			System.out.println(e);

		}
	}
}
