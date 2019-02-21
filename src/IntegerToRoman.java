
public class IntegerToRoman {
	public String intToRoman(int num) {
		StringBuffer result = new StringBuffer("");
		while (num > 0) {
			if (num >= 1000) {
				num -= 1000;
				result.append("M");
			} else if (num >= 900 && num < 1000) {
				num -= 900;
				result.append("CM");
			} else if (num >= 500 && num < 900) {
				num -= 500;
				result.append("D");
			} else if (num >= 400 && num < 500) {
				num -= 400;
				result.append("CD");
			}

			else if (num >= 100 && num < 400) {
				num -= 100;
				result.append("C");
			} else if (num >= 90 && num < 100) {
				num -= 90;
				result.append("XC");
			} else if (num >= 50 && num < 100) {
				num -= 50;
				result.append("L");
			} else if (num >= 40 && num < 50) {
				num -= 40;
				result.append("XL");
			} else if (num >= 10 && num < 50) {
				num -= 10;
				result.append("X");
			} else if (num >= 9 && num < 10) {
				num -= 9;
				result.append("IX");
			} else if (num >= 5 && num < 9) {
				num -= 5;
				result.append("V");
			} else if (num >= 4 && num < 5) {
				num -= 4;
				result.append("IV");
			} else {
				num -= 1;
				result.append("I");
			}

		}
		return result.toString();

	}
}