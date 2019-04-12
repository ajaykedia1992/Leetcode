package Facebook;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public static void main(String args[]) {
		String[] str = { "This", "is", "an", "example", "of", "text", "justification.", "Please!", "say", "Hello",
				"World" };
		List<String> result = new TextJustification().findTextJustification(str, 16);
		for (String r : result) {
			System.out.println(r);
		}
	}

	private List<String> findTextJustification(String[] str, int K) {
		List<String> result = new ArrayList<>();
		List<String> temp = new ArrayList<>();

		int count = 0;
		for (int i = 0; i < str.length; i++) {
			if (count + str[i].length() > K) {
				StringBuffer s = new StringBuffer("");
				count -= temp.size();
				doJustfication(temp, count, K, s, false);
				result.add(s.toString());
				count = 0;
				temp = new ArrayList<>();
				i--;

			} else {
				count += str[i].length() + 1;
				temp.add(str[i]);
			}
		}

		if (temp.size() != 0) {
			StringBuffer s = new StringBuffer("");
			count -= temp.size();
			doJustfication(temp, count, K, s, true);
			result.add(s.toString());
		}

		return result;
	}

	private void doJustfication(List<String> temp, int count, int K, StringBuffer s, boolean isLastLine) {

		int N = temp.size();
		int remainingSlot = K - count;
		int spaceRequired = N > 1 ? remainingSlot / (N - 1) : 0;
		int remainingSpace = N > 1 ? remainingSlot % (N - 1) : 0;

		for (int i = 0; i < temp.size(); i++) {
			s.append(temp.get(i));
			int spaceNeeded = spaceRequired + (remainingSpace-- > 0 ? 1 : 0);

			if (count == K) {
				break;
			}

			if (isLastLine) {
				s.append(" ");
				spaceNeeded--;
			} else {
				while (spaceNeeded != 0) {
					s.append(" ");
					spaceNeeded--;
					count++;
				}
			}
		}

		if (isLastLine) {
			if (temp.size() > 1) {
				while (count != K) {
					s.append(" ");
					count++;
				}
			}
		}

	}
}
