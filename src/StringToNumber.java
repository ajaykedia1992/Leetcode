
public class StringToNumber {

	public int myAtoi(String str) {

		if (str == null || str.length() < 1)
			return 0;

		// trim white spaces
		str = str.trim();

		if (str.length() == 0) {
			return 0;
		}

		char flag = '+';

		// check negative or positive
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		// use double to store result
		double result = 0;

		// calculate value
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}

		if (flag == '-')
			result = -result;

		// handle max and min
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;

		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return (int) result;

	}

	public static void main(String args[]) {
		String str = "  -0012a42";
		StringToNumber s = new StringToNumber();
		int a = s.myAtoi(str);
		System.out.println(a);
	}
}
