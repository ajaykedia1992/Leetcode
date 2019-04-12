package Facebook;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	class TrieNode {
		Map<Character, TrieNode> children;
		boolean isEnd;

		public TrieNode() {
			children = new HashMap<Character, TrieNode>();
			isEnd = false;
		}

	}

	TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	public void insert(String word) {

		TrieNode curr = root;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (curr.children.containsKey(ch)) {
				curr = curr.children.get(ch);
				continue;
			}
			TrieNode node = new TrieNode();
			curr.children.put(ch, node);
			curr = curr.children.get(ch);
		}
		curr.isEnd = true;
	}

	public static void main(String args[]) {
		String[] str = { "GEEKS", "FOR", "QUIZ", "GO" };

		Trie t = new Trie();

		for (int i = 0; i < str.length; i++) {
			t.insert(str[i]);
		}

		System.out.println(t.findWord("QUIZ"));

		t.delete("QUIZ");

		System.out.println(t.findWord("QUIZ"));

		// t.printTrie();

	}

	private void delete(String string) {
		System.out.println(deleteWord(root, "QUIZ", 0));

	}

	private boolean deleteWord(TrieNode root, String word, int index) {

		if (index == word.length()) {
			if (!root.isEnd) {
				return false;
			}
			root.isEnd = false;
			return root.children.size() == 0;
		}

		char ch = word.charAt(index);

		TrieNode node = root.children.get(ch);

		if (node == null) {
			return false;
		}

		boolean shouldDeleteCurrentNode = deleteWord(node, word, index + 1);

		if (shouldDeleteCurrentNode) {
			root.children.remove(ch);
			return root.children.size() == 0;
		}
		return false;
	}

	private boolean findWord(String word) {
		TrieNode curr = root;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (curr.children.containsKey(ch)) {
				curr = curr.children.get(ch);
			}
		}

		return curr.isEnd != false;

	}

	private void printTrie() {
		char word[] = new char[26];
		printEntireTrie(root, word, 0);
	}

	private void printEntireTrie(TrieNode root, char[] word, int pos) {

		if (root == null) {
			return;
		}

		if (root.isEnd) {
			print(word, pos);
		}

		for (int i = 0; i < 26; i++) {
			char c = (char) (i + 'A');
			if (root.children.containsKey(c)) {
				word[pos] = c;
				printEntireTrie(root.children.get(c), word, pos + 1);
			}
		}
	}

	private void print(char[] word, int pos) {
		StringBuilder str = new StringBuilder("");

		for (int i = 0; i < pos; i++) {
			str.append(word[i]);
		}

		System.out.println(str);
	}
}
