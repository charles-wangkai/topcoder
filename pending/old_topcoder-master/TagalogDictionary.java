import java.util.Arrays;
import java.util.Comparator;

public class TagalogDictionary {
	public String[] sortWords(String[] words) {
		Arrays.sort(words, new TagalogComparator());
		return words;
	}
}

class TagalogComparator implements Comparator<String> {
	static final String alphabet[] = { "a", "b", "k", "d", "e", "g", "h", "i",
			"l", "m", "n", "ng", "o", "p", "r", "s", "t", "u", "w", "y" };

	public int compare(String word1, String word2) {
		if (word1.equals(word2)) {
			return 0;
		}
		while (true) {
			if (word1.equals("")) {
				return -1;
			}
			if (word2.equals("")) {
				return 1;
			}
			String letter1 = getNextLetter(word1);
			String letter2 = getNextLetter(word2);
			if (!letter1.equals(letter2)) {
				return indexOf(letter1) - indexOf(letter2);
			}
			word1 = word1.substring(letter1.length());
			word2 = word2.substring(letter2.length());
		}
	}

	String getNextLetter(String word) {
		if (word.startsWith("ng")) {
			return "ng";
		} else {
			return word.charAt(0) + "";
		}
	}

	int indexOf(String letter) {
		for (int i = 0;; i++) {
			if (alphabet[i].equals(letter)) {
				return i;
			}
		}
	}
}