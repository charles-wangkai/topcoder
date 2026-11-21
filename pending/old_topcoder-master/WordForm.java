public class WordForm {
	public String getSequence(String word) {
		word = word.toLowerCase();
		String sequence = "";
		Boolean previousVowel = null;
		for (int i = 0; i <= word.length(); i++) {
			Boolean currentVowel = null;
			if (i < word.length()
					&& (currentVowel = isVowel(word.charAt(i), previousVowel)) == previousVowel) {
				continue;
			}
			if (i != 0) {
				sequence += vowelToChar(previousVowel);
			}
			previousVowel = currentVowel;
		}
		return sequence;
	}

	boolean isVowel(char ch, Boolean precedingVowel) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
				|| (ch == 'y' && precedingVowel != null && !precedingVowel);
	}

	char vowelToChar(boolean vowel) {
		return vowel ? 'V' : 'C';
	}
}
