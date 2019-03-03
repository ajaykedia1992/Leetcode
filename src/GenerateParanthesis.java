import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

	public static void main(String args[]) {

		GenerateParanthesis g = new GenerateParanthesis();

		int n = 3;

		List<String> result = g.generateParenthesis(n);
		
		result.stream().map(x -> x).forEach(x -> System.out.println(x));

	}

	public List<String> generateParenthesis(int n) {

		List<String> result = new ArrayList<String>();

		int pos = 0;

		generateAllCombination(new char[2 * n], pos, result);

		return result;
	}

	public void generateAllCombination(char[] generate, int pos, List<String> result) {
		if (pos == generate.length) {
			if (valid(generate)) {
				result.add(new String(generate));
			}
		} else {
			generate[pos] = '(';
			generateAllCombination(generate, pos + 1, result);
			generate[pos] = ')';
			generateAllCombination(generate, pos + 1, result);
		}
	}

	public boolean valid(char[] generate) {
		int balance = 0;

		for (char c : generate) {
			if (c == '(') {
				balance++;
			} else {
				balance--;
			}

			if (balance < 0) {
				return false;
			}
		}

		return (balance == 0);
	}
}
