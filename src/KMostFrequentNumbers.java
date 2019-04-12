import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class KMostFrequentNumbers {

	public static void main(String args[]) {
		int[] number = { 1, 1, 1, 2, 2, 2, 2, 3, 3, 3 };

		int k = 2;

		System.out.println(findKMostFrequentNumber(number, k));
	}

	private static List<Integer> findKMostFrequentNumber(int[] number, int k) {

		List<Integer> result = new ArrayList<>();

		Map<Integer, Integer> map = new HashMap<>();

		if (number == null || number.length == 0) {
			return result;
		}

		for (int i : number) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		Map<Integer, List<Integer>> resultMap = new TreeMap<>(Collections.reverseOrder());
		
		for(Integer key : map.keySet()) {
			if(resultMap.containsKey(map.get(key))) {
				List<Integer> list = resultMap.get(map.get(key));
				list.add(key);
				resultMap.put(map.get(key), list);
			}
			else {
				List<Integer> list = new ArrayList<>();
				list.add(key);
				resultMap.put(map.get(key), list);
			}
		}

		
		for(Integer key : resultMap.keySet()) {
			result.addAll(resultMap.get(key).stream().collect(Collectors.toList()));
			while(result.size() > k) {
				result.remove(result.size() - 1);
			}
		}
		
		return result;
	}
}
