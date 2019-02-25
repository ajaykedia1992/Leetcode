enum Error {
	FLOORERROR, CEILERROR, UNAVAILABLE, SUCCESSFUL;
}

class FloorAndCeiling {
	int floor;
	int ceil;
	Error status = Error.SUCCESSFUL;

	public FloorAndCeiling(int floor, int ceil, Error status) {
		this.floor = floor;
		this.ceil = ceil;
		this.status = status;
	}

	FloorAndCeiling() {

	}

	@Override
	public String toString() {
		return "FloorAndCeiling [floor=" + floor + ", ceil=" + ceil + "]";
	}

}

public class FloorAndCeilInArray {

	public static void main(String args[]) {

		int a[] = { -11, -5, 2, 8, 10, 10, 12, 19 };
		int n = a.length;
		FloorAndCeiling status = findFloorAndCeil(a, 1, 0, n - 1);

		if (status.status == Error.FLOORERROR) {
			System.out.println("Floor doesn't exist and ceil = " + status.ceil);
		} else if (status.status == Error.CEILERROR) {
			System.out.println("Floor = " + status.floor + " , ceil doesn't exist");
		} else if (status.status == Error.UNAVAILABLE) {
			System.out.println("Floor and ceil both are not existing");
		} else {
			System.out.println("Floor = " + status.floor + " , ceil = " + status.ceil);
		}

	}

	private static FloorAndCeiling findFloorAndCeil(int[] a, int x, int low, int high) {

		FloorAndCeiling fc = new FloorAndCeiling();
		FloorAndCeiling left, right;
		if (a == null || a.length == 0) {
			System.out.println("floor and ceil doesn't exist");
			fc.status = Error.UNAVAILABLE;
			return fc;
		}

		if (x < a[low]) {
			fc.ceil = a[low];
			fc.status = Error.FLOORERROR;
			return fc;
		}

		if (x > a[high]) {
			fc.floor = a[high];
			fc.status = Error.CEILERROR;
			return fc;
		}

		if (x == a[low] && x == a[high]) {
			fc.floor = a[low];
			fc.ceil = a[low];
			fc.status = Error.SUCCESSFUL;
			return fc;
		}

		int mid = (low + high) / 2;

		left = findFloorAndCeil(a, x, low, mid);
		right = findFloorAndCeil(a, x, mid + 1, high);

		if (Math.abs(left.floor - x) < Math.abs(right.floor - x)) {
			fc.floor = left.floor;
		} else {
			fc.floor = right.floor;
		}

		if (Math.abs(left.ceil - x) < Math.abs(right.ceil - x)) {
			fc.ceil = left.ceil <= fc.floor ? right.ceil : left.ceil;
		} else {
			fc.ceil = right.ceil <= fc.floor ? left.ceil : right.ceil;
		}
		return fc;
	}

	static int ceilSearch(int arr[], int low, int high, int x) {
		int mid;

		if (x <= arr[low])
			return low;

		if (x > arr[high])
			return -1;
		mid = (low + high) / 2;
		if (arr[mid] == x)
			return mid;
		else if (arr[mid] < x) {
			if (mid + 1 <= high && x <= arr[mid + 1])
				return mid + 1;
			else
				return ceilSearch(arr, mid + 1, high, x);
		} else {
			if (mid - 1 >= low && x > arr[mid - 1])
				return mid;
			else
				return ceilSearch(arr, low, mid - 1, x);
		}
	}
}
