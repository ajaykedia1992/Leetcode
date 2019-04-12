import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumCostAfterJoiningNetwork {
	class Pair<K, V> {
		private final K k;
		private final V v;

		Pair(K k, V v) {
			this.k = k;
			this.v = v;
		}

		V getValue() {
			return v;
		}

		K getKey() {
			return k;
		}
	}

	private int solve(ArrayList<Pair<Integer, Integer>> available,
			ArrayList<Pair<Pair<Integer, Integer>, Integer>> cost) {
		HashMap<Integer, Integer> costMap = new HashMap<>();
		for (int i = 0; i < available.size(); i++) {
			costMap.put(available.get(i).getValue(), 0);
		}

		for (Pair<Pair<Integer, Integer>, Integer> pair : cost) {
			Integer key = pair.getKey().getValue();
			Integer existing = costMap.get(key);
			if (existing == null || existing > pair.getValue()) {
				costMap.put(key, pair.getValue());
			}
		}

		int total = 0;
		for (Integer key : costMap.keySet()) {
			total += costMap.get(key);
		}

		return total;
	}

	public int minimumCostIncurred(int numTotalEdgeNodes, int numTotalAvailableNetworkRoutes,
			List<List<Integer>> networkRoutesAvailable, int numNewNetworkRoutesConstruct,
			List<List<Integer>> costNewNetworkRoutesConstruct) {

		ArrayList<Pair<Integer, Integer>> available = new ArrayList<>();
		for (List<Integer> pair : networkRoutesAvailable) {
			available.add(new Pair<>(pair.get(0), pair.get(1)));
		}

		ArrayList<Pair<Pair<Integer, Integer>, Integer>> cost = new ArrayList<>();

		for (List<Integer> costL : costNewNetworkRoutesConstruct) {
			cost.add(new Pair<>(new Pair<>(costL.get(0), costL.get(1)), costL.get(2)));
		}

		return solve(available, cost);

	}

	public static void main(String args[]) {

		int numTotalEdgeNodes = 6;
		int numTotalAvailableNetworkRoutes = 4;
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

		MinimumCostAfterJoiningNetwork m = new MinimumCostAfterJoiningNetwork();
		System.out.println(m.minimumCostIncurred(numTotalEdgeNodes, numTotalAvailableNetworkRoutes,
				networkRoutesAvailable, numNewNetworkRoutesConstruct, costNewNetworkRoutesConstruct));

	}
}
