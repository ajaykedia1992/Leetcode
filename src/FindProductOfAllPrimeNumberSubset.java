import java.util.ArrayList;
import java.util.List;

public class FindProductOfAllPrimeNumberSubset {

	public static void main(String args[]) {
		int A[] = { 2, 3, 5 };

		// output = {2,3,5,6,10,15,30}
		List<List<Integer>> res = new ArrayList<>();
		findProductOfAllPrimeNumberSubset(A, res, 0);

		List<Integer> r = new ArrayList<Integer>();
		findProductOfallSubset(res, r);
		System.out.println(r);
	}

	private static void findProductOfallSubset(List<List<Integer>> res, List<Integer> r) {
		for (List<Integer> l : res) {
			product(l, r);
		}
	}

	private static void product(List<Integer> l, List<Integer> r) {
		int total = 1;
		for (int i : l) {
			total *= i;
		}
		r.add(total);
	}

	private static void findProductOfAllPrimeNumberSubset(int[] a, List<List<Integer>> res, int index) {

		int powerSetSize = (int) Math.pow(2, a.length);
		int setsize = a.length;

		for (int counter = 0; counter < powerSetSize; counter++) {
			List<Integer> r = new ArrayList<>();
			for (int i = 0; i < setsize; i++) {
				if ((counter & (1 << i)) > 0) {
					r.add(a[i]);
				}
			}
			if (r.size() > 0) {
				res.add(r);
			}
		}
	}

}
