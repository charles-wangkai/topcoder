public class SMS {
	public String compress(String originalMessage) {
		String parts[] = originalMessage.split(" ", -1);
		String result = "";
		for (int i = 0; i < parts.length; i++) {
			if (i != 0) {
				result += " ";
			}
			result += removeMiddleVowels(parts[i]);
		}
		return result;
	}

	String removeMiddleVowels(String word) {
		int beginIndex = 0;
		while (beginIndex < word.length() && isVowel(word.charAt(beginIndex))) {
			beginIndex++;
		}
		int endIndex = word.length() - 1;
		while (endIndex >= 0 && isVowel(word.charAt(endIndex))) {
			endIndex--;
		}
		if (beginIndex > endIndex) {
			return word;
		} else {
			return word.substring(0, beginIndex)
					+ word.substring(beginIndex, endIndex + 1).replaceAll(
							"a|e|i|o|u|A|E|I|O|U", "")
					+ word.substring(endIndex + 1);
		}
	}

	boolean isVowel(char ch) {
		ch = Character.toLowerCase(ch);
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
}
