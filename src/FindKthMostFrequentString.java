import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindKthMostFrequentString {

	public static void main(String args[]) {
		String str[] = { "a", "a", "b", "c", "a", "b", "c", "d", "c", "c" };
		int k = 1;
		System.out.println(getKthMostFrequentString(str, k));
	}

	@SuppressWarnings("unchecked")
	private static String getKthMostFrequentString(String[] str, int k) {
		if (str == null || str.length == 0) {
			return null;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String s : str) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		System.out.println(map);

		List<Map.Entry> list = new ArrayList(map.entrySet());

		Collections.sort(list, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Integer a = (Integer) ((Map.Entry) o1).getValue();
				Integer b = (Integer) ((Map.Entry) o2).getValue();
				return -1 * a.compareTo(b);
			}
		});

		System.out.println(list);
		if (list.size() > k) {
			return (String) (list.get(k - 1)).getKey();
		}
		return null;
	}
}
