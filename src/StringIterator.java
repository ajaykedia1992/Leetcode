import java.util.LinkedList;
import java.util.Queue;

public class StringIterator {

	Queue<int[]> queue = new LinkedList<>();

	public StringIterator(String str) {
		int i = 0;
		int n = str.length();
		while (i < n) {
			int j = i + 1;
			while (j < n && str.charAt(j) - 'A' < 0)
				j++;
			queue.add(new int[] { str.charAt(i) - 'A', Integer.parseInt(str.substring(i + 1, j)) });
			i = j;
		}
	}
	
	public boolean hasNext() {
		if(!queue.isEmpty()) {
			return true;
		}
		return false;
	}

	
	public char next() {
		if(queue.isEmpty()) {
			return ' ';
		}
		int[]  top = queue.peek();
		if(--top[1] == 0) {
			queue.poll();
		}
		return (char)(top[0] + 'A');
	}
	
	public static void main(String args[]) {
		String str = "L1e2t1C1o1d1e1";
		StringIterator stringIterator = new StringIterator(str);

		while(stringIterator.hasNext()) {
			System.out.println(stringIterator.next());
		}
	}
}
