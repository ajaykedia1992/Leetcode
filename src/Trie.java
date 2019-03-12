import java.util.HashMap;
import java.util.Map;

public class Trie {

	final TrieNode root;

	class TrieNode {
		Map<Character, TrieNode> children;
		boolean isEnd;

		public TrieNode() {
			children = new HashMap<>();
			isEnd = false;
		}
	}

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode temp = current.children.get(c);
			if (temp == null) {
				temp = new TrieNode();
				current.children.put(c, temp);
			}
			current = temp;
		}
		current.isEnd = true;
	}

	public boolean search(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (current.children.containsKey(c)) {
				current = current.children.get(c);
			} else {
				return false;
			}
		}

		if (current.isEnd) {
			return true;
		}
		return false;
	}

	public void delete(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode temp = current.children.get(c);
			if (temp == null) {
				return;
			}
		}

		deleteRecursively(word, 0);
	}

	private void deleteRecursively(String word, int index) {
		
		
	}

	public static void main(String args[]) {
		String str[] = { "abcd", "abc", "def", "mno", "bcf" };
		Trie trie = new Trie();

		for (int i = 0; i < str.length; i++) {
			trie.insert(str[i]);
		}

		String test[] = { "abc", "def", "mno", "ab", "bcf" };

		for (int i = 0; i < test.length; i++) {
			System.out.println(trie.search(test[i]));
		}

		System.out.println("-----------------------------");
		trie.delete("def");
		System.out.println(trie.search("def"));
	}
}
