
public class IntegerToEnglishWord {

	public String one(int num) {
		switch (num) {
		case 1:
			return "One";
		case 2:
			return "Two";
		case 3:
			return "Three";
		case 4:
			return "Four";
		case 5:
			return "Five";
		case 6:
			return "Six";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine";
		}
		return "";
	}

	public String twoLessThanTwenty(int num) {
		switch (num) {
		case 10:
			return "Ten";
		case 11:
			return "Eleven";
		case 12:
			return "Twelve";
		case 13:
			return "Thirteen";
		case 14:
			return "Fourteen";
		case 15:
			return "Fifteen";
		case 16:
			return "Sixteen";
		case 17:
			return "Seventeen";
		case 18:
			return "Eighteen";
		case 19:
			return "Nineteen";
		}
		return "";
	}

	public String ten(int num) {
		switch (num) {
		case 20:
			return "Twenty";
		case 30:
			return "Thirty";
		case 40:
			return "Forty";
		case 50:
			return "Fifty";
		case 60:
			return "Sixty";
		case 70:
			return "Seventy";
		case 80:
			return "Eighty";
		case 90:
			return "Ninety";
		}
		return "";
	}

	public String two(int num) {

		if (num == 0) {
			return "";
		} else if (num < 10) {
			return one(num);
		} else if (num < 20) {
			return twoLessThanTwenty(num);
		} else {
			int tens = num / 10;
			int rest = num - tens * 10;
			if (rest != 0) {
				return ten(tens * 10) + " " + one(rest);
			} else {
				return ten(tens * 10);
			}
		}
	}

	public String three(int num) {
		int hundred = num / 100;
		int rest = num - hundred * 100;
		String res = "";
		if (hundred * rest != 0) {
			res += one(hundred) + " Hundred " + two(rest);
		} else if (hundred == 0 && rest != 0) {
			res += two(rest);
		} else if (hundred != 0 && rest == 0) {
			res += one(hundred) + " Hundred";
		}
		return res;

	}

	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		int billions = num / 1000000000;
		int millions = (num - billions * 1000000000) / 1000000;
		int thousands = (num - billions * 1000000000 - millions * 1000000) / 1000;
		int rest = num - billions * 1000000000 - millions * 1000000 - thousands * 1000;
		StringBuffer result = new StringBuffer("");
		if (billions != 0) {
			result.append(three(billions) + " Billion");
		}
		if (millions != 0) {
			if (result.length() != 0) {
				result.append(" ");
			}
			result.append(three(millions) + " Million");
		}
		if (thousands != 0) {
			if (result.length() != 0) {
				result.append(" ");
			}
			result.append(three(thousands) + " Thousand");
		}
		if (rest != 0) {
			if (result.length() != 0) {
				result.append(" ");
			}
			result.append(three(rest));
		}

		return result.toString();
	}
	
	public static void main(String args[]) {
		int num = 1234567890;
		IntegerToEnglishWord i = new IntegerToEnglishWord();
		System.out.println(i.numberToWords(num));
	}
}
