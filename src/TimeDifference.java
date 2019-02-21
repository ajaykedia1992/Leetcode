import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class Time{
	int start;
	int end;

	public Time(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Time [start=" + start + ", end=" + end + "]";
	}
	
}

public class TimeDifference {

	public static void main(String args[]) {
		List<Time> time = new ArrayList<>();
		time.add(new Time(4, 6)); 
		time.add(new Time(1, 2));
		int result = (getTimeDifference(time));
		System.out.println(result == -1 ? "Time data is empty or null" : result);
	}

	private static int getTimeDifference(List<Time> time) {
		if (time == null || time.size() == 0) {
			return -1;
		}
		Collections.sort(time, new Comparator<Time>() {

			@Override
			public int compare(Time o1, Time o2) {
				// TODO Auto-generated method stub
				Integer a = o1.start;
				Integer b = o2.start;
				return a.compareTo(b);
			}
		});
		
		printTime(time);
		
		Stack<Time> stack = new Stack<Time>();
		int difference = 0;
		for (int i = 0; i < time.size(); i++) {
			if (stack.isEmpty()) {
				stack.push(time.get(i));
			} else {
				Time temp = stack.peek();
				Time current = time.get(i); 
				if(current.start <= temp.end) {
					if(current.end <= temp.end) {
						continue;
					}
					else {
						temp = stack.pop();
						temp.end = current.end;
						stack.push(temp);
					}
				}
				else {
					difference += stack.peek().end - stack.peek().start;
					stack.push(current);
					
				}
			}
		}
		
		difference += stack.peek().end - stack.peek().start;
		return difference;
	}

	private static void printTime(List<Time> time) {
		Iterator itr = time.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
