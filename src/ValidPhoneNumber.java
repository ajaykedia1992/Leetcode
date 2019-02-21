import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPhoneNumber {

	public static void main(String args[]) {
		String[] phone = { "987-123-2321", "123 456 7890", "(123) 456-7890", "1324354", "123) 456-9807" };

		System.out.println(Arrays.toString(validPhone(phone)));

	}

	// valid phone number
	// (123) 123-4567
	// 123-456-7890

	private static boolean checkValidity(String ph) {

		if (ph == null) {
			return false;
		}
		
		//String regex = "(?[1-9][0-9]{2})?[\\s\\-][0-9]{3}\\-[0-9]{4}";
		
		String regex = "(\\([1-9][0-9]{2}\\)\\s)|"
						+ "([1-9][0-9]{2}\\-)"
				+ "[0-9]{3}\\-[0-9]{4}";

		Pattern pattern = Pattern.compile(regex);
		
		Matcher matches = pattern.matcher(ph);
		
		if(matches.find()) {
			return true;
		}
		return false;
	}

	private static String[] validPhone(String[] phone) {

		if (phone == null || phone.length == 0) {
			return null;
		}

		List<String> temp = new ArrayList<String>();
		for (int i = 0; i < phone.length; i++) {
			if (checkValidity(phone[i])) {
				temp.add(phone[i]);
			}
		}

		String[] result = new String[temp.size()];
		int i = 0;
		for (String s : temp) {
			result[i++] = s;
		}
		return result;
	}
}
