import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class IdsofPackages {

	public static void main(String args[]) {
		
		int truckSpace = 100;
		ArrayList<Integer> result = new ArrayList<>();
		
		Random random = new Random();
		for(int i = 0; i<1000; i++) {
		
			result.add(random.nextInt(100));
		}
		System.out.println(IDsOfPackages(truckSpace, result));
		
	}

	static ArrayList<Integer> IDsOfPackages(int truckSpace, ArrayList<Integer> packagesSpace)

	{
		ArrayList<Integer> result = new ArrayList<>();
		if (packagesSpace == null || packagesSpace.size() == 0) {
			return result;
		}
		// Map<Integer, Integer> map = new HashMap<>();
		truckSpace -= 30;
		/*
		 * for(int i = 0 ; i<packagesSpace.size(); i++){
		 * if(map.containsKey(packagesSpace.get(i)) == false){
		 * map.put(packagesSpace.get(i), i);
		 * 
		 * } }
		 */
		ArrayList<Integer> temp = new ArrayList<>(packagesSpace);
		Collections.sort(packagesSpace);
		System.out.println(packagesSpace);
		int left = 0;
		int right = packagesSpace.size() - 1;
		while (left < right) {
			int value1 = packagesSpace.get(left);
			int value2 = packagesSpace.get(right);
			if (value1 + value2 == truckSpace) {
				int index1 = temp.indexOf(value1);
				int index2 = temp.indexOf(value2);
				if (index1 == index2) {
					temp.remove(index1);
					index2 = temp.indexOf(value2) + 1;
				}
				result.add(index1 > index2 ? index2 : index1);
				result.add(index2 > index1 ? index2 : index1);
				
				System.out.println(temp.get(result.get(0)));
				System.out.println(temp.get(result.get(1)));
				return result;
			} else if (value1 + value2 > truckSpace) {
				right--;
			} else {
				left++;
			}
		}
		return result;
	}
	// METHOD SIGNATURE ENDS
}
