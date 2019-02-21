import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for(int i= 0; i<nums.length; i++) {
			if(map.get(target-nums[i]) != null) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
				return result;
			}
			else {
				map.put(nums[i], i);
			}
			
		}
		return null;
	}
	
	public static void main(String args[]) {
		int[] nums = {1,-2,2,-4,8,5,3};
		int target = 10;
		int[] result = twoSum(nums, target);
		System.out.println(Arrays.toString(result));
	}
}
