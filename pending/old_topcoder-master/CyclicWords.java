public class CyclicWords {
	public int differentCW(String[] words) {
		boolean used[] = new boolean[words.length];
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			if (!used[i]) {
				count++;
				used[i] = true;
				for (int j = i + 1; j < words.length; j++) {
					if (!used[j] && isCyclic(words[i], words[j])) {
						used[j] = true;
					}
				}
			}
		}
		return count;
	}

	boolean isCyclic(String word1, String word2) {
		return word1.length() == word2.length()
				&& (word1 + word1).contains(word2);
	}
}
