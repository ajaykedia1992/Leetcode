
public class RotatedArray {

	public int findPivot(int[] arr, int target, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			if (mid < end && arr[mid] > arr[mid + 1]) {
				return mid;
			}
			if (mid > start && arr[mid] < arr[mid - 1])
				return (mid - 1);

			if (arr[start] >= arr[mid])
				return findPivot(arr, target, start, mid - 1);

			return findPivot(arr, target, mid + 1, end);
		}

		if (start == end) {
			return start;
		}
		return -1;
	}

	public int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}

		int n = nums.length;
		int pivot = findPivot(nums, target, 0, n - 1);
		if (pivot == -1) {
			return binarySearch(nums, target, 0, n - 1);
		}
		if (nums[pivot] == target) {
			return pivot;
		}
		if (nums[0] <= target)
			return binarySearch(nums, target, 0, pivot - 1);

		return binarySearch(nums, target, pivot + 1, n - 1);
	}

	public int binarySearch(int[] nums, int target, int start, int end) {
		if (end < start) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (target == nums[mid]) {
			return mid;
		}

		if (target < nums[mid]) {
			return binarySearch(nums, target, start, mid - 1);
		}
		return binarySearch(nums, target, mid + 1, end);

	}
	
	public static void main(String args[]) 
    { 
       // Let us search 3 in below array 
       int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; 
       int n = arr1.length; 
       int key = 3; 
       RotatedArray r = new RotatedArray();
       System.out.println("Index of the element is : "
                      + r.search(arr1, key)); 
    } 
}
