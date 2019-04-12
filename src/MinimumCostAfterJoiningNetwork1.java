import java.util.ArrayList;
import java.util.List;

public class MinimumCostAfterJoiningNetwork1 {

	int minimumCostIncurred(int numTotalEdgeNodes, int numTotalAvailableNetworkRoutes,
			List<List<Integer>> networkRoutesAvailable, int numNewNetworkRoutesConstruct,
			List<List<Integer>> costNewNetworkRoutesConstruct) {
		// WRITE YOUR CODE HERE
		int totalCost = 0;
		boolean[] visited = new boolean[numTotalEdgeNodes];
		int[] keys = new int[numTotalEdgeNodes];
		int[] parent = new int[numTotalEdgeNodes];

		int[][] AdjMatrix = getAdjecnecyMatrix(networkRoutesAvailable, costNewNetworkRoutesConstruct,
				numTotalEdgeNodes);

		for (int i = 0; i < numTotalEdgeNodes; i++) {
			keys[i] = Integer.MAX_VALUE;
		}

		keys[0] = 0;
		parent[0] = -1;

		for (int i = 0; i < numTotalEdgeNodes - 1; i++) {
			int u = findMin(visited, keys);
			visited[u] = true;
			for (int v = 0; v < numTotalEdgeNodes; v++) {
				if (visited[v] == false && AdjMatrix[u][v] != Integer.MAX_VALUE && AdjMatrix[u][v] < keys[v]) {
					parent[v] = u;
					keys[v] = AdjMatrix[u][v];
				}
			}
		}

		for (int i = 1; i < numTotalEdgeNodes; i++) {
			totalCost += AdjMatrix[parent[i]][i];
		}
		return totalCost;
	}

	private int findMin(boolean[] visited, int[] keys) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < keys.length; i++) {
			if (visited[i] == false && keys[i] < min) {
				min = keys[i];
				index = i;
			}
		}
		return index;
	}

	private int[][] getAdjecnecyMatrix(List<List<Integer>> networkRoutesAvailable,
			List<List<Integer>> costNewNetworkRoutesConstruct, int numTotalEdgeNodes) {
		int[][] AdjMatrix = new int[numTotalEdgeNodes][numTotalEdgeNodes];
		for (int i = 0; i < numTotalEdgeNodes; i++) {
			for (int j = 0; j < numTotalEdgeNodes; j++) {
				AdjMatrix[i][j] = Integer.MAX_VALUE;
			}
		}

		int count = 0;
		for (int i = 0; i < networkRoutesAvailable.size(); i++) {
			int start = networkRoutesAvailable.get(i).get(count) - 1;
			int end = networkRoutesAvailable.get(i).get(count + 1) - 1;
			AdjMatrix[start][end] = 0;
		}

		for (int i = 0; i < costNewNetworkRoutesConstruct.size(); i++) {
			int start = costNewNetworkRoutesConstruct.get(i).get(count) - 1;
			int end = costNewNetworkRoutesConstruct.get(i).get(count + 1) - 1;
			int cost = costNewNetworkRoutesConstruct.get(i).get(count + 2);
			AdjMatrix[start][end] = cost;
		}
		return AdjMatrix;
	}
	
	public static void main(String args[]) {

		int numTotalEdgeNodes = 6;
		int numTotalAvailableNetworkRoutes = 5;
		List<List<Integer>> networkRoutesAvailable = new ArrayList<>();
		List<Integer> route = new ArrayList<>();
		route.add(1);
		route.add(4);
		networkRoutesAvailable.add(route);
		route = new ArrayList<>();
		route.add(4);
		route.add(5);
		networkRoutesAvailable.add(route);
		route = new ArrayList<>();
		route.add(2);
		route.add(3);
		networkRoutesAvailable.add(route);
		route = new ArrayList<>();
		route.add(1);
		route.add(2);
		networkRoutesAvailable.add(route);
		route = new ArrayList<>();
		route.add(1);
		route.add(6);
		networkRoutesAvailable.add(route);
		int numNewNetworkRoutesConstruct = 4;
		List<List<Integer>> costNewNetworkRoutesConstruct = new ArrayList<>();
		
		List<Integer> cost = new ArrayList<>();
		cost.add(1);
		cost.add(2);
		cost.add(5);
		costNewNetworkRoutesConstruct.add(cost);
		
		cost = new ArrayList<>();
		cost.add(1);
		cost.add(3);
		cost.add(10);
		costNewNetworkRoutesConstruct.add(cost);
		
		cost = new ArrayList<>();
		cost.add(1);
		cost.add(6);
		cost.add(2);
		costNewNetworkRoutesConstruct.add(cost);
		
		cost = new ArrayList<>();
		cost.add(5);
		cost.add(6);
		cost.add(5);
		costNewNetworkRoutesConstruct.add(cost);

		MinimumCostAfterJoiningNetwork1 m = new MinimumCostAfterJoiningNetwork1();
		System.out.println(m.minimumCostIncurred(numTotalEdgeNodes, numTotalAvailableNetworkRoutes,
				networkRoutesAvailable, numNewNetworkRoutesConstruct, costNewNetworkRoutesConstruct));

	}

}
