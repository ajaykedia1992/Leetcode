import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TripletSum {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		// System.out.println(Arrays.toString(nums));
		List<List<Integer>> result = new ArrayList<>();
		int target = 0;
		Set<String> check = new HashSet<String>();
		for (int i = 0; i < nums.length - 1; i++) {
			int t = target - nums[i];
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int j = i + 1; j < nums.length; j++) {
				List<Integer> triplet = new ArrayList<Integer>();
				String c = nums[i] + ":" + nums[j] + ":" + (t - nums[j]);
				if (map.get(t - nums[j]) != null && !check.contains(c)) {
					triplet.add(nums[i]);
					triplet.add(nums[j]);
					triplet.add(t - nums[j]);
					result.add(triplet);
					check.add(c);
				} else {
					map.put(nums[j], j);
				}
			}
		}
		return result;
	}
}
