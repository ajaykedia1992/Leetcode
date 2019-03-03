
public class AddBinary {

	public static void main(String args[]) {
		String a = "1111";
		String b = "1111";
		System.out.println(addBinary(a, b));
	}

	public static String addBinary(String a, String b) {
		if (a == null || b == null) {
			return null;
		}

		if (a.length() > b.length()) {
			return addBinary(b, a);
		}

		if (a.length() != b.length()) {
			int diff = b.length() - a.length();
			StringBuilder temp = new StringBuilder(a);
			temp.reverse();
			for (int i = 0; i < diff; i++) {
				temp.append("0");
			}
			a = temp.reverse().toString();
		}

		char[] first = new StringBuilder(a).reverse().toString().toCharArray(); // this will contain the smaller String
		char[] second = new StringBuilder(b).reverse().toString().toCharArray(); // this will contain the bigger String
		int carry = 0;
		char[] output = new char[second.length + 1];
		for (int i = 0; i < first.length; i++) {

			if (first[i] == '1' && second[i] == '1') {
				if (carry == 1) {
					output[i] = '1';
				} else {
					output[i] = '0';
					carry = 1;
				}
			}

			else if (first[i] == '1' && second[i] == '0' || first[i] == '0' && second[i] == '1') {
				if (carry == 1) {
					output[i] = '0';
					carry = 1;
				} else {
					output[i] = '1';
				}
			} else {
				if (carry == 1) {
					output[i] = '1';
					carry = 0;
				} else {
					output[i] = '0';
				}
			}
		}

		if (carry == 1) {
			output[output.length - 1] = '1';
		}
		return new StringBuilder(String.copyValueOf(output)).reverse().toString().trim();
	}
}
