public class FoxAndWord {
	public int howManyPairs(String[] words) {
		int pairNum = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if (isInteresting(words[i], words[j])) {
					pairNum++;
				}
			}
		}
		return pairNum;
	}

	boolean isInteresting(String s, String t) {
		return s.length() == t.length() && (s + s).contains(t);
	}
}
