import java.util.Arrays;

/* Let us create the following graph 
        2 3 
    (0)--(1)--(2) 
    | / \ | 
    6| 8/ \5 |7 
    | /     \ | 
    (3)-------(4) 
            9         */
public class PrimsAlgorithmMinimumSpanningTree {

	public static void main(String args[]) {
		int graph[][] = { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 } };
		int V = graph.length;
		boolean[] visited = new boolean[V];
		int vertices[] = new int[V];
		int weight[] = new int[V];
		findMinimumPath(graph, visited, vertices, weight);
		System.out.println(Arrays.toString(vertices));
		System.out.println(Arrays.toString(weight));
	}

	private static int findMinimum(int[] weight, boolean[] visited) {
		int minValue = Integer.MAX_VALUE;
		int index = 0;
		int minIndex = 0;
		while (index < weight.length) {
			if (!visited[index] && weight[index] < minValue) {
				minValue = weight[index];
				minIndex = index;
			}
			index++;
		}

		return minIndex;

	}

	private static void findMinimumPath(int[][] graph, boolean[] visited, int[] vertices, int[] weight) {

		Arrays.fill(weight, Integer.MAX_VALUE);
		weight[0] = 0;
		vertices[0] = -1;

		for (int count = 0; count < graph.length - 1; count++) {
			int u = findMinimum(weight, visited);
			visited[u] = true;
			for (int v = 0; v < graph.length; v++) {
				if (graph[u][v] != 0 && !visited[v] && graph[u][v] < weight[v]) {
					weight[v] = graph[u][v];
					vertices[v] = u;
				}
			}
		}

	}

}
