public class AppleWord {
	public int minRep(String word) {
		if (word.length() < 5) {
			return -1;
		}
		word = word.toLowerCase();
		int replaceNum = 0;
		int indices[] = { 0, word.length() - 2, word.length() - 1 };
		char expectedChars[] = { 'a', 'l', 'e' };
		for (int i = 0; i < indices.length; i++) {
			if (word.charAt(indices[i]) != expectedChars[i]) {
				replaceNum++;
			}
		}
		for (int i = 1; i <= word.length() - 3; i++) {
			if (word.charAt(i) != 'p') {
				replaceNum++;
			}
		}
		return replaceNum;
	}
}
