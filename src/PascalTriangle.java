import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangle {

	public static void main(String args[]) {
		int level = 0;
		System.out.println(getPascalAtIndex(level).stream().map(x -> x).collect(Collectors.toList()));
	}

	private static List<Integer> getPascalAtIndex(int level) {

		if (level < 0) {
			return null;
		}

		List<List<Integer>> result = new ArrayList<>();

		if (level == 0) {
			result.add(new ArrayList<Integer>() {
				{
					add(1);
				}
			});
			
			return result.get(0);
		}

		if (level == 1) {
			result.add(new ArrayList<Integer>() {
				{
					add(1);
					add(1);
				}
			});
			return result.get(0);
		}

		result.add(new ArrayList<Integer>() {
			{

				add(1);
			}
		});
		result.add(new ArrayList<Integer>() {
			{
				add(1);
				add(1);
			}
		});
		int k = 2;

		while (k < level + 1) {
			addToList(result, k);
			k++;
		}

		return result.get(result.size() - 1);
	}

	private static void addToList(List<List<Integer>> result, int k) {

		List<Integer> r = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			if (i == 0 || i == k - 1) {
				r.add(1);
			} else {
				r.add(result.get(result.size() - 1).get(i - 1) + result.get(result.size() - 1).get(i));
			}
		}

		result.add(r);

	}
}
