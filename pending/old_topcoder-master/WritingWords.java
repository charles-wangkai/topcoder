public class WritingWords {
	public int write(String word) {
		return word.chars().map(ch -> ch - 'A' + 1).sum();
	}
}
