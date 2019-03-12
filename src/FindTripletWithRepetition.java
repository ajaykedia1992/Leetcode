/*
 * 
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTripletWithRepetition {

	public static void main(String args[]) {
		int arr[] = {-5,0,5,3,1,2,-1};

		List<List<Integer>> res = new ArrayList<>();

		res = findTripletWithRepeatition(arr);

		for (List<Integer> i : res) {
			i.forEach(x -> System.out.print(x + " "));
			System.out.println();
		}
	}

	private static List<List<Integer>> findTripletWithRepeatition(int[] arr) {
		List<List<Integer>> res = new ArrayList<>();
		if (arr == null || arr.length == 0) {
			return res;
		}

		int n = arr.length;
		Arrays.sort(arr);
		for (int i = 0; i < n - 1; i++) {
			int l = i;
			int r = n - 1;
			int x = arr[i];
			while (l <= r) {
				if (x + arr[l] + arr[r] == 0) {
					List<Integer> temp = new ArrayList<>();
					temp.add(x);
					temp.add(arr[l]);
					temp.add(arr[r]);
					res.add(temp);
					l++;
					r--;
				}

				else if (x + arr[l] + arr[r] < 0) {
					l++;
				}

				else {
					r--;
				}
			}
		}

		return res;
	}

}
