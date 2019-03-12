import java.util.Arrays;
import java.util.Collections;

/*
 * input = ['p','e','r','f','e','c','t',' ','m','a','k','e','s',' ','p','r','a','c','t','i','c','e']
 * 
 * inplace memory o(1)
 * 
 * output = ['p','r','a','c','t','i','c','e',' ','m','a','k','e','s',' ','p','e','r','f','e','c','t']
 */
public class ReverseCharacterArrayBySpace {

	public static void main(String args[]) {
		char[] input = { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't',
				'i', 'c', 'e' };
		System.out.println(Arrays.toString(reverseCharacterArray(input)));
	}

	private static char[] reverseCharacterArray(char[] input) {
		if (input == null || input.length == 0) {
			return null;
		}

		reverse(input, 0, input.length - 1);

		int j = 0;
		for (int i = 0; i <= input.length; i++) {
			if (i < input.length && input[i] != ' ') {
				continue;
			}

			int k = i - 1;
			while (j < k) {
				char temp = input[j];
				input[j] = input[k];
				input[k] = temp;
				j++;
				k--;
			}
			j = i + 1;
		}

		return input;
	}

	public static void reverse(char[] input, int start, int end) {
		int i = start;
		int j = end;
		while (i < j) {
			char temp = input[i];
			input[i] = input[j];
			input[j] = temp;
			i++;
			j--;
		}
	}
}
