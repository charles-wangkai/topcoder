public class grafixCorrupt {
	public int selectWord(String[] dictionary, String candidate) {
		int maxMatch = 0;
		int maxMatchIndex = -1;
		for (int i = 0; i < dictionary.length; i++) {
			int match = calcMatch(candidate, dictionary[i]);
			if (match > maxMatch) {
				maxMatch = match;
				maxMatchIndex = i;
			}
		}
		return maxMatchIndex;
	}

	int calcMatch(String word1, String word2) {
		int match = 0;
		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) == word2.charAt(i)) {
				match++;
			}
		}
		return match;
	}
}
