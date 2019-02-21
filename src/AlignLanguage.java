import java.util.LinkedList;
import java.util.Stack;

class Graph {
	private final LinkedList<Integer>[] adjaencyList;

	public Graph(int no_of_vertex) {
		adjaencyList = new LinkedList[no_of_vertex];
		for (int i = 0; i < no_of_vertex; i++) {
			adjaencyList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int from, int to) {
		this.adjaencyList[from].add(to);
	}
	
	public void topologicalSort() {
		
		Stack<Integer> stack  = new Stack<>();
		
		boolean vertexCheck[] = new boolean[getNoOfVertex()];
		for(int i = 0; i<getNoOfVertex(); i++) {
			vertexCheck[i] = false;
		}
		
		for(int i = 0; i<getNoOfVertex(); i++) {
			if(!vertexCheck[i]) {
				this.topologicalSortUtil(i, vertexCheck, stack);
			}
		}
		
		printAllAlphabets(stack);
	}

	private void topologicalSortUtil(int i, boolean[] vertexCheck, Stack<Integer> stack) {
		
		vertexCheck[i] = true;
		
		for(int a : adjaencyList[i]) {
			if(!vertexCheck[a]) {
				topologicalSortUtil(a, vertexCheck, stack);
			}
		}
		
		stack.push(i);
		
	}

	private void printAllAlphabets(Stack<Integer> stack) {

		while(!stack.isEmpty()) {
			System.out.println((char)('a' + stack.pop()) + " ");
		}
		
	}

	private int getNoOfVertex() {
		return this.adjaencyList.length;
	}
}

public class AlignLanguage {

	public static void main(String args[]) {
		String[] arr = { "baa", "abcd", "abca", "cab", "cad" };
		int no_of_alphabets = 4;
		printAlienLanguage(arr, no_of_alphabets);
	}

	private static void printAlienLanguage(String[] arr, int i) {
		createGraph(arr, i);

	}

	private static void createGraph(String[] arr, int n) {

		Graph graph = new Graph(n);

		for (int i = 0; i < arr.length - 1; i++) {

			String word1 = arr[i];
			String word2 = arr[i + 1];

			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
					break;
				}
			}
		}
		graph.topologicalSort();
	}
	
}
