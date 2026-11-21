public class TextCompressor {
	public String longestRepeat(String sourceText) {
		String longest = "";
		for (int i = 0; i < sourceText.length(); i++) {
			for (int j = i + 1; j * 2 <= sourceText.length() + i; j++) {
				String substr = sourceText.substring(i, j);
				if (sourceText.substring(j).contains(substr)
						&& substr.length() > longest.length()) {
					longest = substr;
				}
			}
		}
		return longest;
	}
}
