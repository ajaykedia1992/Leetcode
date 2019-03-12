import java.util.Arrays;
import java.util.Iterator;

class Tuple {
	String word;
	int count;

	public Tuple(String word, int count) {
		this.word = word;
		this.count = count;
	}

	@Override
	public String toString() {
		return "{" + word + ", " + count + "}";
	}

}

class CustomIterator {

	private String currentWord;

	private final Iterator<String> words;

	public CustomIterator(Iterator<String> words) {
		this.words = words;
	}

	public Tuple next() {
		// ask question?
		if (!this.hasNext()) {
			return null;
		}
		int count = this.currentWord == null ? 0 : 1;
		String prevWord = this.currentWord;
		this.currentWord = null;
		String itrWord = "";
		while (words.hasNext()) {
			itrWord = words.next();
			if (prevWord == null) {
				this.currentWord = prevWord = itrWord;
			}
			if (!itrWord.equals(currentWord)) {
				currentWord = itrWord;
				break;
			}
			count++;
		}

		return new Tuple(prevWord, count);
	}

	public boolean hasNext() {
		return this.currentWord != null || this.words.hasNext();
	}

	public static void main(String args[]) {

		String words[] = { "foo", "foo", "foo", "bar", "Hello", "foo" };
		Iterator<String> i = Arrays.asList(words).iterator();

		CustomIterator itr = new CustomIterator(i);

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}
}