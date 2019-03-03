import java.util.HashSet;
import java.util.Set;

public class PowerSet1 {

	public static void main(String args[]) {
		String str = "ABC";
		int r = str.length();
		printPowerSet(str, r);
	}

	private static void printPowerSet(String str, int r) {

		if (str == null) {
			System.out.println("String is null");
			return;
		}

		double set_size = Math.pow(2, str.length());

		Set<String> set = new HashSet<>();

		for (int counter = 0; counter < set_size; counter++) {
			StringBuffer s = new StringBuffer();
			for (int i = 0; i < r; i++) {
				if ((int) (counter & (1 << i)) > 0) {
					s.append(str.charAt(i));
				}
				set.add(s.toString());
			}
		}

		for (String s : set) {
			System.out.println(s);
		}
	}
}
