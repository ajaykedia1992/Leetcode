import java.util.Arrays;

public class NextPermutation {
	
	public static void main(String args[]) {
		int  nums[] = {2,3,1,3,3};
		NextPermutation n = new NextPermutation();
		n.nextPermutation(nums);
	}
	
	public int findImmediateBigger(int[] nums, int start, int next){
        int diff = nums[next] - nums[start];
        int index = next;
        next += 1;
        while(next < nums.length){
            int temp = nums[next] - nums[start];
            if(temp < diff && temp > 0){
                diff = temp;
                index = next;
            }
            next++;
        }
        
        return index;
    }
    
    public void sortedArray(int[] nums, int start, int next){
        int index = findImmediateBigger(nums, start, next);
        int temp = nums[index];
        nums[index] = nums[start];
        nums[start] = temp;
        
        start += 1;
        
        Arrays.sort(nums, start, nums.length);
    }
    
    
    public void nextPermutation(int[] nums) {
        if(nums.length == 0){
            System.out.println("Array is empty");
            return;
        }
        int length = nums.length;
        boolean flag = false;
        for(int i = length - 1 ; i > 0 ;){
            if(nums[i] > nums[i - 1]){
                flag = true;
                sortedArray(nums, i-1, i);
                break;
            }
            else{
                i--;
            }
        }
        
        if(flag == false){
            for(int i = 0, j = length - 1; i < j ; i++, j--){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
