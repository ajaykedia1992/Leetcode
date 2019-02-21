import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}

class Distance{
	double d;
	Point p;
	
	Distance(double d, Point p){
		this.d = d;
		this.p = p;
	}
}


public class ClosestPoint {

	public static void main(String args[]) {
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(1,2));
		list.add(new Point(3,-1));
		list.add(new Point(2,1));
		list.add(new Point(2,3));
		
		Point vertex = new Point(2,2);
		
		int k = 2;
		
		List<Point> result = nearestPoint(list, vertex, k);
		
		for(Point p : result) {
			System.out.println(p);
		}
	}

	private static List<Point> nearestPoint(List<Point> list, Point vertex, int k) {
		
		PriorityQueue<Distance> minHeap = new PriorityQueue<>(new Comparator<Distance>() {

			@Override
			public int compare(Distance arg0, Distance arg1) {
				// TODO Auto-generated method stub
				Integer d1 = (int)arg0.d;
				Integer d2 = (int)arg1.d;
				return -1*(d1).compareTo(d2);
			}
			
		});
		for(Point p : list) {
			double dist = calculateDistance(p, vertex);
			if(minHeap.size() != k) {
				minHeap.add(new Distance(dist, p));
			}else {
				if(dist < minHeap.peek().d) {
					minHeap.poll();
					minHeap.add(new Distance(dist, p));
				}
			}
		}
		
		List<Point> result = new ArrayList<Point>();
		
		for(Distance d : minHeap) {
			result.add(d.p);
		}
		return result;
	}

	private static double calculateDistance(Point p, Point vertex) {
		
		int diffX = vertex.x - p.x;
		int diffY = vertex.y - p.y;
		return Math.sqrt(Math.pow(diffX,2) - Math.pow(diffY,2));
	}
}
