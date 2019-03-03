import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Building implements Comparable<Building> {
	int x;
	boolean isStart;
	int height;

	public Building(int x, boolean isStart, int height) {
		this.x = x;
		this.isStart = isStart;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Building [x=" + x + ", isStart=" + isStart + ", height=" + height + "]";
	}

	@Override
	public int compareTo(Building o) {
		if (this.x != o.x) {
			return this.x - o.x;
		} else {
			return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
		}
	}

}

public class SkylineProblem {

	public static void main(String args[]) {
		int[][] buildings = { { 1, 3, 4 }, { 3, 4, 4 }, { 2, 6, 2 }, { 8, 11, 4 }, { 7, 9, 3 }, { 10, 11, 2 } };
		SkylineProblem s = new SkylineProblem();
		List<int[]> result = s.getSkyline(buildings);
		result.forEach(x -> System.out.println(Arrays.toString(x)));
	}

	private List<int[]> getSkyline(int[][] buildings) {

		Building[] buildingPoint = new Building[2 * buildings.length];
		int index = 0;
		for (int building[] : buildings) {
			buildingPoint[index++] = new Building(building[0], true, building[2]);
			buildingPoint[index++] = new Building(building[1], false, building[2]);
		}

		Arrays.sort(buildingPoint);

		// print(buildingPoint);

		// max-heap
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		List<int[]> res = new ArrayList<>();
		int previousMax = Integer.MIN_VALUE;
		queue.add(0);
		for (Building b : buildingPoint) {
			if (b.isStart) {
				queue.add(b.height);
			} else {
				queue.remove();
			}
			if (queue.peek() != previousMax) {
				previousMax = queue.peek();
				res.add(new int[] { b.x, queue.peek() });
			}
		}

		return res;
	}

	private void print(Building[] buildingPoint) {
		for (Building b : buildingPoint) {
			System.out.println(b);
		}

	}
}
