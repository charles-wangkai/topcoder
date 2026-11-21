public class WordPattern {
	public long countWords(String word) {
		return Math.max(((1L << (word.length() - 1)) - 1) * 4, 1);
	}
}
